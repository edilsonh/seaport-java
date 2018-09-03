public class Ship extends Thing {
  double weight;
  double length;
  double width;
  double draft;

  public Ship(String name, int index, int parent, double weight, double length, double width, double draft) {
    super(name, index, parent);
    this.draft = draft;
    this.length = length;
    this.weight = weight;
    this.width = width;
  }

  public String toString() {
    return super.toString() + " " + this.weight + " " + this.length + " " + this.width + " " + this.draft;
  }
}
