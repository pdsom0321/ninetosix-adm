package com.gsc.ninetosixadm.core.service;

import com.gsc.ninetosixadm.ninetosix.admin.entity.Admin;
import com.gsc.ninetosixadm.ninetosix.admin.repository.AdminRepository;
import com.gsc.ninetosixadm.ninetosix.member.dto.UserDetailsDTO;
import com.gsc.ninetosixadm.ninetosix.member.entity.MemberRole;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private AdminRepository adminRepository;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws BadCredentialsException {
        log.info("================ loadUserByUsername - username : " + username);
        return adminRepository.findByEmail(username)
                .map(this::createUserDetails)
                .orElseThrow(() -> new InternalAuthenticationServiceException("해당하는 유저를 찾을 수 없습니다."));
    }

    private UserDetails createUserDetails(Admin admin) {
        return new UserDetailsDTO(
                admin.getEmail(),
                admin.getPassword(),
                this.converSimpleAuthorities(admin.getRole())
        );
    }

    private Set<GrantedAuthority> converSimpleAuthorities(Set<MemberRole> roleList) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for(MemberRole item : roleList) {
            authorities.add(new SimpleGrantedAuthority(item.getRole()));
        }
        return authorities;
    }
}
