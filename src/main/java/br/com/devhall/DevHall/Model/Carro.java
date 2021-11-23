package br.com.devhall.DevHall.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String marca;

    private String modelo;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    public Carro() {
    }

    public Carro(String marca, String modelo){
        this.marca = marca;
        this.modelo = modelo;
    }

    public Carro(String marca, String modelo, LocalDate dataCadastro) {
        this.marca = marca;
        this.modelo = modelo;
        this.dataCadastro = dataCadastro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
