package adapter;

public class EuroToLei implements PayExamLei {
    private PayExamEuro money;

    public EuroToLei(PayExamEuro money) {
        this.money = money;
    }

    @Override
    public double getAmount() {

        return convertEurotoLei(money.getAmount());
    }

    private double convertEurotoLei(double m) {
        return m * 21.60;
    }
}


