package aviation.model; 

public class Aircraft {

     private String aircraftId;
     private String registrationId;
     private String model;
     private AircraftStatus status;
     private double range;
 
public Aircraft(String aircraftId, String registrationId, String model, AircraftStatus status, double range)
{
    this.aircraftId = aircraftId;
    this.registrationId = registrationId;
    this.model = model;
    this.status = status;
    this.range = range;
    }


public String getAircraftId() {
    return aircraftId;
}

public String getRegistrationId() {
    return registrationId;
}

public String getModel() {
    return model;
}

public AircraftStatus getStatus() {
    return status;
}

public double getRange() {
    return range;
}

 
public void setAircraftId(String aircraftId) {
    this.aircraftId = aircraftId;
}

public void setRegistrationId(String registrationId) {
    this.registrationId = registrationId;
}

public void setModel(String model) {
    this.model = model;
}

public void setStatus(AircraftStatus status) {
    this.status = status;
}

public void setRange(double range) {
    this.range = range;
}

@Override 
public String toString() {
    return "Aircraft{" +
             "aircraftId='" + aircraftId + '\'' +
             ",registrationId='" + registrationId + '\'' +
             ",model='" + model + '\'' +
             ",status=" + status + 
             ",range=" + range + 
             '}';

}

}

