package Eksamener.Kont2016;

public enum Grade {
    A(5), B(4), C(3), D(2), E(1), F(0);

    public final int value;

    private Grade(int s) {
        this.value = s;
    }

}