package models.wath;

public interface WatchType {
    WatchType ANALOG =() ->"Analog";
    WatchType DIGITAL_WATCH =() ->"Digital_Watch";
    WatchType AUTOMATIC =() ->"Automatic";
    WatchType CHRONOGRAPH =() ->"Chronograph";
    WatchType DIVING =() ->"Diving";
    WatchType DRESS =() ->"Dress";
    WatchType QUARTZ =() ->"Quartz";
    WatchType MECHANICAL =() ->"Mechanical";
    WatchType PILOT =() ->"Pilot";
    WatchType FIELD =() ->"Field";
    WatchType SMART =() ->"Smart";
    WatchType LUXURY =() ->"Luxury";

        String daysForType();
}
