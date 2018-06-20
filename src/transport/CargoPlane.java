package transport;

public class CargoPlane extends Transporter {
	
	final double airportCost;

	public CargoPlane(String id, double maxWeight, double costPerKm, double airportCost, Location firstLocation) {
		super(id, maxWeight, costPerKm, firstLocation);
		this.airportCost = airportCost;
	}

	double getAirportCost() {
		return airportCost;
	}

	@Override
	double goTo(Location destination) {
		// TODO Auto-generated method stub
		return super.goTo(destination) + this.getAirportCost();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toStringStart() + "airport cost: " + this.getAirportCost() + ", " + super.toStringEnd();
	}
	
}
