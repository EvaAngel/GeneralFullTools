package com.general.full.tools.work_demands2;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class DomainScreenshot extends JPanel {

    public DomainScreenshot() {
        this.setLayout(null);
        JLabel jLabel = new JLabel("请选择excel文件");
        jLabel.setBounds(100, 20, 150, 30);
        JTextField jTextField = new JTextField();
        jTextField.setBounds(220, 26, 200, 20);
        JButton jButton = new JButton("选择文件");
        jButton.setBounds(450, 26, 100, 20);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                jfc.showDialog(new JLabel(), "选择");
                File file = jfc.getSelectedFile();
                jTextField.setText(file.getAbsolutePath());
            }
        });
        JLabel jLabel2 = new JLabel("请选择默认浏览器");
        jLabel2.setBounds(100, 80, 150, 20);
        JComboBox jComboBox1 = new JComboBox();
        jComboBox1.addItem("chrome");
        jComboBox1.addItem("iexplorer");
        jComboBox1.addItem("firefox");
        jComboBox1.setBounds(250, 80, 100, 25);
        JLabel jLabel3 = new JLabel("请选择睡眠时间");
        jLabel3.setBounds(100, 140, 150, 20);
        JComboBox jComboBox2 = new JComboBox();
        jComboBox2.addItem("5000");
        jComboBox2.addItem("10000");
        jComboBox2.addItem("15000");
        jComboBox2.setBounds(250, 140, 100, 25);
        JLabel jLabel5 = new JLabel("请选择是否截图");
        jLabel5.setBounds(100, 200, 150, 20);
        JComboBox jComboBox3 = new JComboBox();
        jComboBox3.addItem("是");
        jComboBox3.addItem("否");
        jComboBox3.setBounds(250, 200, 100, 25);
        JLabel jLabel10 = new JLabel("关闭浏览器网页数");
        jLabel10.setBounds(100, 260, 150, 20);
        JComboBox jComboBox4 = new JComboBox();
        jComboBox4.addItem("5");
        jComboBox4.addItem("10");
        jComboBox4.addItem("15");
        jComboBox4.addItem("20");
        jComboBox4.setBounds(250, 260, 100, 25);
        JButton jButton2 = new JButton("开始截图");
        jButton2.setBounds(100, 320, 100, 20);
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> result = new DomainScreenshot().inputUrl(jTextField.getText());
                //System.out.println(result.size());
                int count=0;
                for (String url : result) {
                    count++;
                    new DomainScreenshot().openChrome(url);
                    if (((String) jComboBox3.getSelectedItem()).equals("是")) {
                        new DomainScreenshot().screenShot((String) jComboBox2.getSelectedItem(), url);
                        //new DomainScreenshot().closeChrome("chrome");
                        //这里判断是否开启10个页面，开启10个后关闭一次重新开始
                        if(count==Integer.valueOf((String)jComboBox4.getSelectedItem()))
                        {
                            new DomainScreenshot().closeChrome((String) jComboBox1.getSelectedItem());
                            count=0;
                            try {
                                Thread.sleep(10000);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }
                //这里判断结束标志，如果截图，关闭浏览器表示结束；如果不截图，弹窗表示结束
                if (((String) jComboBox3.getSelectedItem()).equals("是")) {
                    new DomainScreenshot().closeChrome((String) jComboBox1.getSelectedItem());
                }
                if (((String) jComboBox3.getSelectedItem()).equals("否"))

                {
                    //可有可无，因为都是瞬间加载完毕
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "帅哥，已全部加载完毕", "hacker", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        JLabel jLabel4 = new JLabel("说明：1 截图文件会保存在d://picture下");
        jLabel4.setBounds(100, 360, 450, 20);
        JLabel jLabel6 = new JLabel("             2 所选excel文件为第一列存储域名且第一行存储标题数据");
        jLabel6.setBounds(100, 390, 450, 20);
        JLabel jLabel7 = new JLabel("             3 默认浏览器功能选择所要使用的浏览器");
        jLabel7.setBounds(100, 420, 450, 20);
        JLabel jLabel8 = new JLabel("             4 睡眠时间指打开网站预计花费的时间（ms）");
        jLabel8.setBounds(100, 450, 450, 20);
        JLabel jLabel9 = new JLabel("             5 是否截图若选择否指将所有网站打开而非截图且浏览器不关闭");
        jLabel9.setBounds(100, 480, 450, 20);
        JLabel jLabel11 = new JLabel("            6 关闭浏览器网页数可选择指定数目开启网页后关闭");
        jLabel11.setBounds(100, 510, 450, 20);
        this.add(jLabel);
        this.add(jTextField);
        this.add(jButton);
        this.add(jLabel2);
        this.add(jComboBox1);
        this.add(jLabel3);
        this.add(jComboBox2);
        this.add(jButton2);
        this.add(jLabel4);
        this.add(jLabel5);
        this.add(jLabel6);
        this.add(jLabel7);
        this.add(jLabel8);
        this.add(jLabel9);
        this.add(jLabel10);
        this.add(jLabel11);
        this.add(jComboBox4);
        this.add(jComboBox3);
    }

    /**
     * 此方法实现excel数据的导入
     **/
    public List<String> inputUrl(String filePath) {
        List<String> urlList = new ArrayList<>();
        FileInputStream fileInputStream = null;
        Workbook workbook = null;
        if (!filePath.endsWith(".xls") && !filePath.endsWith(".xlsx")) {
            System.out.println("不是excel文件");
            return urlList;
        }
        try {
            fileInputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(0);
                urlList.add(cell.getStringCellValue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlList;
    }

    /**
     * 此方法实现使用浏览器打开特定域名操作,默认打开Google浏览器
     **/
    public void openChrome(String url) {
        URI u;
        //这里特定使用者为Windows用户
        Desktop desktop = Desktop.getDesktop();
        if (Desktop.isDesktopSupported() && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                u = new URI(url);
                desktop.browse(u);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 实现停留10s后截屏
     * 注意截屏程序运行时不得切换页面
     **/
    public void screenShot(String time, String url) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.delay(Integer.valueOf(time));
        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        int width = (int) d.getWidth();
        int height = (int) d.getHeight();
        //最大化浏览器
        robot.keyRelease(KeyEvent.VK_F11);
        robot.delay(2000);
        Image image = robot.createScreenCapture(new Rectangle(0, 0, width,
                height));
        BufferedImage bi = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        g.drawImage(image, 0, 0, width, height, null);
        //保存图片
        try {
            String files = "d:/picture";
            File file = new File(files);
            if (!file.exists()) {
                file.mkdir();
            }
            String reurl = url.replace(":", "-");
            String[] strs = reurl.split("//");
            String urll = null;
            if (strs.length == 1) {
                urll = strs[0];
            } else {
                urll = strs[1];
            }
            ImageIO.write(bi, "jpg", new File(file + "/" + urll + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭默认浏览器操作
     * 注意：当杀死一个浏览器后，再启动会有延时或者无法启动的情况（推测：需要睡眠10s才可以）
     **/
    public void closeChrome(String type) {
        try {
            Runtime.getRuntime().exec("taskkill /IM " + type + ".exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
