package Refactoring;

public class TennisGame {
    public static void main(String[] args) {
        System.out.println(getScore("khanh", "huy", 3, 2));
    }

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Sore) {
        String score = "";
        int tempScore = 0;
        if (player1Score == player2Sore) {score = getEqualPoint(player1Score);}
        else if (player1Score < 4 && player2Sore < 4) {score = getPoint(player1Score, player2Sore, score);}
        else {score = getWinner(player1Score, player2Sore);}
        return score;
    }

    private static String getEqualPoint(int player1Score) {
        String score;
        switch (player1Score) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }

    private static String getPoint(int player1Score, int player2Sore, String score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1Score;
            else {
                score += "-";
                tempScore = player2Sore;
            }
            switch (tempScore) {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }

    private static String getWinner(int player1Score, int player2Sore) {
        String score;
        int minusResult = player1Score - player2Sore;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }
}

