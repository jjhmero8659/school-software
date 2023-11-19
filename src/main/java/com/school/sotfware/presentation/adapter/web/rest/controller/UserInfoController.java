package com.school.sotfware.presentation.adapter.web.rest.controller;

import com.school.sotfware.domain.service.UserInfoService;
import com.school.sotfware.domain.service.UserInfoServiceImpl;
import com.school.sotfware.infrastructure.adapter.persistence.jpa.model.UserInfo;
import com.school.sotfware.presentation.adapter.web.rest.controller.dto.request.CreateUserInfo;
import com.school.sotfware.presentation.adapter.web.rest.controller.dto.request.UpdateUserInfo;
import com.school.sotfware.presentation.adapter.web.rest.controller.dto.response.ResponseUserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(tags = "User Management Api (사용자 정보 관리 관련 API)")
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/user/information")
public class UserInfoController {
    private final UserInfoService userInfoService;

    @ApiOperation(value = "사용자 데이터 정보를 데이터베이스 에서 가져온다.", notes = "사용자 데이터 정보를 데이터베이스 에서 가져온다.")
    @GetMapping
    public ResponseUserInfo getUserInformation(
            @ApiParam(value = "사용자를 식별 할 userAccountId", required = true)
            @RequestParam String userAccountId
    ){
        UserInfo userInfoEntity = userInfoService
                .getUserInformation(userAccountId);

        return ResponseUserInfo
                .builder()
                .accountId(userInfoEntity.getId())
                .userName(userInfoEntity.getUserName())
                .introduction(userInfoEntity.getIntroduction())
                .stepCount(userInfoEntity.getStepCount())
                .startX(userInfoEntity.getStartX())
                .startY(userInfoEntity.getStartY())
                .endX(userInfoEntity.getEndX())
                .endY(userInfoEntity.getEndY())
                .build();
    }
    @ApiOperation(value = "사용자 데이터 정보를 데이터베이스에 저장한다.", notes = "사용자 데이터 정보를 데이터베이스에 저장한다.")
    @PostMapping
    public void createUserInformation(
            @ApiParam(value = "데이터베이스에 저장할 유저 정보 객체", required = true)
            @RequestBody CreateUserInfo createUserInfo
            ){
        userInfoService.createUserInformation(createUserInfo);
    }

    @ApiOperation(value = "사용자 데이터 수정 정보를 데이터베이스에 저장한다.", notes = "사용자 데이터 수정 정보를 데이터베이스에 저장한다.")
    @PutMapping
    public void updateUserInformation(
            @ApiParam(value = "데이터베이스에 저장할 유저 수정 정보 객체", required = true)
            @RequestBody UpdateUserInfo updateUserInfo
    ){
        userInfoService.updateUserInformation(updateUserInfo);
    }

    /////////////Getter

    @ApiOperation(value = "사용자 명을 반환 받는다.", notes = "Account ID 에 해당하는 사용자 명을 반환 받는다.")
    @GetMapping("/name")
    public String getUserName(
            @ApiParam(value = "사용자를 식별 할 userAccountId", required = true)
            @RequestParam String userAccountId
    ){
        return userInfoService.getUserName(userAccountId);
    }

    @ApiOperation(value = "사용자의 자기소개 텍스트 를 반환 받는다.", notes = "Account ID 에 해당하는 자기소개 텍스트 를 반환 받는다.")
    @GetMapping("/introduction")
    public String getIntroduction(
            @ApiParam(value = "사용자를 식별 할 userAccountId", required = true)
            @RequestParam String userAccountId
    ){
        return userInfoService.getIntroduction(userAccountId);
    }

    @ApiOperation(value = "사용자 만보기 횟수 를 반환 한다", notes = "Account ID 에 해당하는 사용자 만보기 횟수 를 반환 한다.")
    @GetMapping("/step-count")
    public Integer setStepCount(
            @ApiParam(value = "사용자를 식별 할 userAccountId", required = true)
            @RequestParam String userAccountId
    ){
        return userInfoService.getStepCount(userAccountId);
    }

    @ApiOperation(value = "사용자의 시작 위치 를 반환 한다", notes = "Account ID 에 해당하는 사용자의 시작 좌표 주소 를 반환 받는다.")
    @GetMapping("/start-point")
    public Map getUserStartPoint(
            @ApiParam(value = "사용자를 식별 할 userAccountId", required = true)
            @RequestParam String userAccountId
    ){
        return userInfoService.getUserStartPoint(userAccountId);
    }

    @ApiOperation(value = "사용자의 최종 위치 를 반환 한다", notes = "Account ID 에 해당하는 사용자의 최종 좌표 주소 를 반환 받는다.")
    @GetMapping("/end-point")
    public Map getUserEndPoint(
            @ApiParam(value = "사용자를 식별 할 userAccountId", required = true)
            @RequestParam String userAccountId
    ){
        return userInfoService.getUserEndPoint(userAccountId);
    }


    ////////////Setter

    @ApiOperation(value = "사용자 명을 설정 한다", notes = "Account ID 에 해당하는 사용자 명을 저장 한다.")
    @PostMapping("/name")
    public void setUserName(
            @ApiParam(value = "사용자를 식별 할 userAccountId", required = true)
            @RequestParam String userAccountId,
            @ApiParam(value = "저장할 사용자 명", required = true)
            @RequestParam String userName
    ){
        userInfoService.setUserName(userAccountId , userName);
    }

    @ApiOperation(value = "사용자 자기소개 를 설정 한다", notes = "Account ID 에 해당하는 사용자 자기소개 를 저장 한다.")
    @PostMapping("/introduction")
    public void setIntroduction(
            @ApiParam(value = "사용자를 식별 할 userAccountId", required = true)
            @RequestParam String userAccountId,
            @ApiParam(value = "저장할 자기소개 텍스트", required = true)
            @RequestParam String introduction
    ){
        userInfoService.setIntroduction(userAccountId , introduction);
    }

    @ApiOperation(value = "사용자 만보기 횟수 를 설정 한다", notes = "Account ID 에 해당하는 사용자 만보기 횟수 를 저장 한다.")
    @PostMapping("/step-count")
    public void setStepCount(
            @ApiParam(value = "사용자를 식별 할 userAccountId", required = true)
            @RequestParam String userAccountId,
            @ApiParam(value = "저장할 만보기 횟수", required = true)
            @RequestParam Integer stepCount
    ){
        userInfoService.setStepCount(userAccountId , stepCount);
    }

    @ApiOperation(value = "사용자 시작 위치 를 설정 한다", notes = "Account ID 에 해당하는 사용자 시작 위치 를 저장 한다.")
    @PostMapping("/start-point")
    public void setStartPoint(
            @ApiParam(value = "사용자를 식별 할 userAccountId", required = true)
            @RequestParam String userAccountId,
            @ApiParam(value = "저장할 만보기 횟수 X", required = true)
            @RequestParam Double userStartX,
            @ApiParam(value = "저장할 만보기 횟수 Y", required = true)
            @RequestParam Double userStartY
    ){
        userInfoService.setStartPoint(
                userAccountId,
                userStartX,
                userStartY);
    }

    @ApiOperation(value = "사용자 시작 위치 를 설정 한다", notes = "Account ID 에 해당하는 사용자 시작 위치 를 저장 한다.")
    @PostMapping("/end-point")
    public void setEndPoint(
            @ApiParam(value = "사용자를 식별 할 userAccountId", required = true)
            @RequestParam String userAccountId,
            @ApiParam(value = "저장할 만보기 횟수 X", required = true)
            @RequestParam Double userEndX,
            @ApiParam(value = "저장할 만보기 횟수 Y", required = true)
            @RequestParam Double userEndY
    ){
        userInfoService.setEndPoint(
                userAccountId,
                userEndX,
                userEndY
        );
    }
}
