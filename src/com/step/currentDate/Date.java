package com.step.currentDate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Date {

    public List<String> currentDate(){
        Calendar calendar = new GregorianCalendar();
        List<String> currentDate = new ArrayList<>();

        int year    = calendar.get(Calendar.YEAR);
        int month   = calendar.get(Calendar.MONTH);
        int day     = calendar.get(Calendar.DATE);
        int hour    = calendar.get(Calendar.HOUR_OF_DAY);
        int minute  = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);

        currentDate.add( (String.format("%02d", day)+'/'+String.format("%02d", (month+1))+'/'+year) );
        currentDate.add( String.format("%02d", hour)+':'+String.format("%02d", minute)+':'+String.format("%02d", seconds) );

        return currentDate;
    }
}
