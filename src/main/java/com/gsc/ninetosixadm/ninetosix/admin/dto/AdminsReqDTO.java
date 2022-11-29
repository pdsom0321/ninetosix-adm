package com.gsc.ninetosixadm.ninetosix.admin.dto;

import lombok.Getter;

@Getter
public class AdminsReqDTO {
    private String keyword;
    private Integer page;
    private Integer size;
    private Integer draw;
    private Integer start;
    private Integer length;

    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 15;
    private static final Integer DEFAULT_PAGE_DRAW = 1;
    private static final Integer DEFAULT_PAGE_START = 0;
    private static final Integer DEFAULT_PAGE_LENGTH = 10;

    public AdminsReqDTO(Integer page, Integer size, String keyword, Integer draw, Integer start, Integer length) {
        this.page = page == null ? DEFAULT_PAGE_NUMBER : page;
        this.size = size == null ? DEFAULT_PAGE_SIZE : size;
        this.draw = draw == null ? DEFAULT_PAGE_DRAW : draw;
        this.start = start == null ? DEFAULT_PAGE_START : start;
        this.length = length == null ? DEFAULT_PAGE_LENGTH : length;
        this.keyword = keyword;
    }
}
