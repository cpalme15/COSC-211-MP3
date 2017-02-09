import javax.swing.JPanel;

public class Roman extends JPanel {
	private int I;
	private int V;
	private int X;
	private int L;
	private int C;
	private int D;
	private int M;
	private String roman;
	
	public Roman(){
		this.I = 1;
		this.V = 5;
		this.X = 10;
		this.L = 50;
		this.C = 100;
		this.D = 500;
		this.M = 1000;
	}

	public void setRoman(String r){
		if(r == "I" || r == "V" || r == "X" || r == "L" || r == "C" || r == "D" || r == "M")
			roman = r;
		else
			System.out.println("Invald Roman Numeral.");
		System.exit(0);
	}
	
	public String getRoman(){
		return roman;
	}
	
	public static int convert_Roman_To_Int(String r){
		switch(r){
			case "I": return 1;
			case "V": return 5;
			case "X": return 10;
			case "L": return 50;
			case "C": return 100;
			case "D": return 500;
			case "M": return 1000;
			default: return 0;
		}
	}

	
	public String convert_Int_To_Roman(int r){
		switch(r){
		case 1: return "I";
		case 5: return "V";
		case 10: return "X";
		case 50: return "L";
		case 100: return "C";
		case 500: return "D";
		case 1000: return "M";
		default: return "Z";
		}
	}
	
	public void display_Roman(Roman r){
		System.out.println(r);
	}
}