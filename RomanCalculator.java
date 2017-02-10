
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class RomanCalculator extends Roman implements ActionListener 
// can only extend one class so if need more use implements
{
	private static int sum=0;
	private static int I=1,V=5,X=10,L=50,C=100,D=500,M=1000,numI=0,numV,numX,numL,numC,numD,numM,oper_Used=0;// num stuff is for the descending division method
	private JButton[] barr=new JButton[14];
	private static JTextField Roman1=new JTextField(100);
	private static JTextField Roman2=new JTextField(100);
	private static JTextField Result=new JTextField(100);
	private static JTextField Integer1=new JTextField(100);
	private static JTextField Integer2=new JTextField(100);
	private static JTextField Integer3=new JTextField(100);
	private String [] caption={"I","V","X","L","C","D","M","CE","-","+","/","%","*","="};
	private JPanel keypad=new JPanel();
	private JPanel Textfields=new JPanel();
	private boolean done=false;// used for the loops with concatenating in the textfields for multiple numerals
	private static boolean use_Operat=false;// use to tell if a person has selected an operation so that switch to the second textfield
	private static int ICounter,VCounter,XCounter,LCounter,CCounter,DCounter,MCounter;// counters used to count how many times we used each roman numeral
	

	
	public RomanCalculator()
	{
		super();// to call the JPanel
		this.setLayout(new BorderLayout());// setting it to border layout
		Font bigFont = Roman1.getFont().deriveFont(Font.PLAIN, 35f);// make font for textfields bigger
		keypad.setLayout(new GridLayout(4,4));// create grid layout for the buttons
		Textfields.setLayout(new GridLayout(3,2));
		Roman1.setFont(bigFont);Roman2.setFont(bigFont);Result.setFont(bigFont);	Integer1.setFont(bigFont);Integer2.setFont(bigFont);Integer3.setFont(bigFont);
		Textfields.add(Roman1);Textfields.add(Integer1);Textfields.add(Roman2);Textfields.add(Integer2);Textfields.add(Result);	Textfields.add(Integer3);
		Roman1.setEditable(false);Roman2.setEditable(false);Result.setEditable(false);Integer1.setEditable(false);Integer2.setEditable(false);Integer3.setEditable(false);
		this.add(Textfields,BorderLayout.NORTH);
		for(int i=0;i<barr.length;i++)
		{
			barr[i]=new JButton(caption[i]);
			keypad.add(barr[i]).setFont(bigFont);
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
			
			switch(oper_Used){
			case 1: add(); break;// all of these are seperate methods for each function did this to make this part look cleaner
			case 2:	Sub();break;
			case 3: multi();break;
			case 4:	divi();break;
			case 5:	module();break;
			}
			Integer3.setText("");
			Integer3.setText(""+sum);
			descending_Divi();// using the descending division method
			break;
			
		case"%":clear_Counters();// specific clears the counters so when you use the second textfield it doesnt keep using the old counters from first textfield
		use_Operat=true;// operation use identifier so I know they clicked and operation so I can switch to second textfield
		oper_Used=5;// operation identifier so I know which operation they used.
		break;
		
		case"/": clear_Counters();
		use_Operat=true;
		oper_Used=4;
		break;
		
		case"*": clear_Counters();
		use_Operat=true;
		oper_Used=3;
		break;
		
		case"-": clear_Counters();
		use_Operat=true;
		oper_Used=2;
		break;
		
		case "+":clear_Counters();
			use_Operat=true;
			oper_Used=1;
			break;
			
		case "CE":
			clear_Everything();
		break;
		
		default: 
			
			if(use_Operat==true){do{// if use_Operat== true then that means switch to the second text field
				
				Roman2.setText(Roman2.getText()+x);
				
				
				switch(x)
				{	
				case "I": ICounter++; break;
				case "V": VCounter++;break;
				case "X": XCounter++;break;
				case "L": LCounter++;break;
				case "C": CCounter++;break;
				case "D": DCounter++;break;
				case "M": MCounter++;break;
				}
				
				Integer2.setText(String.valueOf((ICounter*I)+(VCounter*V)+(XCounter*X)+(LCounter*L)+(CCounter*C)+(DCounter*D)+(MCounter*M)));// how I set
				// the integer2 to the right value by multiply each numerals integr equivalent by how many times we used it.
				done=true;// get out of the loop
				}while(!done);}
			else{
			do{     
					Roman1.setText(Roman1.getText()+x);// for first textfield if didnt use operation
					
					
					switch(x)
					{	
					case "I": ICounter++; break;
					case "V": VCounter++;break;
					case "X": XCounter++;break;
					case "L": LCounter++;break;
					case "C": CCounter++;break;
					case "D": DCounter++;break;
					case "M": MCounter++;break;
					}
					
					Integer1.setText(String.valueOf((ICounter*I)+(VCounter*V)+(XCounter*X)+(LCounter*L)+(CCounter*C)+(DCounter*D)+(MCounter*M)));
					done=true;
					}while(!done);
		}
		}
		}
	public static void descending_Divi(){
		numM=(sum)/M;// number of M that need to be used in the results returned roman numeral easily found by just diving the integer result by M which will give how 
		//many thousands can go into this number 
		sum=sum-(M*numM);// subtracting the amount of thousands from the sum so that it actually calculates from what left after the M's
		
		for(int i=0;i<numM;i++)
		{
			Result.setText(Result.getText()+"M");//Loop that puts M's in the roman result however many times the integr result can be divided by a thousand

		}
		numD=(sum)/D;
		sum=sum-(D*numD);
		for(int i=0;i<numD;i++)//same for 500
		{
			Result.setText(Result.getText()+"D");

		}
		numC=(sum)/C;
		sum=sum-(C*numC);
		for(int i=0;i<numC;i++)//same for 100
		{
			Result.setText(Result.getText()+"C");

		}
		numL=(sum)/L;
		sum=sum-(L*numL);// same for 50
		for(int i=0;i<numL;i++)
		{
			Result.setText(Result.getText()+"L");
			
		}
		numX=(sum)/X;
		sum=sum-(X*numX);// same for 10
		for(int i=0;i<numX;i++)
		{
			Result.setText(Result.getText()+"X");
			
		}
		numV=(sum)/V;
		sum=sum-(V*numV);
		for(int i=0;i<numV;i++)//same for 5
		{
			Result.setText(Result.getText()+"V");

		}
		numI=(sum)/I;
		sum=sum-(I*numI);
		for(int i=0;i<numI;i++)// same for 1
		{
			Result.setText(Result.getText()+"I");
		}
	}
	public static void add()// the different operations
	{sum=Integer.parseInt(Integer1.getText())+Integer.parseInt(Integer2.getText());}// converts each text into an integer through parseint
	
	public static void Sub()
	{sum=Integer.parseInt(Integer1.getText())-Integer.parseInt(Integer2.getText());
	if(Integer.parseInt(Integer1.getText())<Integer.parseInt(Integer2.getText())||
	Integer.parseInt(Integer1.getText())-Integer.parseInt(Integer2.getText())==0)
	{Result.setText("Nulla");}}// nulla if you get a negative number or zero from subtraction nulla means nothing in latin
	
	public static void multi()
	{sum=Integer.parseInt(Integer1.getText())*Integer.parseInt(Integer2.getText());}// self explanatory
	
	public static void divi()
	{sum=Integer.parseInt(Integer1.getText())/Integer.parseInt(Integer2.getText());}// self explanatory
	
	public static void module()
	{sum=Integer.parseInt(Integer1.getText())%Integer.parseInt(Integer2.getText());}//self explanatory
	
	public static void clear_Everything(){// clears all the texts, clears the counters, sums, operation types,sum,etc.
		 Roman1.setText("");
			Roman2.setText("");
			Result.setText("");
			Integer1.setText("");
			Integer2.setText("");
			Integer3.setText("");
			sum=0;
			clear_Counters();
			use_Operat=false;
			oper_Used=0;
			}
	public static void clear_Counters()// clear the counters
	{
		ICounter=0;VCounter=0;XCounter=0;LCounter=0;CCounter=0;DCounter=0;MCounter=0;
	}
	
	}
