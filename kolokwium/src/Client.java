import java.util.ArrayList;
import java.util.Date;

public class Client {
    String imie;
    String nazwisko;
    String email;
    String telefon;
    int rabat;
    private ArrayList<Sale> sales=new ArrayList<>();

    public Client(String imie, String nazwisko){
        setImie(imie);
        setNazwisko(nazwisko);
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
    public Client(String imie, String nazwisko, String email, String telefon,int rabat) {
        setImie(imie);
        setNazwisko(nazwisko);
        setRabat(rabat);
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.telefon = telefon;
        this.rabat=rabat;

    }

    public double buySoftwareLicense(SoftwareLicense product){
        if (product == null){
            throw new IllegalArgumentException("product cannot be null");
        }
        Sale s=findSaleForProduct(product);
        if (s == null){
            throw new IllegalArgumentException("product has been bougth");
        }
        double price=product.getPrice();
        if(rabat>0){
            price*=1-rabat/100.0;
        }
        Date now=new Date();
        Sale newSale=new Sale(product,now ,price);
        this.sales.add(newSale);
        return price;
    }
    public double buySubscription(Subscription subscription){
        if (subscription == null){
            throw new IllegalArgumentException("subscription cannot be null");
        }
        Sale s=findSaleForProduct(subscription);
        if (s!= null){
            throw new IllegalArgumentException("product has been bougth");

        }
        double price=subscription.getTotalCost();
        if (rabat>0){
            price*=1-rabat/100.0;
        }
        Date now=new Date();
        Sale newSale=new Sale(subscription,now ,price);
        this.sales.add(newSale);
        return price;

    }

    public void pay(Product p,double amount){
        if (p==null){
            throw new IllegalArgumentException("product cannot be null");
        }
        if (amount<0){
            throw new IllegalArgumentException("amount cannot be negative");
        }
        Sale s=findSaleForProduct(p);
        if (s == null){
            throw new IllegalArgumentException("Sale was not found");
        }
        s.pay(amount);

    }

    public double calculateTotal(){
        double totalCost=0;
        for (Sale s:sales){
            totalCost+=s.getTotalCost();
        }
        return totalCost;
    }

    public double calculateTotalCostToBePaid(){
        double totalCostToBePaid=0;
        for (Sale s:sales){
            totalCostToBePaid+=s.getTotalCostToBepaid();
        }
        return totalCostToBePaid;
    }
    private Sale findSaleForProduct(Product p){
        for(Sale s: sales){
            if(s.getProduct().equals(p)){
                return s;
            }
        }
        return null;
    }


    public String getImie() {
        return imie;
    }

    private void setImie(String imie) {
        if(imie==null){
            throw new IllegalArgumentException("Imie can't be null");
        }
        this.imie = imie;
    }

    public String getNazwisko() {
        if(nazwisko == null){
            throw new IllegalArgumentException("nazwisko can't be null");
        }
        return nazwisko;
    }

    private void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    private void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getRabat() {
        return rabat;
    }

    private void setRabat(int rabat) {
        if(rabat<0 || rabat>100){
            throw new IllegalArgumentException("rabat must be between 0 and 100");
        }
        this.rabat = rabat;
    }
}
