package transport;

import static transport.CargoType.*;


public class TankTruck extends ContainerTruck {
	
//	final CargoType cargoType = liquid;

	public TankTruck(String id, double maxWeight, double costPerKm, Location firstLocation) {
		super(id, maxWeight, costPerKm, firstLocation);
//		this.cargoType = liquid;
		
	}

	@Override
	CargoType getCargoType() {
		return liquid;
	}
	
	
	
	

}
