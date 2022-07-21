package com.example.novel.controller.front;

import com.example.novel.core.common.resp.RestResp;
import com.example.novel.core.constant.ApiRouteConsts;
import com.example.novel.dto.resp.HomeBookRespDto;
import com.example.novel.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 首页模块 API接口
 *
 * @author:wxh
 * @date:2022/7/21
 **/
@RestController
@RequestMapping(ApiRouteConsts.API_FRONT_HOME_URL_PREFIX)
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    /**
     * 首页小说推荐接口
     */
    @GetMapping("books")
    public RestResp<List<HomeBookRespDto>> listHomeBooks(){
        return homeService.listHomeBooks();
    }
}
