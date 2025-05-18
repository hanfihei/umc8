package umc.spring.study.web.controller;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.converter.ReviewConverter;
import umc.spring.study.converter.StoreConverter;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.Store;
import umc.spring.study.service.MissionService.MissionCommandService;
import umc.spring.study.service.StoreService.StoreCommandService;
import umc.spring.study.service.ReviewService.ReviewCommandService;
import umc.spring.study.validation.annotation.ExistStore;
import umc.spring.study.web.dto.StoreResponseDTO;
import umc.spring.study.web.dto.StoreRequestDTO;
import umc.spring.study.web.dto.ReviewResponseDTO;
import umc.spring.study.web.dto.ReviewRequestDTO;
import umc.spring.study.converter.ReviewConverter;
import umc.spring.study.web.dto.MissionResponseDTO;
import umc.spring.study.web.dto.MissionRequestDTO;
import umc.spring.study.converter.MissionConverter;

@Getter
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    private final ReviewCommandService reviewCommandService;

    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.AddStoreResultDTO> join(@RequestBody @Valid StoreRequestDTO.AddStoreDto request) {
        Store store = storeCommandService.joinStore(request);
        return ApiResponse.onSuccess(StoreConverter.AddResultDTO(store));
    }

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.AddReviewResultDTO> join(
            @Valid @ExistStore @PathVariable(name = "storeId") Long storeId,
            @RequestBody @Valid ReviewRequestDTO.AddReviewDto request) {
        Review review = reviewCommandService.joinReview(request, storeId);
        return ApiResponse.onSuccess(ReviewConverter.AddReviewResultDTO(review));
    }

    @PostMapping("/{storeId}/missions")
    public ApiResponse<MissionResponseDTO.AddMissionResultDTO> join(
            @Valid @ExistStore @PathVariable (name = "storeId")Long storeId,
            @RequestBody @Valid MissionRequestDTO.AddMissionDto request) {
        Mission mission = missionCommandService.joinMission(request, storeId);
        return ApiResponse.onSuccess(MissionConverter.AddMissionResultDTO(mission));
    }
}
