package esiea.com.polind;

public class User {
    private int id;
    private String Email;
    private String Password;

    public User(){

    }

    public User(String email, String password){
        this.Email = email;
        this.Password = password;
    }


    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
