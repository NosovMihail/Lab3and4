import java.util.ArrayList;

public class Map {
    ArrayList<Area> listOfAreas = new ArrayList<>();

    public Map(ArrayList<Area> areasToGenerate, int numberOfAreas, GenerationType genType) {
        if (areasToGenerate.size() > numberOfAreas) {
            throw new AreasNumberException("Количество генерируемых мест меньше колчества обязательных для генерации");
        }
        int randomAreas = numberOfAreas - areasToGenerate.size();
        if (GenerationType.ISLAND == genType) {
            int n = (int)Math.sqrt(numberOfAreas);
            int spread = n*n - numberOfAreas;
            Area[][] minimap = new Area[n+2][n+2];
            int s = 0;
            int p = 0;
            int crit = 0;
            for(int i = 0; i < spread; i++){
                int x = (int)(2*(Math.random()));
                int y = (int)(n*(Math.random()));
                if(Math.random() >= 0.5){
                    if(x == 1){
                        if(minimap[n][y+1] == null){
                            minimap[n][y+1] = new Sea();
                        }
                    }else {
                        if(minimap[1][y+1] == null){
                            minimap[1][y+1] = new Sea();
                        }
                    }
                }else{
                    if(x == 1){
                        if(minimap[y+1][n] == null){
                            minimap[y+1][n] = new Sea();
                        }
                    }else {
                        if(minimap[y+1][1] == null){
                            minimap[y+1][1] = new Sea();
                        }
                    }
                }
            }
            for(int i = 0; i < n+2; i++){
                for(int j = 0; j < n+2; j++){
                    if((i == 0)||(j == 0)||(i == n+1)||(j == n+1)){
                        if((getOnTypeAll(areasToGenerate, AreaType.SEA) != null)&&(getOnTypeAll(areasToGenerate, AreaType.SEA).size() > s)){
                            minimap[i][j] = getOnTypeAll(areasToGenerate, AreaType.SEA).get(s);
                            listOfAreas.add(minimap[i][j]);
                            s++;
                        }else {
                            s = 0;
                            minimap[i][j] = new Sea();
                        }
                    } else if(((i == 1)||(j == 1)||(i == n)||(j == n))&&(minimap[i][j] == null)){
                        if((getOnTypeAll(areasToGenerate, AreaType.SHORE) != null)&&(getOnTypeAll(areasToGenerate, AreaType.SHORE).size() > p)){
                            minimap[i][j] = getOnTypeAll(areasToGenerate, AreaType.SHORE).get(p);
                            listOfAreas.add(minimap[i][j]);
                            p++;
                        }else {
                            if(randomAreas <= 0){
                                for(int k = 0; k < areasToGenerate.size(); k++) {
                                    if (listOfAreas.contains(areasToGenerate.get(crit))) {
                                        crit++;
                                    } else {
                                        minimap[i][j] = areasToGenerate.get(crit);
                                        listOfAreas.add(areasToGenerate.get(crit));
                                        crit++;
                                        break;
                                    }
                                }
                            }else {
                                minimap[i][j] = new Area(AreaType.getTypeName(AreaType.SHORE), AreaType.SHORE);
                                randomAreas--;
                            }
                        }
                    }else {
                        if(crit < areasToGenerate.size()) {
                            for (int k = 0; k < areasToGenerate.size(); k++) {
                                if (listOfAreas.contains(areasToGenerate.get(crit))) {
                                    crit++;
                                } else {
                                    minimap[i][j] = areasToGenerate.get(crit);
                                    listOfAreas.add(areasToGenerate.get(crit));
                                    crit++;
                                    break;
                                }
                            }
                        } else {
                            AreaType[] types = {AreaType.MOUNTAIN, AreaType.FOREST, AreaType.SWAMP, AreaType.FIELD, AreaType.LAKE};
                            AreaType type = randomType(types);
                            minimap[i][j] = new Area(AreaType.getTypeName(type), type);
                            randomAreas--;
                        }
                    }
                }
            }
            for(int i = 0; i < n + 2; i++) {
                for (int j = 0; j < n + 2; j++) {
                    if((i < n+1)&&(j < n+1)){
                        minimap[i][j].addObject(minimap[i][j+1], AreaPart.EAST);
                        minimap[i][j].addObject(minimap[i+1][j], AreaPart.SOUTH);
                    }
                    if(!listOfAreas.contains(minimap[i][j])){
                        listOfAreas.add(minimap[i][j]);
                    }
                }
            }
            for(int i = 0; i < n + 2; i++) {
                for (int j = 0; j < n + 2; j++) {
                    System.out.print(minimap[i][j].getName() + "\t");
                }
                System.out.println();
            }
        }
        System.out.println("finished");
    }

    public AreaType randomType(AreaType[] types) {
        return types[(int) (Math.random() * types.length)];
    }

    public AreaPart randomPart(AreaPart[] parts) {
        return parts[(int) (Math.random() * parts.length)];
    }

    public AreaPart randomPart(ArrayList<AreaPart> parts) {
        return parts.get((int) (Math.random() * parts.size()));
    }

    public Area getOnType(ArrayList<Object> areas, AreaType type) {
        for (Object area : areas) {
            if ((area.getClass() == Area.class) && (((Area) area).getType() == type)) {
                return (Area) area;
            }
        }
        return null;
    }

    public Area getOnType(AreaType type, ArrayList<Area> areas) {
        for (Area area : areas) {
            if (area.getType() == type) {
                return area;
            }
        }
        return null;
    }

    public ArrayList<Area> getOnTypeAll(ArrayList<Area> areas, AreaType type) {
        ArrayList<Area> result = new ArrayList<>();
        for (Area area : areas) {
            if (area.getType() == type) {
                result.add(area);
            }
        }
        return result;
    }

    public boolean isFree(Area area, AreaPart part) {
        ArrayList<Object> obj = area.getObjects(part);
        for (int i = 0; i < obj.size(); i++) {
            if (obj.get(i).getClass() == Area.class) {
                return false;
            }
        }
        return true;
    }
}
