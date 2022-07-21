package com.example.novel.core.common.req;

import lombok.Data;

/**
 * 分页请求数据格式封装，所有分页请求的Dto类都应继承该类
 * @author:wxh
 * @date:2022/7/18
 **/
@Data
public class PageReqDto {
    /**
     * 请求页码，默认第 1 页
     */
    private int pageNum = 1;

    /**
     * 每页大小，默认每页 10 条
     */
    private int pageSize = 10;

    /**
     * 是否查询所有，默认不查所有
     * 为true, pageNUM 和 pageSize 无效
     */
    private boolean fetchAll = false;
}
