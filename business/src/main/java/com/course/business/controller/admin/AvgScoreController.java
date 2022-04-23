package com.course.business.controller.admin;

import com.course.server.dto.AvgScoreDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.AvgScoreService;
import com.course.server.util.ValidatorUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/avgScore")
@Api(
        value = "平均分Controller",
        tags = {"平均分Controller"},
        protocols = "http, https",
        hidden = false
)
public class AvgScoreController {
    public static final String BUSINESS_NAME = "平均分";
    @Resource
    private AvgScoreService avgScoreService;

    @PostMapping("/list")
    @ApiOperation(value = "查看平均分列表",
            response = ResponseDto.class,
            httpMethod = "POST"
    )
    public ResponseDto avgScore(@RequestBody PageDto pageDto){
        ResponseDto responseDto = new ResponseDto();
        avgScoreService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }
    @PostMapping("/save")
    @ApiOperation(value = "保存平均分",
            response = ResponseDto.class,
            httpMethod = "POST"
    )
    public ResponseDto save(@RequestBody AvgScoreDto avgScoreDto){
        // 保存校验

        ResponseDto responseDto = new ResponseDto();
        avgScoreService.save(avgScoreDto);
        responseDto.setContent(avgScoreDto);
        return responseDto;
    }
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除平均分",
            response = ResponseDto.class,
            httpMethod = "POST"
    )
    public ResponseDto delete(@PathVariable String id){
        ResponseDto responseDto = new ResponseDto();
        avgScoreService.delete(id);
        return responseDto;
    }

}
