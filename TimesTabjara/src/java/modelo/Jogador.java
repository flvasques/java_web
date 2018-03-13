/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import persistenia.IDAO;
import persistenia.JogadorDao;
/**
 *
 * @author Fernando Vasques
 */
public class Jogador {
    private int id = 0;
    private String nome = "";
    private Time meutime =  new Time();
;
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
    
        public static ArrayList<Jogador> listarJogadores(){
        IDAO service = new JogadorDao();
        return service.listar();
    }
    
    public void carregar(int id){
       IDAO service = new JogadorDao();
       Jogador retorno = (Jogador)service.carregar(id);
       this.id = retorno.getId();
       this.nome = retorno.getNome();
       
    }
    
    public void inserir(){
        IDAO service = new JogadorDao();
        service.inserir(this);
    }
    
    public void atulizar(){
        IDAO service = new JogadorDao();
        service.atualizar(this);
    }
    
    public void salvar(){
        if(this.id > 0){
            this.inserir();
        }else{
            this.atulizar();
        }
    }
    
    public void Excluir(){
        IDAO service = new JogadorDao();
        service.excluir(this.id);
    }
    public static void excluirPorTime(int id){
        IDAO service = new JogadorDao();
        ((JogadorDao)service).excluirPorTime(id);
    }
}
