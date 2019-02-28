public class Sea extends Area{
    public Sea(){
        super("море");
        setType(AreaType.SEA);
        setPassable(false);
    }

    public void through(Area area, Thing thing){
        this.removeObject(thing);
        area.addObject(thing);
        System.out.printf("Море выбросило %1$s на %2$s. \n", thing.getName(), area.getName());
    }

    public Class getParentClass(){
        return Area.class;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
