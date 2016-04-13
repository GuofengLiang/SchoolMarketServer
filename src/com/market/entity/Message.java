package com.market.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 信息表
 * @author guofeng
 *
 */
@Entity
public class Message {
	
	/**
	 * 消息id
	 */
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable=false)
	private int messageId;
	/**
	 * 用户id
	 */
	@ManyToOne(fetch = FetchType.EAGER,optional = false)
	@JoinColumn(name="user_id")
	private User user;
	/**
	 * 标题
	 */
	@Column(length=20)
	private String title;
	/**
	 * 内容
	 */
	@Column(length=100)
	private String content;
	/**
	 * 日期
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date date;
	/**
	 * 已读
	 */
	private int alreadyRead;
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getAlreadyRead() {
		return alreadyRead;
	}
	public void setAlreadyRead(int alreadyRead) {
		this.alreadyRead = alreadyRead;
	}

}
