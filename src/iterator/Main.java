package iterator;

public class Main {
    public static void main(String[] args) {
        MailRepository mailRepository = new MailRepository();
        System.out.println("Lista de email pentru a trimite notificari cind permisul este gata: ");

        for(Folowing item = mailRepository.getFolowing(); item.theNext();){
            String name = (String)item.next();
            System.out.println("Email: " + name);
        }
    }
}
