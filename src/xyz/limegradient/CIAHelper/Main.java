package xyz.limegradient.CIAHelper;

import jcifs.smb.*;
import xyz.limegradient.CIAHelper.GUI.GUI;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

// 3DS IP: 174.59.220.144

public class Main {
    static GUI gui;
    public static void main(String[] args) throws IOException {
        gui = new GUI();
        gui.OpenGUI();
    }
}