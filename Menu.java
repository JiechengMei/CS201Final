package pack1;

public class Menu {
	private String gameName, gameDescription;
	//constructor
	public Menu(String gameName,String gameDescription) {
		this.gameName = gameName;
		this.gameDescription = gameDescription;
	}
	//getter and setter
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public void setGameDescription(String gameDescription) {
		this.gameDescription = gameDescription;
	}
	public String getGameName() {
		return gameName;
	}
	public String getGameDescription() {
		return gameDescription;
	}
	//toString method
	@Override
	public String toString() {
		return this.getGameName()+" <===> "+this.getGameDescription();
	}
}
