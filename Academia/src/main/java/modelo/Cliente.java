package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Fernando Vasques
 */
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    
    @Column
    @NotNull(message = "Campo nome obrigatório.") 
    @Size(min=1, max=10, message = "Tamanho maximo Para o nome é de 10 caracteres.")
    private String nome;
    
    @Column
    @NotNull(message = "Campo CPF obrigatório.") 
    private String cpf;
    
    @Column
    @NotNull(message = "Campo CPF obrigatório.") 
    private String email;
    
    @Column
    @NotNull(message = "Campo senha obrigatório.") 
    private String senha;
    private Date ultimoPagamento;
    private Date proximoPagamento;
    private ArrayList<Atividade> atividades;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getUltimoPagamento() {
        return ultimoPagamento;
    }

    public void setUltimoPagamento(Date ultimoPagamento) {
        this.ultimoPagamento = ultimoPagamento;
    }

    public Date getProximoPagamento() {
        return proximoPagamento;
    }

    public void setProximoPagamento(Date proximoPagamento) {
        this.proximoPagamento = proximoPagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(ArrayList<Atividade> atividades) {
        this.atividades = atividades;
    }
    
    
}
