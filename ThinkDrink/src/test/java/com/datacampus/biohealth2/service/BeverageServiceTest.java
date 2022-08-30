package com.datacampus.biohealth2.service;

import com.datacampus.biohealth2.dto.BeverageFormDto;
import com.datacampus.biohealth2.entity.BeverageImg;
import com.datacampus.biohealth2.entity.BeverageInformation;
import com.datacampus.biohealth2.entity.CafeInformation;
import com.datacampus.biohealth2.repository.BeverageImgRepository;
import com.datacampus.biohealth2.repository.BeverageInformationRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
class BeverageServiceTest {
    @Autowired
    BeverageService beverageService;
    @Autowired
    BeverageInformationRepository beverageInformationRepository;
    @Autowired
    BeverageImgRepository beverageImgRepository;

    List<MultipartFile> createMultipartFiles() throws Exception{
        List<MultipartFile> multipartFileList = new ArrayList<>();

        for(int i=0;i<5;i++){
            String path = "/Users/bagjin-eun/Desktop/beverageImg";
            String imageName = "image" + i + ".jpg";
            MockMultipartFile multipartFile =
                    new MockMultipartFile(path, imageName, "image/jpg", new byte[]{1,2,3,4});
            multipartFileList.add(multipartFile);
        }

        return multipartFileList;
    }


    @Test
    @DisplayName("상품 등록 테스트")
    void saveBeverage() throws Exception {
        BeverageFormDto beverageFormDto = new BeverageFormDto();
        beverageFormDto.setBeverageName("테스트상품");
        beverageFormDto.setBeverageName("test");
        beverageFormDto.setBigCategory("Test");

        List<MultipartFile> multipartFileList = createMultipartFiles();
        Long beverageId = beverageService.saveBeverage(beverageFormDto, multipartFileList);
        List<BeverageImg> beverageImgList = beverageImgRepository.findByBeverageInformation_BeverageIdOrderByIdAsc(beverageId);

        BeverageInformation beverageInformation = beverageInformationRepository.findById(beverageId)
                .orElseThrow(EntityNotFoundException::new);

        assertEquals(beverageFormDto.getBeverageName(), beverageInformation.getBeverageName());

        assertEquals(multipartFileList.get(0).getOriginalFilename(), beverageImgList.get(0).getOriImgName());

    }


}