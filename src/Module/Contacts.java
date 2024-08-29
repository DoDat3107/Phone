package Module;

public class Contacts {
    private int id;
    private String phoneNumber;
    private String groundName;
    private String name;
    private String gender;
    private String address;
    private String date;
    private String gmail;
    private static int nextID = 1;

    public Contacts(String phoneNumber, String groundName, String name, String gender, String address, String date, String gmail) {
        this.id = nextID++;
        this.phoneNumber = phoneNumber;
        this.groundName = groundName;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.date = date;
        this.gmail = gmail;
    }

    public Contacts(int id, String phoneNumber, String groundName, String name, String gender, String address, String date, String gmail) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.groundName = groundName;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.date = date;
        this.gmail = gmail;
    }

    // Getters and Setters
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getGroundName() { return groundName; }
    public void setGroundName(String groundName) { this.groundName = groundName; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getGmail() { return gmail; }
    public void setGmail(String gmail) { this.gmail = gmail; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @Override
    public String toString() {
        return "Contacts{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", groundName='" + groundName + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", date='" + date + '\'' +
                ", gmail='" + gmail + '\'' +
                '}';
    }
}
