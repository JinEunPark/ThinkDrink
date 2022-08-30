package com.datacampus.biohealth2;

import com.datacampus.biohealth2.entity.CafeInformation;
import com.datacampus.biohealth2.repository.CafeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
class Biohealth2ApplicationTests {
    @Autowired
    CafeRepository cafeRepository;

    @Test
    public void createCafeInformaiton(){
        CafeInformation cafeInformation = new CafeInformation();
        cafeInformation.setCafeName("cafe");
        CafeInformation cafeInformationsaved = cafeRepository.save(cafeInformation);
        System.out.println(cafeInformationsaved.toString());

    }


    public void createCafeInformationList(){
        for(int i = 0; i<10; i++){
            CafeInformation cafeInformation = new CafeInformation();
            cafeInformation.setCafeName("cafe"+i);
            CafeInformation cafeInformationsaved = cafeRepository.save(cafeInformation);
            System.out.println(cafeInformationsaved.toString());

        }
    }

    @Test
    @DisplayName("cafe name query test")
    public void findByCafeName(){
        this.createCafeInformationList();
        List<CafeInformation> cafeInformationList = cafeRepository.findAllByCafeName("cafe1");
        for(CafeInformation cafeInformation: cafeInformationList){
            System.out.println(cafeInformation.toString());
        }
    }


}
