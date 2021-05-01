package pack1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//load information
		Menu[] menu = new Menu[2];
		Library[] TQA = new Library[10];
		Scanner scan = new Scanner(System.in);


		//program start point
		LoadMenu(menu);


		boolean exitLoop = false;
		while (exitLoop = true){
			ShowMenu(menu);
			System.out.println("Please select a game to start or 0 to exit the program");
			int UserSelection = scan.next().charAt(0);
			switch(UserSelection) {
				case '0':
					System.out.println("Thank you for playing our game!\nHope you have a nice day!");
					System.exit(0);
					break;
				case '1':
					User player = new User();
					TriviaGame(TQA,scan,player);
					break;
				default:
					System.out.println("Error!!!You have an invalid input!\n===================================");
			}//switch end
		}
		scan.close();
	}//main method end

	//display the game menu to user
	private static void ShowMenu(Menu[] menu) {
		for (int i = 0;i< menu.length;i++){
			System.out.println("Index: "+i+" :==: "+menu[i].toString());
		}
	}
	//load game menu
	private static void LoadMenu(Menu[] menu) {
		menu[0] = new Menu("Exit", "Exit the program");
		menu[1] = new Menu("Trivia","A quizzing game but it's fun");
	}


	//Trivia game main frame
	public static void TriviaGame(Library[] TQA, Scanner scan, User player) {
		int playerRChance = 2;
		int playerScore = 0;
		int CInRoll = 0; //user get correct answer in a row
		// to save the memory, load the question right now
		LoadQALib(TQA);
		InStreamFlush(scan);
		System.out.println("Hello Player, please enter your name: ");
		player.setUserName(scan.nextLine());
		System.out.println("Now, the game START!");
		GameStart(TQA,scan,playerRChance,playerScore,CInRoll,player);
	}

	private static void InStreamFlush(Scanner scan) {
		scan.nextLine();
	}

	//Trivia game body frame
	private static void GameStart(Library[] TQA, Scanner scan, int playerRChance, int playerScore, int CInRoll, User player) {
		outerloop:
		for(int i = 0; i< TQA.length;i++){
			System.out.println(TQA[i].showQuestion());
			// TODO: 2021/5/1 add a loop and switch if need fix to reenter
			System.out.println("Your answer: ");
			char UAns = scan.next().charAt(0);
			InStreamFlush(scan);
			//get the user input and store to the array
			TQA[i].setUAns(UAns);
			// TODO: 2021/5/1 add a loop and switch if need fix to reenter

			boolean Judge = TQA[i].CompareToIgnoreCase(TQA[i].getCAns(),TQA[i].getUAns());
			if (Judge) {
				playerScore++;
				CInRoll++;
				switch (CInRoll) {
					case 3:
						System.out.println("\nYou got one more chance to get error\nRemain: " + playerRChance+"\nScore: "+playerScore+"\nStrike in a roll: "+CInRoll);
						playerRChance++;
						break;
					case 6:
						System.out.println("\nYou got two more chance to get error\nNow your remain chance is: " + playerRChance+"\nScore: "+playerScore+"\nStrike in a roll: "+CInRoll);
						playerRChance++;
						break;
					case 9:
						System.out.println("\nYou got three more chance to get error\nNow your remain chance is: " + playerRChance+"\nScore: "+playerScore+"\nStrike in a roll: "+CInRoll);
						playerRChance++;
						break;
					case 10:
						System.out.println("\n" + playerRChance + " Remain, you are Awesome!"+"\nScore: "+playerScore+"\nStrike in a roll: "+CInRoll);
						break;
					default:
						System.out.println("You got one correct!"+"\nScore: "+playerScore+"\nRemain: " + playerRChance);
				}
			} else {
				playerRChance--;
				CInRoll = 0;
				switch (playerRChance){
					case 1:
						System.out.println("Error! you have one chance left!"+"\nRemain: " + playerRChance+"\nScore: "+playerScore);
						break;
					case 0:
						System.out.println("No more chance! You are out of the game!"+"\nRemain: " + playerRChance+"\nScore: "+playerScore);
						break outerloop;
				}
			}
		}
		int FinalScore = 3*playerRChance + playerScore;
		player.setScore(FinalScore);
		System.out.println(
				"===============Congratulations====================\n"
						+"==》"+player.toString()+
						""+
						"\n===============Congratulations====================");
	}
	//Trivia Question and Answer loader
	private static void LoadQALib(Library[] TQA) {
		TQA[0] = new Library("What planet is closest to the Sun?", "Mercury", "Mars", "Earth", "Jupiter", 'A');
		TQA[1] = new Library("How many teeth are in a full adult set?", "28", "30", "32", "34", 'C');
		TQA[2] = new Library("What dog breed is the tallest?", "Shiba Inu", "Husky", "Golden Retreiver", "Great Dane", 'D');
		TQA[3] = new Library("How many of Snow White’s dwarfs have names ending with the letter Y?", "5", "3", "4", "7", 'A');
		TQA[4] = new Library("What is the smallest ocean in the world?", "The Atlantic", "The Arctic", "The Pacific", "The Southern", 'B');
		TQA[5] = new Library("What position does Harry Potter play on his Quidditch team?", "Seeker", "Chaser", "Keeper", "Bludger", 'A');
		TQA[6] = new Library("What novel did Sherlock Holmes first appear in?", "Murder on the Orient Express", "A Study in Scarlet", "The Return of Sherlock Holmes", "The Hound of the Baskervilles", 'B');
		TQA[7] = new Library("Which character in Frozen likes warm hugs?", "Elsa", "Kristoff", "Olaf", "Anna", 'C');
		TQA[8] = new Library("Which Avenger is the king of Wakanda?", "Falcon", "Iron Fist", "Hercules", "Black Panther", 'D');
		TQA[9] = new Library("What is the closest living relative to the Tyrannosaurus Rex?", "Cow", "Chicken", "Kangaroo", "Crocodile", 'B');

	}


}
