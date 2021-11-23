package br.com.devhall.DevHall.DTO;

import br.com.devhall.DevHall.Model.Carro;
import br.com.devhall.DevHall.Model.Cliente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClienteDTO {

    private String nome;

    private String cpf;

    private String dataNascimento;

    private Carro carro_alugado;

    public Cliente dtoToCLiente(){
        // Aqui realizará a conversão de String para LocalDate
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String data = dataNascimento;
        LocalDate data_nascimento = LocalDate.parse(data, formatador);

        return new Cliente(this.nome, this.cpf, data_nascimento, this.carro_alugado);
    }

    public ClienteDTO() {
    }

    public Carro getCarro_alugado() {
        return carro_alugado;
    }

    public void setCarro_alugado(Carro carro_alugado) {
        this.carro_alugado = carro_alugado;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
