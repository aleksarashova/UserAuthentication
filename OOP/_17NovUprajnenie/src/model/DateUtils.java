package model;

import java.util.EnumSet;

public class DateUtils {

    public enum WeekDay {
        Mon,
        Tue,
        Wed,
        Thu,
        Fri,
        Sat,
        Sun
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    public static boolean isValidYear(int year) {
        return year >= 1 && year <= 9999;
    }

    public static boolean isValidMonth(Month month) {
        return EnumSet.allOf(Month.class).contains(month);
    }

    public static boolean isValidDay(int year, Month month, int day) {
        return day >= 1 && day <= daysInMonth(year, month);
    }

    public static int daysInMonth(int year, Month month) {
        return switch (month) {
            case Apr, Jun, Sep, Nov -> 30;
            case Feb -> isLeapYear(year) ? 29 : 28;
            default -> 31;
        };
    }

    public static WeekDay getDayOfWeek(int year, Month month, int day) {
        int century;
        if (year >= 1700 && year < 1800) {
            century = 4;
        } else if (year >= 1800 && year < 1900) {
            century = 2;
        } else if (year >= 1900 && year < 2000) {
            century = 0;
        } else if (year >= 2000 && year < 2100) {
            century = 6;
        } else {
            int adjustedYear = year % 400;
            if (adjustedYear >= 0 && adjustedYear < 100) {
                century = 4;
            } else if (adjustedYear >= 100 && adjustedYear < 200) {
                century = 2;
            } else if (adjustedYear >= 200 && adjustedYear < 300) {
                century = 0;
            } else {
                century = 6;
            }
        }

        int result = century + (year % 100) + ((year % 100) / 4);

        int[] monthCodes = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
        int number = monthCodes[month.ordinal()];

        if (month == Month.Jan && isLeapYear(year)) {
            number = 6;
        } else if (month == Month.Feb && isLeapYear(year)) {
            number = 2;
        }

        result = (result + number + day) % 7;

        return switch (result) {
            case 0 -> WeekDay.Sun;
            case 1 -> WeekDay.Mon;
            case 2 -> WeekDay.Tue;
            case 3 -> WeekDay.Wed;
            case 4 -> WeekDay.Thu;
            case 5 -> WeekDay.Fri;
            case 6 -> WeekDay.Sat;
            default -> null;
        };
    }

}
