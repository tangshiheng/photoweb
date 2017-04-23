package com.yue.dao;

import java.util.List;

import com.yue.bean.Photo;

public interface PhotoDao {
	//添加图片
	public int addPhoto(Photo photo);
	//删除图片
	public int deletePhoto(Integer id);
	//修改图片
	public int updatePhoto(Photo photo);
	//查找单个图片
	public Photo onePhoto(Integer id);
	//查找所有的图片
	public List<Photo> listPhoto();
	//分页查询每页的数据
	public List<Photo> listPagePhoto(Integer begin, Integer size);
	//查询所有的记录数
	public int getTotalCount();
	
	//模糊查询
	public  List<Photo> search(String photoName);

}
