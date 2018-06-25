/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import modelo.Jogador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Tiago Silvestre
 */
public class conn_Jogador {

    public static Jogador insert(Jogador jogador) {
        String sql = "insert into jogadores (nome, email, password, datecriacao) values"
                + " (?, ?, ?, ?)";
        try (Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, jogador.getSnome());
            ps.setString(2, jogador.getSemail());
            ps.setString(3, jogador.getSpassword());
            java.sql.Date dataCriacao = new java.sql.Date(jogador.getDdatecriacao().getTime());
            ps.setDate(4, dataCriacao);
            // ps.setInt(5, jogador.getIvocacao());
            ps.execute();
        } catch (Exception e) {
            System.out.println("chanaaa das aldeiaaa");
            // e.printStackTrace();
            return null;
        }
        return jogador;
    }

    //  para ser usado por todos
    public static Jogador updateJogador(Jogador jogador) {
        String sql = "update jogadores set password=?, email=? where nome=?";

        try (Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, jogador.getSpassword());
            ps.setString(2, jogador.getSemail());
            ps.setString(3, jogador.getSnome());
            ps.execute();
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("errroooo");
            return null;
        }
        return jogador;
    }

    /**
     * Verifica se tem o jogador pelo nome
     *
     */
    public static Jogador getJogador(String nome) {
        Jogador jogador = null;
        String sql = "select * from jogadores where nome=?";
        try (Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, nome);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    jogador = new Jogador();
                    jogador.setSnome(rs.getString("nome"));
                    jogador.setSemail(rs.getString("email"));
                    jogador.setSpassword(rs.getString("password"));
                    jogador.setDdatecriacao(rs.getDate("datecriacao"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jogador;
    }

    public static List<Jogador> getJogadores(List<Jogador> jogadores) {
        String sql = "select * from jogadores";
        Jogador jogador = null;
        try (Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    jogador = new Jogador();
                    jogador.setSnome(rs.getString("nome"));
                    jogador.setSemail(rs.getString("email"));
                    jogador.setSpassword(rs.getString("password"));
                    jogador.setDdatecriacao(rs.getDate("datecriacao"));

                    jogadores.add(jogador);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jogadores;
    }

    public static void excluirJogador(Jogador jogador) {
        String sql = "delete from jogadores where nome=?";
        try (Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, jogador.getSnome());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void banirJogador(Jogador jogador) {
        String sql = "update jogadores set password=? where nome=?";
        try (Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, jogador.getSpassword());
            ps.setString(2, jogador.getSnome());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public static Connection getConnection() {
        Connection c = null;
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            c = DriverManager.getConnection(
                    "jdbc:hsqldb:hsql://127.0.0.1/data",
                    "sa",
                    "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
}
