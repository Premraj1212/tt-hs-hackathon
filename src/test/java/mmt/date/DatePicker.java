package mmt.date;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static java.lang.String.format;

public class DatePicker extends PageObject {

    @FindBy(css = "div:nth-of-type(1) > div[role='heading']")
    private WebElement CURRENTPERIOD;
    @FindBy(css = ".DayPicker-NavButton--next")
    private WebElement rightArrow;

    private String day_FORMAT = "//div[contains(@aria-label, '%s')]";


    public void openDatePanel(){
        waitFor(CURRENTPERIOD);
    }


    public void chooseDate(LocalDate localDateFrom, LocalDate localDateTo) {
        chooseMonth(localDateFrom,localDateTo);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dtFrom = formatter.parse(localDateFrom.toString());
            Date dtTo = formatter.parse(localDateTo.toString());
            SimpleDateFormat dateFormat = new SimpleDateFormat("E MMM dd yyyy");

            chooseDay(dateFormat.format(dtFrom));
            chooseDay(dateFormat.format(dtTo));
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    private void chooseDay(String date) {
        By chDay = By.xpath(format(day_FORMAT, date));
        getDriver().findElement(chDay).click();
    }

    private void chooseMonth(LocalDate localDateFrom, LocalDate localDateTo) {
        LocalDate currentPeriod = getCurrentPeriod();
        System.out.println("*********After currentPeriod************>"+currentPeriod.toString());
        long monthsAway = ChronoUnit.MONTHS.between(currentPeriod, localDateFrom.withDayOfMonth(1));
        System.out.println("*********monthsAway************>"+monthsAway);

        if(monthsAway>1){
            for(int i = 0; i < Math.abs(monthsAway); i++){
                rightArrow.click();
            }
        }

    }

    private LocalDate  getCurrentPeriod() {
        System.out.println("*********Before currentPeriod************>"+CURRENTPERIOD.getText());
        String[] currentPeriod = CURRENTPERIOD.getText().split("(?<=\\G.{4})");
        System.out.println("*********Before && currentPeriod************>"+currentPeriod);
        return LocalDate.of(
                Integer.parseInt(currentPeriod[1]),
                Month.valueOf(currentPeriod[0].toUpperCase()),
                1);
    }
}
