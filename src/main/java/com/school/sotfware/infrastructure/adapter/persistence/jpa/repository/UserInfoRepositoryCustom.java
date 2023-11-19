package com.school.sotfware.infrastructure.adapter.persistence.jpa.repository;

import com.school.sotfware.infrastructure.adapter.persistence.jpa.model.UserInfo;
import com.school.sotfware.presentation.adapter.web.rest.controller.dto.request.CreateUserInfo;

import java.util.Map;

public interface UserInfoRepositoryCustom {
    String getUserNameByUserAccountId(String userAccountId);

    String getIntroductionByUserAccountId(String userAccountId);
    Integer getStepCountByUserAccountId(String userAccountId);

    Map getUserStartPointByUserAccountId(String userAccountId);

    Map getUserEndPointByUserAccountId(String userAccountId);

    UserInfo findByAccountId(String accountId);

}
