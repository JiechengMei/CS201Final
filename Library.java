package pack1;

public class Library {
	private String Question,Ans1,Ans2,Ans3,Ans4;
	private char CAns,UAns;

	//constructor
	public Library(String Question, String Ans1, String Ans2,String Ans3,String Ans4, char CAns) {
		this.Question = Question;
		this.Ans1 = Ans1;
		this.Ans2 = Ans2;
		this.Ans3 = Ans3;
		this.Ans4 = Ans4;
		this.CAns = CAns;
	}
	//getter and setter


	public void setQuestion(String question) {
		Question = question;
	}

	public void setAns1(String ans1) {
		Ans1 = ans1;
	}

	public void setAns2(String ans2) {
		Ans2 = ans2;
	}

	public void setAns3(String ans3) {
		Ans3 = ans3;
	}

	public void setAns4(String ans4) {
		Ans4 = ans4;
	}

	public String getQuestion() {
		return Question;
	}

	public String getAns1() {
		return Ans1;
	}

	public String getAns2() {
		return Ans2;
	}

	public String getAns3() {
		return Ans3;
	}

	public String getAns4() {
		return Ans4;
	}

	public void setCAns(char CAns) {
		this.CAns = CAns;
	}

	public char getCAns() {
		return CAns;
	}

	/*Special getter and setter
	getting user's input and store it with the questions*/

	public char getUAns() {
		return UAns;
	}
	public void setUAns(char UAns) {
		UAns = Character.toUpperCase(UAns);
		switch (UAns){
			case 'A':
			case 'B':
			case 'C':
			case 'D':
				this.UAns = UAns;
				break;
			default:
				System.out.println("Invalid Answer, Make sure you answer valid one next time!");
		}

	}



	//similar like toString method
	public String showQuestion(){
		return "\n====================\nQuestion: "+this.getQuestion()+"\nA: "+this.getAns1()+"\nB: "+this.getAns2()+"\nC: "+this.getAns3()+"\nD: "+this.getAns4();
	}

	//compare the correct answer with the user answer, return the true or false back to main
	public boolean CompareToIgnoreCase(char CAns, char UAns) {
		CAns = Character.toUpperCase(CAns);
		return CAns == UAns;
	}
}
