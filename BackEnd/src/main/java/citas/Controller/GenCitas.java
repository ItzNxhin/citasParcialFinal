package citas.Controller;

import java.util.ArrayList;

import citas.Model.Buscadores;
import citas.Model.Postulantes;
import citas.Model.Database.PersonasDAO;

public class GenCitas {
    
    private PersonasDAO bd;

    public GenCitas(){
        bd = new PersonasDAO();
    }

    public ArrayList<Postulantes> matchs(Buscadores buscador){
        ArrayList<Postulantes> postulantesALL = new ArrayList<>();
        try {
            postulantesALL  = new ArrayList<>(bd.listaDePostulantes());
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        ArrayList<Postulantes> matchs  = new ArrayList<>();
        ArrayList<String> gustos  = new ArrayList<>(g_buscadores(buscador));

        for(Postulantes i : postulantesALL){
            int count = 0;
            ArrayList<String> c_post  = new ArrayList<>(c_postulante(i));
            for(String gusto : gustos){
                if(c_post.contains(gusto)){
                    count++;
                }
            }
            if(count>=3){
                matchs.add(i);
            }
        }

        return matchs;
    }

    private ArrayList<String> g_buscadores(Buscadores x){

        ArrayList<String> gustos =  new ArrayList<>();
        gustos.add(x.getG_Edad());
        gustos.add(x.getG_Identidad());
        gustos.add(x.getG_Interes());
        gustos.add(x.getG_contextura());
        gustos.add(x.getG_estatura());
        return gustos;
    }

    private ArrayList<String> c_postulante(Postulantes x){

        ArrayList<String> caracteristicas =  new ArrayList<>();
        caracteristicas.add(String.valueOf(x.getAge()));
        caracteristicas.add(x.getGender());
        caracteristicas.add(x.getInteres());
        caracteristicas.add(x.getPhysique());
        caracteristicas.add(String.valueOf(x.getHeight()));
        return caracteristicas;
    }
}
