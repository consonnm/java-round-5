package com.example.fleamarket.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@TableName("announcement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Announcement extends AbstractAuditingEntity{
    @ApiModelProperty("公告id")
    int announcementId;
    @ApiModelProperty("公告内容")
    String context;

}
