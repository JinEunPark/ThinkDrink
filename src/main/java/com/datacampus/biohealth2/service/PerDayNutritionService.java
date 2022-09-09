package com.datacampus.biohealth2.service;

import com.datacampus.biohealth2.constant.Activity;
import com.datacampus.biohealth2.constant.Gender;
import com.datacampus.biohealth2.dto.PerDayNutritionDto;
import com.datacampus.biohealth2.entity.HealthInformation;
import com.datacampus.biohealth2.entity.PerDayNutrition;
import com.datacampus.biohealth2.repository.HealthInformationRepository;
import com.datacampus.biohealth2.repository.PerDayNutritionRepository;
import groovy.util.logging.Slf4j;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
@Setter
@Slf4j
public class PerDayNutritionService {

    private final HealthInformationRepository healthInformationRepository;
    private final PerDayNutritionRepository perDayNutritionRepository;

    public PerDayNutritionDto getPerDayFromHealthInformation(HealthInformation healthInformation){

//healthInformation객체를 받아서 PerDayDto를 반환하는 메소드.
        PerDayNutritionDto perDayNutritionDto = new PerDayNutritionDto();

        perDayNutritionDto.setHealthInformation(healthInformation);
        perDayNutritionDto.setCaffeine(getAvailableCaffeinePerDay(healthInformation));
        perDayNutritionDto.setDrink_caffeine(getDrink_Caffeine(healthInformation));
        perDayNutritionDto.setKcal(getAvailableCaffeinePerDay(healthInformation));
        perDayNutritionDto.setDrink_kcal(getDrink_kcal(healthInformation));
        perDayNutritionDto.setSugar(getAvailableSugarPerDay(healthInformation));
        perDayNutritionDto.setDrink_sugar(getDrink_Sugar(healthInformation));
        perDayNutritionDto.setSodium(getAvailableSodiumPerDay(healthInformation));
        perDayNutritionDto.setDrink_Sodium(getDrink_Sodium(healthInformation));
        perDayNutritionDto.setProtein(getAvailableProteinPerDay(healthInformation));
        perDayNutritionDto.setDrink_protein(getDrink_Protein(healthInformation));
        perDayNutritionDto.setSaturatedFat(getAvailableSaturated_FatPerDay(healthInformation));
        perDayNutritionDto.setDrink_saturatedFat(getDrink_Saturated_Fat(healthInformation));

        return perDayNutritionDto;
    }

    public PerDayNutritionDto getPerDayNutritionDto(PerDayNutrition perDayNutrition){

        PerDayNutritionDto perDayNutritionDto = PerDayNutritionDto.of(perDayNutrition);
        return perDayNutritionDto;
    }

    public PerDayNutrition createPerDayNutrition(PerDayNutritionDto perDayNutritionDto){
        PerDayNutrition perDayNutrition = perDayNutritionDto.createPerDayNutrition();
        return perDayNutrition;
    }

    public void savePerDayNutrition(PerDayNutrition perDayNutrition){
        perDayNutritionRepository.save(perDayNutrition);
    }

    public double getAvailableKcalForDay(HealthInformation healthInformation) {//일일 권장 섭취 열량
        double height = healthInformation.getHeight();
        double weight = healthInformation.getWeight();
        int age = healthInformation.getAge();
        Gender gender = healthInformation.getGender();
        Activity activity = healthInformation.getActivityType();

        double coefficient = 0;
        double availableKcal = 0;

        if (gender == Gender.MALE) {


            if (age < 3) {//남자이면서 영유아 인경우의 하루 kcal
                availableKcal = 89 * weight - 100;
                return availableKcal;


            } else if (age > 2 && age < 20) {//남자이면서 청소년의 예상 하루 kcal
                if (activity == Activity.lowActivity) {
                    coefficient = 1;
                } else if (activity == Activity.normal) {
                    coefficient = 1.13;
                } else if (activity == Activity.activity) {
                    coefficient = 1.26;
                } else if (activity == Activity.hyperactivity) {
                    coefficient = 1.42;
                }
                availableKcal = 88.5 - 61.9 * age + coefficient * (26.7 * weight + 903 * height);
                return availableKcal;


            } else if (age > 19) {//남자이면서 성인의 하루평균 섭취 칼로리 권장량
                if (activity == Activity.lowActivity) {
                    coefficient = 1;
                } else if (activity == Activity.normal) {
                    coefficient = 1.11;
                } else if (activity == Activity.activity) {
                    coefficient = 1.25;
                } else if (activity == Activity.hyperactivity) {
                    coefficient = 1.48;
                }

                availableKcal = 662 - 9.53 * age + coefficient * (15.91 * weight + 539.6 * height);
                return availableKcal;

            }
        } else {

            if (age < 3) {//여자이면서 영유아 인경우의 하루 kcal
                availableKcal = 89 * weight - 100;
                return availableKcal;


            } else if (age > 2 && age < 20) {//여자이면서 청소년의 예상 하루 kcal
                if (activity == Activity.lowActivity) {
                    coefficient = 1;
                } else if (activity == Activity.normal) {
                    coefficient = 1.16;
                } else if (activity == Activity.activity) {
                    coefficient = 1.31;
                } else if (activity == Activity.hyperactivity) {
                    coefficient = 1.56;
                }
                availableKcal = 135.3 - 30.8 * age + coefficient * (10.0 * weight + 934 * height);
                return availableKcal;


            } else if (age > 19) {//여자이면서 성인의 하루평균 섭취 칼로리 권장량
                if (activity == Activity.lowActivity) {
                    coefficient = 1;
                } else if (activity == Activity.normal) {
                    coefficient = 1.12;
                } else if (activity == Activity.activity) {
                    coefficient = 1.27;
                } else if (activity == Activity.hyperactivity) {
                    coefficient = 1.45;
                }
                availableKcal = 354 - 6.91 * age + coefficient * (9.36 * weight + 726 * height);
                return Math.round(availableKcal);
            }

        }

        return availableKcal;//0을 반환하면 안됨.
    }

    public double getAvailableSugarPerDay(HealthInformation healthInformation) {//일일권장 당류섭취 권장량
        double availableKcal = getAvailableKcalForDay(healthInformation);
        double availableSugar = availableKcal*0.1/4;
        return availableSugar;
    }

    public double getAvailableSaturated_FatPerDay(HealthInformation healthInformation) {//일일 권장 포화지방 섭취 권장량
        double availableKcal = getAvailableKcalForDay(healthInformation);
        double availableSaturated_Fat = availableKcal*0.07/9;
        return availableSaturated_Fat;
    }

    public double getAvailableProteinPerDay(HealthInformation healthInformation) {//일일 권장 단백질 섭취량
        Gender gender = healthInformation.getGender();
        int age = healthInformation.getAge();
        double availableProtein = 0;

        if(gender==Gender.FEMALE) {

            if(age>= 6 && age <=8) {
                availableProtein = 35;
                return availableProtein;

            }else if(age >=9 && age<=11) {
                availableProtein = 50;
                return availableProtein;

            }else if(age >=12 && age<=14) {
                availableProtein = 60;
                return availableProtein;

            }else if(age >=15 && age<=49) {
                availableProtein = 65;
                return availableProtein;

            }else if(age>=50) {
                availableProtein = 60;
                return availableProtein;
            }

        }else {

            if(age >=6 && age<=8) {
                availableProtein = 35;
                return availableProtein;

            } else if (age >= 9 && age <= 11) {
                availableProtein = 45;
                return availableProtein;

            } else if (age >= 12 && age <= 29) {
                availableProtein = 55;
                return availableProtein;

            }else if(age>=30){
                availableProtein = 50;
                return availableProtein;
            }

        }
        return availableProtein;
    }

    public double getAvailableSodiumPerDay(HealthInformation healthInformation) {

        Gender gender = healthInformation.getGender();
        int age = healthInformation.getAge();
        double availableSodium = 0;

        if(gender == Gender.FEMALE) {

            if(age>=6 && age <=8) {
                availableSodium = 1200;
                return availableSodium;

            }else if(age>=9 && age<=64) {
                availableSodium = 1500;
                return availableSodium;

            }else if(age>=65 && age<=74) {
                availableSodium = 1300;
                return availableSodium;

            }else if(age>75) {
                availableSodium = 1100;
                return availableSodium;

            }

        }else {

            if(age>=6 && age <=8) {

                availableSodium = 1200;
                return availableSodium;

            }else if(age>=9 && age<=64) {

                availableSodium = 1500;
                return availableSodium;

            }else if(age>=65 && age<=74) {


                availableSodium = 1300;
                return availableSodium;

            }else if(age>75) {

                availableSodium = 1100;
                return availableSodium;

            }


        }
        return availableSodium;//null 대신에 0값을 반환한다.
    }

    public double getAvailableCaffeinePerDay(HealthInformation healthInformation) {
        return 300;
    }

    //음료로 인한 영양섭취 권장량 반환하는 메소드들
    public double getDrink_kcal(HealthInformation healthInformation) {
        double kcal = getAvailableKcalForDay(healthInformation);
        return kcal*0.04;

    }

    public double getDrink_Sugar(HealthInformation healthInformation) {
        double sugar = getAvailableSugarPerDay(healthInformation);
        return sugar * 0.2;

    }

    public double getDrink_Protein(HealthInformation healthInformation) {
        double protein = getAvailableProteinPerDay(healthInformation);
        return protein*0.008;
    }

    public double getDrink_Saturated_Fat(HealthInformation healthInformation) {
        double saturated_fat = getAvailableSaturated_FatPerDay(healthInformation);
        return saturated_fat*0.013;
    }

    public double getDrink_Sodium(HealthInformation healthInformation) {
        double sodium = getAvailableSodiumPerDay(healthInformation);
        return sodium*0.005;
    }

    public double getDrink_Caffeine(HealthInformation healthInformation) {
        double caffeine = getAvailableCaffeinePerDay(healthInformation);
        return caffeine;

    }


}
