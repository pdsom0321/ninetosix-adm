package com.gsc.ninetosixadm.ninetosix.admin.controller;

import com.gsc.ninetosixadm.ninetosix.admin.dto.AdminsReqDTO;
import com.gsc.ninetosixadm.ninetosix.admin.dto.AdminsResDTO;
import com.gsc.ninetosixadm.ninetosix.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/admins")
    public ResponseEntity<Page<AdminsResDTO>> getAdmins(AdminsReqDTO reqDTO) {
        return ResponseEntity.ok(adminService.getAdmins(reqDTO));
    }

}
