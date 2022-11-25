package com.gsc.ninetosixadm.ninetosix.admin.entity;

import com.gsc.ninetosixadm.ninetosix.admin.dto.AdminUpdateReqDTO;
import com.gsc.ninetosixadm.ninetosix.member.entity.MemberRole;
import com.gsc.ninetosixadm.ninetosix.vo.YNCode;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@Table
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 256)
    private String password;

    @Column(length = 50)
    private String contact;

    @Enumerated(EnumType.STRING)
    @Column(length = 1)
    private YNCode deleteYn;

    /** TODO : 로그인 실패횟수 체크 안할거면 삭제 필요 */
    @Column(length = 1)
    private Integer loginFailCnt;

    private LocalDateTime passwordModifiedDate;

    private String insertId;

    private LocalDateTime insertDate;

    private String updateId;

    private LocalDateTime updateDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "admin", fetch = FetchType.EAGER)
    private Set<MemberRole> role = new HashSet<>();

    @Transient
    private static Integer INIT_LOGIN_FAIL_CNT = 0;

    @Builder
    public void updateAdmin(AdminUpdateReqDTO reqDTO) {
        this.name = reqDTO.getName();
        this.contact = reqDTO.getContact();
    }
}
