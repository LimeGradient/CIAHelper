package xyz.limegradient.CIAHelper.Net;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import xyz.limegradient.CIAHelper.GUI.GUI;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class DSConnection {
    public String name;
    public String user;
    public String pass;
    public String dsIp;
    public DSConnection(String name, String user, String pass) throws IOException {
        this.name = name;
        this.user = user;
        this.pass = pass;
        ConnectToDS();
    }

    public void ConnectToDS() throws IOException {
        System.out.println(String.format("3DS Name: %s - User: %s - Pass: %s - System: %s", name, user, pass, System.getProperty("os.name")));
        String path = String.format("smb://%s/microSD", name);
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("", user, pass);
        SmbFile smb = new SmbFile("smb://"+name+"/microSD", auth);
        if (smb.isDirectory()) {
            File file = new File("test.txt");
            FileInputStream is = new FileInputStream(file);
            System.out.println(is.read());
            is.close();
        }
        GUI gui = new GUI();
        gui.ChangeFrameTitle(String.format("Connected to %s", name));
        gui._dsName.setText(name);
        gui._dsIp.setText(dsIp);
        gui.f.repaint();
        gui.f.revalidate();

    }
}
