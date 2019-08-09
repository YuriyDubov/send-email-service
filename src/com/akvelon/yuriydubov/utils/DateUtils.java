package com.akvelon.yuriydubov.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String toSrting(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        return dateFormat.format(date);
    }
}