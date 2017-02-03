
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RomanCalculator extends JPanel  implements ActionListener
// can only extend one class so if need more use implements
{
	private int sum=0,n1=0,n2=0;
	private JButton[] barr=new JButton[14];
	private JTextField Roman1=new JTextField(5);
	private JTextField Result=new JTextField(5);
	private String [] caption={"I","V","X","L","C","D","M","CE","-","+","/","%","*","="};
	private JPanel keypad=new JPanel();
	private JPanel Textfields=new JPanel();
	
	public RomanCalculator()
		{
			super();// to call the JPanel
			
			this.setLayout(new BorderLayout());// setting it to border layout
			
			keypad.setLayout(new GridLayout(4,4));// create grid layout for the buttons
			Textfields.setLayout(new GridLayout(2,3));
			Textfields.add(Roman1);
			Textfields.add(Result);
			this.add(Textfields,BorderLayout.NORTH);
		
			
			for(int i=0;i<barr.length;i++)
			{
				barr[i]=new JButton(caption[i]);
				keypad.add(barr[i]);
				barr[i].addActionListener(this);// listen to buttons and find action in this class
			}
			this.add(keypad, BorderLayout.CENTER);
		}

	@Override
	public void actionPerformed(ActionEvent e) 
		{
		  	
			String x=e.getActionCommand();
			switch(x)
			{
			case "=":
				switch(x)
				{
				case "I": n2=1; break;
				case "V": n2=5;break;
				case "X": n2=10;break;
				case "L": n2=50;break;
				case "C": n2=100;break;
				case "D": n2=500;break;
				case "M": n2=1000;break;
				}
				sum=n1+n2;
			    Result.setText(""+sum);
			    break;
			case "+": 
					switch(x)
					{
					case "I": n1=1; break;
					case "V": n1=5;break;
					case "X": n1=10;break;
					case "L": n1=50;break;
					case "C": n1=100;break;
					case "D": n1=500;break;
					case "M": n1=1000;break;
					}
			case "CE": Roman1.setText("");
				n1=0;
				n2=0;
				sum=0;
				break;
			default: Roman1.setText(x);
				
			}
		
		}
}