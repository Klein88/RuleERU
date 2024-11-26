package zjc.edu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateConverter {
    public static String convertDateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public static String convertStringToFormattedDate(String dateString) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = inputFormat.parse(dateString);

        // 设置输出的日期格式为ISO 8601格式，同时设置时区为UTC
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        outputFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        return outputFormat.format(date);
    }
    public static String extractDate(String dateString) throws ParseException {
        // 设置输入的日期格式为ISO 8601格式，同时设置时区为UTC
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        inputFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date date = inputFormat.parse(dateString);

        // 设置输出的日期格式为"yyyy-MM-dd"
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

        return outputFormat.format(date);
    }
}
