package com.example.novel.service.impl;

import com.example.novel.core.common.resp.RestResp;
import com.example.novel.dto.resp.HomeBookRespDto;
import com.example.novel.manager.HomeBookCacheManager;
import com.example.novel.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 首页模块 服务实现类
 *
 * @author:wxh
 * @date:2022/7/21
 **/

@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {

    private final HomeBookCacheManager homeBookCacheManager;

    @Override
    public RestResp<List<HomeBookRespDto>> listHomeBooks() {
        return RestResp.ok(homeBookCacheManager.listHomeBooks());
    }
}

