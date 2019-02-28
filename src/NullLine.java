public class NullLine extends IllegalArgumentException {
    public NullLine() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public NullLine(String message){
        super(message);
    }
}
