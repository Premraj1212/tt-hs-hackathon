package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class HelperMethods {
    public LocalDate convertLocaleDate(String dateFrom) {
        return LocalDate.parse(dateFrom);
    }

    public String dateFormatter(String fromPattern,String toPattern, String date){
        SimpleDateFormat sdf=new SimpleDateFormat(fromPattern);
        Date dateZ = null;
        try {
            dateZ = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sdf=new SimpleDateFormat(toPattern);
        return sdf.format(dateZ);
    }

}
