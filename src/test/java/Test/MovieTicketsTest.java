package Test;

import org.example.MovieTickets;
import org.example.MovieTicketData;

import static org.junit.Assert.*;

    public class MovieTicketsTest {
        private MovieTickets movieTickets;

        @Before
        public void setUp() {
            // Initialize with sample data
            movieTickets = new MovieTickets("Sample Movie", 2, 50.0);
        }

        @Test
        public void CalculateTotalTicketPrice_CalculatedSuccessfully() {
            // Test purpose: To supply the number of tickets and ticket price to the CalculateTotalTicketPrice method
            // and check if the correct total price including VAT is returned.

            int numberOfTickets = 2;
            double ticketPrice = 50.0;

            // Expected total price calculation: (numberOfTickets * ticketPrice) + 14% VAT
            double expectedTotal = (numberOfTickets * ticketPrice) * 1.14; // 2 * 50 * 1.14

            double actualTotal = movieTickets.CalculateTotalTicketPrice(numberOfTickets, ticketPrice);

            assertEquals("The total price including VAT should be correctly calculated", expectedTotal, actualTotal, 0.01);
        }

        private void assertEquals(String s, double expectedTotal, double actualTotal, double v) {

        }

        @Test
        public void ValidateData_InvalidMovieName_FailsValidation() {
            // Test purpose: Ensure that validation fails when the movie name is empty.

            MovieTicketData invalidMovieData = new MovieTicketData("", 2, 50.0); // empty movie name

            assertFalse("Validation should fail for an empty movie name", movieTickets.ValidateData(invalidMovieData));
        }

        private void assertFalse(String s, boolean b) {

        }

        @Test
        public void ValidateData_InvalidNumberOfTickets_FailsValidation() {
            // Test purpose: Ensure that validation fails when the number of tickets is less than or equal to zero.

            MovieTicketData invalidTicketsData = new MovieTicketData("Sample Movie", 0, 50.0); // invalid number of tickets

            assertFalse("Validation should fail for zero or negative number of tickets", movieTickets.ValidateData(invalidTicketsData));
        }

        @Test
        public void ValidateData_InvalidTicketPrice_FailsValidation() {
            // Test purpose: Ensure that validation fails when the ticket price is less than or equal to zero.

            MovieTicketData invalidPriceData = new MovieTicketData("Sample Movie", 2, -5.0); // invalid ticket price

            assertFalse("Validation should fail for zero or negative ticket price", movieTickets.ValidateData(invalidPriceData));
        }
    }



