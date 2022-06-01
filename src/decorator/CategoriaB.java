package decorator;

public class CategoriaB extends StudentAutoDecorator {
    public CategoriaB(FullAged cake) {//constructor matching super
        super(cake);
    }

    public String decorate() {
        return super.decorate() + decorateWithCategoriaB();
    }

    private String decorateWithCategoriaB() {
        return " Obtine permis de categoria B, vei putea conduce masini  ";
    }
}
