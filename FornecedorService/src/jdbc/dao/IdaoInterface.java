package jdbc.dao;

import java.util.ArrayList;
import jdbc.model.Medico;
import jdbc.model.Paciente;

public interface IdaoInterface {

    //Medicos
    public ArrayList<Medico> consultarM();

    public Medico consultarM(int ID);

    public Medico cadastrarM(Medico med);

    public Medico consultarM(String nomeUsuario, String senha);

    public boolean excluirM(int ID);

    //Pacientes
    public ArrayList<Paciente> consultarP();

    public Paciente consultarP(int ID);

    public Paciente cadastrarP(Paciente pac);

    public boolean excluirP(int ID);
}
