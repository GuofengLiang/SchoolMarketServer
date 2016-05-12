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
			addressBean.setDefaultedAddress(address.get(i).getDefaultedAddress());
			addressBean.setFreight(10);
			addressListBean.add(addressBean);
		}
		return addressListBean;
	}

	/**
	 * 根据收货地址编号查找收货地址
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
		addressBean.setDefaultedAddress(address.getDefaultedAddress());
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
		Query query1 = entityManager.createQuery("select a from Address a where a.user.userId=?1");
		query.setParameter(1, userId);
		query1.setParameter(1, userId);
		List<Address> addresses = query1.getResultList();
		User user = (User) query.getSingleResult();
		if(addresses.size()>0) {
			Address address1 = DefaultedAddress(userId);	//查找默认地址
			if(defaultedAddress == 1 && address1.getDefaultedAddress()==1){
				address1.setDefaultedAddress(0);
			}
		}
		//持久化address
		Address address = new Address();
		address.setAddressDetail(addressDetail);
		address.setConsignee(consignee);
		address.setPhone(phone);
		address.setUser(user);
		address.setDefaultedAddress(defaultedAddress);
		entityManager.persist(address);
	}

	/**
	 * 根据用户id查找默认地址
	 */
	@Override
	public List<AddressBean> findDefaultedAddress(int userId) {
		Query query = entityManager.createQuery("select a from Address a where a.user.userId=?1 and a.defaultedAddress=1");
		query.setParameter(1, userId);
	//	query.setParameter(2,"1");
		Address address = (Address) query.getSingleResult();
		List<AddressBean> addressListBean = new ArrayList<AddressBean>();
		for(int i = 0; i<1; i++) {
			AddressBean addressBean = new AddressBean();
			addressBean.setAddressDetail(address.getAddressDetail());
			addressBean.setAddressId(address.getAddressId());
			addressBean.setConsignee(address.getConsignee());
			addressBean.setDefaultedAddress(address.getDefaultedAddress());
			addressBean.setPhone(address.getPhone());
			addressBean.setFreight(10);
			addressListBean.add(addressBean);
		}
		return addressListBean;
	}

	/**
	 * 根据用户id查找默认地址
	 */
	@Override
	public Address DefaultedAddress(int userId) {
		Query query = entityManager.createQuery("select a from Address a where a.user.userId=?1 and a.defaultedAddress=1");
		query.setParameter(1, userId);
	//	query.setParameter(2,"1");
		Address address =  (Address) query.getSingleResult();
		return address;
	}
		
	/**
	 * 根据收货地址编号查找收货地址
	 */
	@Override
	public Address findOneAddress(int addressId) {
		Query query = entityManager.createQuery("select s from Address s where s.addressId=?1");
		query.setParameter(1, addressId);
		Address address = (Address) query.getSingleResult();
		return address;
	}
	/**
	 * 根据收货地址id修改收货地址信息
	 */
	@Override
	@Transactional
	public void alterAddress(int addressId, String addressDetail, String consignee, String phone, int defaultedAddress) {
		Query query = entityManager.createQuery("select a from Address a where a.addressId=?1");
		query.setParameter(1, addressId);
		Address address = (Address) query.getSingleResult();
		Address address1 = DefaultedAddress(address.getUser().getUserId());	//查找默认地址
		if(defaultedAddress == 1 && address1.getDefaultedAddress()==1) {
			address1.setDefaultedAddress(0);
			
		}
		address.setAddressDetail(addressDetail);
		address.setConsignee(consignee);
		address.setDefaultedAddress(defaultedAddress);
		address.setPhone(phone);
	}

	/**
	 * 删除收货地址
	 */
	@Override
	@Transactional
	public void deleteAddress(int addressId) {
		Query query = entityManager.createQuery("select a from Address a where a.addressId=?1");
		query.setParameter(1, addressId);
		Address address = (Address) query.getSingleResult();
		entityManager.remove(address);
	}

}
