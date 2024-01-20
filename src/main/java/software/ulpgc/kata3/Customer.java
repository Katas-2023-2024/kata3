package software.ulpgc.kata3;

public class Customer {
    private final String customerId;
    public final String firstName;
    public final String lastName;
    public final String company;
    public final String city;
    public final String country;
    public final String phone1;
    public final String phone2;
    public final String email;
    public final String susbcriptionDate;
    public final String website;

    public Customer(String customerId, String firstName, String lastName, String company, String city, String country, String phone1, String phone2, String email, String susbcriptionDate, String website) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.city = city;
        this.country = country;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.email = email;
        this.susbcriptionDate = susbcriptionDate;
        this.website = website;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone1() {
        return phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getEmail() {
        return email;
    }

    public String getSusbcriptionDate() {
        return susbcriptionDate;
    }

    public String getWebsite() {
        return website;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", phone1='" + phone1 + '\'' +
                ", phone2='" + phone2 + '\'' +
                ", email='" + email + '\'' +
                ", susbcriptionDate='" + susbcriptionDate + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
