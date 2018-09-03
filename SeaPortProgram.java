import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class SeaPortProgram extends JFrame {
  public SeaPortProgram(File sf) {
    System.out.println("Processing >"+sf.toString()+"<");
    try {
      Scanner sc = new Scanner("ship ren 3000 3000 45 45 45 45");

      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        String l[] = line.split(" ");

        System.out.println(l[0]);
        if (l[0].equals("ship")) {

          Ship s = new Ship(l[1], Integer.parseInt(l[2]), Integer.parseInt(l[3]), Double.parseDouble(l[4]), Double.parseDouble(l[5]), Double.parseDouble(l[6]), Double.parseDouble(l[7]));
          System.out.println(s.toString());
        }
      }
    } catch(Exception e) {
      System.out.println(e);
    }

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
