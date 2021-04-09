package model;

public class User{
    private long idUser;
    private String username;
    private String password;
    private String lastName;
    private String firstName;
    private String address;

    public User() {

    }

    public User(long id, String uName, String pW, String laNa, String fiNa, String address) {
        this.idUser = id;
        this.username=uName;
        this.password=pW;
        this.lastName=laNa;
        this.firstName=fiNa;
        this.address=address;
    }

    public long getId() {
        return idUser;
    }

    public void setId(long id) {
        this.idUser = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }


    @Override //annotation
    public String toString() {
        return idUser + " / " + username + " / " + password + " / " + lastName + " / "+ firstName + " / " + address;
    }

}
