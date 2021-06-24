package BillsBurgersOOPFinalChallenge;

public class HealthyBurger extends Hamburger {
    private String healthyExtra1Name;
    private double healthyExtra1Price;
    private String healthyExtra2Name;
    private double healthyExtra2Price;

    public HealthyBurger(String meat, double price) {
        super("Healthy", meat, price, "Brown");
    }

    public void addHealthyAddition1(String addition1Name, double addition1Price) {
        this.healthyExtra1Name = addition1Name;
        this.healthyExtra1Price = addition1Price;
    }

    public void addHealthyAddition2(String addition2Name, double addition2Price) {
        this.healthyExtra2Name = addition2Name;
        this.healthyExtra2Price = addition2Price;
    }

    @Override
    public double itemizeHamburger() {
        return super.itemizeHamburger() + this.healthyExtra1Price + this.healthyExtra2Price;
    }
}
