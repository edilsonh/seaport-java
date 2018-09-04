import java.util.ArrayList;

public class SeaPort extends Thing {
  ArrayList<Dock> docks = new ArrayList<Dock>();
  ArrayList<Ship> que = new ArrayList<Ship>();

  public SeaPort(String name, int index, int parent) {
    super(name, index, parent);
  }

  public void addDock(Dock d) {
    docks.add(d);
    System.out.println("Dock Added!");
  }

  public void addShipToQue(Ship s) {
    que.add(s);
    System.out.println("Ship Added to Que!");
  }

  public String toString() {
    return super.toString();
  }
}
