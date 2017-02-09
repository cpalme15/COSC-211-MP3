
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class RomanCalculator extends Roman implements ActionListener 
// can only extend one class so if need more use implements
{
	private static int sum=0;
	private static int I=1,V=5,X=10,L=50,C=100,D=500,M=1000,numI=0,numV,numX,numL,numC,numD,numM,oper_Used=0;
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
	private boolean done=false;
	private static boolean use_Operat=false;
	private static int ICounter,VCounter,XCounter,LCounter,CCounter,DCounter,MCounter;
	

	
	public RomanCalculator()
	{
		super();// to call the JPanel
		this.setLayout(new BorderLayout());// setting it to border layout
		Font bigFont = Roman1.getFont().deriveFont(Font.PLAIN, 35f);
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
			case 1: add(); break;
			case 2:	Sub();break;
			case 3: multi();break;
			case 4:	divi();break;
			case 5:	module();break;
			}
			Integer3.setText("");
			Integer3.setText(""+sum);
			descending_Divi();
			break;
			
		case"%":clear_Counters();
		use_Operat=true;
		oper_Used=5;
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
			
			if(use_Operat==true){do{
				
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
				
				Integer2.setText(String.valueOf((ICounter*I)+(VCounter*V)+(XCounter*X)+(LCounter*L)+(CCounter*C)+(DCounter*D)+(MCounter*M)));
				done=true;
				}while(!done);}
			else{
			do{     
					Roman1.setText(Roman1.getText()+x);
					
					
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
		numM=(sum)/M;
		sum=sum-(M*numM);
		
		for(int i=0;i<numM;i++)
		{
			Result.setText(Result.getText()+"M");

		}
		numD=(sum)/D;
		sum=sum-(D*numD);
		for(int i=0;i<numD;i++)
		{
			Result.setText(Result.getText()+"D");

		}
		numC=(sum)/C;
		sum=sum-(C*numC);
		for(int i=0;i<numC;i++)
		{
			Result.setText(Result.getText()+"C");

		}
		numL=(sum)/L;
		sum=sum-(L*numL);
		for(int i=0;i<numL;i++)
		{
			Result.setText(Result.getText()+"L");
			
		}
		numX=(sum)/X;
		sum=sum-(X*numX);
		for(int i=0;i<numX;i++)
		{
			Result.setText(Result.getText()+"X");
			
		}
		numV=(sum)/V;
		sum=sum-(V*numV);
		for(int i=0;i<numV;i++)
		{
			Result.setText(Result.getText()+"V");

		}
		numI=(sum)/I;
		sum=sum-(I*numI);
		for(int i=0;i<numI;i++)
		{
			Result.setText(Result.getText()+"I");
		}
	}
	public static void add()
	{sum=Integer.parseInt(Integer1.getText())+Integer.parseInt(Integer2.getText());}
	
	public static void Sub()
	{sum=Integer.parseInt(Integer1.getText())-Integer.parseInt(Integer2.getText());
	if(Integer.parseInt(Integer1.getText())<Integer.parseInt(Integer2.getText())||
	Integer.parseInt(Integer1.getText())-Integer.parseInt(Integer2.getText())==0)
	{Result.setText("Nulla");}}
	
	public static void multi()
	{sum=Integer.parseInt(Integer1.getText())*Integer.parseInt(Integer2.getText());}
	
	public static void divi()
	{sum=Integer.parseInt(Integer1.getText())/Integer.parseInt(Integer2.getText());}
	
	public static void module()
	{sum=Integer.parseInt(Integer1.getText())%Integer.parseInt(Integer2.getText());}
	
	public static void clear_Everything(){
		 Roman1.setText("");
			Roman2.setText("");
			Result.setText("");
			Integer1.setText("");
			Integer2.setText("");
			Integer3.setText("");
			sum=0;
			clear_Counters();
			use_Operat=false;
			}
	public static void clear_Counters()
	{
		ICounter=0;VCounter=0;XCounter=0;LCounter=0;CCounter=0;DCounter=0;MCounter=0;
	}
	
	}
