package aviation.model;

public class Pilot {

    private String pilotId;
    private String name;
    private String licenceNumber;
    private String rank;

    public Pilot(String pilotId, String name, String licenceNumber, String rank) {
         this.pilotId = pilotId;
         this.name = name;
         this.licenceNumber = licenceNumber;
         this.rank = rank;
    }

    public String getPilotId() {
        return pilotId;
    }

    public String getName() {
        return name;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public String getrank() {
        return rank;
    }

    public void setPilotId( String PilotId) {
        this.pilotId = pilotId;
    }

    public void setName(String Name) {
        this.name = name;
    }

    public void setLicenceNumber(String LicenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public void setRank(String Rank) {
        this.rank = rank;
    }

    @Override public String toString() {
        return "Pilot{" +
                "pilotId=" + pilotId +
                ",name=" + name +
                ",licenceNumber=" + licenceNumber +
                ",rank=" + rank +
                '}';
    }
}
