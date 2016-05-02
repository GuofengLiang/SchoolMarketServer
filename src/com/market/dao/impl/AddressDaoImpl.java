package com.market.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.market.dao.AddressDao;
import com.market.entity.Address;
import com.market.entity.User;
import com.market.javabean.AddressBean;

@Repository
public class AddressDaoImpl implements AddressDao {
	@PersistenceContext
	protected EntityManager entityManager;

	/* (non-Javadoc)
	 * @see com.market.dao.AddressDao#findAllAdress(int)
	 */
	/**
	 * 根据用户id查找收货地址
	 */
	@Override
	public List<AddressBean> findAllAddress(int userId) {
		Query query = entityManager.createQuery("select s from Address s where s.user.userId=?1");
		query.setParameter(1, userId);
		@SuppressWarnings("unchecked")
		List<Address> address = query.getResultList();
		List<AddressBean> addressListBean = new ArrayList<AddressBean>();
		for(int i = 0; i<address.size(); i++) {
			AddressBean addressBean = new AddressBean();
			addressBean.setAddressId(address.get(i).getAddressId());
			addressBean.setAddressDetail(address.get(i).getAddressDetail());
			addressBean.setConsignee(address.get(i).getConsignee());
			addressBean.setPhone(address.get(i).getPhone());
			addressBean.setUserId(address.get(i).getUser().getUserId());
			addressListBean.add(addressBean);
		}
		return addressListBean;
	}

	/**
	 * 根据收货地址编号查找收货地址编号
	 */
	@Override
	public AddressBean findSingleAddress(int addressId) {
		Query query = entityManager.createQuery("select s from Address s where s.addressId=?1");
		query.setParameter(1, addressId);
		Address address = (Address) query.getSingleResult();
		AddressBean addressBean = new AddressBean();
		addressBean.setAddressDetail(address.getAddressDetail());
		addressBean.setAddressId(address.getAddressId());
		addressBean.setConsignee(address.getConsignee());
		addressBean.setPhone(address.getPhone());
		addressBean.setUserId(address.getUser().getUserId());
		return addressBean;
	}

	/**
	 * 添加单个收货地址
	 */
	@Override
	@Transactional
	public void addSingleAddress(int userId, String addressDetail, String consignee, String phone, int defaultedAddress) {
		//通过userId获取用户
		Query query = entityManager.createQuery("select u from User u where u.userId=?1");
		query.setParameter(1, userId);
		User user = (User) query.getSingleResult();
		//持久化address
		Address address = new Address();
		address.setAddressDetail(addressDetail);
		address.setConsignee(consignee);
		address.setPhone(phone);
		address.setUser(user);
		address.setDefaultedAddress(defaultedAddress);
		entityManager.persist(address);
	}

}
