public class Dock extends Thing {
  int dockedShip;

  public Dock(String name, int index, int parent, int dockedShip) {
    super(name, index, parent);
    this.dockedShip = dockedShip;
  }

  public String toString() {
    return super.toString() + " " + dockedShip;
  }
}
