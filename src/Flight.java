public class Flight {
  private int id;
  private String airlines,source,destination;
  private double price;

  public Flight(int id, String airlines,double price, String source, String destination) {
    this.id = id;
    this.airlines = airlines;
    this.source = source;
    this.destination = destination;
    this.price = price;
  }

  @Override public String toString() {
    return "Flight{" +
        "id=" + id +
        ", airlines='" + airlines + '\'' +
        ", source='" + source + '\'' +
        ", destination='" + destination + '\'' +
        ", price=" + price +
        '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAirlines() {
    return airlines;
  }

  public void setAirlines(String airlines) {
    this.airlines = airlines;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
