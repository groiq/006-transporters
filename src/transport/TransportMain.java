package transport;

import static transport.CargoType.*;
import static transport.Country.*;

import inout.Out;

public class TransportMain {

	public static void main(String[] args) {
		Location linz = new Location("Linz", 0, 0, Austria);
		Location paris = new Location("Paris", 300, 400, France);
		Location ny = new Location("NY", 8000, 0, USA);
		
		Cargo teddybear = new Cargo("Teddybear", solid, 300);
		Cargo booze = new Cargo("Booze", liquid, 40);
		
		ContainerTruck wallE = new ContainerTruck("Wall.E", 100, 3, linz);
		int totalCost = 0;
		wallE.load(teddybear);
		totalCost += wallE.goTo(paris);
		Out.println(wallE);
		Cargo inParis = wallE.unload();
		Out.println(totalCost);
		Out.println(inParis);
		totalCost += wallE.goTo(ny);
		wallE.load(booze);
		
		
		TankTruck rumRunner = new TankTruck("RumRunner", 100, 200, paris);
		rumRunner.load(booze);
		rumRunner.load(teddybear);
		Out.println(rumRunner);

	}

}
