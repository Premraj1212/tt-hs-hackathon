package mmt.booking;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ApplicationConstants;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class InfoDetails extends PageObject {

    @FindBy(css = ".bdrBottom.makeFlex.recRoom > .column.makeFlex.titleLastWidth .appendBottom15.primaryBtn")
    private WebElement SELECT_ROOM;
    @FindBy(css="ul#detpg_room_includes_options > li")
    private WebElement scrollToRoom;
    @FindBy(css="#travelerInfo")
    private WebElement TRAVELLER_INFO;
    @FindBy(css="input#fName")
    private WebElement TRAVELLER_FIRST_NAME;
    @FindBy(css="input#lName")
    private WebElement TRAVELLER_LAST_NAME;
    @FindBy(css="#email")
    private WebElement TRAVELLER_EMAIL_ID;
    @FindBy(css=".txtInputContactInfo")
    private WebElement TRAVELLER_CONTACT_NO;
    @FindBy(css=".prependTop20.appendBottom5")
    private WebElement SPECIAL_REQ;
    @FindBy(css="[for='101']")
    private WebElement SMOKE_SPECIAL_REQ;
    @FindBy(css="[for='107']")
    private WebElement AIR_TRF_SPECIAL_REQ;
    @FindBy(css="[for='donation']")
    private WebElement MMT_DONATION;
    @FindBy(css=".btnPayNow")
    private WebElement PAY_NOW;
    @FindBy(css=".hotelPageHeading #detpg_hotel_location")
    private WebElement HOTEL_ADDR;
    @FindBy(css="#RoomType .roomWrap:nth-child(3) h2")
    private WebElement ROOM_DETAILS;
    @FindBy(css=".bdrBottom.makeFlex.recRoom > .column.makeFlex.titleWidth > div:nth-of-type(1) > .appendLeft10.column.flexOne.makeFlex > .appendBottom4 > .greenText.latoBold")
    private WebElement ROOM_ONLY;




    public void switchToNewWindow() {
        String originalWindow = Serenity.sessionVariableCalled("originalWindow");
        //Wait for the new window or tab
        waitFor(numberOfWindowsToBe(2));

        //Loop through until we find a new window handle
        for (String windowHandle : getDriver().getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void goToRoomToSelect() {
        waitFor(HOTEL_ADDR);
        Serenity.setSessionVariable("HotelAddress").to(HOTEL_ADDR.getText());
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView();", scrollToRoom);
    }

    public void selectRoomType() {
        waitFor(SELECT_ROOM);
        Serenity.setSessionVariable("RoomDetails").to(ROOM_DETAILS.getText());
        Serenity.setSessionVariable("RoomOnly").to(ROOM_ONLY.getText());
        SELECT_ROOM.click();
    }

    public void goToTravellerDetailsSection() {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView();", TRAVELLER_INFO);
    }

    public void enterAllTravellerInfo() {
        TRAVELLER_FIRST_NAME.click();
        TRAVELLER_FIRST_NAME.sendKeys(ApplicationConstants.FIRST_NAME);
        TRAVELLER_LAST_NAME.click();
        TRAVELLER_LAST_NAME.sendKeys(ApplicationConstants.LAST_NAME);
        TRAVELLER_EMAIL_ID.click();
        TRAVELLER_EMAIL_ID.clear();
        TRAVELLER_EMAIL_ID.sendKeys(ApplicationConstants.EMAIL);
        TRAVELLER_CONTACT_NO.click();
        TRAVELLER_CONTACT_NO.sendKeys(ApplicationConstants.CONTACT_NO);

    }

    public void selectTwoSpecialRequest() {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView();", SPECIAL_REQ);
        SMOKE_SPECIAL_REQ.click();
        AIR_TRF_SPECIAL_REQ.click();
    }

    public void uncheckMMTDonation() {
        MMT_DONATION.click();
    }

    public void selectPayNow() {
        PAY_NOW.click();
    }

}
