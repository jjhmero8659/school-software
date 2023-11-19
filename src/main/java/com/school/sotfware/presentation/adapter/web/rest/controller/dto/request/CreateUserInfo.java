package com.school.sotfware.presentation.adapter.web.rest.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateUserInfo {
    @NotNull
    private String accountId; //사용자 account ID
    private String userName; //사용자 명
    private String introduction; //자기소개
    private Integer stepCount; //만보기 횟수
    private Double startX; //초기 X 좌표 값
    private Double startY; //초기 Y 좌표 값
    private Double endX; //도착 X 좌표 값
    private Double endY; //도착 Y 좌표 값
}
