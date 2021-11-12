public enum Day {
    MONDAY(Type.NORMAL),
    TUESDAY(Type.NORMAL),
    WEDNESDAY(Type.NORMAL),
    THURSDAY(Type.NORMAL),
    FRIDAY(Type.NORMAL);
//    ,
//    SATURDAY(Type.WEEKEND),
//    SUNDAY(Type.WEEKEND),
//    BANK_HOLIDAY(Type.BANK_HOLIDAY);

    private Type type;
    private Day(Type type) {
        this.type = type;
    }

    public double pay(double time, double payRate) {
        // calculate the pay using the strategy: type.overtimePay(hours, payRate)
        return 0.0;
    }

    private enum Type {
        NORMAL {
            @Override
            double overtimePay(double hours, double payRate) {
                // todo: implement
                return 0.0;
            }
        };
        // same for WEEKEND and BANK_HOLIDAY

        abstract double overtimePay(double hours, double payRate);
    }
}
