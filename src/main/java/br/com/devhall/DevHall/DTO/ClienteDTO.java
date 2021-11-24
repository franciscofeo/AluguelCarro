package br.com.devhall.DevHall.DTO;

import br.com.devhall.DevHall.Model.Carro;
import br.com.devhall.DevHall.Model.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class ClienteDTO {

    private String nome;
    private String cpf;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dataNascimento;
    private CarroDTO carroAlugado;


    public ClienteDTO(){

    }

    public Cliente dtoToCLiente(){
        return new Cliente(nome, cpf, dataNascimento, carroAlugado.dtoToCarro());
    }


    public CarroDTO getCarro_alugado() {
        return carroAlugado;
    }

    public void setCarroAlugado(CarroDTO carroAlugado) {
        this.carroAlugado = carroAlugado;
    }

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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
