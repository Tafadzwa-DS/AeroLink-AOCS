package aviation.model;

public class Crew {

    private String crewId;
    private String name;
    private String role;

    public Crew(String crewId, String name, String role) {
        this.crewId = crewId;
        this.name = name;
        this.role = role;
    }

    public String getCrewId() {
        return crewId;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public void setCrewId(String Crew) {
        this.crewId = crewId;
    }

    public void setName(String Name) {
        this.name = name;
    }

    public void setRole(String Name) {
        this.role = role;
    }

    @Override 
    public String toString() {
        return "Crew{" + 
                "crewId=" + crewId + 
                "name=" + name +
                "role=" + role +
                '}';
    }
}