package com.yautumn.banner.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yautumn.banner.entity.CompanyBanner;

public class CompanyBannerRowMapper implements RowMapper<CompanyBanner> {

	@Override
	public CompanyBanner mapRow(ResultSet rs, int rowNum) throws SQLException {
		CompanyBanner companyBanner = new CompanyBanner();
		companyBanner.setId(rs.getString("id"));
		companyBanner.setBannerName(rs.getString("banner_name"));
		companyBanner.setBannerPicture(rs.getBytes("banner_picture"));
		companyBanner.setBannerState(rs.getInt("banner_state"));
		return companyBanner;
	}

}
