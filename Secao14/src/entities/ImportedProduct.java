package entities;

public class ImportedProduct extends Product{
    private Double customsFee;

    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public Double totalPrice() {
        return super.getPrice() + customsFee;
    }

    @Override
    public String priceTag() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getName());
        sb.append(" $ ");
        sb.append(totalPrice());
        sb.append(" (Customs fee: $ ");
        sb.append(customsFee);
        sb.append(")");
        return sb.toString();
    }
}
