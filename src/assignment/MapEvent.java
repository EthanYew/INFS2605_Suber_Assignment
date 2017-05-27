/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import com.lynden.gmapsfx.javascript.object.GoogleMap;
import javafx.event.Event;

/**
 *
 * @author EthanYew
 */
public class MapEvent extends Event {

    public MapEvent(GoogleMap map, double lat, double lng) {
        super(map, Event.NULL_SOURCE_TARGET, Event.ANY); //before there was 'qa' at the end of this line, before semicolon, dunno what it did but it gave an error so got rid of it
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLng() {
        return this.lng;
    }

    private double lat;
    private double lng;
}