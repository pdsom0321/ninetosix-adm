package com.gsc.ninetosixadm.ninetosix.member.entity;

import com.gsc.ninetosixadm.ninetosix.admin.entity.Admin;
import com.gsc.ninetosixadm.ninetosix.vo.Role;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table
public class MemberRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_role_id")
    private Long id;

    private String role;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public static MemberRole createUserRole(Admin admin) {
        return MemberRole.builder()
                .role(Role.ROLE_ADMIN.name())
                .admin(admin)
                .build();
    }
}
