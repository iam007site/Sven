package com.caipiao.controller.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.caipiao.domain.ZixunDetail;
import com.caipiao.domain.base.Page;
import com.caipiao.service.ZixunService;
import com.caipiao.utils.ParamUtils;

/*author:huangshanqi
 *time  :2015年3月17日 下午9:20:52
 *email :hsqmobile@gmail.com
 */
@Controller
@RequestMapping(value = "admin/zx")
public class ZixunWebController {

	@Autowired
	private ZixunService zixunService;

	@RequestMapping(value = "new")
	public String newZixun() {
		return "admin/zixun_new";
	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String addZixun(HttpServletRequest request, @ModelAttribute ZixunDetail zixun,
			RedirectAttributes redirectAttributes) {

		zixun.setUrl("");
		zixun.setPublishTime(new Date());

		if (zixunService.create(zixun) > 0) {
			redirectAttributes.addFlashAttribute("message", "添加资讯成功！");
			return "redirect:/admin/zx/new";
		} else {
			redirectAttributes.addFlashAttribute("message", "添加资讯失败");
			return "redirect:/admin/zx/new";
		}
	}

	@RequestMapping(value = "{pageNum}", method = RequestMethod.GET)
	public String getZixunPage(@PathVariable("pageNum") int pageNum, HttpServletRequest request) {

		int pageSize = 20;

		Page page = new Page();
		page.setPageSize(pageSize);
		page.setOffset((pageNum - 1) * pageSize);
		request.setAttribute("list", zixunService.getPageByOffset(page));
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageSize", pageSize);
		long totalNum = zixunService.getTotalNum();

		request.setAttribute("totalPage", (totalNum % pageSize == 0) ? (totalNum / pageSize)
				: (totalNum / pageSize + 1));

		return "admin/zixun";
	}

	@RequestMapping(value = "edit",method = RequestMethod.GET)
	public String editZixun(HttpServletRequest request, @RequestParam("nid") long nid,
			RedirectAttributes redirectAttributes) {
		if (!ParamUtils.isNotEmpty(nid)) {
			redirectAttributes.addFlashAttribute("message", "编辑资讯文章不存在！！！");
			return "redirect:/admin/zx/edit";
		} else {
			ZixunDetail zixun = zixunService.getZixunDetail(nid);
			if (zixun != null) {
				request.setAttribute("zixun", zixun);
				return "admin/zixun_edit";
			} else {
				redirectAttributes.addFlashAttribute("message", "编辑资讯文章不存在！！！");
				return "redirect:/admin/zx/edit";
			}
		}
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String updateZixun(HttpServletRequest request, @RequestParam("nid") long nid,
			RedirectAttributes redirectAttributes) {

		if (!ParamUtils.isNotEmpty(nid)) {
			redirectAttributes.addFlashAttribute("message", "资讯文章删除失败");
			return "redirect:/admin/zx/1";
		} else {
			if (zixunService.deleteById(nid)) {
				redirectAttributes.addFlashAttribute("message", "资讯文章删除成功");
				return "redirect:/admin/zx/1";
			} else {
				redirectAttributes.addFlashAttribute("message", "资讯文章删除失败");
				return "redirect:/admin/zx/1";
			}
		}
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String deleteZixun(HttpServletRequest request, @ModelAttribute ZixunDetail zixun,
			RedirectAttributes redirectAttributes) {

		if (zixunService.update(zixun)) {
			redirectAttributes.addFlashAttribute("message", "修改资讯文章成功");
			return "redirect:/admin/zx/new";
		} else {
			redirectAttributes.addFlashAttribute("message", "修改资讯文章失败");
			return "redirect:/admin/zx/new";
		}

	}
}
