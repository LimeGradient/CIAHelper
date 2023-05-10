package xyz.limegradient.CIAHelper.Net;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import jcifs.smb.SmbFileOutputStream;
import xyz.limegradient.CIAHelper.GUI.GUI;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

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
        String path = String.format("smb://%s/microSD/", name);
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(String.format("%s:%s", user, pass));
        SmbFile smb = new SmbFile(path, auth);
        for (SmbFile f : smb.listFiles()) {
            System.out.println(f.getName());
        }
        GUI gui = new GUI();
        gui.ChangeFrameTitle(String.format("Connected to %s", name));
        gui._dsName.setText(name);
        gui._dsIp.setText(dsIp);
        gui.f.repaint();
        gui.f.revalidate();

    }
}

/*
        SmbFile file = new SmbFile("smb://3ds-1674/microSD/test.txt", auth);
        SmbFileInputStream is = new SmbFileInputStream(file);
        String deocde = new String(is.readAllBytes(), StandardCharsets.UTF_8);
        System.out.println(deocde);
 */
