package com.gsc.ninetosixadm.ninetosix.admin.service;

import com.gsc.ninetosixadm.ninetosix.admin.dto.AdminsReqDTO;
import com.gsc.ninetosixadm.ninetosix.admin.dto.AdminsResDTO;
import com.gsc.ninetosixadm.ninetosix.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
