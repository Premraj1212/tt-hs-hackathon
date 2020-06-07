package mmt.hotel;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

public class PickHotel extends PageObject {
    @FindBy(className = "listingRow")
    private List<WebElement> GO_TO_SELECT_HOTEL;
    private By SELECT_HOTEL = By.id("hlistpg_hotel_name");
    @FindBy(css = ".input-range")
    private WebElement SLIDER_RANGE;
    @FindBy(css = ".input-range__slider-container:nth-child(2) .input-range__slider")
    private WebElement SLIDER_HANDLE;
    @FindBy(css = "div#hlistpg_fr_user_rating > .filterList > li:nth-of-type(2) > .checkmarkOuter > label")
    private WebElement SELECT_4_USER_RATING;

    private String usr_Rating = "//label[contains(text(),'%s')]";


    public void selectUserRating(String userRating){
        By selUsrRating = By.xpath(format(usr_Rating, userRating));
        waitFor(getDriver().findElement(selUsrRating)).waitUntilClickable().click();
    }

    public void moveSliderTo(int reqValue,float minValue, float maxValue){
        slide(getDriver(),reqValue,minValue,maxValue);
    }

    public void slide(WebDriver driver, int value,float min,float max){
        int width=SLIDER_RANGE.getSize().getWidth();
        int x=(int)Float.parseFloat(SLIDER_HANDLE.getCssValue("left").replace("px", ""));
        float offsetX=width/(max-min)*value;
        new Actions(driver).dragAndDropBy(SLIDER_HANDLE, -x, 10).dragAndDropBy(SLIDER_HANDLE, (int)offsetX, 10).perform();

    }

    public void waitForHotelSelection() {
        getDriver().navigate().refresh();
        waitFor(SLIDER_RANGE);
    }

    public void goToHotelInThePositionAndClick(Integer listedPosition) {
        WebElement selectedHotel = GO_TO_SELECT_HOTEL.get(listedPosition);
        storeHotelDetails(selectedHotel);
        selectedHotel.click();
    }

    private void storeHotelDetails(WebElement selectedHotel) {
        String hotelName = selectedHotel.findElement(SELECT_HOTEL).getText();
        Serenity.setSessionVariable("Hotel Name").to(hotelName);
        System.out.println("*************hotelName**************"+hotelName);
    }

    public void storeCurrentWindowHandle() {
        //Store the ID of the original window
        assertThat(getDriver().getWindowHandles().size() == 1);
        Serenity.setSessionVariable("originalWindow").to(getDriver().getWindowHandle());
    }
}
