public class Contact {
    private String name;
    private String phone;

    public Contact(String name, String phone)
    {
        this.name = name;
        this.phone = phone;
    }

    // Getters
    public String getName() { return name; };
    public String getPhone() { return phone; };

    // Override toString
    public String toString()
    {
        return String.join(" | ", name, phone);
    } 
}