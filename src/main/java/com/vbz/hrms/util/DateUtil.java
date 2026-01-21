package com.vbz.hrms.util;

import java.time.YearMonth;

public class DateUtil {

    public int getTotalDaysInMonth(int year, int month) {
        return YearMonth.of(year, month).lengthOfMonth();
    }
}
