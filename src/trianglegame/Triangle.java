package trianglegame;

/**
 *
 * @author sfinarel
 */
public class Triangle extends Shape implements ShapeInterface {

    //my pawn , jumps when right time
    public Triangle(int x) {
        super.setType("triangle");
        super.x = this.x;
    }

    @Override
    public void printShape() {
        System.out.println("Type: " + super.getType());
    }

    @Override
    public void action() {
    }

}
