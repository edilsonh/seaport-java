import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class SeaPortProgram extends JFrame {
  public SeaPortProgram(File sf) {
    World w = new World();
    w.process(sf);

    setTitle("SeaPort");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new GridLayout(2,1));

    JLabel jl = new JLabel("the ship info will be here!");
    add(jl);

    pack();
    setVisible(true);
    setSize(300,300);
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
