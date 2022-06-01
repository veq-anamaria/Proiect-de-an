package chainOfResp;

public abstract class Examen {
    public static int trafic = 1;
    public static int poligon = 2;
    public static int teorie = 3;

    protected int find;
    protected Examen nextExamen;
    public void setNextExamen(Examen nextExamen){
        this.nextExamen = nextExamen;
    }
    public void Notify(int find, String notify){
        if(this.find <=find){
            write(notify);
        }
        if(nextExamen !=null){
            nextExamen.Notify(find, notify);
        }
    }

    protected abstract void write(String notify);

}
