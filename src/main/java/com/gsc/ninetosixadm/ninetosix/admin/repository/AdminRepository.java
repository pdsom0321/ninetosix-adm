package com.gsc.ninetosixadm.ninetosix.admin.repository;

import com.gsc.ninetosixadm.ninetosix.admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long>, AdminCustomRepository{
    Optional<Admin> findByEmail(String email);

}
