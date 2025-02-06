package com.techacademy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    @GetMapping("/dayofweek/{val}")
    public String dispDayOfWeek(@PathVariable("val") String val) {
        SimpleDateFormat dow = new SimpleDateFormat("yyyymmdd");
        Date date;
        try {
            date = dow.parse(val);
        }catch(ParseException e) {
            return "無効な日付です";
        }
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        String[] weekDays = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        return weekDays[dayOfWeek-1];
    }

    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable("val1") int val1, @PathVariable("val2") int val2) {
        int res = 0;
        res = val1 + val2;
        return "実行結果：" + res;
    }

    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable("val1") int val1, @PathVariable("val2") int val2) {
        int res = 0;
        res = val1 - val2;
        return "実行結果：" + res;
    }

    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable("val1") int val1, @PathVariable("val2") int val2) {
        int res = 0;
        res = val1 * val2;
        return "実行結果：" + res;
    }

    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable("val1") int val1, @PathVariable("val2") int val2) {
        int res = 0;
        res = val1 / val2;
        return "計算結果：" + res;
    }
}