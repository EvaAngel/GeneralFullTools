package com.general.full.tools.gui.codinggui;

import com.general.full.tools.coding.HexCoding;
import com.general.full.tools.coding.HtmlCoding;
import org.apache.commons.codec.DecoderException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

public class HexGui extends JPanel {
    public HexGui()
    {
        this.setLayout(null);
        JTextArea textArea1=new JTextArea("请输入待编码数据");
        textArea1.setBounds(50,50,250,250);
        textArea1.setBackground(new Color(247, 246, 245));
        textArea1.setLineWrap(true);
        JTextArea textArea2=new JTextArea("请输入待解码数据");
        textArea2.setBounds(500,50,250,250);
        textArea2.setBackground(new Color(247, 246, 245));
        textArea2.setLineWrap(true);
        JButton jButton1=new JButton("HEX编码");
        jButton1.setBounds(350,100,100,30);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String string=textArea1.getText();
                try {
                    textArea2.setText(HexCoding.enHex(string));
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                }
            }
        });
        JButton jButton2=new JButton("HEX解码");
        jButton2.setBounds(350,200,100,30);
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String string=textArea2.getText();
                try {
                    textArea1.setText(HexCoding.deHex(string));
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                } catch (DecoderException e1) {
                    e1.printStackTrace();
                }
            }
        });
        this.add(textArea1);
        this.add(jButton1);
        this.add(jButton2);
        this.add(textArea2);
    }
}
