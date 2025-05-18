package umc.spring.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.converter.UserConverter;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.User;
import umc.spring.study.domain.mapping.UserMission;
import umc.spring.study.service.Mission2Service.Mission2CommandService;
import umc.spring.study.service.UserService.UserCommandService;
import umc.spring.study.validation.annotation.AlreadyOngoing;
import umc.spring.study.web.dto.UserRequestDTO;
import umc.spring.study.web.dto.UserResponseDTO;
import umc.spring.study.converter.Mission2Converter;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserRestController {
    private final UserCommandService userCommandService;
    private final Mission2CommandService mission2CommandService;

    @PostMapping("/")
    public ApiResponse<UserResponseDTO.JoinResultDTO> join(@RequestBody @Valid UserRequestDTO.JoinDto request){
        User user = userCommandService.joinMember(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDTO(user));
    }

    @PostMapping("/missions")
    public ApiResponse<UserResponseDTO.AddMissionResultDTO> join(@RequestBody @AlreadyOngoing @Valid UserRequestDTO.AddMissionDto request){
        UserMission mission2 = mission2CommandService.AddMission(request);
        return ApiResponse.onSuccess(Mission2Converter.addResultDTO(mission2));
    }
}
