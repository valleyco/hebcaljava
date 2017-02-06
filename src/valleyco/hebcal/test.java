package valleyco.hebcal;


import valleyco.hebcal.CalendarTime;
import valleyco.hebcal.AstronomicalCalculations;
import valleyco.hebcal.Location;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 */
public class test {

    public static void main(String[] args) {
        CalendarTime t;
        Location loc;
        loc = new Location("Pforzheim", 4854, 842, 1, 263);
        System.out.println("Pforzheim, 20/11/2005...");
        t = AstronomicalCalculations.GetSunrise(11, 20, 2005, loc);
        System.out.println("Sunrise: " + t.formatTime24() + ", " + t.formatTime12());
        t = AstronomicalCalculations.GetSunset(11, 20, 2005, loc);
        System.out.println("Sunset: " + t.formatTime24());
        t.addMinutes(45);
        System.out.println("Sunset + 45 minutes: " + t.formatTime24());
        t = AstronomicalCalculations.GetSunset(11, 20, 2005, loc);
        t.subtractMinutes(18);
        System.out.println("Sunset - 18 minutes: " + t.formatTime24());
        t = AstronomicalCalculations.GetSunriseDegreesBelowHorizon(11, 20, 2005, 11, loc);
        System.out.println("Sunrise - 11° below horizon: " + t.formatTime24());
        t = AstronomicalCalculations.GetSunsetDegreesBelowHorizon(11, 20, 2005, 8.75, loc);
        System.out.println("Sunset + 8.75° below horizon: " + t.formatTime24());
        CalendarTime sunr = AstronomicalCalculations.GetSunrise(11, 20, 2005, loc);
        CalendarTime suns = AstronomicalCalculations.GetSunset(11, 20, 2005, loc);
        t = AstronomicalCalculations.GetProportionalHours(3, sunr, suns);
        System.out.println("Proportional hour (3): " + t.formatTime24());
        int shaaZmanit = AstronomicalCalculations.GetShaaZmanit(sunr, suns);
        System.out.println("Sha'a Zmanit: " + CalendarTime.formatTimeShaaZmanit(shaaZmanit));
    }
}
