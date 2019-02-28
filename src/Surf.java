public class Surf extends Thing {
    public Surf(String name){
        super(name);
    }

    public static class Beats{
        String description;

        public Beats(String s){
            description = s;
        }

        public void makeBeat(Thing thing){
            System.out.printf("%1$s бьёт %2$s \n", thing.getName(), description);
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
}
