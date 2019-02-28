public enum AreaPart {
    NORTH,
    SOUTH,
    WEST,
    EAST,
    CENTER;

    static public AreaPart getOpposit(AreaPart part){
        if(part == NORTH){
            return SOUTH;
        }
        if(part == SOUTH){
            return NORTH;
        }
        if(part == EAST){
            return WEST;
        }
        if(part == WEST){
            return EAST;
        }
        return CENTER;
    }

    public static String getName(AreaPart part) {
        if(part == NORTH){
            return "север";
        }
        if(part == SOUTH){
            return "юг";
        }
        if(part == EAST){
            return "восток";
        }
        if(part == WEST){
            return "запад";
        }
        return "здесь";
    }
}
