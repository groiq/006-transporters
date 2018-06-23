package transport;

import static transport.CargoType.*;
import static transport.Country.*;

import java.util.EnumMap;

import inout.Out;

public class TransportMain {
	
	static Location linz = new Location("Linz", 0, 0, Austria);
	static Location paris = new Location("Paris", 300, 400, France);
	static Location ny = new Location("NY", 8000, 0, USA);
	
	static Cargo solidNormal = new Cargo("ordinary solid cargo", solid, 10);
	static Cargo solidExcess = new Cargo("excess solid cargo", solid, 10);
	static Cargo solidHeavy = new Cargo("overweight solid cargo", solid, 1000);
	static Cargo liquidNormal = new Cargo("ordinary liquid cargo", liquid, 10);
	static Cargo liquidExcess = new Cargo("excess liquid cargo", liquid, 10);
	static Cargo liquidHeavy = new Cargo("overweight liquid cargo", liquid, 1000);

	static Cargo[] solidCargos = { solidNormal, solidExcess, solidHeavy, liquidNormal };
	static Cargo[] liquidCargos = { liquidNormal, liquidExcess, liquidHeavy, solidNormal };

	static ContainerTruck wallE = new ContainerTruck("Wall.E", 100, 100, linz);
	static TankTruck rumRunner = new TankTruck("RumRunner", 100, 100, linz);
	static CargoPlane fireFlash = new CargoPlane("Fireflash", 100, 100, 100, linz);

	static int totalCost = 0;
	static Cargo lastUnload;
	
	
	public static void testAll(Transporter trans) {
		Out.println("## Testing transporter: " + trans.toString());
		Cargo[] cargos;
		if (trans.getCargoType() == solid) {
			cargos = solidCargos;
		} else {
			cargos = liquidCargos;
		}
		Out.println("# Loading with ordinary cargo... ");
		try {
			trans.load(cargos[0]);
			Out.println("OK: " + trans.toString());
		} catch (Exception e) {
			Out.println("ERROR: Unexpected exception: " + e.toString());
		}
		Out.println("# Loading while already loaded... ");
		try {
			trans.load(cargos[1]);
			Out.println("ERROR: Expected exception has not been thrown.");
		} catch (Exception e) {
			Out.println("OK: Expected: Transporter already loaded. Thrown: " + e.toString());
		}
		Out.println("# Unloading...");
		try {
			lastUnload = trans.unload();
			Out.println("OK: " + trans.toString() + "; unloaded: " + lastUnload);
		} catch (Exception e) {
			Out.println("ERROR: Unexpected exception: " + e.toString());
		}
		Out.println("# Unloading while unloaded...");
		try {
			lastUnload = trans.unload();
			Out.println("ERROR: expected exception not thrown.");
		} catch (Exception e) {
			Out.println("OK: Expected: unloading while unloaded. Thrown: " + e.toString());
		}
		Out.println("# Loading overweight cargo...");
		try {
			trans.load(cargos[2]);
			Out.println("ERROR: Expected exception not thrown.");
		} catch (Exception e) {
			Out.println("OK: Expected: overweight cargo. Thrown: " + e.toString());
		}
		Out.println("# Loading wrong cargo type...");
		try {
			trans.load(cargos[3]);
			Out.println("ERROR: Expected exception not thrown.");
		} catch (Exception e) {
			Out.println("OK: Expected: Wrong cargo type. Thrown: " + e.toString());
		}
		Out.println("# Travelling over land...");
		try {
			totalCost += trans.goTo(paris);
			Out.println("OK: " + trans.toString() + "; total cost: " + totalCost);
		} catch (Exception e) {
			Out.println("ERROR: unexpected exception: " + e.toString());
		}
		Out.println("# Travelling overseas...");
		if (trans instanceof transport.CargoPlane) {
			try {
				totalCost += trans.goTo(ny);
				Out.println("OK: " + trans.toString() + "; total cost: " + totalCost);
			} catch (Exception e) {
				Out.println("ERROR: unexpected exception: " + e.toString());
			}
		} else {
			try {
				totalCost += trans.goTo(ny);
				Out.println("ERROR: Expected exception not thrown.");
			} catch (Exception e) {
				Out.println("OK: Expected: truck cannot travel overseas. Thrown: " + e.toString());
			}
		}
		
		Out.println();
	}

	public static void main(String[] args) {
		
		testAll(wallE);
		testAll(rumRunner);
		testAll(fireFlash);

	}

}
