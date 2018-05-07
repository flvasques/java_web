/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import persistencia.AlunoDao;

/**
 *
 * @author Fernando Vasques
 */
public class Aluno {
    private int matricula;
    private String nome;
    
    public Aluno(){
        this.matricula = 0;
        this.nome = "";
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void salvar(){
        AlunoDao service = new AlunoDao();
        if(this.matricula > 0){
            service.atualizar(this);
        }else{
            this.matricula = service.inserir(this);
        }
    }
    
    public static ArrayList<Aluno> listar(){
        return new AlunoDao().listar();
    }
}
