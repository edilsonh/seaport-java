public class Dock extends Thing {
  int dockedShip;
  Ship s;

  public Dock(String name, int index, int parent, int dockedShip) {
    super(name, index, parent);
    this.dockedShip = dockedShip;
  }

  // public int compareTo(int i) {
  //   if (i == dockedShip) {
  //     System.out.println("Ship is Docked!");
  //   }
  // }

  public void addShipToDock(Ship s) {
    this.s = s;
    System.out.println("Ship is Now Docked!");
  }

  public String toString() {
    return super.toString() + " " + dockedShip;
  }
}
