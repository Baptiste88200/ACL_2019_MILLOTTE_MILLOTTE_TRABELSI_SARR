/*
 * Created by JFormDesigner on Mon Dec 02 21:28:46 CET 2019
 */

package model.menu;

import engine.Cmd;
import engine.GamePainter;

import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * @author mohamed sarr
 */
public class Menu extends JPanel {
    private final int width;
    private final int height;
    private MenuController controller;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - mohamed sarr
    private JButton load;
    private JButton exit;
    private JButton nouveau;
    private JButton save;

    public Menu(GamePainter painter, MenuController controller) {
        this.controller = controller;
        this.width = painter.getWidth();
        this.height = painter.getHeight();
        initComponents();
        initBtnListner();
        this.setPreferredSize(new Dimension(this.width, this.height));


    }

    private void initBtnListner() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE)
                    controller.setCommand(Cmd.ECHAP);
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controller.setCommand(Cmd.SAVE);
            }
        });
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controller.setCommand(Cmd.LOAD);
            }
        });
        nouveau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controller.setCommand(Cmd.NEW);
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controller.setCommand(Cmd.EXIT);
            }
        });

    }

    public JButton getNouveau() {
        return nouveau;
    }

    public JButton getLoad() {
        return load;
    }

    public JButton getSave() {
        return save;
    }

    public JButton getExit() {
        return exit;
    }

    public JPanel getThis() {
        return this;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - mohamed sarr
        load = new JButton();
        exit = new JButton();
        nouveau = new JButton();
        save = new JButton();

        //======== this ========
        setBackground(UIManager.getColor("nimbusBlueGrey"));
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
                javax.swing.border.EmptyBorder(0, 0, 0, 0), "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax
                .swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java
                .awt.Font("D\u0069al\u006fg", java.awt.Font.BOLD, 12), java.awt
                .Color.red), getBorder()));
        addPropertyChangeListener(new java.beans.
                PropertyChangeListener() {
            @Override
            public void propertyChange(java.beans.PropertyChangeEvent e) {
                if ("\u0062or\u0064er".
                        equals(e.getPropertyName())) throw new RuntimeException();
            }
        });

        //---- load ----
        load.setText("Chargement");
        load.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 16));
        load.setForeground(UIManager.getColor("nimbusSelectedText"));
        load.setBackground(UIManager.getColor("nimbusBlueGrey"));
        load.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));

        //---- exit ----
        exit.setText("exit");
        exit.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 16));
        exit.setForeground(UIManager.getColor("nimbusSelectedText"));
        exit.setBackground(UIManager.getColor("nimbusBlueGrey"));
        exit.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));

        //---- nouveau ----
        nouveau.setText("Nouveau");
        nouveau.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 16));
        nouveau.setForeground(UIManager.getColor("nimbusSelectedText"));
        nouveau.setBackground(UIManager.getColor("nimbusBlueGrey"));
        nouveau.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));

        //---- play ----
        save.setText("Save");
        save.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 16));
        save.setForeground(UIManager.getColor("nimbusSelectedText"));
        save.setBackground(UIManager.getColor("nimbusBlueGrey"));
        save.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(195, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(nouveau, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                        .addComponent(save, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                        .addComponent(load, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(exit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(178, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(nouveau, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(save, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(load, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(exit, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(100, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
