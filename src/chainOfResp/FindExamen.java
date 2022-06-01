package chainOfResp;

public class FindExamen {
    private static Examen getChainExamen(){
        Examen trafic = new ExamenTrafic(Examen.trafic);
        Examen poligon = new ExamenPoligon(Examen.poligon);
        Examen teorie = new ExamenTeorie(Examen.teorie);

        teorie.setNextExamen(poligon);
        poligon.setNextExamen(trafic);

        return trafic;
    }
    public static void main(String[] args){
        Examen examen = getChainExamen();
        examen.Notify(Examen.teorie, "Succes la examenul de teorie!");
        examen.Notify(Examen.poligon, "Succes la examenul de la poligon!");
        examen.Notify(Examen.trafic, "Succes la examenul de la trafic!");

    }
}
