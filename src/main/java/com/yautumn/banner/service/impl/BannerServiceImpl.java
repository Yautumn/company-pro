package com.yautumn.banner.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.yautumn.banner.entity.CompanyBanner;
import com.yautumn.banner.rowmapper.CompanyBannerRowMapper;
import com.yautumn.banner.service.BannerService;

/**
 * banner操作Service
 * @author Yautumn
 *
 */
@Service
public class BannerServiceImpl implements BannerService {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	/**
	 * 	添加或修改Banner信息
	 */
	public Integer addOrUpdateBanner(CompanyBanner companyBanner) {
		String sql = "insert into company_banner(id,banner_name,banner_picture,banner_state) values(?,?,?,?)";
		Integer i = jdbcTemplate.update(sql,companyBanner.getId(),companyBanner.getBannerName(),companyBanner.getBannerPicture(),companyBanner.getBannerState());
		return i;
	}
	
	/**
	 * 	根据id删除banner信息
	 * @param bannerId
	 * @return
	 */
	public Integer deleteBannerById(String bannerId) {
		String sql = "delete from company_banner cb where cb.id = ?";
		return jdbcTemplate.update(sql, bannerId);
	}
	
	/*
	 * 查询所有Banner
	 */
	public List<CompanyBanner> findAll(){
		String sql = "select cb.id,cb.banner_name,cb.banner_picture,cb.banner_state from company_banner cb";
		RowMapper<CompanyBanner> bannerRowMapper =  new CompanyBannerRowMapper();
		List<CompanyBanner> companyBanners = jdbcTemplate.query(sql, bannerRowMapper);
		return companyBanners;
	}

	/**
	 * 	根据id查询banner信息
	 */
	public CompanyBanner findBannerById(String bannerId) {
		String sql = "select cb.id,cb.banner_name,cb.banner_picture,cb.banner_state from company_banner cb where cb.id = ?";
		CompanyBannerRowMapper companyBannerRowMapper = new CompanyBannerRowMapper();
		CompanyBanner companyBanner = jdbcTemplate.queryForObject(sql, companyBannerRowMapper,bannerId);
		return companyBanner;
	}
}
