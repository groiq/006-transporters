package transport;

public class ContainerTruck extends Transporter {

	public ContainerTruck(String id, double maxWeight, double costPerKm, Location firstLocation) {
		super(id, maxWeight, costPerKm, firstLocation);
		
	}

	@Override
	double goTo(Location destination) {
		// use proper method from location
		if (this.getLocation().reachableOverland(destination)) {
//		if (Country.landConnected(this.getLocation().getCountry(), destination.getCountry())) {
			return super.goTo(destination);
		} else {
			throw new IllegalArgumentException("Error: " + this.getId() + " is a truck and cannot travel overseas.");
		}
	}
}
