public class UncownCreature extends Creature implements LookingFor, Movable{

    private Count count;

    public UncownCreature(String name) {
        super(name);
    }

    public void split(){
        if(this.getCount() == Count.SEVERAL){
            System.out.printf("%1$s разделились. \n", this.getName());
        }
    }

    public void goLookingFor(Area area, Thing thing, boolean showDescription){
        if(this.getCount() == Count.ONE) {
            System.out.printf("%1$s отправляется на поиски. \n", this.getName());
        }else {
            System.out.printf("%1$s отправляются на поиски. \n", this.getName());
        }
        this.moveToArea(area);
    }

    public Count getCount() {
        return count;
    }

    public void setCount(Count count) {
        this.count = count;
    }

    public void make(String s){
        if(this.getCount() == Count.ONE) {
            System.out.printf("%1$s сделали %2$s. \n", this.getName(), s);
        }else {
            System.out.printf("%1$s сделали %2$s. \n", this.getName(), s);
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
    public void moveToArea(Area area) {
        if(this.getArea() != null) {
            if(area != null) {
                getArea().removeObject(this);
                if (this.getCount() == Count.ONE) {
                    System.out.printf("%1$s перешло из %2$s в %3$s. \n", getName(), getArea().getName(), area.getName());
                } else if (this.getCount() == Count.SEVERAL) {
                    System.out.printf("%1$s перешло из %2$s в %3$s. \n", getName(), getArea().getName(), area.getName());
                }
                setArea(area);
            } else {
                getArea().removeObject(this);
                if (this.getCount() == Count.ONE) {
                    System.out.printf("%1$s ушло в неизвестном направлении. \n", getName());
                } else if (this.getCount() == Count.SEVERAL) {
                    System.out.printf("%1$s ушли в неизвестном направлении. \n", getName());
                }
            }
        } else {
            if (area != null) {
                if (this.getCount() == Count.ONE) {
                    System.out.printf("%1$s появилось в %2$s. \n", getName(), area.getName());
                } else if (this.getCount() == Count.SEVERAL) {
                    System.out.printf("%1$s появились в %2$s. \n", getName(), area.getName());
                }
                setArea(area);
            } else {
                if (this.getCount() == Count.ONE) {
                    System.out.printf("%1$s пошло куда-то. \n", getName());
                } else if (this.getCount() == Count.SEVERAL) {
                    System.out.printf("%1$s пошли куда-то. \n", getName());
                }
            }
        }
    }
}
