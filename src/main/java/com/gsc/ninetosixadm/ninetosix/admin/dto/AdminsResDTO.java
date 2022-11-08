package com.gsc.ninetosixadm.ninetosix.admin.dto;

import com.gsc.ninetosixadm.ninetosix.admin.entity.Admin;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class AdminsResDTO {
    private String email;
    private String name;
    private LocalDateTime insertDate;
    private String insertId;
    private LocalDateTime updateDate;
    private String updateId;

    public static AdminsResDTO getAdmins(Admin admin) {
        return AdminsResDTO.builder()
                .email(admin.getEmail())
                .name(admin.getName())
                .insertDate(admin.getInsertDate())
                .insertId(admin.getInsertId())
                .updateDate(admin.getUpdateDate())
                .updateId(admin.getUpdateId())
                .build();
    }
}