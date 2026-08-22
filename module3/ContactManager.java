import java.util.*; 
 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101")); 
        contacts.put("Tywin Lannister", new Contact("Tywin Lannister", "+1 623 555 8163")); 
        contacts.put("Tyrion Lannister", new Contact("Tyrion Lannister", "+1 123 555 7654")); 
        contacts.put("John Snow", new Contact("John Snow", "+1 534 555 9876")); 
        contacts.put("Hermione Granger", new Contact("Hermione Granger", "+1 423 555 8361")); 
 
        // Step 5: look up a contact 
         var knownContact = contacts.get("John Snow");
         if (knownContact == null) {
            System.out.println("Contact not found.");
         } else {
            System.out.println(knownContact.toString());
         }

         var unknownContact = contacts.get("Harry Potter");
         if (unknownContact == null) {
            System.out.println("Contact not found.");
         } else {
            System.out.println(unknownContact.toString());
         }
 
        // Step 6: print sorted list 
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values()); 
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));
        System.out.println("=== All Contacts ===  ");
        for (var contact : sorted) {
            System.out.println(contact.toString());
        }
    } 
}