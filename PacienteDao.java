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
        String sql = "SELECT * FROM Medicos;";
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
                p.setTelefone(resultado.getInt("Telefone"));
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
        String sql = "SELECT * FROM Pacientes WHERE ID = ?;";
        PreparedStatement comando;
        ResultSet resultado;
        try {
            comando = conn.prepareStatement(sql);
            comando.setInt(1, ID);
            resultado = comando.executeQuery();

            if (resultado.next()) {
                Paciente p = new Paciente();
                p.setId(resultado.getInt("ID"));
                p.setNome(resultado.getString("Nome"));
                p.setRg(resultado.getString("RG"));
                p.setData(resultado.getDate("DataNasc"));
                p.setConvenio(resultado.getString("Convenio"));
                p.setNumeroConv(resultado.getInt("NumeroConv"));
                p.setTelefone(resultado.getInt("Telefone"));
                p.setEmail(resultado.getString("Email"));
                p.setCidade(resultado.getString("Cidade"));
                p.setCep(resultado.getString("CEP"));
                return p;
            } else {
                return null;
            }
        } catch (SQLException err) {
            throw new RuntimeException(err.getMessage());
        }
    }

    @Override
    public Paciente cadastrarP(Paciente pac) {
        String sql = "INSERT INTO Pacientes (Nome, RG, DataNasc, Convenio, NumeroConv, Telefone, Email, Cidade, CEP) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement comando;

        try {
            comando = conn.prepareStatement(sql);
            comando.setString(1, pac.getNome());
            comando.setString(2, pac.getRg());
            comando.setDate(3, pac.getData());
            comando.setString(4, pac.getConvenio());
            comando.setInt(5, pac.getNumeroConv());
            comando.setInt(6, pac.getTelefone());
            comando.setString(7, pac.getEmail());
            comando.setString(8, pac.getCidade());
            comando.setString(9, pac.getCep());
            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas == 0) {
                throw new SQLException("Falha ao cadastrar o Paciente.");
            }

            return pac;
        } catch (SQLException err) {
            throw new RuntimeException(err.getMessage());
        }
    }

    @Override
    public boolean excluirP(int ID) {

        String sql = "DELETE FROM Pacientes WHERE ID = ?;";
        PreparedStatement comando;

        try {
            comando = conn.prepareStatement(sql);
            comando.setInt(1, ID);

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException err) {
            throw new RuntimeException(err.getMessage());
        }
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

    @Override
    public Medico consultarM(String nomeUsuario, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
