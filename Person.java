public class Person extends Thing {
  String skill;

  public Person(String name, int index, int parent, String skill) {
    super(name, index, parent);
    this.skill = skill;
  }

  public String toString() {
    return super.toString() + " " + skill;
  }
}
