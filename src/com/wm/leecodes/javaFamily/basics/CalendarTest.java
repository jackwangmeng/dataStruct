package com.wm.leecodes.javaFamily.basics;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @author wm
 * @Package com.wm.leecode.javaFamily.basics
 * @date 2020/9/1 15:58
 */
public class CalendarTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        date = date.minusDays(today - 1);
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 0; i < value; i++){
            System.out.print("  ");
        }
        while (date.getMonthValue() == month){
            System.out.printf("%3d" , date.getDayOfMonth());
            if (date.getDayOfMonth() == today){
                System.out.print("*");
            }else {
                System.out.print(" ");
            }
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1){
                System.out.println();
            }
        }
        if (date.getDayOfWeek().getValue() != 1){
            System.out.println();
        }
    }
}
