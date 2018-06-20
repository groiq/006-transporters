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
	
		@Override
	public String toString() {
		return "Transporter [id=" + id + ", maxWeight=" + maxWeight + ", costPerKm=" + costPerKm + ", cargoType="
				+ this.getCargoType() + ", location=" + location + ", cargo=" + cargo + "]";
	}



	double goTo(Location destination) {
		double result = location.getDistance(destination);
		result = result * costPerKm;
		location = destination;
		return result;
	}
	
	void load(Cargo cargo) {
		if (cargo.cargoType == this.getCargoType()) {
			// replace with proper exception handling down the line
			// Also: raise an error if transporter is already carrying cargo
			// calculate weights?
			this.cargo = cargo;
		} else {
			Out.println("Error: wrong cargo type:" + cargo.label + " on " + this.id);
		}
	}
	
	Cargo unload() {
		Cargo result = this.cargo;
		this.cargo = null;
		return result;
	}
	

}
