package com.si.seminar.realestatewebsite.web.mapper;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by sarsovsk on 28.09.2016.
 */
public final class BigDecimalFormatter {

    public static String formatBigDecimal(BigDecimal number) {

        number = number.setScale(2, BigDecimal.ROUND_HALF_UP);

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(0);

        String result = df.format(number);

        return result;
    }

}
