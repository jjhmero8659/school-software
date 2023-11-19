package com.school.sotfware.domain.service;

import com.school.sotfware.infrastructure.adapter.persistence.jpa.model.UserInfo;
import com.school.sotfware.presentation.adapter.web.rest.controller.dto.request.CreateUserInfo;
import com.school.sotfware.presentation.adapter.web.rest.controller.dto.request.UpdateUserInfo;

import java.util.Map;

public interface UserInfoService {
    String getUserName(String userAccountId);
    //사용자명 반환

    String getIntroduction(String userAccountId);
    //사용자 자기소개 반환
    Integer getStepCount(String userAccountId);
    //사용자 만보기 횟수 반환
    Map getUserStartPoint(String userAccountId);
    //유저 시작 지점 반환

    Map getUserEndPoint(String userAccountId);
    //유저 최종 지점 반환

    void createUserInformation(CreateUserInfo createUserInfo);
    //유저 정보를 데이터 베이스에 생성

    void updateUserInformation(UpdateUserInfo updateUserInfo);
    //유저 정보를 수정 후 데이터베이스에 저장

    UserInfo getUserInformation(String userAccountId);
    //유저 정보 객체를 반환

    void setUserName(String userAccountId , String userName);
    //사용자 명 저장

    void setIntroduction(String userAccountId, String introduction);
    //사용자 자기소개 저장

    void setStepCount(String userAccountId, Integer stepCount);
    //사용자 만보기 횟수 저장

    void setStartPoint(String userAccountId, Double userStartX, Double userStartY);
    //사용자 시작 위치 설정

    void setEndPoint(String userAccountId, Double userEndX, Double userEndY);
    //사용자 마지막 위치 설정
}
