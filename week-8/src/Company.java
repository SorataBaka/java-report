import java.util.Date;
class Company {
    String name;
    Date founded;
    String[] sector;
    String stockSymbol;
    double stockPrice;
    String currentTrend;
    Company(String name, Date founded, String[] sector, String stockSymbol, double stockPrice){
        this.name = name;
        this.founded = founded;
        this.sector = sector;
        this.stockSymbol = stockSymbol;
        this.stockPrice = stockPrice;
        this.currentTrend = "=";
    }

    void updatePrice(double newPrice){
        if(newPrice == this.stockPrice){
            this.currentTrend = "=";
        }
        if(newPrice > this.stockPrice){
            this.currentTrend = "^";
        }
        if(newPrice < this.stockPrice) {
            this.currentTrend = "v";
        }

        this.stockPrice = newPrice;

        System.out.println(String.format("株価が更新されました。現在、株式%sは%.02fに変更されました。トレンドは%s", this.stockSymbol, newPrice, this.currentTrend ));
    }
}