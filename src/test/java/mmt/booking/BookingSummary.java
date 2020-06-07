package mmt.booking;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ApplicationConstants;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class BookingSummary extends PageObject {
    @FindBy(css=".summry_info")
    private WebElement BOOKING_SUMMARY;
    @FindBy(css="[data-hasqtip='4']")
    private WebElement HOTEL_NAME;
    @FindBy(css="[data-hasqtip='5']")
    private WebElement HOTEL_ADDRESS;
    @FindBy(css=".checkin .lato-semibold")
    private WebElement CHECK_IN_DATE;
    @FindBy(css=".checkout .lato-semibold")
    private WebElement CHECK_OUT_DATE;
    @FindBy(css=".checkin .grey")
    private WebElement CHECK_IN_DAY;
    @FindBy(css=".checkout .grey")
    private WebElement CHECK_OUT_DAY;
    @FindBy(css=".lato-semibold .black")
    private WebElement ROOM_INFO;
    @FindBy(css=".append_bottom5.pull-left > .adult_info.lato-regular.make_block")
    private List<WebElement> ROOM_MEMBERS;
    @FindBy(css=".traveler_name.append_bottom6")
    private WebElement TRAVELLER_FULL_NAME;
    @FindBy(css=".contact_info")
    private WebElement CONTACT_INFO;



    public void verifyTitleOfBookingSummary() {
        withTimeoutOf(Duration.ofSeconds(ApplicationConstants.MAX_WAIT_TIME)).waitFor(BOOKING_SUMMARY).isDisplayed();
        assertThat(BOOKING_SUMMARY.getText()).isEqualTo("BOOKING SUMMARY");
    }

    public String getHotelName() {
        return HOTEL_NAME.getText();
    }
    public String getHotelAddr() {
        return HOTEL_ADDRESS.getText();
    }

    public String getCheckInDate() {
        return CHECK_IN_DATE.getText();
    }

    public String getCheckOutDate() {
        return CHECK_OUT_DATE.getText();
    }

    public String getCheckInDay() {
        return CHECK_IN_DAY.getText();
    }

    public String getCheckOutDay() {
        return CHECK_OUT_DAY.getText();
    }

    public String getRoomInfo() {
        String[] roomDetls = ROOM_INFO.getText().split(Pattern.quote("|"));
        return roomDetls[0].trim();
    }
    public String getRoomOnlyInfo() {
        String[] roomDetls = ROOM_INFO.getText().split(Pattern.quote("|"));
        return roomDetls[1].trim();
    }

    public List<String> getRoomMembers(){
        return ROOM_MEMBERS.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

    }
    public String getTravellerFullName() {
        return TRAVELLER_FULL_NAME.getText();
    }
    public String getContactInfo() {
        return CONTACT_INFO.getText();
    }


}
