package mmt.date;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Shared;
import net.thucydides.core.annotations.Step;
import utils.HelperMethods;

import java.time.LocalDate;

public class DateSelection {
    @Shared
    HelperMethods helperMethods;
    DatePicker datePicker;

    @Step
    public void openToSelectTravelDate() {
        datePicker.openDatePanel();
    }
    @Step
    public void selectDateFromTo(String dateFrom, String dateTo) {
        Serenity.setSessionVariable("DateFrom").to(dateFrom);
        Serenity.setSessionVariable("DateTo").to(dateTo);
        LocalDate localDateFrom = helperMethods.convertLocaleDate(dateFrom);
        LocalDate localDateTo = helperMethods.convertLocaleDate(dateTo);
        datePicker.chooseDate(localDateFrom,localDateTo);
    }
}
