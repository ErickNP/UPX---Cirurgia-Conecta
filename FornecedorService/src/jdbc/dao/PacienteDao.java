package jdbc.dao;

import java.util.ArrayList;
import jdbc.model.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.model.Medico;

public class PacienteDao implements IdaoInterface {

    private Connection conn;

    public PacienteDao() {
        conn = new ConnectionFactory().getConnection();
    }

    @Override
    public ArrayList<Paciente> consultarP() {
        ArrayList<Paciente> lstPacientes = new ArrayList<>();
        String sql = "SELECT * FROM Pacientes;";
        PreparedStatement comando;
        ResultSet resultado;
        try {
            comando = conn.prepareStatement(sql);
            resultado = comando.executeQuery();

            while (resultado.next()) {
                Paciente p = new Paciente();
                p.setId(resultado.getInt("ID"));
                p.setNome(resultado.getString("Nome"));
                p.setRg(resultado.getString("RG"));
                p.setData(resultado.getDate("DataNasc"));
                p.setConvenio(resultado.getString("Convenio"));
                p.setNumeroConv(resultado.getInt("NumeroConv"));
                p.setTelefone(resultado.getString("Telefone"));
                p.setEmail(resultado.getString("Email"));
                p.setCidade(resultado.getString("Cidade"));
                p.setCep(resultado.getString("CEP"));
                lstPacientes.add(p);
            }
            return lstPacientes;
        } catch (SQLException err) {
            throw new RuntimeException(err.getMessage());
        }
    }

    @Override
    public Paciente consultarP(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Paciente consultarP(String email, String rg){
        Paciente p = new Paciente();
        String sql = "select * from pacientes where email = ? and rg = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultado;
        try {
            preparedStatement = conn.prepareCall(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, rg);
            resultado = preparedStatement.executeQuery();
            if (resultado.next()) {
                p.setId(resultado.getInt("ID"));
                p.setNome(resultado.getString("Nome"));
                p.setRg(resultado.getString("RG"));
                p.setData(resultado.getDate("DataNasc"));
                p.setConvenio(resultado.getString("Convenio"));
                p.setNumeroConv(resultado.getInt("NumeroConv"));
                p.setTelefone(resultado.getString("Telefone"));
                p.setEmail(resultado.getString("Email"));
                p.setCidade(resultado.getString("Cidade"));
                p.setCep(resultado.getString("CEP"));
                return p;
            }else{
                return null;
            }

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Paciente cadastrarP(Paciente pac) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean excluirP(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //Herdados devido a declaração de interface
    @Override
    public ArrayList<Medico> consultarM() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
}
