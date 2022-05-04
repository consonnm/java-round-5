package com.example.fleamarket.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@TableName("posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("帖子")
public class Reply extends AbstractAuditingEntity{
    @ApiModelProperty("主键id")
    int Id;
    @ApiModelProperty("对应帖子id")
    int postId;
    @ApiModelProperty("回复用户的id")
    int sellManId;
    @ApiModelProperty("描述")
    String description;
    @ApiModelProperty("图片")
    String pic;
    @ApiModelProperty("楼层")
    int floor;
}
