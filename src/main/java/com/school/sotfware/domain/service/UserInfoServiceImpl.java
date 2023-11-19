package com.school.sotfware.domain.service;

import com.school.sotfware.infrastructure.adapter.persistence.jpa.model.UserInfo;
import com.school.sotfware.infrastructure.adapter.persistence.jpa.repository.UserInfoRepository;
import com.school.sotfware.presentation.adapter.web.rest.controller.dto.request.CreateUserInfo;
import com.school.sotfware.presentation.adapter.web.rest.controller.dto.request.UpdateUserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService{
    private final UserInfoRepository userInfoRepository;

    @Override
    public String getUserName(String userAccountId) {
        return userInfoRepository.getUserNameByUserAccountId(userAccountId);
    }

    @Override
    public String getIntroduction(String userAccountId) {
        return userInfoRepository.getIntroductionByUserAccountId(userAccountId);
    }

    @Override
    public Integer getStepCount(String userAccountId) {
        return userInfoRepository.getStepCountByUserAccountId(userAccountId);
    }

    @Override
    public Map getUserStartPoint(String userAccountId) {
        return userInfoRepository.getUserStartPointByUserAccountId(userAccountId);
    }

    @Override
    public Map getUserEndPoint(String userAccountId) {
        return userInfoRepository.getUserEndPointByUserAccountId(userAccountId);
    }

    @Override
    public void createUserInformation(CreateUserInfo createUserInfo) {
        UserInfo userInfoEntity = UserInfo.builder()
                .id(createUserInfo.getAccountId())
                .userName(createUserInfo.getUserName())
                .introduction(createUserInfo.getIntroduction())
                .stepCount(createUserInfo.getStepCount())
                .startX(createUserInfo.getStartX())
                .startY(createUserInfo.getStartY())
                .endX(createUserInfo.getEndX())
                .endY(createUserInfo.getEndY())
                .build();

        userInfoRepository.save(userInfoEntity);
    }

    @Override
    public void updateUserInformation(UpdateUserInfo updateUserInfo) {
        UserInfo byAccountId = userInfoRepository
                .findByAccountId(updateUserInfo.getAccountId());

        byAccountId.updateInformation(updateUserInfo);

        userInfoRepository.save(byAccountId);
    }

    @Override
    public UserInfo getUserInformation(String userAccountId) {
        return userInfoRepository
                .findByAccountId(userAccountId);
    }

    @Override
    public void setUserName(String userAccountId , String userName) {
        UserInfo byAccountId = userInfoRepository
                .findByAccountId(userAccountId);

        byAccountId.setUserName(userName);

        userInfoRepository.save(byAccountId);
    }

    @Override
    public void setIntroduction(String userAccountId, String introduction) {
        UserInfo byAccountId = userInfoRepository
                .findByAccountId(userAccountId);

        byAccountId.setIntroduction(introduction);

        userInfoRepository.save(byAccountId);
    }

    @Override
    public void setStepCount(String userAccountId, Integer stepCount) {
        UserInfo byAccountId = userInfoRepository
                .findByAccountId(userAccountId);

        byAccountId.setStepCount(stepCount);

        userInfoRepository.save(byAccountId);
    }

    @Override
    public void setStartPoint(String userAccountId, Double userStartX, Double userStartY) {
        UserInfo byAccountId = userInfoRepository
                .findByAccountId(userAccountId);

        byAccountId.setStartPoint(userStartX , userStartY);

        userInfoRepository.save(byAccountId);

    }

    @Override
    public void setEndPoint(String userAccountId, Double userEndX, Double userEndY) {
        UserInfo byAccountId = userInfoRepository
                .findByAccountId(userAccountId);

        byAccountId.setEndPoint(userEndX , userEndY);

        userInfoRepository.save(byAccountId);
    }
}
