package br.com.devhall.DevHall.DTO;

import br.com.devhall.DevHall.Model.Carro;

public class CarroDTO {

    private String marca;

    private String modelo;

    public Carro dtoToCarro(){
        return new Carro(this.marca, this.modelo);
    }

    public CarroDTO() {
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
}
