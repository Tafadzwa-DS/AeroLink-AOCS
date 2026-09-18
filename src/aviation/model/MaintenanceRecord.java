package aviation.model;

public class MaintenanceRecord {

    private String recordId;
    private Aircraft aircraft;
    private String maintenanceDate;
    private String description;
    private double cost;

    public MaintenanceRecord(String recordId, Aircraft aircraft, String maintenanceDate, String description, double cost) {

        this.recordId = recordId;
        this.aircraft = aircraft;
        this.maintenanceDate = maintenanceDate;
        this.description = description;
        this.cost = cost;
    }

    public String getRecordId() {
        return recordId;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public String getMaintenanceDate() {
        return maintenanceDate;
    }

    public String Description() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public void setMaintenanceDate(String maintenanceDate) {
        this.maintenanceDate = maintenanceDate; 
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override 
    public String toString() {
        return "MaintenanceRecord{" + 
                "recordId=" + recordId +
                ",aircraft=" + aircraft + 
                ",maintenanceDate=" + 
            maintenanceDate +
                ",description=" + description +
                ",cost=" + cost +
                '}';
    }
}