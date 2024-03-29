package com.general.full.tools.gui.cryptorgui;

import com.general.full.tools.cryptor.symmetric.AesSym;
import com.general.full.tools.cryptor.symmetric.Des3Sym;
import com.general.full.tools.cryptor.symmetric.DesSym;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AesDesGUI extends JPanel {
    public AesDesGUI() {
        this.setLayout(null);
        JTextArea jTextArea1 = new JTextArea("请输入待加密数据");
        jTextArea1.setBounds(50, 50, 250, 250);
        jTextArea1.setBackground(new Color(247, 246, 245));
        jTextArea1.setLineWrap(true);
        JScrollPane jsp1 = new JScrollPane(jTextArea1);
        jsp1.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JTextArea jTextArea2 = new JTextArea("请输入待解密数据");
        jTextArea2.setBounds(520, 50, 250, 250);
        jTextArea2.setBackground(new Color(247, 246, 245));
        jTextArea2.setLineWrap(true);
        JScrollPane jsp2 = new JScrollPane(jTextArea2);
        jsp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JLabel jLabel1 = new JLabel("算法:");
        jLabel1.setBounds(330, 50, 60, 30);
        JComboBox jComboBox1 = new JComboBox();
        jComboBox1.addItem("AES-128（常用）");
        jComboBox1.addItem("AES-192");
        jComboBox1.addItem("AES-256");
        jComboBox1.addItem("DES");
        jComboBox1.addItem("3DES");
        jComboBox1.setBounds(390, 50, 100, 25);
        JLabel jLabel2 = new JLabel("加密模式:");
        jLabel2.setBounds(330, 100, 60, 30);
        JComboBox jComboBox2 = new JComboBox();
        jComboBox2.addItem("CBC");
        jComboBox2.addItem("ECB");
        jComboBox2.addItem("CFB");
        jComboBox2.addItem("OFB");
        jComboBox2.addItem("PCBC");
        jComboBox2.setBounds(390, 100, 100, 25);
        JLabel jLabel3 = new JLabel("填充模式:");
        jLabel3.setBounds(330, 150, 60, 30);
        JComboBox jComboBox3 = new JComboBox();
        jComboBox3.addItem("NoPadding");
        jComboBox3.addItem("PKCS5Padding");
        jComboBox3.addItem("PKCS7Padding");
        jComboBox3.setBounds(390, 150, 100, 25);
        JLabel jLabel4 = new JLabel("明文编码:");
        jLabel4.setBounds(330, 200, 60, 30);
        JComboBox jComboBox4 = new JComboBox();
        jComboBox4.addItem("HEX");
        jComboBox4.addItem("Base64");
        jComboBox4.addItem("UTF-8");
        jComboBox4.addItem("GBK");
        jComboBox4.setBounds(390, 200, 100, 25);
        JLabel jLabel5 = new JLabel("密文编码:");
        jLabel5.setBounds(330, 250, 60, 30);
        JComboBox jComboBox5 = new JComboBox();
        jComboBox5.addItem("HEX");
        jComboBox5.addItem("Base64");
        jComboBox5.addItem("UTF-8");
        jComboBox5.addItem("GBK");
        jComboBox5.setBounds(390, 250, 100, 25);
        JLabel jLabel6 = new JLabel("KEY密钥:");
        jLabel6.setBounds(50, 320, 60, 30);
        JComboBox jComboBox6 = new JComboBox();
        jComboBox6.addItem("String");
        jComboBox6.addItem("Base64");
        jComboBox6.setBounds(110, 320, 80, 25);
        JTextField jTextFieldKey = new JTextField();
        jTextFieldKey.setBounds(210, 320, 200, 25);
        JLabel jLabel7 = new JLabel("IV偏移量:");
        jLabel7.setBounds(420, 320, 60, 30);
        JComboBox jComboBox7 = new JComboBox();
        jComboBox7.addItem("String");
        jComboBox7.addItem("Base64");
        jComboBox7.setBounds(480, 320, 80, 25);
        JTextField jTextFieldIv = new JTextField();
        jTextFieldIv.setBounds(580, 320, 200, 25);
        JButton jButton1 = new JButton("加密");
        jButton1.setBounds(300, 370, 100, 30);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch ((String) jComboBox1.getSelectedItem()) {
                    case "AES-128（常用）":
                        AesSym aesSym = new AesSym();
                        try {
                            String miwen = aesSym.encrypt(jTextArea1.getText(), (String) jComboBox6.getSelectedItem(), jTextFieldKey.getText(), (String) jComboBox7.getSelectedItem(), jTextFieldIv.getText(), (String) jComboBox2.getSelectedItem(), (String) jComboBox3.getSelectedItem(), (String) jComboBox5.getSelectedItem());
                            jTextArea2.setText(miwen);
                        } catch (NoSuchPaddingException e1) {
                            e1.printStackTrace();
                        } catch (NoSuchAlgorithmException e1) {
                            e1.printStackTrace();
                        } catch (InvalidAlgorithmParameterException e1) {
                            e1.printStackTrace();
                        } catch (InvalidKeyException e1) {
                            e1.printStackTrace();
                        } catch (BadPaddingException e1) {
                            e1.printStackTrace();
                        } catch (IllegalBlockSizeException e1) {
                            e1.printStackTrace();
                        }
                        break;
                    case "AES-192":
                        break;
                    case "AES-256":
                        break;
                    case "DES":
                        DesSym desSym = new DesSym();
                        String miwen = desSym.encrypt(jTextArea1.getText(), (String) jComboBox6.getSelectedItem(), jTextFieldKey.getText(), (String) jComboBox7.getSelectedItem(), jTextFieldIv.getText(), (String) jComboBox2.getSelectedItem(), (String) jComboBox3.getSelectedItem(), (String) jComboBox5.getSelectedItem());
                        jTextArea2.setText(miwen);
                        break;
                    case "3DES":
                        Des3Sym des3Sym = new Des3Sym();
                        String miwen3 = des3Sym.encrypt(jTextArea1.getText(), (String) jComboBox6.getSelectedItem(), jTextFieldKey.getText(), (String) jComboBox7.getSelectedItem(), jTextFieldIv.getText(), (String) jComboBox2.getSelectedItem(), (String) jComboBox3.getSelectedItem(), (String) jComboBox5.getSelectedItem());
                        jTextArea2.setText(miwen3);
                        break;

                }
            }
        });
        JButton jButton2 = new JButton("解密");
        jButton2.setBounds(400, 370, 100, 30);
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch ((String) jComboBox1.getSelectedItem()) {
                    case "AES-128（常用）":
                        AesSym aesSym = new AesSym();
                        try {
                            String mingwen = aesSym.decrypt(jTextArea2.getText(), (String) jComboBox6.getSelectedItem(), jTextFieldKey.getText(), (String) jComboBox6.getSelectedItem(), jTextFieldIv.getText(), (String) jComboBox2.getSelectedItem(), (String) jComboBox3.getSelectedItem(), (String) jComboBox5.getSelectedItem());
                            jTextArea1.setText(mingwen);
                        } catch (NoSuchPaddingException e1) {
                            e1.printStackTrace();
                        } catch (NoSuchAlgorithmException e1) {
                            e1.printStackTrace();
                        } catch (InvalidAlgorithmParameterException e1) {
                            e1.printStackTrace();
                        } catch (InvalidKeyException e1) {
                            e1.printStackTrace();
                        } catch (BadPaddingException e1) {
                            e1.printStackTrace();
                        } catch (IllegalBlockSizeException e1) {
                            e1.printStackTrace();
                        }
                        break;
                    case "AES-192":
                        break;
                    case "AES-256":
                        break;
                    case "DES":
                        DesSym desSym = new DesSym();
                        String mingwen = desSym.decrypt(jTextArea2.getText(), (String) jComboBox6.getSelectedItem(), jTextFieldKey.getText(), (String) jComboBox6.getSelectedItem(), jTextFieldIv.getText(), (String) jComboBox2.getSelectedItem(), (String) jComboBox3.getSelectedItem(), (String) jComboBox5.getSelectedItem());
                        jTextArea1.setText(mingwen);
                        break;
                    case "3DES":
                        Des3Sym des3Sym = new Des3Sym();
                        String mingwen3 = des3Sym.decrypt(jTextArea2.getText(), (String) jComboBox6.getSelectedItem(), jTextFieldKey.getText(), (String) jComboBox6.getSelectedItem(), jTextFieldIv.getText(), (String) jComboBox2.getSelectedItem(), (String) jComboBox3.getSelectedItem(), (String) jComboBox5.getSelectedItem());
                        jTextArea1.setText(mingwen3);
                        break;
                }
            }
        });
        JLabel jLabelsum1 = new JLabel("注意事项：1 现阶段完成的功能为AES-128、(3)DES，key/iv均可选择字符串与base64编码格式,输出可选择hex/base64转码");
        jLabelsum1.setBounds(100, 400, 1000, 50);
        JLabel jLabelsum2 = new JLabel("                      2 AES-128的key请使用16位字符,iv请使用16位；DES 8/8,3DES 24/8");
        jLabelsum2.setBounds(100, 420, 1000, 50);
        JLabel jLabelsum3 = new JLabel("                      3 工作模式：AES-128请使用CBC/CFB/ECB（无iv）/OFB/PCBC，(3)DES请使用CBC/CFB/ECB（无iv）/OFB/PCBC；");
        jLabelsum3.setBounds(100, 440, 1000, 50);
        JLabel jLabelsum4 = new JLabel("                      4 填充模式：AES-128、(3)DES可使用3种填充方式（选择不填充ase使用16位明文，(3)des使用8位");
        jLabelsum4.setBounds(100, 460, 1000, 50);
        JLabel jLabelsum5 = new JLabel("                      5 ASE-192/256 待开发中。。。。。。");
        jLabelsum5.setBounds(100, 480, 1000, 50);
        this.add(jTextArea1);
        this.add(jTextArea2);
        this.add(jsp1);
        this.add(jsp2);
        this.add(jLabel1);
        this.add(jComboBox1);
        this.add(jLabel2);
        this.add(jComboBox2);
        this.add(jLabel3);
        this.add(jComboBox3);
        this.add(jLabel4);
        this.add(jComboBox4);
        this.add(jLabel5);
        this.add(jComboBox5);
        this.add(jLabel6);
        this.add(jComboBox6);
        this.add(jTextFieldKey);
        this.add(jLabel7);
        this.add(jComboBox7);
        this.add(jTextFieldIv);
        this.add(jButton1);
        this.add(jButton2);
        this.add(jLabelsum1);
        this.add(jLabelsum2);
        this.add(jLabelsum3);
        this.add(jLabelsum4);
        this.add(jLabelsum5);
    }

}
