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

	String getLabel() {
		return label;
	}

	void setLabel(String label) {
		this.label = label;
	}

	CargoType getCargoType() {
		return cargoType;
	}

	void setCargoType(CargoType cargoType) {
		this.cargoType = cargoType;
	}

	double getWeight() {
		return weight;
	}

	void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Cargo [label=" + label + ", state=" + cargoType + ", weight=" + weight + "]";
	}
	
}
