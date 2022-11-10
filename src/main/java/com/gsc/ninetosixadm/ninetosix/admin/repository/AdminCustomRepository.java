package com.gsc.ninetosixadm.ninetosix.admin.repository;

import com.gsc.ninetosixadm.ninetosix.admin.entity.Admin;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminCustomRepository {
    List<Admin> findByAllAdminByPage(String keyword, Pageable pageable);
    Long findByAllAdminByCount(String keyword);
}
