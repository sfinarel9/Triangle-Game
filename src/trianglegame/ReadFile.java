package trianglegame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sfinarel
 */
public class ReadFile {

    Scanner inputReader = null;
    ArrayList<Integer> xthesis = new ArrayList<Integer>();
    ArrayList<String> shape = new ArrayList<String>();
    Shape[] shapes = new Shape[6];
    int count = 0;
    String str;

    public ReadFile() {
        try {
            inputReader = new Scanner(new FileInputStream("myTxt.txt")); //Read the text
        } catch (FileNotFoundException e) {
            System.out.println("File myTxt.txt was not found");
            System.out.println("or could not be opened.");
            System.exit(0);
        }
        while (inputReader.hasNextLine()) {                 //Group each information by its number of line 
            count++;
            switch (count) {
                case 1:
                    str = inputReader.nextLine();
                    shape.add(str);
                    break;
                case 2:
                    str = inputReader.nextLine();
                    xthesis.add(Integer.parseInt(str));
                    count -= 2;
                    break;
            }

        }
        inputReader.close();
        int x = 0;
        for (String element : shape) {                           //Create my shapes
            switch (element) {
                case "rhombus":
                    shapes[x] = new Rhombus(xthesis.get(x));
                    break;
                case "square":
                    shapes[x] = new Square(xthesis.get(x));

                    break;
                case "circle":
                    shapes[x] = new Circle(xthesis.get(x));
                    break;
                case "finalLine":
                    shapes[x] = new Line(xthesis.get(x));
                    break;
            }
            x++;
        }
    }
}
