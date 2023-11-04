package data;

public class coinData {
    String coinName;
    String price;
    String PercentChange1h;
    String PercentChange24h;
    String PercentChange7d;
    String currency;

    public coinData(String coinName,String price,String PercentChange1h,String PercentChange24h, String PercentChange7d,String currency) {
        this.coinName = coinName;
        this.price=price;
        this.PercentChange1h=PercentChange1h;
        this.PercentChange24h=PercentChange24h;
        this.PercentChange7d=PercentChange7d;
        this.currency=currency;

    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPercentChange1h() {
        return PercentChange1h;
    }

    public void setPercentChange1h(String percentChange1h) {
        PercentChange1h = percentChange1h;
    }

    public String getPercentChange24h() {
        return PercentChange24h;
    }

    public void setPercentChange24h(String percentChange24h) {
        PercentChange24h = percentChange24h;
    }

    public String getPercentChange7d() {
        return PercentChange7d;
    }

    public void setPercentChange7d(String percentChange7d) {
        PercentChange7d = percentChange7d;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
