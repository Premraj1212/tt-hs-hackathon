package mmt.hotel;

import net.thucydides.core.annotations.Step;
import utils.ApplicationConstants;

public class ChooseHotel {

    PickHotel pickHotel;

    @Step
    public void chooseMinimumPriceRange(Integer reqValue) {
        pickHotel.waitForHotelSelection();
        pickHotel.moveSliderTo(reqValue, ApplicationConstants.MIN_SLIDER_RANGE,ApplicationConstants.MAX_SLIDER_RANGE);
    }
    @Step
    public void selectHotelsBasedOnUserRating(String usrRating) {
        pickHotel.selectUserRating(usrRating);
    }
    @Step
    public void selectHotelListedInDesiredPosition(Integer listedPosition) {
        pickHotel.storeCurrentWindowHandle();
        pickHotel.goToHotelInThePositionAndClick(listedPosition);
    }
}
