import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService service;
    private Contact contact;

    @BeforeEach
    void setUp() {
        service = new ContactService();
        contact = new Contact("C100", "Bradley", "Hobson",
                "9135551212", "123 Main Street");
    }

    @Test
    void testAddContact() {
        service.addContact(contact);
        assertSame(contact, service.getContact("C100"));
    }

    @Test
    void testDuplicateContactIdRejected() {
        service.addContact(contact);
        Contact duplicate = new Contact("C100", "John", "Smith",
                "8165551212", "456 Oak Street");
        assertThrows(IllegalArgumentException.class,
                () -> service.addContact(duplicate));
    }

    @Test
    void testDeleteContact() {
        service.addContact(contact);
        service.deleteContact("C100");
        assertNull(service.getContact("C100"));
    }

    @Test
    void testDeleteMissingContactRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> service.deleteContact("missing"));
    }

    @Test
    void testUpdateFields() {
        service.addContact(contact);
        service.updateFirstName("C100", "Brad");
        service.updateLastName("C100", "Smith");
        service.updatePhone("C100", "8165551212");
        service.updateAddress("C100", "456 Oak Street");

        Contact updated = service.getContact("C100");
        assertEquals("Brad", updated.getFirstName());
        assertEquals("Smith", updated.getLastName());
        assertEquals("8165551212", updated.getPhone());
        assertEquals("456 Oak Street", updated.getAddress());
    }

    @Test
    void testUpdateMissingContactRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> service.updateFirstName("missing", "Brad"));
    }

    @Test
    void testInvalidUpdateRejected() {
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class,
                () -> service.updatePhone("C100", "123"));
    }
}
