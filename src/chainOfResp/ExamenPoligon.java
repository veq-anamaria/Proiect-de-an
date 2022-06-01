package chainOfResp;

public class ExamenPoligon extends  Examen{
    public ExamenPoligon(int find){
        this.find = find;
    }

    @Override
    protected void write(String notify) {
        System.out.println("Programarea la examenul de poligon poate fi efectuata ->" + notify);
    }
}
