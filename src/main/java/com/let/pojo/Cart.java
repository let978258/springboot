package com.let.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

//配置MybatisPlus
@TableName(value="tb_cart") //类和数据库表的映射
public class Cart extends BasePojo{

	@TableId(type=IdType.AUTO) //主键 自增id
	private Long id;
	//@TableField(value="user_id") 基于MybatisPlus和和Mybatis下配置驼峰规则
	private Long userId;
	//@TableField(value="item_id")
	private Long itemId;
	//@TableField(value="item_title")
	private String itemTitle;
	//@TableField(value="item_image")
	private String itemImage;
	//@TableField(value="item_price")
	private Long itemPrice;//(*100)
	private Integer num;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemTitle() {
		return itemTitle;
	}
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	public Long getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Long itemPrice) {
		this.itemPrice = itemPrice;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
}
