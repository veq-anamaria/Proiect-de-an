package adapter;

public class Main {
    public static void main(String[] args) {
        PayExamEuro employee = new PayService();
        PayExamLei employeeAdapter = new EuroToLei(employee);
        System.out.println("Suma spre plata in euro " + employee.getAmount());
        System.out.println("Suma spre plata in lei " + employeeAdapter.getAmount());
    }
}





