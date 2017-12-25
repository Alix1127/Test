package com.alix.mytest.service.base;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alix.mytest.dao.base.BaseDao;
import com.alix.mytest.entity.BaseEntity;

/**
 * <pre>基础service实现类<pre>
 * @author Alix
 * @date 2017年12月20日 上午10:32:07
 */
@Component
@Transactional(readOnly=true)
public class BaseService<T extends BaseEntity>{

	@Autowired
	@Qualifier("baseDaoImpl")
	private BaseDao<T> baseDao;
	
	/**
	 * <pre>根据id和class得到一条实体<pre>
	 * @param id 实体ID
	 * @param cls 实体class
	 * @return
	 * @author Alix
	 * @date 2017年12月19日 下午2:55:42
	 */
	public T findById(Object id, Class<T> cls) {
		return this.baseDao.findById(id, cls);
	}
	
	/**
	 * <pre>新增一条记录<pre>
	 * @param t 需新增实体记录
	 * @return 返回实体存储时生成的主键ID
	 * @author Alix
	 * @date 2017年12月19日 下午2:57:07
	 */
	@Transactional(readOnly=false)
	public Object save(T t) {
		return this.baseDao.save(t);
	}
	
	/**
	 * <pre>更新一条记录<pre>
	 * @param t 需更新的实体记录
	 * @return
	 * @author Alix
	 * @date 2017年12月19日 下午2:59:16
	 */
	@Transactional(readOnly=false)
	public T update(T t) {
		return this.baseDao.update(t);
	}
	
	/**
	 * <pre>删除一条记录<pre>
	 * @param t 需删除的实体记录
	 * @author Alix
	 * @date 2017年12月19日 下午2:58:05
	 */
	@Transactional(readOnly=false)
	public void delete(T t) {
		this.baseDao.delete(t);
	}
	
	/**
	 * <pre>查询所有记录<pre>
	 * @return
	 * @author Alix
	 * @date 2017年12月19日 下午2:59:51
	 */
	public List<T> findAll(Class<T> cls) {
		return this.baseDao.findAll(cls);
	}
	
	/**
	 * <pre>查询所有记录, 支持排序<pre>
	 * @param cls
	 * @param order
	 * @return
	 * @author Alix
	 * @date 2017年12月19日 下午3:04:14
	 */
	public List<T> findAll(Class<T> cls, Order order) {
		return this.baseDao.findAll(cls, order);
	}
}
