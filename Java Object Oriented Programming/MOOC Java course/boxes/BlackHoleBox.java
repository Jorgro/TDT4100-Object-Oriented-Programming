package boxes;


public class BlackHoleBox extends Box {


    public BlackHoleBox() {

    }
    @Override
    public void add(Thing thing) {

    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return false;
    }

    public static void main(String[] args) {
        BlackHoleBox box = new BlackHoleBox();
        box.add(new Thing("Saludo", 5));
        box.add(new Thing("Pirkka", 5));

        System.out.println(box.isInTheBox(new Thing("Saludo")));
        System.out.println(box.isInTheBox(new Thing("Pirkka")));
    }

}


