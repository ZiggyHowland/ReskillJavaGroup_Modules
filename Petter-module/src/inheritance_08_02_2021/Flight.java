package inheritance_08_02_2021;

public abstract class Flight {
  private String flightCode; //Guessing this is unique
  private String from;
  private String to;
  private double flightDuration;

  public Flight(String flightCode, String from, String to, double flightDuration) {
    this.flightCode = flightCode;
    this.from = from;
    this.to = to;
    this.flightDuration = flightDuration;
  }

  @Override
  public String toString() {
    return "Flight{" +
            "flightCode='" + flightCode + '\'' +
            ", from=" + from +
            ", to=" + to +
            ", flightDuration=" + flightDuration +
            '}';
  }
}
