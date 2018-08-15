package com.project.quelvymuahio.postbus.Model;

import java.io.Serializable;

public class Car implements Serializable {

    private String carro_id, carro_nome, carro_assentos, carro_matricula, carro_motorista, carro_imagem_url;

    public Car(){
        // require no-argumented constructor
    }

    public Car(String carro_id, String carro_nome, String carro_assentos, String carro_matricula, String carro_motorista, String carro_imagem_url) {
        this.carro_id = carro_id;
        this.carro_nome = carro_nome;
        this.carro_assentos = carro_assentos;
        this.carro_matricula = carro_matricula;
        this.carro_motorista = carro_motorista;
        this.carro_imagem_url = carro_imagem_url;
    }

    public String getCarro_id() {
        return carro_id;
    }

    public void setCarro_id(String carro_id) {
        this.carro_id = carro_id;
    }

    public String getCarro_nome() {
        return carro_nome;
    }

    public void setCarro_nome(String carro_nome) {
        this.carro_nome = carro_nome;
    }

    public String getCarro_assentos() {
        return carro_assentos;
    }

    public void setCarro_assentos(String carro_assentos) {
        this.carro_assentos = carro_assentos;
    }

    public String getCarro_matricula() {
        return carro_matricula;
    }

    public void setCarro_matricula(String carro_matricula) {
        this.carro_matricula = carro_matricula;
    }

    public String getCarro_motorista() {
        return carro_motorista;
    }

    public void setCarro_motorista(String carro_motorista) {
        this.carro_motorista = carro_motorista;
    }

    public String getCarro_imagem_url() {
        return carro_imagem_url;
    }

    public void setCarro_imagem_url(String carro_imagem_url) {
        this.carro_imagem_url = carro_imagem_url;
    }
}
