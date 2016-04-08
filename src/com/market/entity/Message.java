package com.market.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.joda.time.DateTime;
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
	@Id
	private int messageId;
	/**
	 * 用户id
	 */
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional = false)
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
	private DateTime date;
	/**
	 * 已读
	 */
	private int read;
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
	public DateTime getDate() {
		return date;
	}
	public void setDate(DateTime date) {
		this.date = date;
	}
	public int getRead() {
		return read;
	}
	public void setRead(int read) {
		this.read = read;
	}

}
