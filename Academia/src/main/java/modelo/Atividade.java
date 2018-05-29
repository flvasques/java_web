
package modelo;

import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Fernando Vasques
 */
@Entity
@Table(name = "atividade")
public class Atividade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    
    @Column
    @NotNull(message = "Campo nome obrigatório.")
    private String nome;
    @Column
    @NotNull(message = "Campo nome obrigatório.")
    private double preco;
    
    private ArrayList<Cliente> participantes;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Cliente> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Cliente> participantes) {
        this.participantes = participantes;
    }
    
    
  
}
