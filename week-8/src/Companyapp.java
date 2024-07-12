import java.util.Date;
class Companyapp {
    public static void main(String[] args) {
        String[] sectors = new String[2];
        sectors[0] = "Technology";
        sectors[1] = "Lifestyle";
        Company company = new Company("Apple", new Date(1976 - 1900, 4, 1), sectors, "AAPL", 186.88);

        company.updatePrice(190.00);
        company.updatePrice(180.00);
        company.updatePrice(180.00);
        company.updatePrice(170.00);
        company.updatePrice(176.00);
        company.updatePrice(180.00);
        company.updatePrice(190.00);

    }
}