package com.caipiao.controller.web;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.caipiao.domain.Website;
import com.caipiao.domain.base.Page;
import com.caipiao.service.WebsiteService;
import com.caipiao.utils.ParamUtils;

/*author:huangshanqi
 *time  :2015年3月17日 下午9:06:56
 *email :hsqmobile@gmail.com
 */
@Controller
@RequestMapping(value = "admin/website")
public class WebsiteWebController {
	@Autowired
	private WebsiteService websiteService;

	@RequestMapping(value = "{pageNum}", method = RequestMethod.GET)
	public String getPage(@PathVariable("pageNum") int pageNum, HttpServletRequest request) {

		int pageSize = 20;

		Page page = new Page();
		page.setPageSize(pageSize);
		page.setOffset((pageNum - 1) * pageSize);
		request.setAttribute("list", websiteService.getPageByOffset(page));
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageSize", pageSize);
		long totalNum = websiteService.getTotalNum();

		request.setAttribute("totalPage", (totalNum % pageSize == 0) ? (totalNum / pageSize)
				: (totalNum / pageSize + 1));

		return "admin/website";
	}
	
	
	@RequestMapping(value = "new")
	public String newWebsite() {
		return "admin/website_new";
	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String addWebsite(HttpServletRequest request, @RequestParam("logoFile") MultipartFile logoFile,
			@RequestParam("picture1") MultipartFile picture1, @RequestParam("picture2") MultipartFile picture2,
			@RequestParam("picture3") MultipartFile picture3, @ModelAttribute Website website,
			RedirectAttributes redirectAttributes) {
		if (logoFile == null) {
			redirectAttributes.addFlashAttribute("message", "提交网站展示失败,请选择logo文件");
			return "redirect:/admin/website/new";
		}
		if (picture1 == null || picture2 == null || picture3 == null) {
			redirectAttributes.addFlashAttribute("message", "提交网站展示失败,请选择3个网站展示图片");
			return "redirect:/admin/website/new";
		}

		String path = "/upload/images/website/";
		String logoName = "w" + (System.currentTimeMillis() + 0)
				+ logoFile.getOriginalFilename().substring(logoFile.getOriginalFilename().indexOf("."));
		String picture1Name = "w" + (System.currentTimeMillis() + 1)
				+ picture1.getOriginalFilename().substring(picture1.getOriginalFilename().indexOf("."));
		String picture2Name = "w" + (System.currentTimeMillis() + 2)
				+ picture2.getOriginalFilename().substring(picture2.getOriginalFilename().indexOf("."));
		String picture3Name = "w" + (System.currentTimeMillis() + 3)
				+ picture3.getOriginalFilename().substring(picture3.getOriginalFilename().indexOf("."));

		File logoTemp = new File(path, logoName);
		File picture1File = new File(path, picture1Name);
		File picture2File = new File(path, picture2Name);
		File picture3File = new File(path, picture3Name);
		if (!logoTemp.exists()) {
			logoTemp.mkdirs();
		}
		try {
			logoFile.transferTo(logoTemp);
			picture1.transferTo(picture1File);
			picture2.transferTo(picture2File);
			picture3.transferTo(picture3File);

			website.setCreateTime(new Date());
			website.setLogo("/website/" + logoName);
			String pictures = "/website/" + picture1Name + "||" + "/website/" + picture2Name + "||" + "/website/"
					+ picture3Name;
			website.setPictures(pictures);

			if (websiteService.create(website) > 0) {
				redirectAttributes.addFlashAttribute("message", "提交网站展示成功,可以到网站展示页面查看");
				return "redirect:/admin/website/new";
			} else {
				redirectAttributes.addFlashAttribute("message", "提交网站展示失败");
				return "redirect:/admin/website/new";
			}

		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message", "提交网站展示失败,异常");
			return "redirect:/admin/website/new";
		}
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteWebsite(HttpServletRequest request, @RequestParam("nid") long nid,
			RedirectAttributes redirectAttributes) {

		if (!ParamUtils.isNotEmpty(nid)) {
			redirectAttributes.addFlashAttribute("message", "展示网站删除失败");
			return "redirect:/admin/website/1";
		} else {
			if (websiteService.deleteById(nid)) {
				redirectAttributes.addFlashAttribute("message", "展示网站删除成功");
				return "redirect:/admin/website/1";
			} else {
				redirectAttributes.addFlashAttribute("message", "广告删除失败");
				return "redirect:/admin/website/1";
			}
		}
	}

}
