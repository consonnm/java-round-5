package com.example.fleamarket.empty;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@TableName("history")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "浏览记录")
public class History extends AbstractAuditingEntity {
    @ApiModelProperty("主键，自增")
    Integer id;
    @ApiModelProperty("用户的id")
    Integer userId;
    @ApiModelProperty("商品的id")
    Integer goodsId;
}
