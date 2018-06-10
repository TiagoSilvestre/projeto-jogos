/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import br.com.modelo.Jogador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author comp8
 */
public class ConexaoJogador {
//    public static void adicionar(Jogador jogador){
//        Jogador temJogador = getJogador(jogador.getSemail());
//        if(temJogador == null){
//            insert(jogador);
//        }else{
//            update(jogador);
//        }
//    }
    
    // quando é criado uma conta ele vai cadastrar apenas os dados necessarios,
    // apos a criação da conta 
    public static Jogador insert(Jogador jogador){
        String sql = "insert into jogadores (nome, email, password, datecriacao, vocacao) values"
                + " (?, ?, ?, ?, ?)";
        try (Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql)){
            ps.setString(1, jogador.getSnome());
            ps.setString(2, jogador.getSemail());
            ps.setString(3, jogador.getSpassword());            
            java.sql.Date dataCriacao = new java.sql.Date(jogador.getDdatecriacao().getTime());
            ps.setDate(4, dataCriacao);
            ps.setInt(5, jogador.getIvocacao());
            ps.execute();
        }catch(Exception e){
            //e.printStackTrace();
            return null;
        }
        return jogador;
    }

    // para ser usado pelo administrador
    public static void updateJogador(Jogador jogador){
        String sql = "";
    }
    
    //  para ser usado por todos
    public static Jogador updatePassword(Jogador jogador){
        String sql = "update jogadores set password=? where nome=?";
        
        try(Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql)){
            ps.setString(1, jogador.getSpassword());
            ps.setString(2, jogador.getSnome());
            ps.execute();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return jogador;
    }
    
    /** 
     * Verifica se tem o jogador pelo nome 
     **/
    public static Jogador getJogador(String nome){
        Jogador jogador = null;
        String sql = "select * from jogadores where nome=?";
        try (Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql)){
            ps.setString(1, nome);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    jogador = new Jogador();
                    jogador.setSnome(rs.getString("nome"));
                    jogador.setSemail(rs.getString("email"));
                    jogador.setSpassword(rs.getString("password"));
                    jogador.setDdatecriacao(rs.getDate("datecriacao"));
                    jogador.setIvocacao(rs.getInt("vocacao"));
                    jogador.setBadministrador(rs.getBoolean("administrador"));
                    jogador.setBbanido(rs.getBoolean("banido"));
                    jogador.setIpoderdemagia(rs.getInt("poderdemagia"));
                    jogador.setIpoderdesword(rs.getInt("poderdesword"));
                    jogador.setIpoderdeaxe(rs.getInt("poderdeaxe"));
                    jogador.setIpoderdedefesa(rs.getInt("poderdedefesa"));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return jogador;
    }
    
    public static Jogador getTemLoginJogador(String email, String password){
        Jogador jogador = null;     
        
        String sql = "select * from jogadores where email=? and password=?";
        try (Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql)){
            ps.setString(1, email);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    // lembrando que boolean é tem ou não tem "1 - 0"                    
                    //bTemConta = rs.getBoolean("");
                    // String sql = "select count(email) from jogadores where email=? and password=?";
                    
                    jogador = new Jogador();
                    jogador.setSnome(rs.getString("nome"));
                    jogador.setSemail(rs.getString("email"));
                    jogador.setSpassword(rs.getString("password"));
                    jogador.setDdatecriacao(rs.getDate("datecriacao"));
                    jogador.setIvocacao(rs.getInt("vocacao"));
                    jogador.setBadministrador(rs.getBoolean("administrador"));
                    jogador.setBbanido(rs.getBoolean("banido"));
                    jogador.setIpoderdemagia(rs.getInt("poderdemagia"));
                    jogador.setIpoderdesword(rs.getInt("poderdesword"));
                    jogador.setIpoderdeaxe(rs.getInt("poderdeaxe"));
                    jogador.setIpoderdedefesa(rs.getInt("poderdedefesa"));                    
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return jogador;
    }
    
    public static List<Jogador> getJogadores(List<Jogador> jogadores){
        String sql = "select * from jogadores";
        Jogador jogador = null;
        try (Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql)){
            try (ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    jogador = new Jogador();
                    jogador.setSnome(rs.getString("nome"));
                    jogador.setSemail(rs.getString("email"));
                    jogador.setSpassword(rs.getString("password"));
                    jogador.setDdatecriacao(rs.getDate("datecriacao"));
                    jogador.setIvocacao(rs.getInt("vocacao"));
                    jogador.setBadministrador(rs.getBoolean("administrador"));
                    jogador.setBbanido(rs.getBoolean("banido"));
                    jogador.setIpoderdemagia(rs.getInt("poderdemagia"));
                    jogador.setIpoderdesword(rs.getInt("poderdesword"));
                    jogador.setIpoderdeaxe(rs.getInt("poderdeaxe"));
                    jogador.setIpoderdedefesa(rs.getInt("poderdedefesa")); 
                    
                    jogadores.add(jogador);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return jogadores;
    }
    
    public static void excluirJogador(Jogador jogador){
        String sql = "delete from jogadores where nome=?";
        try (Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql)){
            ps.setString(1, jogador.getSnome());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void banirJogador(Jogador jogador){
        String sql = "update jogadores set banido=? where nome=?";
        try(Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql)){
            ps.setBoolean(1, true);
            ps.setString(2, jogador.getSnome());
            ps.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection(){                
        Connection c = null;
        try{
            Class.forName("org.hsqldb.jdbcDriver");
            c = DriverManager.getConnection(
                    "jdbc:hsqldb:hsql://127.0.0.1/data",
                    "sa",
                    "");
        }catch(Exception e){            
            e.printStackTrace();
        }
        return c;
    }
    
}
