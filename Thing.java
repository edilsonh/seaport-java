public class Thing implements Comparable<Thing> {
  String name;
  int index;
  int parent;

  public Thing(String name, int index, int parent) {
    this.name = name;
    this.index = index;
    this.parent = parent;
  }

  public int compareTo(Thing t){
    System.out.println("Comparing");
    return 1;
  }

  public String toString() {
    return this.name + " " + this.index + " " + this.parent;
  }
}
