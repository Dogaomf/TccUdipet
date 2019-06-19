package br.udipet.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Clinica {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank(message = "Campo obrigatório")
    private String nome;
    @CNPJ(message = "Campo obrigatório")
    private String cnpj;
    @NotBlank(message = "Campo obrigatório")
    private String telefone;
    @NotBlank(message = "Campo obrigatório")
    private String endereco;
    @NotBlank(message = "Campo obrigatório")
    private String bairro;
    @NotBlank(message = "Campo obrigatório")
    private String cidade;
    @NotBlank(message = "Campo obrigatório")
    private String uf;
    @NotBlank(message = "Campo obrigatório")
    private String cep;
    
    public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clinica clinica = (Clinica) o;
        return Objects.equals(id, clinica.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
