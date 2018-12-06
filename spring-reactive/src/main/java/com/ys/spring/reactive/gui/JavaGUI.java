package com.ys.spring.reactive.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author HuaDong
 * @date 2018/12/6 22:47
 *
 * Java GUI 程序 - 理解 Callback Hell
 */
public class JavaGUI {

    public static void main(String[] args) {

        JFrame jFrame = new JFrame("GUI 示例");
        jFrame.setBounds(500, 300, 400, 300);
        LayoutManager layoutManager = new BorderLayout(400, 300);
        jFrame.setLayout(layoutManager);

        jFrame.addMouseListener(new MouseAdapter() {
            // callback 1
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.printf("[线程 : %s] 鼠标点击，坐标(X : %d, Y : %d)\n",
                        currentThreadName(), e.getX(), e.getY());
            }
        });
        jFrame.addWindowListener(new WindowAdapter() {
            // callback 2
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.printf("[线程 : %s] 清除 jFrame... \n", currentThreadName());
                // 清除 jFrame
                jFrame.dispose();
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.printf("[线程 : %s] 退出程序... \n", currentThreadName());
                // 退出程序
                System.exit(0);
            }
        });
        System.out.println("当前线程：" + currentThreadName());
        jFrame.setVisible(true);
    }

    private static String currentThreadName() { // 当前线程名称
        return Thread.currentThread().getName();
    }
}
