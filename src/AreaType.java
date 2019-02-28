public enum AreaType {
    MOUNTAIN,
    SHORE,
    FOREST,
    SWAMP,
    FIELD,
    RIVER,
    LAKE,
    SEA,
    ISLAND;

    static public String getTypeName(AreaType type){
        switch (type){
            case MOUNTAIN: return "Гора";
            case SHORE: return "Берег";
            case FOREST: return "Лес";
            case SWAMP: return "Болото";
            case FIELD: return "Поле";
            case RIVER: return "Река";
            case LAKE: return "Озеро";
            case SEA: return "Море";
            case ISLAND: return "Остров";
        }
        return null;
    }
}
