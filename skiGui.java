/* 
 *A simple GUI for the Ski score Calculator
 *that was built for EOX. It provides a graphical
 *way of selecting input files and
 * some basic functionality buttons
 *
 * @author Konstantinos Peratinos
 */

package Ski;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class skiGui
extends JFrame {
 private JButton Calculate;
 private JButton browse;
 private JFileChooser jFileChooser1;
 private JLabel jLabel1;
 private JLabel jLabel2;
 private JLabel jLabel3;
 private JTextField path;
 private JTextField path1;

 public skiGui() {
  initComponents();
 }

 private void initComponents() {
  this.jFileChooser1 = new JFileChooser();
  this.path = new JTextField();
  this.browse = new JButton();
  this.jLabel1 = new JLabel();
  this.jLabel2 = new JLabel();
  this.path1 = new JTextField();
  this.Calculate = new JButton();
  this.jLabel3 = new JLabel();

  this.jFileChooser1.setDialogTitle("Θέση Αρχείου");
  this.jFileChooser1.setFileFilter(new xlsFilter());

  setDefaultCloseOperation(3);
  setTitle("Point Calculator");

  this.path.setFont(new Font("Tahoma", 0, 10));
  this.path.setText("C:\\");
  this.path.setToolTipText("");
  this.path.setEnabled(false);
  this.path.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent evt) {
    skiGui.this.pathActionPerformed(evt);
   }
  });
  this.browse.setFont(new Font("Tahoma", 1, 9));
  this.browse.setText("Εξευρεύνησε");
  this.browse.setToolTipText("");
  this.browse.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent evt) {
    skiGui.this.browseActionPerformed(evt);
   }
  });
  this.jLabel1.setFont(new Font("Times New Roman", 1, 11));
  this.jLabel1.setHorizontalAlignment(0);
  this.jLabel1.setText("Διαδρομή Αρχείου");

  this.jLabel2.setFont(new Font("Times New Roman", 1, 11));
  this.jLabel2.setHorizontalAlignment(0);
  this.jLabel2.setText("Νέο Αρχείο");

  this.path1.setFont(new Font("Tahoma", 0, 10));
  this.path1.setText("Αποτελέσματα");
  this.path1.setToolTipText("");
  this.path1.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent evt) {
    skiGui.this.path1ActionPerformed(evt);
   }
  });
  this.Calculate.setFont(new Font("Tahoma", 1, 11));
  this.Calculate.setText("Υπολόγισε!");
  this.Calculate.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent evt) {
    skiGui.this.CalculateActionPerformed(evt);
   }
  });
  this.jLabel3.setFont(new Font("Tunga", 1, 11));
  this.jLabel3.setText("Copyright [2013] [Konstantinos]");
  this.jLabel3.setToolTipText("");
  this.jLabel3.setVerticalAlignment(3);

  GroupLayout layout = new GroupLayout(getContentPane());
  getContentPane().setLayout(layout);
  layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
   .addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout
     .Alignment.TRAILING, false).addComponent(this.jLabel2, GroupLayout.Alignment.LEADING, -1, -1, 32767)
    .addComponent(this.jLabel1, GroupLayout.Alignment.LEADING, -1, 97, 32767)).addPreferredGap(LayoutStyle
    .ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    .addGroup(layout.createSequentialGroup().addComponent(this.path1, -2, 271, -2).addContainerGap())
    .addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.path, -2, 271, -2).addComponent(this.Calculate, -2, 193, -2))
     .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.browse, -1, -1, 32767).addComponent(this.jLabel3, -1, -1, 32767))))));

  layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup()
   .addGap(30, 30, 30).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1)
    .addComponent(this.path, -2, 21, -2).addComponent(this.browse)).addGroup(layout.createParallelGroup(GroupLayout
    .Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(30, 30, 30)
    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.path1, -2, 21, -2)
     .addComponent(this.jLabel2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 31, 32767)
    .addComponent(this.Calculate).addGap(11, 11, 11)).addGroup(GroupLayout.Alignment.TRAILING, layout
    .createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jLabel3)))));

  pack();
 }

 private void browseActionPerformed(ActionEvent evt) {
  int returnVal = this.jFileChooser1.showOpenDialog(this);
  if (returnVal == 0) {
   File file = this.jFileChooser1.getSelectedFile();
   try {
    this.path.setText(file.getAbsolutePath());
   } catch (Exception ex) {
    System.out.println("problem accessing file" + file.getAbsolutePath());
   }
  } else {
   System.out.println("File access cancelled by user.");
  }
 }

 private void pathActionPerformed(ActionEvent evt) {}

 private void path1ActionPerformed(ActionEvent evt) {}

 private void CalculateActionPerformed(ActionEvent evt) {
  calc calc1 = new calc();
  String fpath = this.path.getText();
  String fname = this.path1.getText();
  calc.pointCalc(fpath, fname);
 }

 public static void main(String[] args) {
  try {
   for (UIManager.LookAndFeelInfo info: ) {
    if ("Nimbus".equals(info.getName())) {
     UIManager.setLookAndFeel(info.getClassName());
     break;
    }
   }
  } catch (ClassNotFoundException ex) {
   Logger.getLogger(skiGui.class.getName()).log(Level.SEVERE, null, ex);
  } catch (InstantiationException ex) {
   Logger.getLogger(skiGui.class.getName()).log(Level.SEVERE, null, ex);
  } catch (IllegalAccessException ex) {
   Logger.getLogger(skiGui.class.getName()).log(Level.SEVERE, null, ex);
  } catch (UnsupportedLookAndFeelException ex) {
   Logger.getLogger(skiGui.class.getName()).log(Level.SEVERE, null, ex);
  }
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    new skiGui().setVisible(true);
   }
  });
 }
}