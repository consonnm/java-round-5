package com.example.fleamarket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("question")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("帖子")
public class Question {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("问题id")
    int questionId;
    @ApiModelProperty("问题")
    String question;
    @ApiModelProperty("回答")
    String answer;
}
