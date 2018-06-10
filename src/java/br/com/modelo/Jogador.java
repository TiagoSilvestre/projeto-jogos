/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

import java.util.Date;

/**
 *
 * @author comp8
 */
public class Jogador {
   private String snome;
   private String semail;
   private String spassword;
   private Date ddatecriacao;
   private int ivocacao;
   private boolean badministrador;
   private boolean bbanido;
   private int ipoderdemagia;
   private int ipoderdesword;
   private int ipoderdeaxe;
   private int ipoderdedefesa;

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

    public int getIvocacao() {
        return ivocacao;
    }

    public void setIvocacao(int ivocacao) {
        this.ivocacao = ivocacao;
    }

    public boolean isBadministrador() {
        return badministrador;
    }

    public void setBadministrador(boolean badministrador) {
        this.badministrador = badministrador;
    }

    public boolean isBbanido() {
        return bbanido;
    }

    public void setBbanido(boolean bbanido) {
        this.bbanido = bbanido;
    }

    public int getIpoderdemagia() {
        return ipoderdemagia;
    }

    public void setIpoderdemagia(int ipoderdemagia) {
        this.ipoderdemagia = ipoderdemagia;
    }

    public int getIpoderdesword() {
        return ipoderdesword;
    }

    public void setIpoderdesword(int ipoderdesword) {
        this.ipoderdesword = ipoderdesword;
    }

    public int getIpoderdeaxe() {
        return ipoderdeaxe;
    }

    public void setIpoderdeaxe(int ipoderdeaxe) {
        this.ipoderdeaxe = ipoderdeaxe;
    }

    public int getIpoderdedefesa() {
        return ipoderdedefesa;
    }

    public void setIpoderdedefesa(int ipoderdedefesa) {
        this.ipoderdedefesa = ipoderdedefesa;
    }
}
