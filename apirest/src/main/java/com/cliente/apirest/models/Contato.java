package com.cliente.apirest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.property.access.spi.Setter;

import javax.persistence.*;

@Entity
@Table(name="CONTATO")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="ID")
    private Long id;

    @Column(name = "TELEFONE")
    private String telefone;

    @Column(name = "TIPO")
    private String tipo;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "IDCLIENTE")
    private Cliente cliente;

//    Metodos de acessos Getters & Setters ********************************
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
