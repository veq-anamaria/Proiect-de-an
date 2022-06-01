package decorator;

public class Main {
    public static void main(String[] args) {
        FullAged fullAged1 = new CategoriaB(new Student());
        System.out.println(fullAged1.decorate());

        FullAged fullAged2 = new CategoriaA(new CategoriaB(new CategoriaD(new Student())));
        System.out.println(fullAged2.decorate());

        FullAged fullAged3 = new CategoriaA(new CategoriaB(new Student()));
        System.out.println(fullAged3.decorate());
    }
}
