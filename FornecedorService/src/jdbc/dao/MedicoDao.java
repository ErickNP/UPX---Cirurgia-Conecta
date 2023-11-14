package jdbc.dao;

import java.util.ArrayList;
import jdbc.model.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.model.Paciente;

public class MedicoDao implements IdaoInterface {

    private Connection conn;

    public MedicoDao() {
        conn = new ConnectionFactory().getConnection();
    }

    public ArrayList<Medico> consultarM() {
        ArrayList<Medico> lstMedicos = new ArrayList<>();
        String sql = "SELECT * FROM Medicos;";
        PreparedStatement comando;
        ResultSet resultado;
        try {
            comando = conn.prepareStatement(sql);
            resultado = comando.executeQuery();

            while (resultado.next()) {
                Medico m = new Medico();
                m.setId(resultado.getInt("ID"));
                m.setNome(resultado.getString("Nome"));
                m.setNomeUsuario(resultado.getString("NomeUsuario"));
                m.setSenha(resultado.getString("Senha"));
                lstMedicos.add(m);
            }
            return lstMedicos;
        } catch (SQLException err) {
            throw new RuntimeException(err.getMessage());
        }
    }

    @Override
    public Medico consultarM(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Medico cadastrarM(Medico med) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean excluirM(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //Herdados devido a declaração de interface
    @Override
    public ArrayList<Paciente> consultarP() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Paciente consultarP(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Paciente cadastrarP(Paciente pac) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean excluirP(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
