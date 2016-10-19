package com.wen.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wen.dao.OrderDao;
import com.wen.domain.Order;

/**
 * 
 * @author Wen
 * @CreatDate: 2016年5月9日
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Value("${jdbc.driverClass}")
	private String testJdbc;
	@Resource
	private OrderDao orderDao;

	@Override
	public String getTestJdbc() {
		return testJdbc;
	}


	@Transactional
	@Override
	public void add(Order order) {
		orderDao.add_(order);
		
		Order dbOrder = orderDao.getById_(order.getId());
		System.out.println(dbOrder);
		if(dbOrder.getId() %2 ==0){
			throw new RuntimeException("ahahahh");
		}
		
		order.setName("test1111");
		orderDao.add_(order);
	}

}
