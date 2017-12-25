package com.alix.mytest.dao.base;

import java.util.List;

import org.hibernate.criterion.Order;

/**
 * <pre>基础dao接口<pre>
 * @author Alix
 * @date 2017年12月19日 下午2:54:27
 */
public interface BaseDao<T> {

	/**
	 * <pre>根据id和class得到一条实体<pre>
	 * @param id 实体ID
	 * @param cls 实体class
	 * @return
	 * @author Alix
	 * @date 2017年12月19日 下午2:55:42
	 */
	public T findById(Object id, Class<T> cls);
	
	/**
	 * <pre>新增一条记录<pre>
	 * @param t 需新增实体记录
	 * @return 返回实体存储时生成的主键ID
	 * @author Alix
	 * @date 2017年12月19日 下午2:57:07
	 */
	public Object save(T t);
	
	/**
	 * <pre>更新一条记录<pre>
	 * @param t 需更新的实体记录
	 * @return
	 * @author Alix
	 * @date 2017年12月19日 下午2:59:16
	 */
	public T update(T t);
	
	/**
	 * <pre>删除一条记录<pre>
	 * @param t 需删除的实体记录
	 * @author Alix
	 * @date 2017年12月19日 下午2:58:05
	 */
	public void delete(T t);
	
	/**
	 * <pre>查询所有记录<pre>
	 * @return
	 * @author Alix
	 * @date 2017年12月19日 下午2:59:51
	 */
	public List<T> findAll(Class<T> cls);
	
	/**
	 * <pre>查询所有记录, 支持排序<pre>
	 * @param cls
	 * @param order
	 * @return
	 * @author Alix
	 * @date 2017年12月19日 下午3:04:14
	 */
	public List<T> findAll(Class<T> cls, Order order);
}
