package com.let.service;

import java.util.List;

import com.let.common.SysResult;
import com.let.pojo.Cart;

public interface CartService {

	List<Cart> findMyCart(Long userId);
	
	SysResult save(Cart cart) ;
	
	void updateNum(Cart cart);
	
	void delete(Long userId,Long itemId);
}
