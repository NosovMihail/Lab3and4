import java.util.ArrayList;

public class Area implements Showable{

    private String name;
    private AreaType type;
    private Size size;
    private Area parent;
    private ArrayList<Object> northObjects = new ArrayList<Object>();
    private ArrayList<Object> southObjects = new ArrayList<Object>();
    private ArrayList<Object> westObjects = new ArrayList<Object>();
    private ArrayList<Object> eastObjects = new ArrayList<>();
    private ArrayList<Object> centerObjects = new ArrayList<Object>();
    private String description;
    private boolean passable;

    public Area (){
        name = "где-то";
        passable = true;
    }

    public Area (String name){
        if(name == null){
            throw new NullLine("Empty name");
        }
        passable = true;
        this.name = name;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public Area (String name, AreaType type){
        if(name == null){
            throw new NullLine("Empty name");
        }
        setType(type);
        passable = true;
        this.name = name;
    }

    public void setType(AreaType type) {
        this.type = type;
    }

    public AreaType getType() {
        return type;
    }

    public void setPassable(boolean passable) {
        this.passable = passable;
    }

    public boolean isPassable() {
        return passable;
    }

    public void addObject(Object object, AreaPart part){
        if(object != null) {
            if (part == AreaPart.NORTH) {
                if (((object.getClass().equals(Area.class))||(object.getClass().getSuperclass().equals(Area.class))) && (!northObjects.contains(object))) {
                    if(!northObjects.contains(object)) {
                        northObjects.add(object);
                        ((Area) object).addObject(this, AreaPart.SOUTH);
                    }
                } else {
                    northObjects.add(object);
                }
            }
            if (part == AreaPart.SOUTH) {
                if ((object.getClass().equals(Area.class))||(object.getClass().getSuperclass().equals(Area.class))) {
                    if(!southObjects.contains(object)) {
                        southObjects.add(object);
                        ((Area) object).addObject(this, AreaPart.NORTH);
                    }
                } else {
                    southObjects.add(object);
                }
            }
            if (part == AreaPart.WEST) {
                if ((object.getClass().equals(Area.class))||(object.getClass().getSuperclass().equals(Area.class))) {
                    if(!westObjects.contains(object)) {
                        westObjects.add(object);
                        ((Area) object).addObject(this, AreaPart.EAST);
                    }
                } else {
                    westObjects.add(object);
                }
            }
            if (part == AreaPart.EAST) {
                if ((object.getClass().equals(Area.class))||(object.getClass().getSuperclass().equals(Area.class))) {
                    if(!eastObjects.contains(object)) {
                        eastObjects.add(object);
                        ((Area) object).addObject(this, AreaPart.WEST);
                    }
                } else {
                    eastObjects.add(object);
                }
            }
            if (part == AreaPart.CENTER) {
                if (((object.getClass().equals(Area.class))||(object.getClass().getSuperclass().equals(Area.class))) && (!centerObjects.contains(object))) {
                    ((Area) object).setParent(this);
                }
                centerObjects.add(object);
            }
        }
    }

    public void addObject(Object object){
        if(object != null) {
            centerObjects.add(object);
        }
    }

    public void removeObject(Object object){
        centerObjects.remove(object);
    }

    public String getName() {
        return name;
    }

    public void setParent(Area parent) {
        this.parent = parent;
    }

    public Area getParent() {
        return parent;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void showDescription() throws NoDescription {
        if(description.equals("")){
            throw new NoDescription("Area have no description");
        }
        System.out.printf("%1$s \n", description);
    }

    public ArrayList<Object> getObjects(){
        ArrayList<Object> objects = new ArrayList<>();
        objects.addAll(northObjects);
        objects.addAll(southObjects);
        objects.addAll(westObjects);
        objects.addAll(eastObjects);
        objects.addAll(centerObjects);
        return objects;
    }

    public ArrayList<Object> getObjects(AreaPart part){
        if(part == AreaPart.NORTH){
            return northObjects;
        }
        if(part == AreaPart.SOUTH){
            return southObjects;
        }
        if(part == AreaPart.WEST){
            return westObjects;
        }
        if(part == AreaPart.EAST){
            return eastObjects;
        }
        if(part == AreaPart.CENTER){
            return centerObjects;
        }
        return null;
    }

    @Override
    public String toString(){
        return this.getName();
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
    public void show(String s, TextPosition pos) {
        if(pos == TextPosition.BEFORE) {
            System.out.printf("%1$s %2$s ", s, this.getName());
        }
        if(pos == TextPosition.AFTER){
            System.out.printf("%1$s %2$s ", this.getName(), s);
        }
    }
}
