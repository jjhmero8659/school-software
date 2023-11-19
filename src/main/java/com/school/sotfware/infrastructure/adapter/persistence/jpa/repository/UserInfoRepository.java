package com.school.sotfware.infrastructure.adapter.persistence.jpa.repository;

import com.school.sotfware.infrastructure.adapter.persistence.jpa.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo , Long> , UserInfoRepositoryCustom {
}
