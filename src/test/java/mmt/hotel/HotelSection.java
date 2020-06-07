package mmt.hotel;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ApplicationConstants;

import java.time.Duration;

import static java.lang.String.format;

public class HotelSection extends PageObject {

    @FindBy(css = ".menu_Hotels .darkGreyText")
    private WebElement HOTEL_MENU;

    @FindBy(css = "input#city")
    private WebElement HIT_CITY;

    @FindBy(css = "div[role='combobox'] > .react-autosuggest__input")
    private WebElement ENTER_CITY;

    @FindBy(css = "li:nth-of-type(1) .appendBottom5.locusLabel")
    private WebElement SELECT_CITY;

    @FindBy(css = "#hsw_search_button")
    private WebElement SEARCH;

    @FindBy(css = ".blackText.code.font20 > span > span:nth-of-type(2)")
    private WebElement ROOM_GUEST;
    @FindBy(css = ".btnAddRoom")
    private WebElement ADD_ROOM;
    @FindBy(css = ".btnApply.primaryBtn")
    private WebElement APPLY_ROOM_SELECTION;
    @FindBy(css = ".hsw_inputBox.travelFor > label > .appendBottom5.latoBold.lbl_input")
    private WebElement TRAVELLING_FOR;
    @FindBy(css = "[data-cy='travelFor-Leisure']")
    private WebElement TRAVELLING_FOR_LEISURE;

    private String SEL_ADULT = "[data-cy='adults-%s']";
    private String SEL_CHILD = "[data-cy='children-%s']";

    public void goToHotelSection(){
        HOTEL_MENU.click();
    }

    public void enterCity(String cityName){
        HIT_CITY.click();
        ENTER_CITY.sendKeys(cityName);
    }

    public void selectCity(){
        waitFor(SELECT_CITY);
        SELECT_CITY.click();
    }

    public void clickSearch(){
        SEARCH.click();
    }

    public void selectAdult(String noAdult){
        WebElement SELECT_ADULT = getDriver().findElement(By.cssSelector(format(SEL_ADULT,noAdult)));
        SELECT_ADULT.click();
    }

    public void openRoomGuestDlg(){
        ROOM_GUEST.click();
    }

    public void selectChild(String noChild){
        WebElement SELECT_CHILD = getDriver().findElement(By.cssSelector(format(SEL_CHILD,noChild)));
        SELECT_CHILD.click();
    }

    public void clickAddRoom(){
        ADD_ROOM.click();
    }

    public void pressApplyRoomGuest(){
        ((JavascriptExecutor) getDriver()).executeScript("javascript:window.scrollBy(250,350)");
        waitFor(APPLY_ROOM_SELECTION);
        APPLY_ROOM_SELECTION.click();
    }
    public void openTravellingFor(){
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(document.body.scrollHeight,0)");
        withTimeoutOf(Duration.ofSeconds(ApplicationConstants.MAX_WAIT_TIME)).waitFor(TRAVELLING_FOR).waitUntilClickable();
        TRAVELLING_FOR.click();
    }
    public void selectTravelType(){
        TRAVELLING_FOR_LEISURE.click();
    }

}
