package com.datacampus.biohealth2.service;

import com.datacampus.biohealth2.dto.CafeInformationDto;
import com.datacampus.biohealth2.entity.CafeInformation;
import com.datacampus.biohealth2.repository.CafeRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Getter
@Setter
@RequiredArgsConstructor

public class CafeInformationService {
    private final CafeRepository cafeRepository;

    public CafeInformationDto getCafeInformationDto(Long cafeId){

        Optional<CafeInformation> cafeInformationOpt = cafeRepository.findById(cafeId);
        CafeInformation cafeInformation = cafeInformationOpt.get();
        CafeInformationDto cafeInformationDto = CafeInformationDto.of(cafeInformation);

        return cafeInformationDto;

    }
}
