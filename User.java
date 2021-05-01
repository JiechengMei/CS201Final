package pack1;

public class User {
    String UserName;
    int Score;

    public void setScore(int score) {
        Score = score;
    }

    public int getScore() {
        return Score;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    @Override
    public String toString() {
        return "Player = " + this.getUserName() + ", Score = " + this.getScore();
    }
}
