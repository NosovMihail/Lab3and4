public class PrimevalRock extends Thing{
    public PrimevalRock(String name){
        super(name);
    }

    public void rise(){
        System.out.printf("%1$s вздымали из моря свои отшлифованные спины. \n", this.getName());
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
