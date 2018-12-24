package com.yautumn.banner.service;

import java.util.List;

import com.yautumn.banner.entity.CompanyBanner;

public interface BannerService {

	public Integer addOrUpdateBanner(CompanyBanner companyBanner);
	
	public Integer deleteBannerById(String bannerId);
	
	public List<CompanyBanner> findAll();
	
	public CompanyBanner findBannerById(String bannerId);
}
