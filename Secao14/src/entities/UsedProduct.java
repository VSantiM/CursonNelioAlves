package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product{
    private LocalDate manufactureDate;

    public UsedProduct(String name, Double price, LocalDate manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getName());
        sb.append(" (used) $ ");
        sb.append(super.getPrice());
        sb.append(" (Manufacture date: ");
        sb.append(manufactureDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        sb.append(")");
        return sb.toString();
    }
}
