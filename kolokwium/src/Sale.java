import java.util.Calendar;
import java.util.Date;

public class Sale {
    private static int NEXT_ID=1;
    private int id;
    private Product product;
    private Date dateOfSale;
    private Date deadline;


    private double totalCost;
    private double pricePaid;

    public Sale(Product product, Date dateOfSale, double cost) {
        this.id=NEXT_ID++;
        this.product = product;
        this.dateOfSale = dateOfSale;
        this.deadline = calculateDeadline(dateOfSale);
        this.totalCost = cost;
    }

    public double getTotalCostToBepaid(){
        return totalCost-pricePaid;
    }
    private Date calculateDeadline(Date date) {
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(dateOfSale);
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }
    public void pay (double amount){
        if(pricePaid>=totalCost){
            throw new IllegalArgumentException("Sale has been paid");
        }
        if(pricePaid+amount>pricePaid){
            throw new IllegalArgumentException("Amount is too high");
        }
        Date now=new Date();
        if(deadline.before(now)){
            throw new IllegalArgumentException("Deadline has passed");
        }
        this.pricePaid+=amount;
    }

    public static int getNextId() {
        return NEXT_ID;
    }

    private static void setNextId(int nextId) {
        NEXT_ID = nextId;
    }

    public Product getProduct() {
        return product;
    }

    private void setProduct(Product product) {
        this.product = product;
    }

    public Date getDateOfSale() {
        return dateOfSale;
    }

    private void setDateOfSale(Date dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public Date getDeadline() {
        return deadline;
    }

    private void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public double getTotalCost() {
        return totalCost;
    }

    private void setTotalCost(double totalCost) {
        if(totalCost<0){
            throw new IllegalArgumentException("Cost cannot be negative");
        }
        this.totalCost = totalCost;
    }

    public double getPricePaid() {
        return pricePaid;
    }

    private void setPricePaid(double pricePaid) {
        this.pricePaid = pricePaid;
    }
}
