/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jdbc.model.EtapasPaciente;
import jdbc.model.Paciente;

/**
 *
 * @author liggia
 */
public class EtapasPacienteDao {
        private Connection conn;

    public EtapasPacienteDao() {
        conn = new ConnectionFactory().getConnection();
    }

    public ArrayList<EtapasPaciente> consultarM(int id) {
        ArrayList<EtapasPaciente> lstEtapas = new ArrayList<>();
        String sql = "select e.ID, e.Descricao, p.DataHoraInicio, p.Observacoes, m.Nome as medico, pa.Nome from progressocirurgia as p join etapascirurgia as e on e.ID = p.IDEtapaCirurgia \n" +
                        "join medicos as m on p.IDMédico = m.ID\n" +
                        "join pacientes as pa on p.IDPaciente = pa.ID\n" +
                        "where pa.ID = ?;";
        PreparedStatement comando;
        ResultSet resultado;
        try {
            comando = conn.prepareStatement(sql);
             comando.setInt(1, id);
            resultado = comando.executeQuery();

            while (resultado.next()) {
                EtapasPaciente m = new EtapasPaciente();
                m.setId(resultado.getInt("ID"));
                m.setDescricao(resultado.getString("Descricao"));
                m.setHorario(resultado.getString("DataHoraInicio"));
                m.setObservacao(resultado.getString("Observacoes"));
                m.setNomeMedico(resultado.getString("medico"));
                m.setNomePaciente(resultado.getString("Nome"));
                lstEtapas.add(m);
            }
            return lstEtapas;
        } catch (SQLException err) {
            throw new RuntimeException(err.getMessage());
        }
    }
    
    public boolean cadastrarProgresso(int idPac, int idM){
        String sql = "insert into progressocirurgia (\n" +
                    "    IDEtapaCirurgia,\n" +
                    "    DataHoraInicio, \n" +
                    "    Observacoes,\n" +
                    "    IDPaciente,\n" +
                    "    IDMédico) values (1, now(), '', ?, ?);";
        PreparedStatement comando;
        try {
            comando = conn.prepareStatement(sql);
            comando.setInt(1, idPac);
            comando.setInt(2, idM);
            int linhasAfetadas = comando.executeUpdate();
            
            if (linhasAfetadas > 0) {
                return true;
            }
            else{
                return false;
            }
            
        } catch (SQLException erro) {
            throw new RuntimeException(erro.getMessage());
        }
            
    }
    
    public ArrayList<Paciente> consultarPacientes(int idM) {
        ArrayList<Paciente> lstMedicos = new ArrayList<>();
        String sql = "select distinct m.Nome as medico, pa.* from progressocirurgia as p \n" +
                        "join medicos as m on p.IDMédico = m.ID\n" +
                        "join pacientes as pa on p.IDPaciente = pa.ID\n" +
                        "where m.ID = ?;";
        PreparedStatement comando;
        ResultSet resultado;
        try {
            comando = conn.prepareStatement(sql);
            comando.setInt(1, idM);
            resultado = comando.executeQuery();

            while (resultado.next()) {
                Paciente p = new Paciente();
                p.setId(resultado.getInt("ID"));
                p.setNome(resultado.getString("Nome"));
                p.setRg(resultado.getString("RG"));
                p.setData(resultado.getString("DataNasc"));
                p.setConvenio(resultado.getString("Convenio"));
                p.setNumeroConv(resultado.getInt("NumeroConv"));
                p.setTelefone(resultado.getString("Telefone"));
                p.setEmail(resultado.getString("Email"));
                p.setCidade(resultado.getString("Cidade"));
                p.setCep(resultado.getString("CEP"));
                p.setMedico(resultado.getString("medico"));
                lstMedicos.add(p);
            }
            return lstMedicos;
        } catch (SQLException err) {
            throw new RuntimeException(err.getMessage());
        }
    }
    
        public boolean cadastrarProgresso(int idEtapa, int idPac, int idM, String obs){
        String sql = "insert into progressocirurgia (\n" +
                    "    IDEtapaCirurgia,\n" +
                    "    DataHoraInicio, \n" +
                    "    Observacoes,\n" +
                    "    IDPaciente,\n" +
                    "    IDMédico) values (?, now(), ?, ?, ?);";
        PreparedStatement comando;
        try {
            comando = conn.prepareStatement(sql);
            comando.setInt(1, idEtapa);
            comando.setString(2, obs);
            comando.setInt(3, idPac);
            comando.setInt(4, idM);
            int linhasAfetadas = comando.executeUpdate();
            
            if (linhasAfetadas > 0) {
                return true;
            }
            else{
                return false;
            }
            
        } catch (SQLException erro) {
            throw new RuntimeException(erro.getMessage());
        }
            
    }
}
