public abstract class Creature implements Showable{

    private Size size;
    private String name;
    private Area myArea;

    public Creature(String name){
        if(name == null){
            throw new NullLine("Empty name");
        }
        this.name = name;
    }

    public void setArea(Area area){
        myArea = area;
        area.addObject(this);
    }

    @Override
    public void show(String s, TextPosition pos){
        if(pos == TextPosition.AFTER){
            System.out.printf("%1$s %2$s ", this.getName(), s);
        }
        if(pos == TextPosition.BEFORE) {
            System.out.printf("%1$s %2$s ", s, this.getName());
        }
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Area getArea(){
        return myArea;
    }

    public String getName(){
        return name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
