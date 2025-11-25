package posttestbasic;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ScoreAnalyzerTest {

    @Test
    public void testClassifyResult_Excellent() {
        // --- Code Input ---
        int[] codeInputScores = { 92, 88, 96, 100, 85 };

        // --- Execute ---
        ScoreAnalyzer analyzer = new ScoreAnalyzer();
        String codeOutput = analyzer.classifyResult(codeInputScores);

        // --- Expected Output ---
        String expectedOutput = "Excellent";

        // --- Assertion ---
        assertEquals("Classification Excellent", expectedOutput, codeOutput);
    }

    @Test
    public void testClassifyResult_Good() {
        // --- Code Input ---
        int[] codeInputScores = { 70, 75, 80, 60, 78, 82 };

        // --- Execute ---
        ScoreAnalyzer analyzer = new ScoreAnalyzer();
        String codeOutput = analyzer.classifyResult(codeInputScores);

        // --- Expected Output ---
        String expectedOutput = "Good";

        // --- Assertion ---
        assertEquals("Classification Good", expectedOutput, codeOutput);
    }

    @Test
    public void testClassifyResult_Fair() {
        // --- Code Input ---
        int[] codeInputScores = { 50, 55, 60 };

        // --- Execute ---
        ScoreAnalyzer analyzer = new ScoreAnalyzer();
        String codeOutput = analyzer.classifyResult(codeInputScores);

        // --- Expected Output ---
        String expectedOutput = "Fair";

        // --- Assertion ---
        assertEquals("Classification Fair", expectedOutput, codeOutput);
    }

    @Test
    public void testClassifyResult_PoorWithInvalid() {
        // --- Code Input (invalid scores included) ---
        int[] codeInputScores = { -5, 40, 45, 200, 30 };

        // --- Execute ---
        ScoreAnalyzer analyzer = new ScoreAnalyzer();
        String codeOutput = analyzer.classifyResult(codeInputScores);

        // --- Expected Output ---
        // Only valid scores: 40 + 45 + 30 = 115, average = 115/5 = 23 → "Poor"
        String expectedOutput = "Poor";

        // --- Assertion ---
        assertEquals("Classification Poor with invalid input", expectedOutput, codeOutput);
    }

    @Test
    public void testClassifyResult_MixedSize() {
        // --- Code Input ---
        int[] codeInputScores = { 65, 72, 58, 60, 70, 66, 68 };

        // --- Execute ---
        ScoreAnalyzer analyzer = new ScoreAnalyzer();
        String codeOutput = analyzer.classifyResult(codeInputScores);

        // --- Expected Output ---
        String expectedOutput = "Fair";

        // --- Assertion ---
        assertEquals("Classification Fair for 7-element array", expectedOutput, codeOutput);
    }

}
