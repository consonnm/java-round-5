package com.example.fleamarket.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@TableName("collection")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "收藏")
public class Collection extends AbstractAuditingEntity {
	@ApiModelProperty("用户的id")
	Integer userId;
	@ApiModelProperty("商品的id")
	Integer goodId;
}