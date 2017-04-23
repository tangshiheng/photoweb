package com.yue.test;


import java.util.List;

import org.junit.Test;

import com.yue.bean.Photo;
import com.yue.dao.PhotoDao;
import com.yue.dao.impl.PhotoDaoImpl;

public class PhotoDaoImplTest {
	PhotoDao photoDao = new PhotoDaoImpl();
	@Test
	public void testAddPhoto() {
		Photo photo = new Photo(null, "添加的第一张", "imges/p1.jpg", "看看添加图片成功吗？");
		int addPhoto = photoDao.addPhoto(photo);
		System.out.println(addPhoto);
	}

	@Test
	public void testDeletePhoto() {
		int deletePhoto = photoDao.deletePhoto(5);
		System.out.println(deletePhoto);
	}

	@Test
	public void testUpdatePhoto() {
		Photo photo = new Photo(6, "就是修改下", "images/p1.jpg", "修改成功了");
		int updatePhoto = photoDao.updatePhoto(photo);
		System.out.println(updatePhoto);
	}

	@Test
	public void testOnePhoto() {
		Photo photo = photoDao.onePhoto(1);
		System.out.println(photo);
	}

	@Test
	public void testListPhoto() {
		List<Photo> listPhoto = photoDao.listPhoto();
		System.out.println(listPhoto);
	}
	@Test
	public void testPagePhoto() {
		List<Photo> photo = photoDao.listPagePhoto(2,2);
		System.out.println(photo);
	}
	
	@Test
	public void testSearch() {
		List<Photo> search = photoDao.search("p1");
		System.out.println(search);
	}
}
