package com.yue.service;

import java.util.List;

import com.yue.bean.Page;
import com.yue.bean.Photo;

public interface PhotoService {
	// 添加图片
	public int addPhoto(Photo photo);

	// 删除图片
	public int deletePhoto(Integer id);

	// 修改图片
	public int updatePhoto(Photo photo);

	// 查找单个图片
	public Photo onePhoto(Integer id);

	// 查找所有的图片
	public List<Photo> listPhoto();
	
	//分页显示每页的图片信息
	public Page<Photo> queryPagePhoto(Integer pageNo,Integer pageSize);
	
	//模糊查询
	public  List<Photo> search(String PhotoName);
}
