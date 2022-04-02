package com.example.fleamarket.empty;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@TableName("book_context")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "关注")
public class Follow  extends AbstractAuditingEntity {
	@ApiModelProperty("主键，自增")
	Integer id;
	@ApiModelProperty("关注者的id")
	Integer followerId;
	@ApiModelProperty("被关注者的id")
	Integer followedId;
}
