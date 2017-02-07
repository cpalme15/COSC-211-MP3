import javax.swing.*;

/*\
 * gooey 
 * 11/07/16
 * COSC 111
 */
public class Main {

	public static void main(String[] args) 
	{
	JFrame jiff=new JFrame("Calculator");
	
	RomanCalculator calc=new RomanCalculator();
	jiff.getContentPane().add(calc);
	jiff.setSize(700, 500);
	jiff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jiff.setVisible(true);
	
	
	}

}