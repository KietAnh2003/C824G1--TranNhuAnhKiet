package ss1_ss11.ss8_clean_code;

public class TennisGame {
    public static String[] SCORES = {"Love", "Fifteen", "Thirty", "Forty"};

    public static String getScore(String name1, String name2, int score1, int score2) {
        if (score1 == score2) {
            return (score1 < 3) ? SCORES[score1] + "-All" : "Deuce";
        } else {
            return matchResult(score1, score2);
        }
    }
    private static String matchResult(int player1Score, int player2Score) {
        if (player1Score >= 4 || player2Score >= 4) {
            int scoreDifference = player1Score - player2Score;
            if (scoreDifference == 1) {
                return "Advantage player1";
            } else if (scoreDifference == -1) {
                return "Advantage player2";
            } else if (scoreDifference >= 2) {
                return "Win for player1";
            } else {
                return "Win for player2";
            }
        } else {
            return SCORES[player1Score] + "-" + SCORES[player2Score];
        }
    }
}

