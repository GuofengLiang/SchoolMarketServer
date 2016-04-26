package com.market.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.market.dao.AddressDao;
import com.market.javabean.AddressBean;

@Repository
public class AddressDaoImpl implements AddressDao {
	@PersistenceContext
	protected EntityManager entityManager;

	/* (non-Javadoc)
	 * @see com.market.dao.AddressDao#findAllAdress(int)
	 */
	@Override
	public List<AddressBean> findAllAdress(int userId) {
		Query query = entityManager.createQuery("select s from Address s where s.user.userId=?1");
		query.setParameter(1, userId);
		@SuppressWarnings("unchecked")
		List<AddressBean> addressBean = query.getResultList();
		return addressBean;
	}

}
