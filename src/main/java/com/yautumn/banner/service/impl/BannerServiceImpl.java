package com.yautumn.banner.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.yautumn.banner.entity.CompanyBanner;
import com.yautumn.banner.rowmapper.CompanyBannerRowMapper;
import com.yautumn.banner.service.BannerService;
import com.yautumn.common.Utils;

@Service
public class BannerServiceImpl implements BannerService {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<CompanyBanner> findAll(){
		String sql = "select cb.id,cb.banner_name,cb.banner_picture,cb.banner_state from company_banner cb";
		RowMapper<CompanyBanner> bannerRowMapper =  new CompanyBannerRowMapper();
		return jdbcTemplate.query(sql, bannerRowMapper);
	}
	
	public Integer addBanner(CompanyBanner companyBanner) {
		String sql = "insert into company_banner values(?,?,?,?)";
		Integer i = jdbcTemplate.update(sql,Utils.getUUID(),companyBanner.getBannerName(),companyBanner.getBannerPicture(),companyBanner.getBannerState());
		return i;
	}
}
