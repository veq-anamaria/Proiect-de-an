package decorator;

public class CategoriaD extends StudentAutoDecorator {
    public CategoriaD(FullAged fullAged) {//constructor matching super
        super(fullAged);
    }

    public String decorate() {
        return super.decorate() + decorateWithCategoriaD();
    }

    private String decorateWithCategoriaD() {
        return " Obtine permis de categoria D, vei putea conduce autobuze ";
    }
}
