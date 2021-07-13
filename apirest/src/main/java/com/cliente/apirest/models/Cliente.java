package com.cliente.apirest.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.Size;

@Entity
@Table(name="CLIENTE")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JoinColumn(name = "id")
    private Long id;

    @Size(min = 3, max = 100)
    @Column(name = "NOME")
    private String nome;

    @Column(name="CPF")
    private String CPF;

    @Column(name="CEP")
    private String cep;

    @Column(name ="LOGRADOURO")
    private String logradouro;

    @Column(name ="BAIRRO")
    private String bairro;

    @Column(name ="CIDADE")
    private String cidade;

    @Column(name ="UF")
    private String uf;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(name ="CODCONTATO")
    private List<Contato> telefones;

    @Column(name ="CODEMAIL")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Email> emails;

    public Cliente(long id) {
        super();
    }

    public Cliente() {

    }

//    Metodos de acesso Getters & Setters

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<Contato> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Contato> telefones) {
        this.telefones = telefones;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }
}
