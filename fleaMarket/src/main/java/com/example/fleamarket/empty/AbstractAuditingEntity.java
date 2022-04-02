package com.example.fleamarket.empty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

@Data
@ApiModel(description = "所有实体类的抽象父类，包括插入者，插入时间，更新者，更新时间等属性")
public abstract class AbstractAuditingEntity {
	@ApiModelProperty(value = "执行插入的用户的用户名")
	String insertUserUsername;
	@ApiModelProperty(value = "插入时间")
	Date insertDate;
	@JsonIgnore
	@ApiModelProperty(value = "执行最后一次更新的用户的用户名")
	String updateUserUsername;
	@JsonIgnore
	@ApiModelProperty(value = "执行最后一次更新的时间")
	Date updateDate;
}
