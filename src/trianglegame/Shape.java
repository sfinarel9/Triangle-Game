package trianglegame;

public abstract class Shape {
//Every shape has a type and coordinates

    private String Type;
    protected int x;

    public Shape() {
    }

    public Shape(String Type) {
        this.Type = Type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void action() {
    }
;

}
