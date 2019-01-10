package boxes;

public class OneThingBox extends Box {
    private Thing[] thing;

    public OneThingBox() {
        
    }
    @Override
    public void add(Thing thing) {
        if (this.thing == null) {
            this.thing = new Thing[]{thing};

        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return thing.equals(this.thing[0]);
    }

    public static void main(String[] args) {
        OneThingBox box = new OneThingBox();
        box.add(new Thing("Saludo", 5));
        box.add(new Thing("Pirkka", 5));

        System.out.println(box.isInTheBox(new Thing("Saludo")));
        System.out.println(box.isInTheBox(new Thing("Pirkka")));
    }
}