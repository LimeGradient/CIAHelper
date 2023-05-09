package xyz.limegradient.CIAHelper.Net;

public class DSConnection {
    public String name;
    public String user;
    public String pass;
    public DSConnection(String name, String user, String pass) {
        this.name = name;
        this.user = user;
        this.pass = pass;
        ConnectToDS(name, user, pass);
    }

    public void ConnectToDS(String name, String user, String pass) {
        System.out.println(String.format("3DS Name: %s - User: %s - Pass: %s", name, user, pass));
        
    }
}
