package decorator;

public class Student implements FullAged {

    @Override
    public String decorate(){
        return " Potential student la scoala auto ";
    }
}
