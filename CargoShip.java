public class CargoShip extends Ship {
  double cargoWeight;
  double cargoVolume;
  double cargoValue;

  public CargoShip(String name, int index, int parent, double weight, double length, double width, double draft,
  double cargoWeight, double cargoVolume, double cargoValue) {
    super(name, index, parent, weight, length, width, draft);
    this.cargoWeight = cargoWeight;
    this.cargoVolume = cargoVolume;
    this.cargoValue = cargoValue;
  }

  public String toString() {
    return "Cargo Ship: " + this.name + " " + this.index;
  }
}
