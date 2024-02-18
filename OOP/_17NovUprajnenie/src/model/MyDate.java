package model;

import error.InvalidYearException;
import error.InvalidMonthException;
import error.InvalidDayException;
import error.InvalidYearAfterCalculationException;

public class MyDate {
    private int day;
    private Month month;
    private int year;

    public MyDate(int year, int month, int day) throws InvalidYearException, InvalidMonthException, InvalidDayException {
        if (!DateUtils.isValidYear(year))
            throw new InvalidYearException();
        if (!DateUtils.isValidMonth(Month.values()[month - 1]))
            throw new InvalidMonthException();
        if (!DateUtils.isValidDay(year, Month.values()[month - 1], day))
            throw new InvalidDayException();
        this.day = day;
        this.month = Month.values()[month - 1];
        this.year = year;
    }

    public void setDate(int year, Month month, int day) throws InvalidYearException, InvalidMonthException, InvalidDayException {
        setYear(year);
        setMonth(month);
        setDay(year, month, day);
    }

    public void setYear(int year) throws InvalidYearException {
        if (DateUtils.isValidYear(year))
            throw new InvalidYearException();
        this.year = year;
    }

    public void setMonth(Month month) throws InvalidMonthException {
        if (DateUtils.isValidMonth(month))
            throw new InvalidMonthException();
        this.month = month;
    }

    public void setDay(int year, Month month, int day) throws InvalidDayException {
        if (DateUtils.isValidDay(year, month, day))
            throw new InvalidDayException();
        this.day = day;
    }

    public int getYear() {
        return this.year;
    }

    public Month getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DateUtils.getDayOfWeek(this.year, this.month, this.day)).append(' ');
        sb.append(getDay()).append(' ').append(getMonth()).append(' ').append(getYear());

        return sb.toString();
    }


    public MyDate nextDay() throws InvalidYearAfterCalculationException {
        if (day < DateUtils.daysInMonth(year, month)) {
            day++;
        } else {
            day = 1;
            if (month == Month.Dec) {
                month = Month.Jan;
                year++;
            } else {
                month = Month.values()[month.ordinal() + 1];
            }
        }
        if (!DateUtils.isValidYear(year))
            throw new InvalidYearAfterCalculationException();
        return this;
    }

    public MyDate nextMonth() throws InvalidYearAfterCalculationException {
        if (month == Month.Dec) {
            month = Month.Jan;
            year++;
        } else {
            month = Month.values()[month.ordinal() + 1];
        }
        if (day > DateUtils.daysInMonth(year, month)) {
            day = DateUtils.daysInMonth(year, month);
        }
        if (!DateUtils.isValidYear(year))
            throw new InvalidYearAfterCalculationException();
        return this;
    }

    public MyDate nextYear() throws InvalidYearAfterCalculationException {
        if (month == Month.Feb && day == 29 && !DateUtils.isLeapYear(year + 1)) {
            day = 28;
        }
        year++;
        if (!DateUtils.isValidYear(year))
            throw new InvalidYearAfterCalculationException();
        return this;
    }

    public MyDate previousDay() throws InvalidYearAfterCalculationException {
        if (day > 1) {
            day--;
        } else {
            day = 31;
            if (month == Month.Jan) {
                month = Month.Dec;
                year--;
            } else {
                month = Month.values()[month.ordinal() - 1];
                day = DateUtils.daysInMonth(year, month);
            }
        }
        if (!DateUtils.isValidYear(year))
            throw new InvalidYearAfterCalculationException();
        return this;
    }


    public MyDate previousMonth() throws InvalidYearAfterCalculationException {
        if (month == Month.Jan) {
            month = Month.Dec;
            year--;
        } else {
            month = Month.values()[month.ordinal() - 1];
        }
        if (day > DateUtils.daysInMonth(year, month)) {
            day = DateUtils.daysInMonth(year, month);
        }
        if (!DateUtils.isValidYear(year))
            throw new InvalidYearAfterCalculationException();
        return this;
    }

    public MyDate previousYear() throws InvalidYearAfterCalculationException {
        if (month == Month.Feb && day == 29 && !DateUtils.isLeapYear(year - 1)) {
            day = 28;
        }
        year--;
        if (!DateUtils.isValidYear(year))
            throw new InvalidYearAfterCalculationException();
        return this;
    }

    public boolean isBefore(MyDate date) {
        if (this.year < date.year) {
            return true;
        } else if (this.year > date.year) {
            return false;
        } else {
            if (this.month.ordinal() < date.month.ordinal()) {
                return true;
            } else if (this.month.ordinal() > date.month.ordinal()) {
                return false;
            } else {
                return this.day < date.day;
            }
        }
    }

    public boolean isAfter(MyDate date) {
        if (this.year > date.year) {
            return true;
        } else if (this.year < date.year) {
            return false;
        } else {
            if (this.month.ordinal() > date.month.ordinal()) {
                return true;
            } else if (this.month.ordinal() < date.month.ordinal()) {
                return false;
            } else {
                return this.day > date.day;
            }
        }
    }

}
