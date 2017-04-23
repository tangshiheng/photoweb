package com.yue.bean;

public class Photo {
	private Integer id;//图片id
	private String photoName;//图片的名字
	private String url;//图片的url
	private String erea;//描述图片内容
	public Photo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Photo(Integer id, String photoName, String url, String erea) {
		super();
		this.id = id;
		this.photoName = photoName;
		this.url = url;
		this.erea = erea;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getErea() {
		return erea;
	}
	public void setErea(String erea) {
		this.erea = erea;
	}
	@Override
	public String toString() {
		return "Photo [id=" + id + ", photoName=" + photoName + ", url=" + url
				+ ", erea=" + erea + "]";
	}
	
}
