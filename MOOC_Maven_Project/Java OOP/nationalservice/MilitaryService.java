
package nationalservice;

public class MilitaryService implements NationalService {
    private int daysLeft;

    public MilitaryService(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public void work() {
        if (this.daysLeft > 0) {
            this.daysLeft --;
        }
    }

    public int getDaysLeft() {
        return this.daysLeft;
    }
}