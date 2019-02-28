public class Wind extends Thing{

    public Wind(String name){
        super(name);
    }

    public Wind(){
        super("ветер");
    }

    public void blow(){
        boolean hasPlants = false;
        for(int i = 0; i < getArea().getObjects().size(); i++){
            if(getArea().getObjects().get(i).getClass() == Plant.class){
                hasPlants = true;
                break;
            }
        }
        if(hasPlants){
            System.out.printf("В стеблях растений, растущих на %2$s, шалестит и посвистывает %1$s. \n", this.getName(), getArea().getName());
        }else {
            System.out.printf("На %2$s дует %1$s. \n", this.getName(), getArea().getName());
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
}
