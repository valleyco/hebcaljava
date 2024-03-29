
/**
 *
 * Source code Copyright © by Ulrich and David Greve (2005)
 * The code is freely usable for non-profit purposes when this Copyright notice is included.
 */
package valleyco.hebcal;
public class CalendarTime {

    CalendarTime(int hour, int min) {
        this.hour = hour;
        this.min = min;
    }

    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public String formatTime12() {
        int hourModulo12 = hour % 12;
        if (hourModulo12 == 0) {
            hourModulo12 = 12;
        }

        String ampm;
        if (hour >= 12) {
            ampm = "PM";
        } else {
            ampm = "AM";
        }

        String hourStr, minStr;
        if (hourModulo12 < 10) {
            hourStr = "0" + Integer.toString(hourModulo12);
        } else {
            hourStr = Integer.toString(hourModulo12);
        }
        if (min < 10) {
            minStr = "0" + Integer.toString(min);
        } else {
            minStr = Integer.toString(min);
        }
        return hourStr + ":" + minStr + ampm;
    }

    public String formatTime24() {
        String hourStr, minStr;
        if (hour < 10) {
            hourStr = "0" + Integer.toString(hour);
        } else {
            hourStr = Integer.toString(hour);
        }
        if (min < 10) {
            minStr = "0" + Integer.toString(min);
        } else {
            minStr = Integer.toString(min);
        }
        return hourStr + ":" + minStr;
    }

    public static String formatTimeShaaZmanit(int value) {
        int hour = (int) (value / 60);
        int min = value % 60;
        String hourStr, minStr;
        if (hour < 10) {
            hourStr = "0" + Integer.toString(hour);
        } else {
            hourStr = Integer.toString(hour);
        }
        if (min < 10) {
            minStr = "0" + Integer.toString(min);
        } else {
            minStr = Integer.toString(min);
        }
        return hourStr + ":" + minStr;
    }

    public void addMinutes(int min) {
        this.min += min;
        while (this.min >= 60) {
            this.min -= 60;
            this.hour += 1;
        }
    }

    public void subtractMinutes(int min) {
        this.min -= min;
        while (this.min < 0) {
            this.min += 60;
            this.hour -= 1;
        }
    }

    private int hour, min;
}
