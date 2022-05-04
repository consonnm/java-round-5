package com.example.fleamarket.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@TableName("posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("帖子")
public class Posts extends AbstractAuditingEntity{
    @ApiModelProperty("帖子id")
    int postId;
    @ApiModelProperty("寻物用户的id")
    int buyerId;
    @ApiModelProperty("求物描述")
    String description;


}
