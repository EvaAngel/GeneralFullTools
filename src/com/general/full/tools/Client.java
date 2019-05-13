package com.general.full.tools;

import com.general.full.tools.gui.TotalGui;

import javax.swing.*;

public class Client {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            new TotalGui().totalGui();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
