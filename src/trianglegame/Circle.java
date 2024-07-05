package trianglegame;

/**
 *
 * @author sfinarel
 */
public class Circle extends Shape implements ShapeInterface {

    public Circle(int x) {
        super.setType("circle");
    }

    @Override
    public void printShape() {
        System.out.println("Type: " + super.getType());
        super.x = this.x;
    }

    //Canvas movement 2x
    @Override
    public void action() {
        new MyCanvas(null).moving *= 2;
    }
}
