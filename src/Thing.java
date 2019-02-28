public class Thing extends Object implements Actionable, Showable{
    private String name;
    private Area area;
    private boolean visible;

    public Thing(String name){
        if(name == null){
            throw new NullLine("Empty name");
        }
        visible = true;
        this.name = name;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    public String getName(){
        return name;
    }

    public void setArea(Area area) {
        this.area = area;
        area.addObject(this);
    }

    public Area getArea() {
        return area;
    }

    public void show(String s, TextPosition pos){
        if(pos == TextPosition.BEFORE) {
            System.out.printf("%1$s %2$s ", s, this.getName());
        }
        if(pos == TextPosition.AFTER){
            System.out.printf("%1$s %2$s ", this.getName(), s);
        }
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
        return super.toString();
    }

    @Override
    public void action(String s) {
        if(s == null){
            throw new NullLine("Empty action");
        }
        System.out.printf("%1$s %2$s ", this.getName(), s);
    }
}
