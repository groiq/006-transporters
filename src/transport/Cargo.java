package transport;

public class Cargo {
	
	String label;
	CargoType state;
	double weight;
	
	Cargo(String label, CargoType state, double weight) {
		this.label = label;
		this.state = state;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Cargo [label=" + label + ", state=" + state + ", weight=" + weight + "]";
	}
	
}
