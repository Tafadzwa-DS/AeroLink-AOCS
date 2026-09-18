package aviation.model;

public class Airport {

    private String airportCode;
    private String airportName;
    private String city;
    private String country;

    public Airport(String airportCode, String airportName, String city, String country) {
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.city = city;
        this.country = country;
    
    }

    public String getAirportCode() {
        return airportCode;
    }
     public String getAirportName() {
        return airportName;
     }

     public String getCity() {
        return city;
     }

     public String getCountry() {
        return country;
     }


     public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
     }

     public void setAirportName(String airportName) {
        this.airportName = airportName;
     }

     public void setCity(String city) {
        this.city = city;
     }

     public void setCountry(String country) {
        this.country = country;
     }


    @Override
public String toString() {
    return "Airport{" +
            "airportCode='" + airportCode + '\'' +
            ", airportName='" + airportName + '\'' +
            ", city='" + city + '\'' +
            ", country='" + country + '\'' +
            '}';
}

}