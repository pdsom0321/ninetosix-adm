package com.gsc.ninetosixadm.ninetosix.admin.repository.impl;

import com.gsc.ninetosixadm.ninetosix.admin.entity.Admin;
import com.gsc.ninetosixadm.ninetosix.admin.repository.AdminCustomRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.core.util.StringUtils;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.gsc.ninetosixadm.ninetosix.admin.entity.QAdmin.admin;

@Repository
@RequiredArgsConstructor
public class AdminCustomRepositoryImpl implements AdminCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Long findByAllAdminByCount(String keyword) {
        return jpaQueryFactory.select(Wildcard.count).from(admin)
                .where(
                        containNameValue(keyword),
                        containEmailValue(keyword)
                )
                .fetch().get(0);
    }

    @Override
    public List<Admin> findByAllAdminByPage(String keyword, Pageable pageable) {
        return jpaQueryFactory.selectFrom(admin)
                .where(
                        containNameValue(keyword),
                        containEmailValue(keyword)
                )
                .orderBy(admin.insertDate.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        /*List<Admin> content =jpaQueryFactory.selectFrom(admin)
                .orderBy(admin.insertDate.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return jpaQueryFactory.selectFrom(admin)
                .leftJoin(admin.role).fetchJoin()
                .where(
                        containNameValue(keyword),
                        containEmailValue(keyword)
                )
                .where(admin.in(content))
                .fetch();*/
    }

    private BooleanExpression containNameValue(String value) {
        return StringUtils.isNullOrEmpty(value) ? null : admin.name.contains(value);
    }

    private BooleanExpression containEmailValue(String value) {
        return StringUtils.isNullOrEmpty(value) ? null : admin.email.contains(value);
    }

}
