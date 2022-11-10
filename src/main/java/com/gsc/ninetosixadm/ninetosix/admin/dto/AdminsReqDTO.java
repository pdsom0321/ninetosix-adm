package com.gsc.ninetosixadm.ninetosix.admin.dto;

import lombok.Getter;

@Getter
public class AdminsReqDTO {
    private String keyword;
    private Integer page;
    private Integer size;

    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 15;

    public AdminsReqDTO(Integer page, Integer size, String keyword) {
        this.page = page == null ? DEFAULT_PAGE_NUMBER : page;
        this.size = size == null ? DEFAULT_PAGE_SIZE : size;
        this.keyword = keyword;
    }
}
