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
}
