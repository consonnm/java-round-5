package com.example.fleamarket.controller;
import com.example.fleamarket.response.ResultVo;
import com.example.fleamarket.service.IPostsService;
import com.example.fleamarket.service.IReplyService;
import com.example.fleamarket.utils.AliyunOSSUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping(value = "/reply")
public class ReplyController {
    @Autowired
    IPostsService iPostsService;
    IReplyService iReplyService;
    AliyunOSSUtil aliyunOSSUtil;
    @ApiOperation("无图片添加回复接口")
    @GetMapping("/insertReplyWithoutPic")
    public ResultVo insert1(@ApiParam("主键id")int Id,@ApiParam("帖子id")int postId,@ApiParam("楼层")int floor,@ApiParam("卖家id")int sellManId,@ApiParam("描述")String description) {
        log.info("无图片添加回复接口");
        iReplyService.insertWithoutPic(Id,floor,postId,sellManId,description);
        return new ResultVo().setCode(200);

    }
    @ApiOperation("有图片添加回复接口")
    @GetMapping("/insertReplyWithPic")
    public ResultVo insert2(@ApiParam("主键id")int Id, @ApiParam("帖子id")int postId, @ApiParam("楼层")int floor, @ApiParam("卖家id")int sellManId, @ApiParam("描述")String description,
                            @ApiParam("照片") MultipartFile file) {
        log.info("有图片添加回复接口");
        String pic = aliyunOSSUtil.upload(file);
        iReplyService.insertWithPic(Id,floor,postId,sellManId,pic,description);
        return new ResultVo().setCode(200);

    }

    @ApiOperation("删除回复接口")
    @GetMapping("/deleteReply")
    public ResultVo delete(@ApiParam("主键id")int Id) {
        log.info("删除回复接口");
        iReplyService.remove(Id);
        return new ResultVo().setCode(200);

    }
}
