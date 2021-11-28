package br.com.devhall.DevHall.DTO;

import br.com.devhall.DevHall.Model.CarroCliente;

public class CarroClienteDTO {

    private String marca;

    private String modelo;

    public CarroCliente dtoToCarro(){
        return new CarroCliente(this.marca, this.modelo);
    }

    public CarroClienteDTO() {
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
