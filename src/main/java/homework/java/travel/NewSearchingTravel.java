package homework.java.travel;

import java.util.ArrayList;
import java.util.List;

public class NewSearchingTravel {
    public static final String COUNTRY_VIETNAM = "vietnam";
    public static final String COUNTRY_PHILLIPHINE = "philliphine";
    public static final String COUNTRY_TAILAND = "tailand";

    // 여행상품 저장
    private List<TravelInfoV0> travelInfoList = new ArrayList<>();

    public NewSearchingTravel() {
        initializeProduct();
    }

    private void initializeProduct() {
        TravelInfoV0 cebu = new TravelInfoV0();
        cebu.setName("Cebu Travel");
        cebu.setCountry(COUNTRY_PHILLIPHINE);
        cebu.setCity("cebu");
        cebu.setDays(5);
        cebu.setNights(3);
        travelInfoList.add(cebu);

        TravelInfoV0 boracay = new TravelInfoV0();
        boracay.setName("Boracay Travel");
        boracay.setCountry(COUNTRY_PHILLIPHINE);
        boracay.setCity("boracay");
        boracay.setDays(5);
        boracay.setNights(3);
        travelInfoList.add(boracay);

        TravelInfoV0 hanoi = new TravelInfoV0();
        hanoi.setName("Hanoi Travel");
        hanoi.setCountry(COUNTRY_VIETNAM);
        hanoi.setCity("hanoi");
        hanoi.setDays(3);
        hanoi.setNights(2);
        travelInfoList.add(hanoi);

        TravelInfoV0 danang = new TravelInfoV0();
        danang.setName("Danang Travel");
        danang.setCountry(COUNTRY_VIETNAM);
        danang.setCity("danang");
        danang.setDays(6);
        danang.setNights(4);
        travelInfoList.add(danang);

        TravelInfoV0 bankok = new TravelInfoV0();
        bankok.setName("Bankok Travel");
        bankok.setCountry(COUNTRY_TAILAND);
        bankok.setCity("bankok");
        bankok.setDays(3);
        bankok.setNights(2);
        travelInfoList.add(bankok);

    }

    public List<TravelInfoV0> searchTravelInfo(TravelInfoFilter searchCondition) {
        List<TravelInfoV0> value = new ArrayList<>();

        for (TravelInfoV0 travelInfo : travelInfoList) {
            if (searchCondition.isMatched(travelInfo)) {
                value.add(travelInfo);
            }
        }
        return value;
    }

    public static void main(String[] args) {
        NewSearchingTravel st = new NewSearchingTravel();

        List<TravelInfoV0> searchList = st.searchTravelInfo(new TravelInfoFilter(){
            @Override
            public boolean isMatched(TravelInfoV0 travelInfo){
                if (travelInfo.getCountry().equals("philliphine")) {
                    return true;
                } else {
                    return false;
                }
            }
        });

        for (TravelInfoV0 travelInfo : searchList) {
            System.out.println("travelInfo = " + travelInfo);
        }
    }




}
