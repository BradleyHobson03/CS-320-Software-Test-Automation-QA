import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        }
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID must be unique.");
        }
        contacts.put(contact.getContactId(), contact);
    }

    public void deleteContact(String contactId) {
        if (contacts.remove(contactId) == null) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
    }

    public void updateFirstName(String contactId, String firstName) {
        getRequiredContact(contactId).setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        getRequiredContact(contactId).setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        getRequiredContact(contactId).setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        getRequiredContact(contactId).setAddress(address);
    }

    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    private Contact getRequiredContact(String contactId) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        return contact;
    }
}
