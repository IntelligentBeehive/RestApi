package server;

public class Player {
    private String url;
    private int id;
    private String name;
    private String password;

    public Player() { } // Default to allow JSON Type convert

    public Player(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public void setUrl(String url){
        this.url = url+"player/"+this.id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return String.format("Name: %s Url: %s", name, url);
    }
}
