package br.com.devhall.DevHall.DTO;

import br.com.devhall.DevHall.Model.Carro;
import br.com.devhall.DevHall.Model.Cliente;
import br.com.devhall.DevHall.Repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Component
public class ClienteDTO {

    private String nome;
    private String cpf;
    private String dataNascimento;
    private Long carro_alugado;

    @Autowired
    private CarroRepository carroRepository;

    public Cliente dtoToCLiente(){
        // Aqui realizará a conversão de String para LocalDate
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String data = dataNascimento;
        LocalDate data_nascimento = LocalDate.parse(data, formatador);

        // Aqui fará a busca na tabela de carros pelo id informado
        Optional<Carro> carro = carroRepository.findById(carro_alugado);

        if(carro.isPresent()){
            return new Cliente(this.nome, this.cpf, data_nascimento, carro.get());
        } else{
            System.out.println("Nenhum carro encontrado para fazer referencia com o cliente.");
            return null;
        }
    }

    public ClienteDTO() {
    }

    public Long getCarro_alugado() {
        return carro_alugado;
    }

    public void setCarro_alugado(Long carro_alugado) {
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
