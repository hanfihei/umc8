package umc.spring.study.converter;

import umc.spring.study.domain.Store;
import umc.spring.study.domain.Region;
import umc.spring.study.web.dto.StoreResponseDTO;
import umc.spring.study.web.dto.StoreRequestDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.AddStoreResultDTO AddResultDTO(Store store){
        return StoreResponseDTO.AddStoreResultDTO.builder()
                .storeId(store.getStoreId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.AddStoreDto request, Region region){

        return Store.builder()
                .storeName(request.getName())
                .address(request.getAddress())
                .region(region)
                .build();
    }
}
