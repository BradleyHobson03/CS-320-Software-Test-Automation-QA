import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppointmentServiceTest {
    private AppointmentService service;
    private Appointment appointment;

    @BeforeEach
    void setUp() {
        service = new AppointmentService();
        Date future = new Date(System.currentTimeMillis() + 86_400_000L);
        appointment = new Appointment("A100", future, "Scheduled appointment");
    }

    @Test
    void testAddAppointment() {
        service.addAppointment(appointment);
        assertSame(appointment, service.getAppointment("A100"));
    }

    @Test
    void testDuplicateAppointmentIdRejected() {
        service.addAppointment(appointment);
        Date future = new Date(System.currentTimeMillis() + 172_800_000L);
        Appointment duplicate = new Appointment("A100", future, "Second appointment");
        assertThrows(IllegalArgumentException.class,
                () -> service.addAppointment(duplicate));
    }

    @Test
    void testDeleteAppointment() {
        service.addAppointment(appointment);
        service.deleteAppointment("A100");
        assertNull(service.getAppointment("A100"));
    }

    @Test
    void testDeleteMissingAppointmentRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> service.deleteAppointment("missing"));
    }
}
