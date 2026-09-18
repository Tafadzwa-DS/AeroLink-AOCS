package aviation.model;

public class Passenger {

    private String passengerId;
    private String name;
    private String phone;
    private String password;
    private String email;

public Passenger(String passengerId, String name,String phone, String password, String email) {

        this.passengerId = passengerId;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.email = email;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setPassengerId(String PassengerId) {
        this.passengerId  = passengerId;
    }

    public void setName(String Name) {
        this.name = name;
    }

    public void setPhone(String Phone) {
        this.phone = phone;
    }

    public void setPassword(String Password) {
        this.password = password;
    }

    public void setEmail(String Email) {
        this.email = email;
    }

    @Override 
    public String toString() {
        return "Passenger{" + 
                "passengerId=" + passengerId +
                ",name=" + name +
                ",phone=" + phone + 
                ", email=" + email +
                '}';
    }
}

