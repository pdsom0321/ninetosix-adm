package com.gsc.ninetosixadm.ninetosix.admin.controller;

import com.gsc.ninetosixadm.ninetosix.admin.dto.AdminResDTO;
import com.gsc.ninetosixadm.ninetosix.admin.dto.AdminUpdateReqDTO;
import com.gsc.ninetosixadm.ninetosix.admin.dto.AdminsReqDTO;
import com.gsc.ninetosixadm.ninetosix.admin.dto.AdminsResDTO;
import com.gsc.ninetosixadm.ninetosix.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value="/admin/{id}")
    public ResponseEntity<AdminResDTO> detail(@PathVariable Long id) {
        return new ResponseEntity<>(adminService.getAdmin(id), HttpStatus.OK);
    }

    @PutMapping(value="/admin/{id}")
    public ResponseEntity update(@PathVariable Long id, AdminUpdateReqDTO reqDTO) {
        return new ResponseEntity<>(adminService.updateAdmin(id, reqDTO), HttpStatus.OK);
    }

    @DeleteMapping(value="/admin/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.deleteAdmin(id));
    }
}
