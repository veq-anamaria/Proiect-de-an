package chainOfResp;

public class ExamenTeorie extends Examen {
    public ExamenTeorie(int find){
        this.find = find;
    }

    @Override
    protected void write(String notify) {
        System.out.println("Programarea la examenul de teorie poate fi efectuata ->" + notify);
    }
}
