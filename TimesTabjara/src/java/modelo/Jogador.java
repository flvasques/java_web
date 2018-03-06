/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import persistenia.IDAO;
import persistenia.JogadorDao;
import persistenia.TimeDao;

/**
 *
 * @author Fernando Vasques
 */
public class Jogador {
    private int id;
    private String nome;
    private Time meutime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Time getMeutime() {
        return meutime;
    }

    public void setMeutime(Time meutime) {
        this.meutime = meutime;
    }
    
        public static ArrayList<Time> listarTimes(){
        IDAO service = new TimeDao();
        return service.listar();
    }
    
    public static Jogador carregar(int id){
       IDAO service = new JogadorDao();
       Jogador retorno = (Jogador)service.carregar(id);
       return retorno;
    }
    
    public void inserir(){
        IDAO service = new JogadorDao();
        service.inserir(this);
    }
    
    public void atulizar(){
        IDAO service = new JogadorDao();
        service.atualizar(this);
    }
    
    public void Excluir(){
        IDAO service = new JogadorDao();
        service.excluir(this.id);
    }
}
