package mice.bean;

public class Address {
    private int id;
    private String name;
    private String address;
    private String phone;

    public String getPhone() {
        return this.phone;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phone = phone;
    }

    int userId;

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}