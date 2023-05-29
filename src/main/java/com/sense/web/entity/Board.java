package com.sense.web.entity;

import java.util.Date;

public class Board {
	
	private int nid;
	private String title;
	private String writerId;
	private Date reg;
	private int hit;
	private String content;
	
	
	public Board(int nid, String title, String writerId, Date reg, int hit, String content) {
		this.nid = nid;
		this.title = title;
		this.writerId = writerId;
		this.reg = reg;
		this.hit = hit;
		this.content = content;
	}


	public int getNid() {
		return nid;
	}


	public void setNid(int nid) {
		this.nid = nid;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getWriterId() {
		return writerId;
	}


	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}


	public Date getReg() {
		return reg;
	}


	public void setReg(Date reg) {
		this.reg = reg;
	}


	public int getHit() {
		return hit;
	}


	public void setHit(int hit) {
		this.hit = hit;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "Board [nid=" + nid + ", title=" + title + ", writerId=" + writerId + ", reg=" + reg + ", hit=" + hit
				+ ", content=" + content + "]";
	}
	
}
