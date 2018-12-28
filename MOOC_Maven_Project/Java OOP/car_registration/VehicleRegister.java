package car_registration;

import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegister {

    private HashMap<RegistrationPlate, String> register;

    public VehicleRegister() {
        this.register = new HashMap<RegistrationPlate, String>();
    }

    public boolean add(RegistrationPlate plate, String owner) {
        if (!this.register.containsKey(plate)) {
            this.register.put(plate, owner);
        }
        return false;
    }

    public boolean delete(RegistrationPlate plate) {
        if (this.register.containsKey(plate)) {
            this.register.remove(plate);
            return true;
        }
        return false;
    }

    public String get(RegistrationPlate plate) {
        if (this.register.containsKey(plate)) {
            return this.register.get(plate);
        }
        return null;
    } 

    public void printRegistration() {
        for (RegistrationPlate plate : this.register.keySet()) {
            System.out.println(plate);
        }
    }

    public void printOwners() {
        ArrayList<String> owners = new ArrayList<String>();
        
        for (String owner : this.register.values()) {
            if (!owners.contains(owner)) {
                owners.add(owner);
            }
        }

        for (String owner : owners) {
            System.out.println(owner);
        }
    }

    public static void main(String[] args) {

        RegistrationPlate plate1 = new RegistrationPlate("290", "NO");
        RegistrationPlate plate2 = new RegistrationPlate("298", "NO");
        RegistrationPlate plate3 = new RegistrationPlate("299", "NO");

        VehicleRegister register = new VehicleRegister();
        register.add(plate1, "Jørgen");
        register.add(plate2, "Jørgen");
        register.add(plate3, "Rasmus");

        register.printRegistration();
        register.printOwners();

        register.delete(plate3);
        register.printOwners();

    }
}