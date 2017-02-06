/**
 *
 * Source code Copyright © by Ulrich and David Greve (2005)
 * The code is freely usable for non-profit purposes when this Copyright notice is included.
 */
package valleyco.hebcal;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Holydays {

    private static int getWeekdayOfHebrewDate(int hebDay, int hebMonth, int hebYear) {
        int absDate = CalendarImpl.absoluteFromJewishDate(new CalendarDate(hebDay, hebMonth, hebYear));
        return absDate % 7;
    }

    public static ArrayList getHolidayForDate(CalendarDate gdate, boolean diaspora) {
        int absDate = CalendarImpl.absoluteFromGregorianDate(gdate);
        CalendarDate jewishDate = CalendarImpl.jewishDateFromAbsolute(absDate);
        int hebDay = jewishDate.getDay();
        int hebMonth = jewishDate.getMonth();
        int hebYear = jewishDate.getYear();

        ArrayList listHolidays = new ArrayList();

        // Holidays in Nisan
        int hagadolDay = 14;
        while (getWeekdayOfHebrewDate(hagadolDay, 1, hebYear) != 6) {
            hagadolDay -= 1;
        }
        if (hebDay == hagadolDay && hebMonth == 1) {
            listHolidays.add("Shabat Hagadol");
        }

        if (hebDay == 14 && hebMonth == 1) {
            listHolidays.add("Erev Pesach");
        }
        if (hebDay == 15 && hebMonth == 1) {
            listHolidays.add("Pesach I");
        }
        if (hebDay == 16 && hebMonth == 1) {
            if (diaspora) {
                listHolidays.add("Pesach II");
            } else {
                listHolidays.add("Chol Hamoed");
            }
        }
        if (hebDay == 17 && hebMonth == 1) {
            listHolidays.add("Chol Hamoed");
        }
        if (hebDay == 18 && hebMonth == 1) {
            listHolidays.add("Chol Hamoed");
        }
        if (hebDay == 19 && hebMonth == 1) {
            listHolidays.add("Chol Hamoed");
        }
        if (hebDay == 20 && hebMonth == 1) {
            listHolidays.add("Chol Hamoed");
        }
        if (hebDay == 21 && hebMonth == 1) {
            if (!diaspora) {
                listHolidays.add("Pesach VII (Yizkor)");
            } else {
                listHolidays.add("Pesach VII");
            }
        }
        if (hebDay == 22 && hebMonth == 1) {
            if (diaspora) {
                listHolidays.add("Pesach VIII (Yizkor)");
            }
        }

        // Yom Hashoah
        if (getWeekdayOfHebrewDate(27, 1, hebYear) == 5) {
            if (hebDay == 26 && hebMonth == 1) {
                listHolidays.add("Yom Hashoah");
            }
        } else if (hebYear >= 5757 && getWeekdayOfHebrewDate(27, 1, hebYear) == 0) {
            if (hebDay == 28 && hebMonth == 1) {
                listHolidays.add("Yom Hashoah");
            }
        } else {
            if (hebDay == 27 && hebMonth == 1) {
                listHolidays.add("Yom Hashoah");
            }
        }

        // Holidays in Iyar
        // Yom Hazikaron
        if (getWeekdayOfHebrewDate(4, 2, hebYear) == 5) { // If 4th of Iyar is a Thursday ...
            if (hebDay == 2 && hebMonth == 2) // ... then Yom Hazicaron is on 2th of Iyar
            {
                listHolidays.add("Yom Hazikaron");
            }
        } else if (getWeekdayOfHebrewDate(4, 2, hebYear) == 4) {
            if (hebDay == 3 && hebMonth == 2) {
                listHolidays.add("Yom Hazikaron");
            }
        } else if (hebYear >= 5764 && getWeekdayOfHebrewDate(4, 2, hebYear) == 0) {
            if (hebDay == 5 && hebMonth == 2) {
                listHolidays.add("Yom Hazikaron");
            }
        } else {
            if (hebDay == 4 && hebMonth == 2) {
                listHolidays.add("Yom Hazikaron");
            }
        }

        // Yom Ha'Azmaut
        if (getWeekdayOfHebrewDate(5, 2, hebYear) == 6) {
            if (hebDay == 3 && hebMonth == 2) {
                listHolidays.add("Yom Ha'Atzmaut");
            }
        } else if (getWeekdayOfHebrewDate(5, 2, hebYear) == 5) {
            if (hebDay == 4 && hebMonth == 2) {
                listHolidays.add("Yom Ha'Atzmaut");
            }
        } else if (hebYear >= 5764 && getWeekdayOfHebrewDate(4, 2, hebYear) == 0) {
            if (hebDay == 6 && hebMonth == 2) {
                listHolidays.add("Yom Ha'Atzmaut");
            }
        } else {
            if (hebDay == 5 && hebMonth == 2) {
                listHolidays.add("Yom Ha'Atzmaut");
            }
        }
        if (hebDay == 14 && hebMonth == 2) {
            listHolidays.add("Pesach Sheni");
        }
        if (hebDay == 18 && hebMonth == 2) {
            listHolidays.add("Lag BaOmer");
        }
        if (hebDay == 28 && hebMonth == 2) {
            listHolidays.add("Yom Yerushalayim");
        }

        // Holidays in Sivan
        if (hebDay == 5 && hebMonth == 3) {
            listHolidays.add("Erev Shavuot");
        }
        if (hebDay == 6 && hebMonth == 3) {
            if (diaspora) {
                listHolidays.add("Shavuot I");
            } else {
                listHolidays.add("Shavuot (Yizkor)");
            }
        }
        if (hebDay == 7 && hebMonth == 3) {
            if (diaspora) {
                listHolidays.add("Shavuot II (Yizkor)");
            }
        }

        // Holidays in Tammuz
        if (getWeekdayOfHebrewDate(17, 4, hebYear) == 6) {
            if (hebDay == 18 && hebMonth == 4) {
                listHolidays.add("Fast of Tammuz");
            }
        } else {
            if (hebDay == 17 && hebMonth == 4) {
                listHolidays.add("Fast of Tammuz");
            }
        }

        // Holidays in Av
        if (getWeekdayOfHebrewDate(9, 5, hebYear) == 6) {
            if (hebDay == 10 && hebMonth == 5) {
                listHolidays.add("Fast of Av");
            }
        } else {
            if (hebDay == 9 && hebMonth == 5) {
                listHolidays.add("Fast of Av");
            }
        }
        if (hebDay == 15 && hebMonth == 5) {
            listHolidays.add("Tu B'Av");
        }

        // Holidays in Elul
        if (hebDay == 29 && hebMonth == 6) {
            listHolidays.add("Erev Rosh Hashana");
        }

        // Holidays in Tishri
        if (hebDay == 1 && hebMonth == 7) {
            listHolidays.add("Rosh Hashana I");
        }
        if (hebDay == 2 && hebMonth == 7) {
            listHolidays.add("Rosh Hashana II");
        }
        if (getWeekdayOfHebrewDate(3, 7, hebYear) == 6) {
            if (hebDay == 4 && hebMonth == 7) {
                listHolidays.add("Tzom Gedaliah");
            }
        } else {
            if (hebDay == 3 && hebMonth == 7) {
                listHolidays.add("Tzom Gedaliah");
            }
        }
        if (hebDay == 9 && hebMonth == 7) {
            listHolidays.add("Erev Yom Kippur");
        }
        if (hebDay == 10 && hebMonth == 7) {
            listHolidays.add("Yom Kippur (Yizkor)");
        }
        if (hebDay == 14 && hebMonth == 7) {
            listHolidays.add("Erev Sukkot");
        }
        if (hebDay == 15 && hebMonth == 7) {
            if (diaspora) {
                listHolidays.add("Sukkot I");
            } else {
                listHolidays.add("Sukkot");
            }
        }
        if (hebDay == 16 && hebMonth == 7) {
            if (diaspora) {
                listHolidays.add("Sukkot II");
            } else {
                listHolidays.add("Chol Hamoed");
            }
        }
        if (hebDay == 17 && hebMonth == 7) {
            listHolidays.add("Chol Hamoed");
        }
        if (hebDay == 18 && hebMonth == 7) {
            listHolidays.add("Chol Hamoed");
        }
        if (hebDay == 19 && hebMonth == 7) {
            listHolidays.add("Chol Hamoed");
        }
        if (hebDay == 20 && hebMonth == 7) {
            listHolidays.add("Chol Hamoed");
        }
        if (hebDay == 21 && hebMonth == 7) {
            listHolidays.add("Hoshana Raba");
        }
        if (hebDay == 22 && hebMonth == 7) {
            if (!diaspora) {
                listHolidays.add("Shemini Atzereth (Yizkor)");
                listHolidays.add("Simchat Torah");
            } else {
                listHolidays.add("Shemini Atzereth (Yizkor)");
            }
        }
        if (hebDay == 23 && hebMonth == 7) {
            if (diaspora) {
                listHolidays.add("Simchat Torah");
            }
        }

        // Holidays in Kislev
        if (hebDay == 25 && hebMonth == 9) {
            listHolidays.add("Chanukka I");
        }
        if (hebDay == 26 && hebMonth == 9) {
            listHolidays.add("Chanukka II");
        }
        if (hebDay == 27 && hebMonth == 9) {
            listHolidays.add("Chanukka III");
        }
        if (hebDay == 28 && hebMonth == 9) {
            listHolidays.add("Chanukka IV");
        }
        if (hebDay == 29 && hebMonth == 9) {
            listHolidays.add("Chanukka V");
        }

        // Holidays in Tevet
        if (hebDay == 10 && hebMonth == 10) {
            listHolidays.add("Fast of Tevet");
        }

        if (CalendarImpl.getLastDayOfJewishMonth(9, hebYear) == 30) {
            if (hebDay == 30 && hebMonth == 9) {
                listHolidays.add("Chanukka VI");
            }
            if (hebDay == 1 && hebMonth == 10) {
                listHolidays.add("Chanukka VII");
            }
            if (hebDay == 2 && hebMonth == 10) {
                listHolidays.add("Chanukka VIII");
            }
        }
        if (CalendarImpl.getLastDayOfJewishMonth(9, hebYear) == 29) {
            if (hebDay == 1 && hebMonth == 10) {
                listHolidays.add("Chanukka VI");
            }
            if (hebDay == 2 && hebMonth == 10) {
                listHolidays.add("Chanukka VII");
            }
            if (hebDay == 3 && hebMonth == 10) {
                listHolidays.add("Chanukka VIII");
            }
        }

        // Holidays in Shevat
        if (hebDay == 15 && hebMonth == 11) {
            listHolidays.add("Tu B'Shevat");
        }

        // Holidays in Adar (I)/Adar II
        int monthEsther;
        if (CalendarImpl.hebrewLeapYear(hebYear)) {
            monthEsther = 13;
        } else {
            monthEsther = 12;
        }

        if (getWeekdayOfHebrewDate(13, monthEsther, hebYear) == 6) {
            if (hebDay == 11 && hebMonth == monthEsther) {
                listHolidays.add("Fast of Esther");
            }
        } else {
            if (hebDay == 13 && hebMonth == monthEsther) {
                listHolidays.add("Fast of Esther");
            }
        }

        if (hebDay == 14 && hebMonth == monthEsther) {
            listHolidays.add("Purim");
        }
        if (hebDay == 15 && hebMonth == monthEsther) {
            listHolidays.add("Shushan Purim");
        }

        if (CalendarImpl.hebrewLeapYear(hebYear)) {
            if (hebDay == 14 && hebMonth == 12) {
                listHolidays.add("Purim Katan");
            }
            if (hebDay == 15 && hebMonth == 12) {
                listHolidays.add("Shushan Purim Katan");
            }
        }
        return listHolidays;
    }
}
