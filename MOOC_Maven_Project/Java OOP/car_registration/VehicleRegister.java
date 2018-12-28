package car_registration;

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

    public void printRegistration
}