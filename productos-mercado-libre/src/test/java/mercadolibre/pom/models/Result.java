package mercadolibre.pom.models;

public class Result {
    private String name;
    private String currency;
    private String price;
    private String link;

    public Result(String name, String currency, String price, String link) {
        this.name = name;
        this.currency = currency;
        this.price = price;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getLink() {
        return link;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Price: " + currency + " " + price + "\n" +
                "Link: " + link;
    }
}
