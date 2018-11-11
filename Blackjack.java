import java.util.Random;
import java.util.Scanner;

public class Blackjack {
		
		String type;
		int huidigekaart; //instance variable
		int totaal = 0; //instance variable
		static int bankTotaal =0;  //Waarde om totaal van speler op te slaan
		static int spelerTotaal =0; //Waarde om totaal van speler op te slaan
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		//constructor
		public Blackjack(String speler) {
			type = speler;
			System.out.println("Spel is gestart");
			delen();
			spel();
		}
		void laatKaartZien() {
			huidigekaart = ran.nextInt(14)+1;
			
			switch(huidigekaart) {
				case 11: 	System.out.println(type+ " heeft getrokken een Boer");
							totaal = totaal+10;
							System.out.println(type+ " Huidige totaal is: "+totaal);
							break;
				case 12: 	System.out.println(type+ " heeft getrokken een Vrouw");
							totaal = totaal+10;
							System.out.println(type+ " Huidige totaal is: "+totaal);
							break;
				case 13: 	System.out.println(type+ " heeft getrokken een Heer");
							totaal = totaal+10;
							System.out.println(type+ " Huidige totaal is: "+totaal);
							break;
				case 14: 	System.out.println(type+ " heeft getrokken een Aas");
							if(totaal<=10) {
								totaal= totaal+11;
							}else {
								totaal = totaal+1;
							}
							System.out.println(type+ " Huidige totaal is: "+totaal);
							break;
				default: 	System.out.println(type+ " heeft getrokken een "+huidigekaart);
							totaal= totaal+huidigekaart;
							System.out.println(type+ " Huidige totaal is: "+totaal);
						
			}
		}
		void delen() {
			System.out.println("Eerste kaart is: ");
			laatKaartZien();
			System.out.println("Tweede kaart is: ");
			laatKaartZien();
		}
		void spel() {
			if(totaal <= 21) {
				if(!(type.equals("Bank"))) {
					System.out.println("Wil je nog een kaart? (ja/nee)");
					if(scan.nextLine().equals("ja")) {
						laatKaartZien();
						spel();
					}else {
						System.out.println("Jouw totaal: "+totaal);
						spelerTotaal = totaal;
					}
				}
			}
			else {
				System.out.println(type +" Game Over: "+totaal);
				System.exit(0); //Gaat naar main
			}
			if(type.equals("Bank")) {
				if((totaal < 17 && totaal <21) || totaal < spelerTotaal) {
					laatKaartZien(); 
					spel();
				}else {
					
					bankTotaal = totaal;
				}
			}
		}
		void WieWint() { //conditities om te bepalen of men heeft gewonnen of niet
			if(bankTotaal>spelerTotaal) {
				System.out.println("Bank wint!");
			}
			else if(bankTotaal<spelerTotaal) {
				System.out.println("speler wint!");
			
			}
			if(bankTotaal == spelerTotaal) {
				System.out.println("Push (Gelijk)");
			}
		}
		
		public static void main(String [] args) {
			Blackjack karwai = new Blackjack("Karwai");
			Blackjack Bank = new Blackjack("Bank");
			karwai.WieWint();	
	}

}