package com.general.full.tools.gui;

import com.general.full.tools.gui.codinggui.*;
import com.general.full.tools.gui.computer_principle_gui.BiBinaryGui;
import com.general.full.tools.gui.computer_principle_gui.OriginalCodeGui;
import com.general.full.tools.gui.cryptorgui.AesDesGUI;
import com.general.full.tools.gui.cryptorgui.Md5ShaGUI;
import com.general.full.tools.gui.cryptorgui.RsaDsaGUI;
import com.general.full.tools.work_demands2.DomainScreenshot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * 图形化界面主入口
 * **/
public class TotalGui {
    public void totalGui() {
        //JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame jFrame = new JFrame("GeneralTool V1.0");
        //设置主窗体位置
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        jFrame.setBounds((width - 820) / 2,
                (height - 700) / 2, 850, 700);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);// 设置关闭退出
        //定义菜单
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu1 = new JMenu("windows");
        JMenuItem jMenuItem11 = new JMenuItem("new");
        JMenuItem jMenuItem12 = new JMenuItem("open");
        jMenu1.add(jMenuItem11);
        jMenu1.add(jMenuItem12);
        JMenu jMenu2 = new JMenu("help");
        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);
        //定义选项卡：这里想把计算机组成原理放在后面
        // http://c.biancheng.net/view/1263.html
        JTabbedPane jTabbedPane = new JTabbedPane();
        //
        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(new GridLayout(1, 1));
        jTabbedPane.addTab("编码解码器", jPanel1);
        jTabbedPane.setMnemonicAt(0, KeyEvent.VK_2);
        JTabbedPane jTabbedPane1 = new JTabbedPane();
        AsciiGui asciiGui=new AsciiGui();
        jTabbedPane1.addTab("ASCII编码", asciiGui);
        jTabbedPane1.setMnemonicAt(0, KeyEvent.VK_1);
        UnicodeGui unicodeGui=new UnicodeGui();
        jTabbedPane1.addTab("Unicode编码", unicodeGui);
        jTabbedPane1.setMnemonicAt(0, KeyEvent.VK_2);
        Utf_8Gui utf_8Gui=new Utf_8Gui();
        jTabbedPane1.addTab("utf-8编码", utf_8Gui);
        jTabbedPane1.setMnemonicAt(0, KeyEvent.VK_3);
        GBKGui GBKGui =new GBKGui();
        jTabbedPane1.addTab("GBK编码", GBKGui);
        jTabbedPane1.setMnemonicAt(0, KeyEvent.VK_4);
        Base64Gui base64Gui=new Base64Gui();
        jTabbedPane1.addTab("BASE64编码", base64Gui);
        jTabbedPane1.setMnemonicAt(0, KeyEvent.VK_5);
        UrlGui urlGui=new UrlGui();
        jTabbedPane1.addTab("URL编码", urlGui);
        jTabbedPane1.setMnemonicAt(0, KeyEvent.VK_6);
        HtmlGui htmlGui=new HtmlGui();
        jTabbedPane1.addTab("HTML编码", htmlGui);
        jTabbedPane1.setMnemonicAt(0, KeyEvent.VK_7);
        HexGui hexGui=new HexGui();
        jTabbedPane1.addTab("HEX编码", hexGui);
        jTabbedPane1.setMnemonicAt(0, KeyEvent.VK_8);
        jPanel1.add(jTabbedPane1);
        //
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new GridLayout(1, 1));
        jTabbedPane.addTab("加密解密器", jPanel2);
        jTabbedPane.setMnemonicAt(0, KeyEvent.VK_3);
        JTabbedPane jTabbedPane2= new JTabbedPane();
        Md5ShaGUI md5ShaGUI=new Md5ShaGUI();
        jTabbedPane2.addTab("hash加解密", md5ShaGUI);
        jTabbedPane2.setMnemonicAt(0, KeyEvent.VK_1);
        AesDesGUI aesGUI=new AesDesGUI();
        jTabbedPane2.addTab("AES、DES对称加解密", aesGUI);
        jTabbedPane2.setMnemonicAt(0, KeyEvent.VK_2);
        RsaDsaGUI rsaDsaGUI=new RsaDsaGUI();
        jTabbedPane2.addTab("RSA、DSA非对称加解密", rsaDsaGUI);
        jTabbedPane2.setMnemonicAt(0, KeyEvent.VK_3);
        //GBKGui GBKGui2=new GBKGui();
        jPanel2.add(jTabbedPane2);
        //
        JPanel jPanel3 = new JPanel();
        //比较好的讲解布局的文章：https://blog.csdn.net/jianggujin/article/details/50445093
        jPanel3.setLayout(new GridLayout(1, 1)); //这里可以完全解决布局问题
        jTabbedPane.addTab("计算机组成原理", jPanel3);
        jTabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        //在panel1中添加子元素
        JTabbedPane jTabbedPane3 = new JTabbedPane();
        BiBinaryGui biBinaryGui=new BiBinaryGui();
        jTabbedPane3.addTab("进制进制转换", biBinaryGui);
        jTabbedPane3.setMnemonicAt(0, KeyEvent.VK_1);
        OriginalCodeGui originalCodeGui=new OriginalCodeGui();
        jTabbedPane3.addTab("原反补码", originalCodeGui);
        jTabbedPane3.setMnemonicAt(0, KeyEvent.VK_2);
        jPanel3.add(jTabbedPane3);
        //
        JPanel jPanel4 = new JPanel();
        jPanel4.setLayout(new GridLayout(1, 1));
        jTabbedPane.addTab("工作便利器", jPanel4);
        jTabbedPane.setMnemonicAt(0, KeyEvent.VK_4);
        //在panel14中添加子元素
        JTabbedPane jTabbedPane4=new JTabbedPane();
        DomainScreenshot domainScreenshot=new DomainScreenshot();
        jTabbedPane4.addTab("网站截图工具",domainScreenshot);
        jTabbedPane4.setMnemonicAt(0,KeyEvent.VK_1);
        jPanel4.add(jTabbedPane4);
        //添加菜单
        jFrame.setJMenuBar(jMenuBar);
        //添加选项卡
        jFrame.add(jTabbedPane);
        jFrame.setVisible(true);
    }




    public static void main(String[] args) {
        new TotalGui().totalGui();
    }
}
