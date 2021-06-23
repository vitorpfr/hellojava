public class VipCustomer {
    private String name;
    private int creditLimit;
    private String emailAddress;

    public VipCustomer(String name, int creditLimit, String emailAddress) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.emailAddress = emailAddress;
    }

    public VipCustomer() {
        this("defaultName", 100, "default@default.com");
    }

    public VipCustomer(String name, String emailAddress) {
        this(name, 50, emailAddress);
    }

    public String getName() {
        return name;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "VipCustomer{" +
                "name='" + name + '\'' +
                ", creditLimit=" + creditLimit +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
