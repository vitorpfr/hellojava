package printerchallenge;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean isDuplexPrinter;

    public Printer(boolean isDuplexPrinter) {
        this.tonerLevel = 100;
        this.pagesPrinted = 0;
        this.isDuplexPrinter = isDuplexPrinter;
    }

    public int fillToner(int tonerAmount) {
        if (tonerAmount > 0 && tonerAmount <= 100) {
            this.tonerLevel = Math.min(100, tonerAmount + tonerLevel);
            System.out.println("Toner filled!");
            return tonerLevel;
        } else {
            return -1;
        }

    }

    public void printPage(int pages) {
        this.tonerLevel -= pages;
        int pagesEffectivelyPrinted = isDuplexPrinter ? (int) Math.ceil((double) pages / 2.0) : pages;
        pagesPrinted += pagesEffectivelyPrinted;
    }

    @Override
    public String toString() {
        return "Printer{" +
                "tonerLevel=" + tonerLevel +
                ", pagesPrinted=" + pagesPrinted +
                ", isDuplexPrinter=" + isDuplexPrinter +
                '}';
    }
}
