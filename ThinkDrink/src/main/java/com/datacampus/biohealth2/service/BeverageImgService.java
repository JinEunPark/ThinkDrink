package com.datacampus.biohealth2.service;

import com.datacampus.biohealth2.entity.BeverageImg;
import com.datacampus.biohealth2.repository.BeverageImgRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.processing.Generated;

@Service
@Getter@Setter
@RequiredArgsConstructor//반드시 추가해야 final 형태로 DI가 가능하다.
public class BeverageImgService {

    private final BeverageImgRepository beverageImgRepository;

    private final FileService fileService;

    @Value("${BeverageImgLocation}")
    private String beverageImgLocation;





    public void saveBeverageImg(BeverageImg beverageImg, MultipartFile beverageImgFile) throws Exception{
        String oriImgName= beverageImgFile.getOriginalFilename();
        String imgName = "";
        String imgUrl = "";

        //파일업로드
        if(!StringUtils.isEmpty(oriImgName)){
            imgName = fileService.uploadFile(beverageImgLocation, oriImgName,beverageImgFile.getBytes());
            imgUrl = "/imges/"+imgName;

        }
        //상품이미지 정보 저장
        beverageImg.updateBeverageInformationImg(oriImgName,imgName, imgUrl);
        beverageImgRepository.save(beverageImg);
    }
}
