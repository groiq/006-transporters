package transport;

public class Cargo {
	
	String label;
	CargoType cargoType;
	double weight;
	
	Cargo(String label, CargoType cargoType, double weight) {
		this.label = label;
		this.cargoType = cargoType;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Cargo [label=" + label + ", state=" + cargoType + ", weight=" + weight + "]";
	}
	
}
