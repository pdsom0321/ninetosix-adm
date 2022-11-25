package com.gsc.ninetosixadm.ninetosix.admin.service;

import com.gsc.ninetosixadm.ninetosix.admin.dto.AdminResDTO;
import com.gsc.ninetosixadm.ninetosix.admin.dto.AdminUpdateReqDTO;
import com.gsc.ninetosixadm.ninetosix.admin.dto.AdminsReqDTO;
import com.gsc.ninetosixadm.ninetosix.admin.dto.AdminsResDTO;
import com.gsc.ninetosixadm.ninetosix.admin.entity.Admin;
import com.gsc.ninetosixadm.ninetosix.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.module.FindException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminService {
    private final AdminRepository adminRepository;

    public Page<AdminsResDTO> getAdmins(AdminsReqDTO reqDTO) {
        Pageable pageable = PageRequest.of(reqDTO.getPage(), reqDTO.getSize());

        Long count = adminRepository.findByAllAdminByCount(reqDTO.getKeyword());
        List<AdminsResDTO> content = adminRepository.findByAllAdminByPage(reqDTO.getKeyword(), pageable).stream()
                .map(AdminsResDTO::getAdmins)
                .collect(Collectors.toList());
        return new PageImpl<>(content, pageable, count);
    }

    public AdminResDTO getAdmin(Long id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new FindException("관리자를 찾을 수 없습니다."));
        return AdminResDTO.getAdmin(admin);
    }

    @Transactional
    public ResponseEntity updateAdmin(Long id, AdminUpdateReqDTO reqDTO) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new FindException("관리자를 찾을 수 없습니다."));
        admin.updateAdmin(reqDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity deleteAdmin(Long id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new FindException("관리자를 찾을 수 없습니다."));
        adminRepository.delete(admin);
        return new ResponseEntity(HttpStatus.OK);
    }
}
