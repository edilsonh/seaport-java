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
      } else {
        seaPortAL.get(i).addShipToShips(s);
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
        } else if (l[0].equals("person")) {
          Person p = new Person(l[1], Integer.parseInt(l[2]), Integer.parseInt(l[3]), l[4]);
          for (int i = 0; i<seaPortAL.size(); i++) {
            if (seaPortAL.get(i).index == Integer.parseInt(l[3])) {
              seaPortAL.get(i).addPerson(p);
            }
          }
          System.out.println(p.toString());
        }
      }
    } catch(Exception e) {
      System.out.println(e);
    }
  }

  public String displayData() {
    String dataString = ">>>>> The World: \n\n\n SeaPort: ";
    for (int i = 0; i<seaPortAL.size(); i++) {
      dataString += seaPortAL.get(i) + "\n\n";
      for (int j = 0; j<seaPortAL.get(i).docks.size(); j++) {
        System.out.println(seaPortAL.get(i).docks.get(j));
        dataString += "     Dock:" + seaPortAL.get(i).docks.get(j).name + " " + seaPortAL.get(i).docks.get(j).index + "\n";
        dataString += "        Ship:" + seaPortAL.get(i).docks.get(j).s.toString() + "\n\n";
      }

      dataString += "\n     --- List of all ships:\n";

      for (int ii = 0; ii<seaPortAL.get(i).que.size(); ii++) {
        dataString += "        > " + seaPortAL.get(i).que.get(ii).toString() + "\n";
      }

      for (int jj = 0; jj<seaPortAL.get(i).ships.size(); jj++) {
        dataString += "        > " + seaPortAL.get(i).ships.get(jj).toString() + "\n";
      }

      dataString += "\n\n     --- List of all persons:\n";

      for (int k = 0; k<seaPortAL.get(i).persons.size(); k++) {
        dataString += "        > " + seaPortAL.get(i).persons.get(k).toString() + "\n";
      }
    }

    return dataString;
  }
}
