package com.gsc.ninetosixadm.ninetosix.admin.dto;

import com.gsc.ninetosixadm.ninetosix.admin.entity.Admin;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Builder
public class AdminsResDTO {
    private Long id;
    private String email;
    private String name;
    private LocalDateTime insertDate;
    private String insertId;
    private LocalDateTime updateDate;
    private String updateId;

    private List<Admin> data;
    private Integer draw;
    private Integer recordsTotal;
    private Integer recordsFiltered;

    public static AdminsResDTO getAdmins(List<Admin> data, Integer draw, Integer recordsTotal, Integer recordsFiltered) {
        return AdminsResDTO.builder()
                .data(data)
                .draw(draw)
                .recordsTotal(recordsTotal)
                .recordsFiltered(recordsFiltered)
                .build();
    }

    /*public static AdminsResDTO getAdmins(Admin admin) {
        return AdminsResDTO.builder()
                .id(admin.getId())
                .email(admin.getEmail())
                .name(admin.getName())
                .insertDate(admin.getInsertDate())
                .insertId(admin.getInsertId())
                .updateDate(admin.getUpdateDate())
                .updateId(admin.getUpdateId())
                .build();
    }*/
}
