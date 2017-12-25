package com.alix.mytest.dao.base;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * <pre>基础dao接口实现类<pre>
 * @author Alix
 * @date 2017年12月20日 上午10:31:43
 */
@Repository
public class BaseDaoImpl<T> implements BaseDao<T>{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public T findById(Object id, Class<T> cls) {
		Criteria cri = this.getSession().createCriteria(cls).add(Restrictions.idEq(id));
		if (cri != null) {
			List list = cri.list();
			if (list != null && list.size() > 0) {
				return (T) list.get(0);
			} else {
				throw new RuntimeException("根据主键ID查询时,返回多条记录!");
			}
		} else {
			return null;
		}
	}

	@Override
	public Object save(T t) {
		return this.getSession().save(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T update(T t) {
		return (T) this.getSession().merge(t);
	}

	@Override
	public void delete(T t) {
		this.getSession().delete(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<T> cls) {
		return this.getSession().createCriteria(cls).addOrder(Order.asc("id")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<T> cls, Order order) {
		return this.getSession().createCriteria(cls).addOrder(order).list();
	}

}
