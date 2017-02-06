/**
 *
 * Source code Copyright © by Ulrich and David Greve (2005)
 * The code is freely usable for non-profit purposes when this Copyright notice is included.
 */
package valleyco.hebcal;

public class Location {

    Location() {
        name = "";
        latitude = longitude = timeZone = elevation = 0;
    }

    Location(String name, int latitude, int longitude, int timeZone, int elevation) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timeZone = timeZone;
        this.elevation = elevation;
    }

    public String getName() {
        return name;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getTimeZone() {
        return timeZone;
    }

    public int getElevation() {
        return elevation;
    }

    public Location setName(String name) {
        this.name = name;
        return this;
    }

    public Location setLatitude(int latitude) {
        this.latitude = latitude;
        return this;
    }

    public Location setLongitude(int longitude) {
        this.longitude = longitude;
        return this;
    }

    public Location setTimeZone(int timeZone) {
        this.timeZone = timeZone;
        return this;
    }

    public Location setElevation(int elevation) {
        this.elevation = elevation;
        return this;
    }

    private String name;
    private int latitude, longitude, timeZone, elevation;
}
