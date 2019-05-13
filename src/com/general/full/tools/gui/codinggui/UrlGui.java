package com.general.full.tools.gui.codinggui;

import com.general.full.tools.coding.AsciiCoding;
import com.general.full.tools.coding.UrlCoding;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UrlGui extends JPanel {
    public UrlGui() {
        this.setLayout(null);
        JTextArea textArea1 = new JTextArea("请输入待编码数据");
        textArea1.setBounds(50, 50, 250, 250);
        textArea1.setBackground(new Color(247, 246, 245));
        textArea1.setLineWrap(true);
        JTextArea textArea2 = new JTextArea("请输入待解码数据");
        textArea2.setBounds(500, 50, 250, 250);
        textArea2.setBackground(new Color(247, 246, 245));
        textArea2.setLineWrap(true);
        JLabel jLabel0 = new JLabel("编码类型:");
        jLabel0.setBounds(320, 50, 60, 30);
        JComboBox jComboBox0 = new JComboBox();
        jComboBox0.addItem("半编码");
        jComboBox0.addItem("全编码");
        jComboBox0.setBounds(380, 50, 100, 25);
        JLabel jLabel1 = new JLabel("编码方式:");
        jLabel1.setBounds(320, 100, 60, 30);
        JComboBox jComboBox1 = new JComboBox();
        jComboBox1.addItem("UTF-8");
        jComboBox1.addItem("UNICODE");
        jComboBox1.setBounds(380, 100, 100, 25);
        JLabel jLabel2 = new JLabel("解码方式:");
        jLabel2.setBounds(320, 150, 60, 30);
        JComboBox jComboBox2 = new JComboBox();
        jComboBox2.addItem("UTF-8");
        jComboBox2.addItem("UNICODE");
        jComboBox2.setBounds(380, 150, 100, 25);
        JButton jButton1 = new JButton("url编码");
        jButton1.setBounds(350, 200, 100, 30);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String string = textArea1.getText();
                String choose = (String) jComboBox0.getSelectedItem();
                if (choose.equals("半编码")) {
                    textArea2.setText(UrlCoding.enUrlCoding(string, (String) jComboBox1.getSelectedItem()));
                }
                else
                {
                    textArea2.setText(UrlCoding.enUrlCoding2(string));
                }
            }
        });
        JButton jButton2 = new JButton("url解码");
        jButton2.setBounds(350, 250, 100, 30);
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String string = textArea2.getText();
                String choose = (String) jComboBox0.getSelectedItem();
                if (choose.equals("半编码")) {
                    textArea1.setText(UrlCoding.deUrlCoding(string, (String) jComboBox1.getSelectedItem()));
                }
                else
                {
                    textArea1.setText(UrlCoding.deUrlCoding2(string));
                }
            }
        });
        this.add(textArea1);
        this.add(jButton1);
        this.add(jButton2);
        this.add(textArea2);
        this.add(jLabel1);
        this.add(jComboBox1);
        this.add(jLabel2);
        this.add(jComboBox2);
        this.add(jLabel0);
        this.add(jComboBox0);
    }
}
