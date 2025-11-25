package posttestbasic;

public class ScoreAnalyzer {

    public String classifyResult(int[] scores) {
        if (scores == null || scores.length == 0) {
            return "Poor";
        }

        int total = 0;

        // tetap hitung rata-rata berdasarkan jumlah elemen asli,
        // tapi nilai yang tidak valid tidak ditambahkan
        for (int score : scores) {
            if (score >= 0 && score <= 100) {
                total += score;
            }
        }

        double average = (double) total / scores.length;

        if (average >= 85)
            return "Excellent";
        else if (average >= 70)
            return "Good";
        else if (average >= 50)
            return "Fair";
        else
            return "Poor";
    }
}
