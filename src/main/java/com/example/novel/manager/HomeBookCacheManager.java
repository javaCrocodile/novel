package com.example.novel.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.novel.dao.entity.BookInfo;
import com.example.novel.dao.entity.HomeBook;
import com.example.novel.dao.mapper.BookInfoMapper;
import com.example.novel.dao.mapper.HomeBookMapper;
import com.example.novel.dto.resp.HomeBookRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import com.example.novel.core.constant.CacheConsts;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *首页推荐小说 缓存管理类
 * @author:wxh
 * @date:2022/7/20
 **/
@Component
@RequiredArgsConstructor
public class HomeBookCacheManager {

    private final HomeBookMapper homeBookMapper;

    private final BookInfoMapper bookInfoMapper;

    /**
     * 查询小说推荐，并放入缓存中
     */
    //cacheManager用来获取缓存管理器，value用来指定缓存组件的名字，将方法的返回结果放在哪个缓存中，可以是数组的方式，支持指定多个缓存
    @Cacheable(cacheManager = CacheConsts.CAFFEINE_CACHE_MANAGER, value = CacheConsts.HOME_BOOK_CACHE_NAME)
    public List<HomeBookRespDto> listHomeBooks(){
        //从首页小说推荐表中查询出需要推荐的小说
        List<HomeBook> homeBooks = homeBookMapper.selectList(null);

        //获取推荐小说ID列表
        if (!CollectionUtils.isEmpty(homeBooks)){
            List<Long> bookIds = homeBooks.stream()
                    .map(HomeBook::getBookId)
                    .toList();

            //根据小说ID列表查询相关的小说信息列表
            QueryWrapper<BookInfo> bookInfoQueryWrapper = new QueryWrapper<>();
            bookInfoQueryWrapper.in("id", bookIds);
            List<BookInfo> bookInfos = bookInfoMapper.selectList(bookInfoQueryWrapper);

            //组装 HomeBook
            if (!CollectionUtils.isEmpty(bookInfos)){
                Map<Long, BookInfo> bookInfoMap = bookInfos.stream()
                        .collect(Collectors.toMap(BookInfo::getId, Function.identity()));
                return homeBooks.stream().map(v -> {
                    BookInfo bookInfo = bookInfoMap.get(v.getBookId());
                    HomeBookRespDto bookRespDto = new HomeBookRespDto();
                    bookRespDto.setBookId(v.getBookId());
                    bookRespDto.setBookName(bookInfo.getBookName());
                    bookRespDto.setPicUrl(bookInfo.getPicUrl());
                    bookRespDto.setAuthorName(bookInfo.getAuthorName());
                    bookRespDto.setBookDesc(bookInfo.getBookDesc());
                    return bookRespDto;
                }).toList();

            }
        }
        return Collections.emptyList();
    }
}
