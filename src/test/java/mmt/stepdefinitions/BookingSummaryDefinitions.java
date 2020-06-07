package mmt.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import mmt.booking.BookingInfo;
import mmt.date.DateSelection;
import mmt.hotel.ChooseHotel;
import mmt.hotel.FindHotel;
import mmt.login.LoginToHisAccount;

public class BookingSummaryDefinitions {
    @Managed
    WebDriver driver;

    @Steps
    LoginToHisAccount login;
    @Steps
    FindHotel findHotel;
    @Steps
    DateSelection pickDate;
    @Steps
    ChooseHotel chooseHotel;
    @Steps
    BookingInfo bookingInfo;


    @Given("Vindhiyan is making the reservation in make my trip")
    public void vindhiyan_is_making_the_reservation_in_make_my_trip() {
        login.launchApplication();

    }

    @When("he do login to the application")
    public void he_do_login_to_the_application() {
        login.openLoginSection();
        login.enterInUserNameSection();
        login.enterInPasswordSection();
    }

    @When("he click on Hotels in the top menu bar")
    public void he_click_on_hotels_in_the_top_menu_bar() {
        findHotel.openToHotelSection();
    }

    @When("he select location as {string}")
    public void he_select_location_as(String cityName) {
        findHotel.enterCityNameToFindHotel(cityName);
        findHotel.selectCityFromList();
    }

    @When("he select date from {string} to {string}")
    public void he_select_date_from_to(String dateFrom, String dateTo) {
        pickDate.openToSelectTravelDate();
        pickDate.selectDateFromTo(dateFrom,dateTo);
    }

    @When("he add {string} Adult and {string} kids for room one")
    public void he_add_Adult_and_kids_for_room_one(String noAdult, String noChild) {
        findHotel.openRoomGuest();
        findHotel.selectAdult(noAdult);
        findHotel.selectChild(noChild);
    }

    @When("he add {string} Adult and {string} kids for room two")
    public void he_add_Adult_and_kids_for_room_two(String noAdult, String noChild) {
        findHotel.addAnotherRoom();
        findHotel.selectAdult(noAdult);
        findHotel.selectChild(noChild);
        findHotel.confirmRoomGuest();
    }

    @When("he select travel type as {string}")
    public void he_select_travel_type_as(String string) throws InterruptedException {
        findHotel.openTravellingFor();
        findHotel.selectTravelType();
    }

    @When("he click Search")
    public void he_click_search() {
        findHotel.searchHotel();
    }


    @When("he sets minimum value as {int} in a slider")
    public void he_sets_minimum_value_as_in_a_slider(Integer reqValue) {
        chooseHotel.chooseMinimumPriceRange(reqValue);
    }
    @When("he selects user rating as {string}")
    public void he_selects_user_rating_as(String usrRating) {
        chooseHotel.selectHotelsBasedOnUserRating(usrRating);
    }


    @When("he scrolls to hotel listed in {int} th position")
    public void he_scrolls_to_hotel_listed_in_th_position(Integer listedPosition) {
        chooseHotel.selectHotelListedInDesiredPosition(listedPosition);
    }
    @When("he clicks on hotel listed in {int} th position")
    public void he_clicks_on_hotel_listed_in_th_position(Integer listedPosition) {
        chooseHotel.selectHotelListedInDesiredPosition(listedPosition);
    }

    @When("he scrolls to the room type")
    public void he_scrolls_to_the_room_type() {
        bookingInfo.goToRoomTypeToSelect();
    }

    @When("he clicks select room on the first listed")
    public void he_clicks_select_room_on_the_first_listed() {
        bookingInfo.selectRoomTypeDesired();
    }

    @When("he fills all the information")
    public void he_fills_all_the_information() {
        bookingInfo.fillAllTravellersDetails();
    }

    @When("he selects smoking room and airport transfer in commonly requested")
    public void he_selects_smoking_room_and_airport_transfer_in_commonly_requested() {
        bookingInfo.chooseSpecialRequest();
    }

    @When("he unchecks for donation")
    public void he_unchecks_for_donation() {
        bookingInfo.uncheckAdditionalMoneyGetsAddedForDonation();
    }

    @When("he click Pay Now")
    public void he_click_Pay_Now() {
        bookingInfo.hitPayNow();
    }

    @Then("he checks details listed in booking summary")
    public void he_checks_details_listed_in_booking_summary() {
        bookingInfo.checkBookingSummarySectionisShown();
        bookingInfo.validateHotelName();
        bookingInfo.validateCheckInDate();
        bookingInfo.validateCheckOutDate();
        bookingInfo.validateDayOfWeek();
        bookingInfo.validateRoomType();
        bookingInfo.validateRoomMembers();
        bookingInfo.validateTravellerName();
        bookingInfo.validateContactInfo();
    }



}
