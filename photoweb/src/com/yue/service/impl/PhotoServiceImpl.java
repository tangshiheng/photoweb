package com.yue.service.impl;

import java.util.List;

import com.yue.bean.Page;
import com.yue.bean.Photo;
import com.yue.dao.PhotoDao;
import com.yue.dao.impl.PhotoDaoImpl;
import com.yue.service.PhotoService;

public class PhotoServiceImpl implements PhotoService {
	PhotoDao photoDao = new PhotoDaoImpl();
	@Override
	public int addPhoto(Photo photo) {
		return photoDao.addPhoto(photo);
	}

	@Override
	public int deletePhoto(Integer id) {
		return photoDao.deletePhoto(id);
	}

	@Override
	public int updatePhoto(Photo photo) {
		return photoDao.updatePhoto(photo);
	}

	@Override
	public Photo onePhoto(Integer id) {
		return photoDao.onePhoto(id);
	}

	@Override
	public List<Photo> listPhoto() {
		return photoDao.listPhoto();
	}
	//分页的操作
	@Override
	public Page<Photo> queryPagePhoto(Integer pageNo,Integer pageSize) {
		//首先创建分页的模型
		Page<Photo> page = new Page<Photo>();
		//将每页显示的数据放在模型中
		page.setPageSize(pageSize);
		//获取总的记录数
		int totalCount = photoDao.getTotalCount();
		page.setTotalCount(totalCount);
		//获取总的页数
		int pageTotal = 0;
		pageTotal= page.getTotalCount()/page.getPageSize();
		if(page.getTotalCount()%page.getPageSize()!=0) {
			pageTotal++;
		}
		//设置总的页数
		page.setPageTotal(pageTotal);
		//设置当前页数
		page.setPageNo(pageNo);
		//要查找的索引值
		int begin  = (page.getPageNo()-1)*page.getPageSize();
		//每页的记录数
		int size = page.getPageSize();
		//调用dao查询每页的图片信息
		List<Photo> photo = photoDao.listPagePhoto(begin, size);
		//将获取的每页的数据集合放在page里面
		page.setItems(photo);
		//返回封装的page模型 
		return page;
	}

	@Override
	public List<Photo> search(String PhotoName) {
		return photoDao.search(PhotoName);
	}

}
