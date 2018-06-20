package transport;

import inout.Out;

public class ContainerTruck extends Transporter {

	public ContainerTruck(String id, double maxWeight, double costPerKm, Location firstLocation) {
		super(id, maxWeight, costPerKm, firstLocation);
		
	}

	@Override
	public String toString() {
		return this.getId() + ", currently in " + this.getLocation() + "," + this.capacityString();
	}



	@Override
	double goTo(Location destination) {
		// use proper method from location
		if (this.getLocation().reachableOverland(destination)) {
//		if (Country.landConnected(this.getLocation().getCountry(), destination.getCountry())) {
			return super.goTo(destination);
		} else {
			Out.println("Error: cannot go overseas");
			return 0;
		}
		
	}

}
