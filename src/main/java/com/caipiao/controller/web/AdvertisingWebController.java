package com.caipiao.controller.web;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.caipiao.domain.Advertising;
import com.caipiao.domain.base.Page;
import com.caipiao.service.AdvertisingService;
import com.caipiao.utils.ParamUtils;

/*author:huangshanqi
 *time  :2015年3月17日 下午8:45:14
 *email :hsqmobile@gmail.com
 */
@Controller
@RequestMapping(value = "admin/ad")
public class AdvertisingWebController {

	@Autowired
	private AdvertisingService adService;

	@RequestMapping(value = "{pageNum}", method = RequestMethod.GET)
	public String getPage(@PathVariable("pageNum") int pageNum, HttpServletRequest request) {

		int pageSize = 20;

		Page page = new Page();
		page.setPageSize(pageSize);
		page.setOffset((pageNum - 1) * pageSize);
		request.setAttribute("list", adService.getPageByOffset(page));
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageSize", pageSize);
		long totalNum = adService.getTotalNum();

		request.setAttribute("totalPage", (totalNum % pageSize == 0) ? (totalNum / pageSize)
				: (totalNum / pageSize + 1));

		return "admin/ad";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteAd(HttpServletRequest request, @RequestParam("nid") long nid,
			RedirectAttributes redirectAttributes) {

		if (!ParamUtils.isNotEmpty(nid)) {
			redirectAttributes.addFlashAttribute("message", "广告删除失败");
			return "redirect:/admin/ad/1";
		} else {
			if (adService.deleteById(nid)) {
				redirectAttributes.addFlashAttribute("message", "广告删除成功");
				return "redirect:/admin/ad/1";
			} else {
				redirectAttributes.addFlashAttribute("message", "广告删除失败");
				return "redirect:/admin/ad/1";
			}
		}
	}

	@RequestMapping(value = "new", method = RequestMethod.GET)
	public String newAd() {
		return "admin/ad_new";
	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String addAd(HttpServletRequest request, @RequestParam("image") MultipartFile image,
			@RequestParam("url") String url, @RequestParam("title") String title, RedirectAttributes redirectAttributes) {
		if (image == null) {
			System.out.println("image is null``````````````````````````````````````````");
		}
		String path = "/upload/images/ad/";
		String imageName = System.currentTimeMillis()
				+ image.getOriginalFilename().substring(image.getOriginalFilename().indexOf("."));

		File imageFile = new File(path, imageName);
		if (!imageFile.exists()) {
			imageFile.mkdirs();
		}
		try {
			image.transferTo(imageFile);
			String imageUrl = "/ad/" + imageName;

			Advertising advertising = new Advertising();
			advertising.setCreateTime(new Date());
			advertising.setPicture(imageUrl);
			advertising.setUrl(url);
			advertising.setTitle(title);

			if (adService.create(advertising) > 0) {
				redirectAttributes.addFlashAttribute("message", "提交广告成功,可以到广告管理页面查看");
				return "redirect:/admin/ad/new";
			} else {
				redirectAttributes.addFlashAttribute("message", "提交广告失败");
				return "redirect:/admin/ad/new";
			}

		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message", "提交广告失败,异常");
			return "redirect:/admin/ad/new";
		}
	}

}