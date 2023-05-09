package xyz.limegradient.CIAHelper.GUI;

import xyz.limegradient.CIAHelper.Net.DSConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    public GUI() {
        OpenGUI();
    }
    public static void OpenGUI() {
        JFrame frame = new JFrame("CIAHelper by LimeGradient : No Connection ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        JTextField dsName = new JTextField("3DS Name"); dsName.setColumns(10);
        JTextField user = new JTextField("Name"); user.setColumns(10);
        JTextField pass = new JTextField("Password"); pass.setColumns(10);
        JButton connect = new JButton("Connect to 3DS");
        connect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DSConnection dsConn = new DSConnection(dsName.getText(), user.getText(), pass.getText());
            }
        });



        JPanel panel = new JPanel();
        panel.add(dsName);
        panel.add(user);
        panel.add(pass);
        panel.add(connect);

        frame.add(panel);
        frame.setVisible(true);
    }

}
