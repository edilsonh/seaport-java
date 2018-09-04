import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class World extends Thing {
  ArrayList<SeaPort> seaPortAL = new ArrayList<SeaPort>();
  // PortTime
  public World() {
    super("World", 1, 0);
  }

  private void addShipToSeaPort(Ship s, int ind) {
    for (int i = 0; i<seaPortAL.size(); i++) {
      if (seaPortAL.get(i).index == ind) {
        seaPortAL.get(i).addShipToQue(s);
      }
    }
  }

  public void process(File f) {
    System.out.println("Processing>" + f + "<");
    try {
      Scanner sc = new Scanner(f);

      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        String l[] = line.split(" ");

        System.out.println(l[0]);
        if (l[0].equals("ship")) {
          Ship s = new Ship(l[1], Integer.parseInt(l[2]), Integer.parseInt(l[3]), Double.parseDouble(l[4]), Double.parseDouble(l[5]), Double.parseDouble(l[6]), Double.parseDouble(l[7]));

          System.out.println(s.toString());

          addShipToSeaPort(s, Integer.parseInt(l[3]));
        } else if (l[0].equals("pship")) {
          PassengerShip ps = new PassengerShip(l[1], Integer.parseInt(l[2]), Integer.parseInt(l[3]), Double.parseDouble(l[4]), Double.parseDouble(l[5]), Double.parseDouble(l[6]), Double.parseDouble(l[7]),
          Integer.parseInt(l[8]), Integer.parseInt(l[9]), Integer.parseInt(l[10]));

          System.out.println(ps.toString());

          addShipToSeaPort(ps, Integer.parseInt(l[3]));
        } else if (l[0].equals("cship")) {
          CargoShip cs = new CargoShip(l[1], Integer.parseInt(l[2]), Integer.parseInt(l[3]), Double.parseDouble(l[4]), Double.parseDouble(l[5]), Double.parseDouble(l[6]), Double.parseDouble(l[7]),
          Double.parseDouble(l[8]), Double.parseDouble(l[9]), Double.parseDouble(l[10]));

          System.out.println(cs.toString());

          addShipToSeaPort(cs, Integer.parseInt(l[3]));
        } else if (l[0].equals("port")) {
          SeaPort sp = new SeaPort(l[1], Integer.parseInt(l[2]), Integer.parseInt(l[3]));

          seaPortAL.add(sp);

          System.out.println(sp.toString());
          System.out.println("Port Added!");
        } else if (l[0].equals("dock")) {
          Dock d = new Dock(l[1], Integer.parseInt(l[2]), Integer.parseInt(l[3]), Integer.parseInt(l[4]));
          System.out.println(d.toString());

          for (int i = 0; i<seaPortAL.size(); i++) {
            if (seaPortAL.get(i).index == Integer.parseInt(l[3])) {
              seaPortAL.get(i).addDock(d);
            }
          }
        }
      }
    } catch(Exception e) {
      System.out.println(e);
    }
  }
}
