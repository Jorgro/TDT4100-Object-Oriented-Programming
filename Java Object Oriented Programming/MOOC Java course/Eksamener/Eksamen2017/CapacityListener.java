package Eksamener.Eksamen2017;

public interface CapacityListener {
    /**
    * Called to inform that a Diner has changed capacity
    * @param diner
    */
    public void capacityChanged(Diner diner);
}