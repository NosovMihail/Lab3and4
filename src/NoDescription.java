public class NoDescription extends Exception {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public NoDescription(String message){
        super(message);
    }
}
