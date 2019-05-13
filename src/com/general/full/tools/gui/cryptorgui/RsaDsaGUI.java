package com.general.full.tools.gui.cryptorgui;

import com.general.full.tools.cryptor.asymmetric.RsaAsy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.KeyPair;
import java.security.PrivateKey;

public class RsaDsaGUI extends JPanel {
    public RsaDsaGUI()
    {
        this.setLayout(null);
        JTextArea jTextArea1 = new JTextArea("公钥");
        jTextArea1.setBounds(50, 20, 250, 200);
        jTextArea1.setBackground(new Color(247, 246, 245));
        jTextArea1.setLineWrap(true);
        JTextArea jTextArea2 = new JTextArea("私钥");
        jTextArea2.setBounds(520, 20, 250, 200);
        jTextArea2.setBackground(new Color(247, 246, 245));
        jTextArea2.setLineWrap(true);
        JLabel jLabel1 = new JLabel("选择输出的密钥对编码方式:");
        jLabel1.setBounds(330, 20, 200, 30);
        JComboBox jComboBox1 = new JComboBox();
        jComboBox1.addItem("base64编码");
        jComboBox1.addItem("hex编码");
        jComboBox1.setBounds(330, 50, 100, 25);
        JLabel jLabel2 = new JLabel("选择加解密方式:");
        jLabel2.setBounds(330, 80, 200, 30);
        JComboBox jComboBox2 = new JComboBox();
        jComboBox2.addItem("RSA加解密");
        jComboBox2.addItem("DSA加解密");
        jComboBox2.setBounds(330, 110, 100, 25);
        JButton jButton=new JButton("生成密钥对");
        jButton.setBounds(330,150,100,30);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KeyPair keyPair = null;
                try {
                    keyPair = RsaAsy.getKeyPair();
                    jTextArea1.setText(RsaAsy.getPublicKey(keyPair));
                    jTextArea2.setText(RsaAsy.getPrivateKey(keyPair));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        //---------------------------------------------------------
        JTextArea jTextArea3 = new JTextArea("待加密数据");
        jTextArea3.setBounds(50, 250, 250, 200);
        jTextArea3.setBackground(new Color(247, 246, 245));
        jTextArea3.setLineWrap(true);
        JTextArea jTextArea4 = new JTextArea("待解密数据");
        jTextArea4.setBounds(520, 250, 250, 200);
        jTextArea4.setBackground(new Color(247, 246, 245));
        jTextArea4.setLineWrap(true);
        JButton jButton1=new JButton("加密");
        jButton1.setBounds(330,250,100,30);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    byte[] publicEncript = RsaAsy.publicEncrypt(jTextArea3.getText().getBytes(), RsaAsy.string2PublicKey(jTextArea1.getText()));
                    jTextArea4.setText(RsaAsy.byte2Base64(publicEncript));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        JButton jButton2=new JButton("解密");
        jButton2.setBounds(330,300,100,30);
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PrivateKey privateKey = RsaAsy.string2PrivateKey(jTextArea2.getText());
                    byte[] base642Byte = RsaAsy.base642Byte(jTextArea4.getText());
                    byte[] privateDecrypt = RsaAsy.privateDecrypt(base642Byte, privateKey);
                    jTextArea3.setText(new String(privateDecrypt));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        JLabel jLabel0=new JLabel("说明：功能仅实现RSA的base64编码非对称加解密；注意：首先获取密钥对，后进行加解密");
        jLabel0.setBounds(50,500,1000,30);
        this.add(jTextArea1);
        this.add(jTextArea2);
        this.add(jLabel1);
        this.add(jComboBox1);
        this.add(jLabel2);
        this.add(jComboBox2);
        this.add(jButton);
        this.add(jTextArea3);
        this.add(jButton1);
        this.add(jButton2);
        this.add(jTextArea4);
        this.add(jLabel0);

    }
}
