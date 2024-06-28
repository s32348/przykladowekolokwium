import java.util.Objects;

public class Subscription implements Product{
    public static final int MIN = 1;
    public static final int MAX = 6;
    private String name;
    private String description;
    private double price;
    private int renewalPeriod;


    public double getTotalCost(){
        return price * renewalPeriod;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if(name==null){
            throw new IllegalArgumentException("Name can't be null");
        }
        this.name = name;

    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        if(description==null){
            throw new IllegalArgumentException("Description can't be null");
        }
        this.description = description;

    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        if (price<0){
            throw new IllegalArgumentException("Price cant be <0");
        }
        this.price = price;

    }

    public int getRenewalPeriod() {
        return renewalPeriod;
    }

    private void setRenewalPeriod(int renewalPeriod) {
        if(renewalPeriod< MIN || renewalPeriod>MAX){
            throw new IllegalArgumentException("Incorrect renewal period");
        }
        this.renewalPeriod = renewalPeriod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subscription that)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
