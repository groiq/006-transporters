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

		int totalCost = 0;
		Cargo lastUnload;
		
		ContainerTruck wallE = new ContainerTruck("Wall.E", 100, 3, linz);
		wallE.load(booze);
		wallE.load(teddybear);
		totalCost += wallE.goTo(paris);
		totalCost += wallE.goTo(ny);
		Out.println(wallE);
		Out.println(totalCost);
		lastUnload = wallE.unload();
		Out.println(lastUnload);
		Out.println();

		TankTruck rumRunner = new TankTruck("RumRunner", 100, 200, linz);
		rumRunner.load(booze);
		rumRunner.load(teddybear);
		totalCost += rumRunner.goTo(paris);
		totalCost += rumRunner.goTo(ny);
		Out.println(rumRunner);
		Out.println(totalCost);
		lastUnload = rumRunner.unload();
		Out.println(lastUnload);
		Out.println();

		CargoPlane fireflash = new CargoPlane("Fireflash", 100, 100, 100, linz);
		fireflash.load(booze);
		fireflash.load(teddybear);
		totalCost += fireflash.goTo(paris);
		totalCost += fireflash.goTo(ny);
		Out.println(fireflash);
		Out.println(totalCost);
		lastUnload = fireflash.unload();
		Out.println(lastUnload);
		Out.println();
		

	}

}
