public class InterfacesTest {
    public static void main(String[] args) {

        // here I can say that 'timsPhone' will have the ITelephone interface, but the object needs to be instantiated
        // with a class that implements this interface
        ITelephone timsPhone;                                   // this could be 'DeskPhone timsPhone;'
        timsPhone = new DeskPhone(123456);

        timsPhone.powerOn();
        timsPhone.callPhone(123456);
        timsPhone.answer();

        timsPhone = new MobilePhone(522221);          // reassignment only worked because type of timsPhone is a interface
        timsPhone.powerOn();
        timsPhone.callPhone(522221);
        timsPhone.answer();

    }
}
