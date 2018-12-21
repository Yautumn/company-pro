package com.yautumn.banner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yautumn.banner.entity.CompanyBanner;
import com.yautumn.banner.service.BannerService;

@RestController
public class BannerController {
	
	@Autowired
	private BannerService bannerService;
	
	@RequestMapping("/banner")
	public ModelAndView getBannerAll() {
		ModelAndView modelAndView = new ModelAndView("find_list");
		List<CompanyBanner> list = bannerService.findAll();
		list.forEach((banner) -> System.out.println(banner.getBannerName()+"===>"));
		modelAndView.addObject("list", list);
		return modelAndView;
	}
}
