package br.com.devhall.DevHall.Model;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "carro_cliente")
public class CarroCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;

    private String modelo;

    @Column(name = "data_cadastro")
    @CreationTimestamp
    private LocalDate dataCadastro;

    public CarroCliente() {
    }

    public CarroCliente(String marca, String modelo){
        this.marca = marca;
        this.modelo = modelo;
    }

    public CarroCliente(String marca, String modelo, LocalDate dataCadastro) {
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
