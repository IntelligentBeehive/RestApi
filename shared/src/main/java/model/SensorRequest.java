package model;

public class SensorRequest {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public SensorRequest() {}

    public SensorRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
