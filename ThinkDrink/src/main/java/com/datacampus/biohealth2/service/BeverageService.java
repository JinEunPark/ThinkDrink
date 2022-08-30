package com.datacampus.biohealth2.service;

import com.datacampus.biohealth2.dto.BeverageFormDto;
import com.datacampus.biohealth2.entity.BeverageImg;
import com.datacampus.biohealth2.entity.BeverageInformation;
import com.datacampus.biohealth2.repository.BeverageImgRepository;
import com.datacampus.biohealth2.repository.BeverageInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BeverageService {
    private final BeverageInformationRepository beverageInformationRepository;
    private final BeverageImgService beverageImgService;

    private final BeverageImgRepository beverageImgRepository;

    public Long saveBeverage(BeverageFormDto beverageFormDto, List<MultipartFile> beverageImgFileList) throws Exception {
        //음료를 저장함
        BeverageInformation beverageInformation = beverageFormDto.createBeverageInformation();
        beverageInformationRepository.save(beverageInformation);
        //이미지 등록
        for (int i = 0; i < beverageImgFileList.size(); i++) {


            BeverageImg beverageImg = new BeverageImg();
            beverageImg.setBeverageInformation(beverageInformation);
            if (i == 0) beverageImg.setRepimgYn("Y");
            else
                beverageImg.setRepimgYn("N");

            beverageImgService.saveBeverageImg(beverageImg, beverageImgFileList.get(i));
        }
        return (Long)beverageInformation.getBeverageId();
    }

}
