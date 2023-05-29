package com.sense.web.entity;

import java.util.Date;

public class Notice {
	
	private int nid;
	private String title;
	private String writerId;
	private Date reg;
	private int hit;
	private String content;
	private String files;
	private boolean pub;
	
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Notice(int nid, String title, String writerId, Date reg, int hit, String content, String files,
			boolean pub) {
		this(nid, title, writerId, reg, hit);
		this.content = content;
		this.files = files;
		this.pub = pub;
	}


	public Notice(int nid, String title, String writerId, Date reg, int hit) {
		this.nid = nid;
		this.title = title;
		this.writerId = writerId;
		this.reg = reg;
		this.hit = hit;
		
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
	
	


	public String getFiles() {
		return files;
	}


	public void setFiles(String files) {
		this.files = files;
	}


	public boolean isPub() {
		return pub;
	}


	public void setPub(boolean pub) {
		this.pub = pub;
	}


	@Override
	public String toString() {
		return "Board [nid=" + nid + ", title=" + title + ", writerId=" + writerId + ", reg=" + reg + ", hit=" + hit
				+ ", content=" + content + "]";
	}
	
}
