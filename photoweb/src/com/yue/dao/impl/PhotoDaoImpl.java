package com.yue.dao.impl;

import java.util.List;

import com.yue.bean.Photo;
import com.yue.dao.PhotoDao;
import com.yue.util.Utils;

public class PhotoDaoImpl extends BaseDaoImpl<Photo> implements PhotoDao {

	@Override
	public int addPhoto(Photo photo) {
		String sql = "insert into `photo` values(null,?,?,?)";
		return getUpdate(sql, photo.getPhotoName(),photo.getUrl(),photo.getErea());
	}

	@Override
	public int deletePhoto(Integer id) {
		String sql = "delete from `photo` where id = ?";
		return getUpdate(sql, id);
	}

	@Override
	public int updatePhoto(Photo photo) {
		String sql = "UPDATE `photo` SET `photoname` = ?,`url` = ?,`erea` = ? WHERE `id` = ?";
		return getUpdate(sql, photo.getPhotoName(),photo.getUrl(),photo.getErea(),photo.getId());
	}

	@Override
	public Photo onePhoto(Integer id) {
		String sql = "select `id`,`photoname`,`url`,`erea` from `photo` where `id` = ?";
		return getOne(sql, id);
	}

	@Override
	public List<Photo> listPhoto() {
		String sql = "select `id`,`photoname`,`url`,`erea` from `photo`";
		return getList(sql);
	}

	@Override
	public List<Photo> listPagePhoto(Integer begin, Integer size) {
		String sql = "select `id`,`photoname`,`url`,`erea` from `photo` limit ?,?";
		return getList(sql, begin ,size);
	}

	@Override
	public int getTotalCount() {
		String sql = "select count(*) from `photo`";
		Object object = getObject(sql);
		Number number = (Number) object;
		int value = number.intValue();
		//long ss = (long) object;
		//return (int) ss;
		return value;
	}
	//模糊查询
	@Override
	public List<Photo> search(String photoName) {
		String sql = "select `id`,`photoname`,`url`,`erea` from `photo` where `photoname` like ? ";
		return getList(sql, "%"+photoName+"%");
	}
	
}
