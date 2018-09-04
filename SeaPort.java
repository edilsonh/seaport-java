import java.util.ArrayList;

public class SeaPort extends Thing {
  ArrayList<Dock> docks = new ArrayList<Dock>();
  ArrayList<Ship> que = new ArrayList<Ship>();
  ArrayList<Ship> ships = new ArrayList<Ship>();
  ArrayList<Person> persons = new ArrayList<Person>();

  public SeaPort(String name, int index, int parent) {
    super(name, index, parent);
  }

  public void addPerson(Person p) {
    persons.add(p);
    System.out.println("Person Added!");
  }

  public void addDock(Dock d) {
    docks.add(d);
    System.out.println("Dock Added!");
  }

  public void addShipToQue(Ship s) {
    que.add(s);
    System.out.println("Ship Added to Que!");
  }

  public void addShipToShips(Ship s) {
    ships.add(s);
    for (int i = 0; i<docks.size(); i++) {
      if (docks.get(i).dockedShip == s.index) {
        docks.get(i).addShipToDock(s);
      }
    }
  }

  public String toString() {
    return super.toString();
  }
}
