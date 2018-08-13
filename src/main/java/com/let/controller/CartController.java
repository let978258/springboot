package com.let.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.let.common.SysResult;
import com.let.pojo.Cart;
import com.let.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping("/query/{userId}")//查询我的购物车
	public SysResult findMyCart(@PathVariable Long userId) {
		try {
			List<Cart> cartList=cartService.findMyCart(userId);
			return SysResult.oK(cartList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "查询购物车记录失败!");
	}
	
	@RequestMapping("/save")//保存商品到购物车
	public SysResult save(Cart cart) {
		//模拟发起post请求,使用httpClient模拟
		return cartService.save(cart);
	} 
	
	@RequestMapping("/update/{userId}/{itemId}/{num}")//更新商品数量
	public SysResult updateNum(@PathVariable Long userId,
							   @PathVariable Long itemId,
							   @PathVariable Integer num) {
		try {
			Cart cart=new Cart();
			cart.setUserId(userId);
			cart.setItemId(itemId);
			cart.setNum(num);
			cartService.updateNum(cart);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201,"修改商品数量失败!");
	}
	
	@RequestMapping("/delete/{userId}/{itemId}")//删除购物车中商品 使用了不同方式接受参数
	public SysResult delete(@PathVariable Long userId,
							@PathVariable Long itemId) {
		try {
			cartService.delete(userId, itemId);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "删除商品失败!");
	}
	
	
}
