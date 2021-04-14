package com.hackaton.bbva.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String toString(Date date) {
        if (date == null) {
            return null;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fecha = sdf.format(date);
            return fecha;
        }
    }
}
