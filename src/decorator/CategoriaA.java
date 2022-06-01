package decorator;

public class CategoriaA extends StudentAutoDecorator {

    public CategoriaA(FullAged cake) {
        super(cake);
    }

    public String decorate() {
        return super.decorate() + decorateWithCategoriaA();
    }

    private String decorateWithCategoriaA() {
        return " Obtine permis de categoria A, vei putea conduce motociclete ";
    }
}
