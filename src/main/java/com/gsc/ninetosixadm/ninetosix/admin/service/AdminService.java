package com.gsc.ninetosixadm.ninetosix.admin.service;

import com.gsc.ninetosixadm.ninetosix.admin.dto.AdminsResDTO;
import com.gsc.ninetosixadm.ninetosix.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminService {
    private final AdminRepository adminRepository;

    public List<AdminsResDTO> getAdmins() {
        return adminRepository.findAll().stream()
                .map(AdminsResDTO::getAdmins)
                .collect(Collectors.toList());
    }
}
