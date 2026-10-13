import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    void testValidContact() {
        Contact contact = new Contact("1234567890", "Bradley", "Hobson",
                "9135551212", "123 Main Street");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("Bradley", contact.getFirstName());
        assertEquals("Hobson", contact.getLastName());
        assertEquals("9135551212", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345678901", "Bradley", "Hobson",
                        "9135551212", "123 Main Street"));
    }

    @Test
    void testContactIdNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(null, "Bradley", "Hobson",
                        "9135551212", "123 Main Street"));
    }

    @Test
    void testFirstNameRules() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", null, "Hobson", "9135551212", "123 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "ABCDEFGHIJK", "Hobson", "9135551212", "123 Main Street"));
    }

    @Test
    void testLastNameRules() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Bradley", null, "9135551212", "123 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Bradley", "ABCDEFGHIJK", "9135551212", "123 Main Street"));
    }

    @Test
    void testPhoneRules() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Bradley", "Hobson", null, "123 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Bradley", "Hobson", "123456789", "123 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Bradley", "Hobson", "123456789a", "123 Main Street"));
    }

    @Test
    void testAddressRules() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Bradley", "Hobson", "9135551212", null));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Bradley", "Hobson", "9135551212",
                        "1234567890123456789012345678901"));
    }

    @Test
    void testFieldUpdates() {
        Contact contact = new Contact("1", "Bradley", "Hobson",
                "9135551212", "123 Main Street");
        contact.setFirstName("Brad");
        contact.setLastName("Smith");
        contact.setPhone("8165551212");
        contact.setAddress("456 Oak Street");

        assertEquals("Brad", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("8165551212", contact.getPhone());
        assertEquals("456 Oak Street", contact.getAddress());
    }
}
