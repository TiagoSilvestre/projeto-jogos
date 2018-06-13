/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

import java.util.Date;

/**
 *
 * @author LuisGuilherme
 */
public class Jogador {

    private String snome;
    private String semail;
    private String spassword;
    private Date ddatecriacao;

    public String getSnome() {
        return snome;
    }

    public void setSnome(String snome) {
        this.snome = snome;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    public Date getDdatecriacao() {
        return ddatecriacao;
    }

    public void setDdatecriacao(Date ddatecriacao) {
        this.ddatecriacao = ddatecriacao;
    }

}
