package transport;

import static transport.CargoType.*;

import inout.Out;

abstract class Transporter {
	
	public final String id;
	public final double maxWeight;
	public final double costPerKm;
	
	// default to solid goods; Tank truck will override this
//	public final CargoType cargoType = solid;
	
	public Location location;
	public Cargo cargo;
	
	public Transporter(String id, double maxWeight, double costPerKm, Location firstLocation) {
		this.id = id;
		this.maxWeight = maxWeight;
		this.costPerKm = costPerKm;
		this.cargo = null;
		this.location = firstLocation;
		
	}
	
	Location getLocation() {
		return location;
	}

	void setLocation(Location location) {
		this.location = location;
	}

	Cargo getCargo() {
		return cargo;
	}

	void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	String getId() {
		return id;
	}

	double getMaxWeight() {
		return maxWeight;
	}

	double getCostPerKm() {
		return costPerKm;
	}
	
	CargoType getCargoType() {
		return solid;
	}
	
	String toStringStart() {
		return this.id + ": " + this.getCostPerKm() + " E/km, ";
	}
	
	String toStringEnd() {
		return "max. " + this.getMaxWeight() + " kg, in " + this.getLocation().getName() + ", cargo: " + this.shortCargo() + ".";
	}
	
		private String shortCargo() {
		if (this.getCargo() == null) {
			return "nothing";
		} else {
			return this.getCargo().getWeight() + " kg of " + this.getCargo().getLabel();
		}
	}



		@Override
	public String toString() {
		return this.toStringStart() + this.toStringEnd();
	}



	double goTo(Location destination) {
		double result = location.getDistance(destination);
		result = result * costPerKm;
		location = destination;
		return result;
	}
	
	void load(Cargo cargo) {
		if (this.getCargo() != null) {
			throw new IllegalStateException("Error: " + this.getId() + " is already carrying cargo.");
		} else if (cargo.getCargoType() != this.getCargoType()) {
			throw new IllegalArgumentException("Error: " + this.getId() + " is made for " + this.getCargoType() + " goods, but "
					+ cargo.getLabel() + " is " + cargo.getCargoType() + ".");
		} else if (cargo.getWeight() > this.getMaxWeight()) {
			throw new IllegalArgumentException("Error: " + cargo.getWeight() + " exceeds the maximum payload for " + this.getId() + ".");
		} else {
			this.setCargo(cargo);
		}
	}
	
	Cargo unload() {
		Cargo result = this.cargo;
		if (result != null) {
			this.cargo = null;
		} else {
			throw new NullPointerException("Error: " + this.getId() + " isn't carrying anything.");
		}
		return result;
	}
	

}
