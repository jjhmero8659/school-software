package com.school.sotfware.infrastructure.adapter.persistence.jpa.model;

import com.school.sotfware.presentation.adapter.web.rest.controller.dto.request.UpdateUserInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userInfoId")
    @NotNull
    private Long userInfoId; //Primary Key

    @NotNull
    private String id; //사용자 account ID
    @NotNull
    @Builder.Default
    private String userName = "Noname"; //사용자 명
    private String introduction; //자기소개
    @NotNull
    @Builder.Default
    private Integer stepCount = 0; //만보기 횟수
    private Double startX; //초기 X 좌표 값
    private Double startY; //초기 Y 좌표 값
    private Double endX; //도착 X 좌표 값
    private Double endY; //도착 Y 좌표 값

    public void updateInformation(UpdateUserInfo updateUserInfo){
        this.userName = updateUserInfo.getUserName();
        this.introduction = updateUserInfo.getIntroduction();
        this.stepCount = updateUserInfo.getStepCount();
        this.startX = updateUserInfo.getStartY();
        this.startY = updateUserInfo.getStartY();
        this.endX = updateUserInfo.getEndX();
        this.endY = updateUserInfo.getEndY();
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setIntroduction(String introduction){
        this.introduction = introduction;
    }

    public void setStepCount(Integer stepCount){
        this.stepCount = stepCount;
    }

    public void setStartPoint(Double startX , Double startY){
        this.startX = startX;
        this.startY = startY;
    }

    public void setEndPoint(Double endX , Double endY){
        this.endX = endX;
        this.endY = endY;
    }
}
