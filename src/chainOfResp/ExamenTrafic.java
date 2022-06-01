package chainOfResp;

public class ExamenTrafic extends Examen{
    public ExamenTrafic(int find){
        this.find = find;
    }

    @Override
    protected void write(String notify) {
        System.out.println("Programarea la examenul de trafic poate fi efectuata ->" + notify);
    }
}
