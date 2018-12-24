package com.yautumn.banner.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yautumn.banner.entity.CompanyBanner;
import com.yautumn.banner.service.BannerService;
import com.yautumn.common.ImageUtil;
import com.yautumn.common.Utils;

@RestController
public class BannerController {
	
	@Autowired
	private BannerService bannerService;
	
	/**
	 *	 index
	 * @return
	 */
	@RequestMapping("/bannerindex")
	public ModelAndView bannerIndex() {
		ModelAndView modelAndView = new ModelAndView("banner/add_or_update_banner");
		return modelAndView;
	}
	
	/**
	 * 	添加或更新banner
	 * @param companyBannerForm
	 * @return
	 */
	@RequestMapping("/addbanner")
	public ModelAndView addOrUpdateBanner(@ModelAttribute("banner_form")CompanyBanner companyBannerForm) {
		
		String bannerName = companyBannerForm.getBannerName();
		byte[] bannerPicture = companyBannerForm.getBannerPicture();
		Integer bannerState = companyBannerForm.getBannerState();
		
		CompanyBanner companyBanner = new CompanyBanner();
		companyBanner.setId(Utils.getUUID());
		companyBanner.setBannerName(bannerName);
		companyBanner.setBannerPicture(bannerPicture);
		companyBanner.setBannerState(bannerState);
		Integer i = bannerService.addOrUpdateBanner(companyBanner);
		
		ModelAndView modelAndView = new ModelAndView("banner/add_or_update_banner_result");
		if (i > 0) {
			modelAndView.addObject("stats", "插入成功");
		}else {
			modelAndView.addObject("stats", "插入失败");
		}
		return modelAndView;
	}
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/deletebannerbyid")
	public ModelAndView deletetBannerById(@ModelAttribute("company_banner")CompanyBanner companyBannerForm) {
		ModelAndView modelAndView = new ModelAndView("banner/del_banner_result");
		String bannerId = companyBannerForm.getId();
		Integer i = bannerService.deleteBannerById(bannerId);
		if (i > 0) {
			modelAndView.addObject("stats", "删除成功");
		} else {
			modelAndView.addObject("stats", "删除失败");
		}
		return modelAndView;
	}
	
	/**
	 *	 查询所有banner信息
	 * @return
	 */
	@RequestMapping("/findallbanner")
	public ModelAndView getBannerAll() {
		ModelAndView modelAndView = new ModelAndView("banner/find_banner_list");
		List<CompanyBanner> list = bannerService.findAll();
		list.forEach((banner) -> ImageUtil.readBin2Image(new ByteArrayInputStream(banner.getBannerPicture()), "H:/i.jpg"));
		modelAndView.addObject("list", list);
		return modelAndView;
	}
	
	/**
	 *	 根据Id查询banner信息
	 * @return
	 */
	@RequestMapping("/findbannerbyid")
	public ModelAndView getBannerById(@ModelAttribute("banner_form")CompanyBanner companyBannerForm) {
		ModelAndView modelAndView = new ModelAndView("banner/find_banner_by_id");
		String bannerId = companyBannerForm.getId();
		CompanyBanner companyBanner = bannerService.findBannerById(bannerId);
		modelAndView.addObject("companyBanner", companyBanner);
		return modelAndView;
	}
	
}
