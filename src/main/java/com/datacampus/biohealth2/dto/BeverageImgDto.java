package com.datacampus.biohealth2.dto;

import com.datacampus.biohealth2.entity.BeverageImg;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
@Getter
@Setter
public class BeverageImgDto {
    private Long id;
    private String imgName;
    private String oriImgName;
    private String imgUrl;
    private String repImgYn;
    private static ModelMapper modelMapper = new ModelMapper();//멤버 변수로 moldelmapper 객체를 생성함

    public static BeverageImgDto of(BeverageImg beverageImg){
        return modelMapper.map(beverageImg,BeverageImgDto.class);//model mapper 객체를 사용하면 변수이름이 같은 것들끼리 복사해서 돌려쭘

    }

}
