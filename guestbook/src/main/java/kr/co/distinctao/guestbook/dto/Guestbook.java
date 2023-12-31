package kr.co.distinctao.guestbook.dto;

import java.util.Date;

public class Guestbook {
	private Long id;
	private String name;
	private String content;
	private Date regdate;
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getContent() {
		return content;
	}
	
	public Date getRegdate() {
		return regdate;
	}

	@Override
	public String toString() {
		return "Guestbook [id=" + id + ", name=" + name + ", content=" + content + ", regdate=" + regdate + "]";
	}
	
}
