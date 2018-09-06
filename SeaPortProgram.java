import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.*;
import javax.swing.JScrollPane;
import java.awt.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.border.*;

public class SeaPortProgram extends JFrame {
  public SeaPortProgram(File sf) {
    World w = new World();
    w.process(sf);

    setTitle("SeaPort");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new GridLayout(2,1));

    JLabel jl = new JLabel("Port Info");
    add(jl);

    JTextArea jt = new JTextArea(w.displayData());
    JScrollPane scrollPane = new JScrollPane(jt);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    jt.setEditable(false);
    Border border = BorderFactory.createLineBorder(Color.BLACK);
    jt.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10,10,10,10)));
    add(scrollPane);

    pack();
    setVisible(true);
    setSize(400,400);
  }
  public static void main(String[] args) {
    JFileChooser j = new JFileChooser("./");
    j.setDialogTitle("Choose text file:");

    j.setAcceptAllFileFilterUsed(false);
    FileNameExtensionFilter f = new FileNameExtensionFilter("Text files", "txt");
    j.addChoosableFileFilter(f);

    int rv = j.showOpenDialog(null);
    if (rv == JFileChooser.APPROVE_OPTION) {
      System.out.println(j.getSelectedFile());
    }
    new SeaPortProgram(j.getSelectedFile());
  }
}
