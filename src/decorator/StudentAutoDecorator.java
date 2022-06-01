package decorator;

public class StudentAutoDecorator implements FullAged {
    private FullAged fullAged;

    public StudentAutoDecorator(FullAged fullAged) {
        this.fullAged = fullAged;
    }
    @Override
    public String decorate(){
        return fullAged.decorate();
    }
}
