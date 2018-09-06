public class PassengerShip extends Ship {
  int numberOfOccupiedRooms;
  int numberOfPassengers;
  int numberOfRooms;

  public PassengerShip(String name, int index, int parent, double weight, double length, double width, double draft,
  int numberOfOccupiedRooms, int numberOfPassengers, int numberOfRooms) {
    super(name, index, parent, weight, length, width, draft);
    this.numberOfOccupiedRooms = numberOfOccupiedRooms;
    this.numberOfPassengers = numberOfPassengers;
    this.numberOfRooms = numberOfRooms;
  }

  public String toString() {
    return "Passenger Ship: " + this.name + " " + this.index;
  }
}
