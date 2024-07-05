package trianglegame;

/**
 *
 * @author sfinarel
 */
public class Rhombus extends Shape implements ShapeInterface {

    public Rhombus(int x) {
        super.setType("rhombus");
    }

    @Override
    public void printShape() {
        System.out.println("Type: " + super.getType());
        super.x = this.x;
    }

    //Changes the backround color.
    @Override
    public void action() {

    }

}
