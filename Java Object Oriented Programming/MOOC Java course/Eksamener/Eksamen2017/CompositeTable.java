package Eksamener.Eksamen2017;

public class CompositeTable extends Table {

    private Table tab1, tab2;

    public CompositeTable(Table tab1, Table tab2, int lostCapacity) {
        super(tab1.getNum() + tab2.getNum() - lostCapacity);
        this.tab1 = tab1;
        this.tab2 = tab2;
    }

    public Table getTab1() {
        return tab1;
    }

    public Table getTab2() {
        return tab2;
    }
}