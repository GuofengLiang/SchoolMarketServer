package com.market.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * 管理员信息表
 * @author 
 *
 */
@Entity
public class Admin {
   /**
    * 用户id
    */
   @Id
   private int adminId;
   /**
    * 用户名
    */
   @Column(length=12,nullable=false)
   private String adminName;
   /**
    * 用户密码
    */
   @Column(length=20,nullable=false)
   private String password;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	   
}