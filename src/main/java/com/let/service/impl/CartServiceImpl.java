package com.let.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.let.common.SysResult;
import com.let.mapper.CartMapper;
import com.let.pojo.Cart;
import com.let.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired	//注入Mapper接口
	private CartMapper cartMapper;
	
	//实现查询我的购物车
	public List<Cart> findMyCart(Long userId){
		//设置where条件,在MybatisPlus中的查询方式QBC,把查询条件封装到QBC对象中,
		EntityWrapper<Cart> ew=new EntityWrapper<Cart>();
		//第一个参数是将要拼接到where条件的,参数的名称是数据库表的字段,{0}是一个占位符
		ew.where("user_id={0}",userId);
		return cartMapper.selectList(ew);
	}
	
	//保存商品到购物车
	public SysResult save(Cart cart) {
		try {
			//查询某个用户的某个商品:count(*)--(0/1)/查询对象是否存在
			//EntityWrapper<Cart> ew=new EntityWrapper<Cart>();
			//ew.where("user_id={0}",userId);
			//ew.and("item_id={0}", itemId);
			//为什么不用上诉方法?字段其他值不匹配
			Cart param=new Cart();
			param.setUserId(cart.getUserId());
			param.setItemId(cart.getItemId());
			//获取数据库中是否有商品的信息
			Cart oldCart=cartMapper.selectOne(cart);
			//判断oldCart中是否有值,如果有,则是update,如果没有,就save
			if(oldCart==null) {
				//新增
				cartMapper.insert(cart);
				return SysResult.oK();
			}else {
				//修改
				cart.setNum(oldCart.getNum()+cart.getNum());
				EntityWrapper<Cart> ew=new EntityWrapper<Cart>();
				ew.where("user_id={0}",cart.getUserId());
				ew.and("item_id={0}", cart.getItemId());
				cartMapper.update(cart, ew);
				return SysResult.build(202,"此商品已存在购物车!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "添加购物车失败!");
	}
	
	//修改商品数量(数量是传递过来的具体值,直接做修改,不做+-)
	public void updateNum(Cart cart) {
		EntityWrapper<Cart> ew=new EntityWrapper<Cart>();
		ew.where("user_id={0}", cart.getUserId());
		ew.and("item_id={0}",cart.getItemId());
		cartMapper.update(cart, ew);
	}
	
	//删除某个用户的某个商品
	public void delete(Long userId,Long itemId) {
		//构造where条件
		EntityWrapper<Cart> ew=new EntityWrapper<Cart>();
		ew.where("user_id={0}", userId);
		ew.and("item_id={0}",itemId);
		cartMapper.delete(ew);
	}
	
}
