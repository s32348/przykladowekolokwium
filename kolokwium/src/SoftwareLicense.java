import java.util.Date;
import java.util.Objects;

public class SoftwareLicense implements Product{
    private String name;
    private String description;
    private double price;
    private String licenseKey;
    private Date activationDate;
    private UserType userType;

    public SoftwareLicense(String description, String name, double price, String licenseKey, Date activationDate, UserType userType) {
        setName(description);
        setDescription(description);
        setName(name);
        setLicenseKey(licenseKey);
        setActivationDate(activationDate);
        setUserType(userType);
        this.description = description;
        this.name = name;
        this.price = price;
        this.licenseKey = licenseKey;
        this.activationDate = activationDate;
        this.userType = userType;
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

    public UserType getUserType() {
        return userType;
    }

    private void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    private void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public String getLicenseKey() {
        return licenseKey;
    }

    private void setLicenseKey(String licenseKey) {
        this.licenseKey = licenseKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SoftwareLicense that)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
