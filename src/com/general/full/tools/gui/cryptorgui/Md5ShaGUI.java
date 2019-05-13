package com.general.full.tools.gui.cryptorgui;

import com.general.full.tools.coding.AsciiCoding;
import com.general.full.tools.cryptor.hash.MD5;
import com.general.full.tools.cryptor.hash.Sha1;
import com.general.full.tools.cryptor.hash.Sha256;
import com.general.full.tools.cryptor.hash.Sha512;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Md5ShaGUI extends JPanel {
    public Md5ShaGUI()
    {
        this.setLayout(null);
        JTextArea textArea1=new JTextArea("请输入待编码数据");
        textArea1.setBounds(50,50,250,250);
        textArea1.setBackground(new Color(247, 246, 245));
        JTextArea textArea2=new JTextArea("请输入待解码数据");
        textArea1.setLineWrap(true);
        textArea2.setBounds(500,50,250,250);
        textArea2.setBackground(new Color(247, 246, 245));
        textArea2.setLineWrap(true);
        JLabel jLabel1 = new JLabel("加密模式:");
        jLabel1.setBounds(320, 100, 60, 30);
        JComboBox jComboBox1 = new JComboBox();
        jComboBox1.addItem("MD5");
        jComboBox1.addItem("SHA1");
        jComboBox1.addItem("SHA256");
        jComboBox1.addItem("SHA512");
        jComboBox1.setBounds(380, 104, 100, 25);
        JButton jButton1=new JButton("加密");
        jButton1.setBounds(350,200,100,30);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String way=(String)jComboBox1.getSelectedItem();
                String string=textArea1.getText();
                switch (way){
                    case "MD5":
                        textArea2.setText(MD5.md5(string));
                        break;
                    case "SHA1":
                        textArea2.setText(Sha1.SHA1(string));
                        break;
                    case "SHA256":
                        textArea2.setText(Sha256.SHA256(string));
                        break;
                    case "SHA512":
                        textArea2.setText(Sha512.SHA512(string));
                        break;
                }
            }
        });
        this.add(textArea1);
        this.add(jButton1);
        this.add(textArea2);
        this.add(jLabel1);
        this.add(jComboBox1);

    }
}
