package mmt.hotel;

import net.thucydides.core.annotations.Step;

public class FindHotel {

    HotelSection hotelSection;

    @Step
    public void openToHotelSection(){
        hotelSection.goToHotelSection();
    }

    @Step
    public void enterCityNameToFindHotel(String cityName){
        hotelSection.enterCity(cityName);
    }

    @Step
    public void selectCityFromList(){
        hotelSection.selectCity();
    }

    @Step
    public void openRoomGuest() {
        hotelSection.openRoomGuestDlg();
    }
    @Step
    public void selectAdult(String noAdult) {
        hotelSection.selectAdult(noAdult);
    }
    @Step
    public void selectChild(String noChild) {
        hotelSection.selectChild(noChild);
    }

    @Step
    public void searchHotel() {
        hotelSection.clickSearch();
    }

    @Step
    public void addAnotherRoom() {
        hotelSection.clickAddRoom();
    }
    @Step
    public void confirmRoomGuest() {
        hotelSection.pressApplyRoomGuest();
    }

    @Step
    public void openTravellingFor() {
        hotelSection.openTravellingFor();
    }

    @Step
    public void selectTravelType() {
        hotelSection.selectTravelType();
    }


}
