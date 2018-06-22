package transport;

import static transport.CargoType.*;
import static transport.Country.*;

import inout.Out;

public class TransportMain {
	
	public static void printGeneric(Transporter trans) {
		Out.println(trans.id);
		Out.println(trans.getMaxWeight());
	}

	public static void main(String[] args) {
		Location linz = new Location("Linz", 0, 0, Austria);
		Location paris = new Location("Paris", 300, 400, France);
		Location ny = new Location("NY", 8000, 0, USA);
		
		Cargo teddybear = new Cargo("Teddybear", solid, 30);
		Cargo eggs = new Cargo("Those eggs that never fit in", solid, 30);
		Cargo booze = new Cargo("Booze", liquid, 40);
		Cargo feather = new Cargo("Feather", solid, 5000);
		Cargo wine = new Cargo("Leichter Tischwein", liquid, 6000);

		int totalCost = 0;
		Cargo lastUnload;
		
		ContainerTruck wallE = new ContainerTruck("Wall.E", 100, 3, linz);
		try {
			wallE.load(teddybear);
			Out.println("Transporter loaded with cargo:" + wallE);
		} catch (Exception e) {
			Out.println("Unexpected exception: " + e.toString());
		}
		try {
			wallE.load(eggs);
			Out.println("Error: Expected exception has not been thrown.");
		} catch (Exception e) {
			Out.println("Expected: Already carrying cargo. Received: " + e.toString());
		}
		try {
			lastUnload = wallE.unload();
			Out.println("Transporter unloaded.");
		} catch (Exception e) {
			Out.println("Unexpected exception: " + e.toString());
		}
		try {
			lastUnload = wallE.unload();
			Out.println("Error: expected 'already unloaded' exception.");
		} catch (Exception e) {
			Out.println("Expected: already unloaded. Thrown: " + e.toString());
		}
		try {
			wallE.load(booze);
			Out.println("Error: Expected exception: wrong cargo type.");
		} catch (Exception e) {
			Out.println("Expected: wrong cargo type. Thrown: " + e.toString());
		}
		try {
			wallE.load(feather);
			Out.println("Error: Expected exception: overweight.");
		} catch (Exception e) {
			Out.println("Expected: overweight. Thrown: " + e.toString());
		}
		try {
			totalCost += wallE.goTo(paris);
			Out.println(wallE.getId() + " traveled to " + wallE.getLocation() + ". Total cost now" + totalCost + ".");
		} catch (Exception e) {
			Out.println("Error: unexpected exception: " + e.toString());
		}
		
		
		
//		wallE.load(booze);
//		wallE.unload();
//		wallE.load(booze);
//		wallE.load(feather);
//		totalCost += wallE.goTo(paris);
//		totalCost += wallE.goTo(ny);
//		Out.println(wallE);
//		Out.println(totalCost);
//		lastUnload = wallE.unload();
//		Out.println(lastUnload);
//		Out.println();

		TankTruck rumRunner = new TankTruck("RumRunner", 100, 200, linz);
//		rumRunner.load(booze);
//		rumRunner.load(teddybear);
//		totalCost += rumRunner.goTo(paris);
//		totalCost += rumRunner.goTo(ny);
//		Out.println(rumRunner);
//		Out.println(totalCost);
//		lastUnload = rumRunner.unload();
//		Out.println(lastUnload);
//		Out.println();
//
//		CargoPlane fireflash = new CargoPlane("Fireflash", 100, 100, 100, linz);
//		fireflash.load(booze);
//		fireflash.load(teddybear);
//		totalCost += fireflash.goTo(paris);
//		totalCost += fireflash.goTo(ny);
//		Out.println(fireflash);
//		Out.println(totalCost);
//		lastUnload = fireflash.unload();
//		Out.println(lastUnload);
//		Out.println();
		
		

	}

}
