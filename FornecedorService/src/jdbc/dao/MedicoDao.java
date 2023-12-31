package jdbc.dao;

import java.beans.Statement;
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

        String sql = "SELECT * FROM Medicos WHERE ID = ?;";
        PreparedStatement comando;
        ResultSet resultado;
        try {
            comando = conn.prepareStatement(sql);
            comando.setInt(1, ID);
            resultado = comando.executeQuery();

            if (resultado.next()) {
                Medico m = new Medico();
                m.setId(resultado.getInt("ID"));
                m.setNome(resultado.getString("Nome"));
                m.setNomeUsuario(resultado.getString("NomeUsuario"));
                m.setSenha(resultado.getString("Senha"));
                return m;
            } else {
                return null;
            }
        } catch (SQLException err) {
            throw new RuntimeException(err.getMessage());
        }

    }

    @Override
    public Medico cadastrarM(Medico med) {

        String sql = "INSERT INTO Medicos (Nome, NomeUsuario, Senha) VALUES (?, ?, ?);";
        PreparedStatement comando;

        try {
            comando = conn.prepareStatement(sql);
            comando.setString(1, med.getNome());
            comando.setString(2, med.getNomeUsuario());
            comando.setString(3, med.getSenha());

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas == 0) {
                throw new SQLException("Falha ao cadastrar o médico.");
            }

            return med;
        } catch (SQLException err) {
            throw new RuntimeException(err.getMessage());
        }

    }

    @Override
    public boolean excluirM(int ID) {

        String sql = "DELETE FROM Medicos WHERE ID = ?;";
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

    @Override
    public Medico consultarM(String nomeUsuario, String senha) {

        String sql = "SELECT * FROM Medicos WHERE NomeUsuario = ? AND Senha = ?;";
        PreparedStatement comando;
        ResultSet resultado;

        try {
            comando = conn.prepareStatement(sql);
            comando.setString(1, nomeUsuario);
            comando.setString(2, senha);

            resultado = comando.executeQuery();

            if (resultado.next()) {
                Medico m = new Medico();
                m.setId(resultado.getInt("ID"));
                m.setNome(resultado.getString("Nome"));
                m.setNomeUsuario(resultado.getString("NomeUsuario"));
                m.setSenha(resultado.getString("Senha"));
                return m;
            } else {
                return null;
            }
        } catch (SQLException err) {
            throw new RuntimeException(err.getMessage());
        }
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
