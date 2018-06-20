package transport;

public class CargoPlane extends Transporter {
	
	final double airportCost;

	public CargoPlane(String id, double maxWeight, double costPerKm, double airportCost, Location firstLocation) {
		super(id, maxWeight, costPerKm, firstLocation);
		this.airportCost = airportCost;
		// TODO Auto-generated constructor stub
	}

	double getAirportCost() {
		return airportCost;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	double goTo(Location destination) {
		// TODO Auto-generated method stub
		return super.goTo(destination) + this.getAirportCost();
	}
	
	

}
