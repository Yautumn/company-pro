package com.yautumn.banner.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="company_banner")
@NamedQuery(name="CompanyBanner.findAll", query="SELECT c FROM CompanyBanner c")
public class CompanyBanner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="banner_name")
	private String bannerName;

	@Lob
	@Column(name="banner_picture")
	private byte[] bannerPicture;

	@Column(name="banner_state")
	private int bannerState;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createtime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatetime;

	public CompanyBanner() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBannerName() {
		return this.bannerName;
	}

	public void setBannerName(String bannerName) {
		this.bannerName = bannerName;
	}

	public byte[] getBannerPicture() {
		return this.bannerPicture;
	}

	public void setBannerPicture(byte[] bannerPicture) {
		this.bannerPicture = bannerPicture;
	}

	public int getBannerState() {
		return this.bannerState;
	}

	public void setBannerState(int bannerState) {
		this.bannerState = bannerState;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

}