package com.example.fleamarket.empty;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("audit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Audit extends AbstractAuditingEntity{

    @ApiModelProperty(" 审核记录id")
    int auditId;
    @ApiModelProperty("商品的id")
    int goodId;
    @ApiModelProperty("管理员id")
    int adminId;
    @ApiModelProperty("审核情况")
    Boolean status;
}
