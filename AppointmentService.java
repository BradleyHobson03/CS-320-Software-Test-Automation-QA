import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private final Map<String, Appointment> appointments = new HashMap<>();

    public void addAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null.");
        }
        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment ID must be unique.");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    public void deleteAppointment(String appointmentId) {
        if (appointments.remove(appointmentId) == null) {
            throw new IllegalArgumentException("Appointment ID not found.");
        }
    }

    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}
