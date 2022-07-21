package com.example.novel.service;

import com.example.novel.core.common.resp.RestResp;
import com.example.novel.dto.resp.HomeBookRespDto;

import java.util.List;

/**
 * 首页模块
 * @author:wxh
 * @date:2022/7/21
 **/
public interface HomeService {

    /**
     * 查询首页小说推荐列表
     *
     * @return 首页小说推荐列表的rest响应结果
     */

    RestResp<List<HomeBookRespDto>> listHomeBooks();
}
