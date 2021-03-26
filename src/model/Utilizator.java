package model;

public class Utilizator extends Object{
    private long id_User;
    private String username;
    private String password;
    private String lastName;
    private String firstName;
    private String address;

    public Utilizator() {

    }

    public Utilizator(long id, String uName, String pW, String laNa, String fiNa, String address) {
        this.id_User = id;
        this.username=uName;
        this.password=pW;
        this.lastName=laNa;
        this.firstName=fiNa;
        this.address=address;
    }

    public long getId() {
        return id_User;
    }

    public void setId(long id) {
        this.id_User = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }


    @Override //annotation
    public String toString() {
        return id_User + " / " + username + " / " + password + " / " + lastName + " / "+ firstName + " / " + address;
    }

}
