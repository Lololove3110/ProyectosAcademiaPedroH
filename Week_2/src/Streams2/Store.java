package Streams2;

public class Store {
	private String name;
    private String product;
    private int distance;
    private int price;

    public Store(String name, String product, int distance, int price) {
        this.name = name;
        this.product = product;
        this.distance = distance;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", product='" + product + '\'' +
                ", distance=" + distance +
                ", price=" + price +
                '}';
    }

}
