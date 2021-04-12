package com.banjo.blogvue.util;


import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

// 这个类是用于分页显示的
// <T>表示这个类是支持泛型的

@Data
public class Page4Navigator<T> {

    // 将JPA的page，封装到该类里面
    Page<T> pageFromJPA;

    // 这个参数是用来控制分页显示的页数，如果这个数是5，并且当前页是3
    // 那么就显示 1 2 3 4 5 这个五个分页。以此类推
    int navigatePages;

    // 数组 用于存储，上面根据navigatePages推断出来的 navigatePages 个 需要在前端展示的分页数
    int[] navigatePageNums;

    // 总页数
    int totalPages;

    // 第几页（基0）
    int number;

    // 总共有多少条数据
    long totalElements;

    // 每一页有多少条数据
    int size;

    // 当前页面有多少数据
    int numberOfElements;

    // 数据集合
    List<T> content;

    boolean isHasContent;

    boolean first;

    boolean last;

    boolean isHasNext;

    boolean isHasPrevious;


    public Page4Navigator() {
        //这个空的分页是为了 Redis 从 json格式转换为 Page4Navigator 对象而专门提供的
    }

    public Page4Navigator(Page<T> pageFromJPA) {
        this.pageFromJPA = pageFromJPA;

        totalPages = pageFromJPA.getTotalPages();

        number  = pageFromJPA.getNumber() ;

        totalElements = pageFromJPA.getTotalElements();

        size = pageFromJPA.getSize();

        numberOfElements = pageFromJPA.getNumberOfElements();

        content = pageFromJPA.getContent();

        isHasContent = pageFromJPA.hasContent();

        first = pageFromJPA.isFirst();

        last = pageFromJPA.isLast();

        isHasNext = pageFromJPA.hasNext();

        isHasPrevious  = pageFromJPA.hasPrevious();

    }

}
