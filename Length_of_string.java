import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringLengthTest {

    @Test
    public void testStringLength() {
        // Define the string to test
        String str = "Hello, World!";

        // Calculate the expected length of the string
        int expectedLength = str.length();

        // Initialize a counter to store the length of the string
        int length = 0;

        // Iterate over each character in the string
        for (char c : str.toCharArray()) {
            // Increment the counter for each character
            length++;
        }

        // Check if the calculated length matches the expected length
        assertEquals(expectedLength, length);
    }
}
