package mmt.booking;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Shared;
import net.thucydides.core.annotations.Step;
import utils.ApplicationConstants;
import utils.HelperMethods;

import static org.assertj.core.api.Assertions.assertThat;

public class BookingInfo {

    @Shared
    HelperMethods helperMethods;

    InfoDetails infoDetails;
    BookingSummary bookingSummary;

    @Step
    public void goToRoomTypeToSelect() {
        infoDetails.switchToNewWindow();
        infoDetails.goToRoomToSelect();

    }

    @Step
    public void selectRoomTypeDesired() {
        infoDetails.selectRoomType();
    }
    @Step
    public void fillAllTravellersDetails() {
        infoDetails.goToTravellerDetailsSection();
        infoDetails.enterAllTravellerInfo();
    }
    @Step
    public void chooseSpecialRequest() {
        infoDetails.selectTwoSpecialRequest();
    }
    @Step
    public void uncheckAdditionalMoneyGetsAddedForDonation() {
        infoDetails.uncheckMMTDonation();
    }
    @Step
    public void hitPayNow() {
        infoDetails.selectPayNow();
    }
    @Step
    public void checkBookingSummarySectionisShown() {
        bookingSummary.verifyTitleOfBookingSummary();
    }
    @Step
    public void validateHotelName(){
        String hotelName = Serenity.sessionVariableCalled("Hotel Name");
        assertThat(hotelName).isEqualTo(bookingSummary.getHotelName());
    }
    @Step
    public void validateHotelAddress(){
        String hotelAddress = Serenity.sessionVariableCalled("HotelAddress");
        assertThat(hotelAddress).isEqualTo(bookingSummary.getHotelAddr().substring(0, Math.min(bookingSummary.getHotelAddr().length(), 21)));
    }
    @Step
    public void validateCheckInDate() {
        String checkInDate = Serenity.sessionVariableCalled("DateFrom");
        String bkSummaryDate=bookingSummary.getCheckInDate().replaceAll("'","").trim();
        assertThat(checkInDate).isEqualTo(helperMethods.dateFormatter("dd MMM yyyy","yyyy-MM-dd",bkSummaryDate));
    }
    @Step
    public void validateCheckOutDate() {
        String checkOutDate = Serenity.sessionVariableCalled("DateTo");
        String bkSummaryDate=bookingSummary.getCheckOutDate().replaceAll("'","").trim();
        assertThat(checkOutDate).isEqualTo(helperMethods.dateFormatter("dd MMM yyyy","yyyy-MM-dd",bkSummaryDate));
    }
    @Step
    public void validateDayOfWeek() {
        String checkInDate = Serenity.sessionVariableCalled("DateFrom");
        String checkOutDate = Serenity.sessionVariableCalled("DateTo");
        String checkInDayOfWeek = helperMethods.convertLocaleDate(checkInDate).getDayOfWeek().toString();
        String checkOutDayOfWeek = helperMethods.convertLocaleDate(checkOutDate).getDayOfWeek().toString();

        assertThat(checkInDayOfWeek.substring(0, Math.min(checkInDayOfWeek.length(), 3)))
                .isEqualTo(bookingSummary.getCheckInDay().toUpperCase());
        assertThat(checkOutDayOfWeek.substring(0, Math.min(checkOutDayOfWeek.length(), 3)))
                .isEqualTo(bookingSummary.getCheckOutDay().toUpperCase());
    }
    @Step
    public void validateRoomType() {
        String roomDetails = Serenity.sessionVariableCalled("RoomDetails");
        String roomOnly = Serenity.sessionVariableCalled("RoomOnly");
        assertThat(roomDetails).isEqualTo(bookingSummary.getRoomInfo());
        assertThat(roomDetails).contains(bookingSummary.getRoomOnlyInfo());
    }
    @Step
    public void validateRoomMembers() {
        bookingSummary.getRoomMembers()
                        .stream()
                            .forEach(member ->assertThat(member)
                                    .contains("2"));
    }
    @Step
    public void validateTravellerName() {
        assertThat(bookingSummary.getTravellerFullName()).contains(ApplicationConstants.FIRST_NAME);
        assertThat(bookingSummary.getTravellerFullName()).contains(ApplicationConstants.LAST_NAME);
    }
    @Step
    public void validateContactInfo() {
        assertThat(bookingSummary.getContactInfo()).contains(ApplicationConstants.CONTACT_NO);
        assertThat(bookingSummary.getContactInfo()).contains(ApplicationConstants.EMAIL);
    }
}
