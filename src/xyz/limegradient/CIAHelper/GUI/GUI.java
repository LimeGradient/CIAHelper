package xyz.limegradient.CIAHelper.GUI;

import xyz.limegradient.CIAHelper.Net.DSConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUI {

    public static JFrame f;

    public JLabel _dsName = new JLabel();
    public JLabel _dsIp = new JLabel();
    public GUI() {

    }
    public void OpenGUI() {
        JFrame frame = new JFrame("CIAHelper by LimeGradient : No Connection ");
        SetFrame(frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        JTextField dsName = new JTextField("3DS Name");
        JTextField user = new JTextField("Username");
        JTextField pass = new JTextField("Password");
        JButton connect = new JButton("Connect to 3DS");
        connect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DSConnection dsConn = new DSConnection(dsName.getText(), user.getText(), pass.getText());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        frame.setLayout(grid);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        Container pane = frame.getContentPane();
        pane.setLayout(grid);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        pane.add(dsName, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(50,0,0,0);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        pane.add(user, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(100,0,0,0);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        pane.add(pass, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(150,0,0,0);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        pane.add(connect, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        pane.add(_dsName, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(25,0,0,0);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        pane.add(_dsIp, gbc);

        frame.setVisible(true);
    }

    public void SetFrame(JFrame fr) {
        this.f = fr;
    }

    public void ChangeFrameTitle(String title) {
        f.setTitle(String.format("CIAHelper by LimeGradient : %s", title));
    }

}
