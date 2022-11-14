package com.gsc.ninetosixadm.ninetosix.admin.dto;

import com.gsc.ninetosixadm.ninetosix.admin.entity.Admin;
import com.gsc.ninetosixadm.ninetosix.vo.YNCode;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter @Builder
public class AdminResDTO {
    private Long id;
    private String email;
    private String name;
    private String contact;
    private YNCode deleteYn;
    private Integer loginFailCnt;
    private LocalDateTime passwordModifiedDate;
    private String insertId;
    private LocalDateTime insertDate;
    private String updateId;
    private LocalDateTime updateDate;

    public static AdminResDTO getAdmin(Admin admin) {
        return AdminResDTO.builder()
                .email(admin.getEmail())
                .name(admin.getName())
                .contact(admin.getContact())
                .passwordModifiedDate(admin.getPasswordModifiedDate())
                .insertDate(admin.getInsertDate())
                .insertId(admin.getInsertId())
                .updateDate(admin.getUpdateDate())
                .updateId(admin.getUpdateId())
                .build();
    }
}
