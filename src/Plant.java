public class Plant extends Creature{

    private boolean group;

    public Plant(String name){
        super(name);
        setSize(Size.NORMAL);
        group = false;
    }

    public Plant(String name, Size size){
        super(name);
        setSize(size);
        group = false;
    }

    public Plant(String name, Size size, boolean group){
        super(name);
        setSize(size);
        this.group = group;
    }

    public void grow(){
        if(group) {
            System.out.printf("Hа %2$s растут %1$s. \n", this.getName(), this.getArea().getName());
        }else {
            System.out.printf("Hа %2$s растёт %1$s. \n", this.getName(), this.getArea().getName());
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

    public void wobble(){
        if(group){
            System.out.printf("%1$s раскачиваются. \n", this.getName());
        }else {
            System.out.printf("%1$s раскачивается. \n", this.getName());
        }
    }
}
