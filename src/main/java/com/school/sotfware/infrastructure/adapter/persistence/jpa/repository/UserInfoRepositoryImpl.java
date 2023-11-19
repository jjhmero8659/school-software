package com.school.sotfware.infrastructure.adapter.persistence.jpa.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.school.sotfware.exception.UserNotFoundException;
import com.school.sotfware.infrastructure.adapter.persistence.jpa.model.QUserInfo;
import com.school.sotfware.infrastructure.adapter.persistence.jpa.model.UserInfo;
import com.school.sotfware.presentation.adapter.web.rest.controller.dto.request.CreateUserInfo;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import static com.school.sotfware.infrastructure.adapter.persistence.jpa.model.QUserInfo.userInfo;

@RequiredArgsConstructor
public class UserInfoRepositoryImpl implements UserInfoRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    private void userStringDataNullCheck(String userData){
        if (userData == null){
            throw new UserNotFoundException();
        }
    }

    private void userEntityNullCheck(UserInfo userInfoEntity){
        if (userInfoEntity == null){
            throw new UserNotFoundException();
        }
    }
    @Override
    public String getUserNameByUserAccountId(String userAccountId) {
        String userName = jpaQueryFactory
                .select(userInfo.userName)
                .from(userInfo)
                .where(userInfo.id.eq(userAccountId))
                .fetchOne();

        userStringDataNullCheck(userName);
        return userName;
    }

    @Override
    public String getIntroductionByUserAccountId(String userAccountId) {
        String introduction = jpaQueryFactory
                .select(userInfo.introduction)
                .from(userInfo)
                .where(userInfo.id.eq(userAccountId))
                .fetchOne();

        userStringDataNullCheck(introduction);
        return introduction;
    }

    @Override
    public Integer getStepCountByUserAccountId(String userAccountId) {
        UserInfo userInfoEntity = jpaQueryFactory
                .selectFrom(userInfo)
                .where(userInfo.id.eq(userAccountId))
                .fetchOne();

        userEntityNullCheck(userInfoEntity);

        return userInfoEntity.getStepCount();
    }

    @Override
    public Map getUserStartPointByUserAccountId(String userAccountId) {
        UserInfo userInfoEntity = jpaQueryFactory
                .selectFrom(userInfo)
                .where(userInfo.id.eq(userAccountId))
                .fetchOne();

        userEntityNullCheck(userInfoEntity);
        HashMap<String, Double> startPointMap = new HashMap<>();

        startPointMap.put("startX" , userInfoEntity.getStartX());
        startPointMap.put("startY" , userInfoEntity.getStartY());

        return startPointMap;
    }

    @Override
    public Map getUserEndPointByUserAccountId(String userAccountId) {
        UserInfo userInfoEntity = jpaQueryFactory
                .selectFrom(userInfo)
                .where(userInfo.id.eq(userAccountId))
                .fetchOne();

        userEntityNullCheck(userInfoEntity);
        HashMap<String, Double> startPointMap = new HashMap<>();

        startPointMap.put("endX" , userInfoEntity.getEndX());
        startPointMap.put("endY" , userInfoEntity.getEndY());

        return startPointMap;
    }

    @Override
    public UserInfo findByAccountId(String userAccountId) {
        UserInfo userInfoEntity = jpaQueryFactory
                .selectFrom(userInfo)
                .where(userInfo.id.eq(userAccountId))
                .fetchOne();
        userEntityNullCheck(userInfoEntity);

        return userInfoEntity;
    }
}
