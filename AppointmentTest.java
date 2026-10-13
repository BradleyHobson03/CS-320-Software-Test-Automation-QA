import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.Test;

public class AppointmentTest {

    private Date futureDate() {
        return new Date(System.currentTimeMillis() + 86_400_000L);
    }

    @Test
    void testValidAppointment() {
        Appointment appointment = new Appointment(
                "A100", futureDate(), "Scheduled service appointment");
        assertEquals("A100", appointment.getAppointmentId());
        assertEquals("Scheduled service appointment", appointment.getDescription());
        assertNotNull(appointment.getAppointmentDate());
    }

    @Test
    void testAppointmentIdTooLongRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment("12345678901", futureDate(), "Description"));
    }

    @Test
    void testNullAppointmentIdRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment(null, futureDate(), "Description"));
    }

    @Test
    void testNullDateRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment("A100", null, "Description"));
    }

    @Test
    void testPastDateRejected() {
        Date past = new Date(System.currentTimeMillis() - 86_400_000L);
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment("A100", past, "Description"));
    }

    @Test
    void testFiftyCharacterDescriptionAccepted() {
        String description = "12345678901234567890123456789012345678901234567890";
        Appointment appointment = new Appointment("A100", futureDate(), description);
        assertEquals(50, appointment.getDescription().length());
    }

    @Test
    void testFiftyOneCharacterDescriptionRejected() {
        String description = "123456789012345678901234567890123456789012345678901";
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment("A100", futureDate(), description));
    }

    @Test
    void testNullDescriptionRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment("A100", futureDate(), null));
    }
}
