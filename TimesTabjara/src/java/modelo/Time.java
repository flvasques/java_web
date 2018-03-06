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
public class Time {
    private int id;
    private String nome;
    private ArrayList<Jogador> jogadores;

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

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }
    
    public static ArrayList<Time> listarTimes(){
        IDAO service = new TimeDao();
        return service.listar();
    }
    
    public static Time carregar(int id){
       IDAO service = new TimeDao();
       Time retorno = (Time)service.carregar(id);
       retorno.listarJogadores();
       return retorno;
    }
    
    public void inserir(){
        IDAO service = new TimeDao();
        service.inserir(this);
    }
    
    public void atulizar(){
        IDAO service = new TimeDao();
        service.atualizar(this);
    }
    
    public void Excluir(){
        IDAO service = new TimeDao();
        service.excluir(this.id);
    }
    
    public void listarJogadores(){
        IDAO service = new JogadorDao();
        this.jogadores = ((JogadorDao)service).listar(this.id);
    }
    
}
