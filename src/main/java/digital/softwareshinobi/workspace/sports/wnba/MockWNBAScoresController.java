package digital.softwareshinobi.workspace.sports.wnba;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockWNBAScoresController {

    @GetMapping("/wnba/mock-scores")
    public String generateMockScores() {
        return generateMockScores(null);
    }

    private String generateMockScores(String date) {
        // If no date is provided, default to today's date
        date = date != null ? date : "2024-07-12";

        // Sample team names (replace with actual WNBA teams if desired)
        String[] teams = {"Storm", "Sky", "Aces", "Lynx", "Mystics", "Sparks", "Fever", "Wings", "Liberty", "Sun"};

        // Generate random scores between 60 and 100
        int[] scores = new int[teams.length];
        for (int i = 0; i < teams.length; i++) {
            scores[i] = (int) Math.floor(Math.random() * (100 - 60 + 1)) + 60;
        }

        // Shuffle teams to create random matchups
        shuffleArray(teams);

        // Construct the mock scores string
        StringBuilder mockScores = new StringBuilder("WNBA Mock Scores - " + date + "\n\n");
        for (int i = 0; i < scores.length; i += 2) {
            String team1 = teams[i];
            String team2 = teams[i + 1];
            int score1 = scores[i];
            int score2 = scores[i + 1];
            int overUnder = (int) Math.floor(Math.random() * (170 - 130 + 1)) + 130;

            // Randomly assign favorite/underdog for moneylines
            String favorite = team1;
            String underdog = team2;
            if (Math.random() < 0.5) {
                favorite = team2;
                underdog = team1;
            }

            double moneylineFavorite = Math.round(10000 / (Math.random() * 100 + 100));
            
            double moneylineUnderdog = Math.round(10000 / (1 - Math.random() * 100));

            mockScores.append(team1 + " vs. " + team2 + ": " + score1 + "-" + score2 + "\n");
            mockScores.append("Over/Under: " + overUnder + "\n");
            mockScores.append("Moneyline: " + favorite + " (" + moneylineFavorite + "), " + underdog + " (" + moneylineUnderdog + ")\n\n");
        }

        return mockScores.toString();
    }

    // Utility function to shuffle an array (Fisher-Yates shuffle)
    private static void shuffleArray(String[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = (int) Math.floor(Math.random() * (i + 1));
            String temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
