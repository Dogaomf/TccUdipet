package br.udipet.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import java.math.BigInteger;
import java.util.Objects;

@Entity
public class Fornecedor {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank(message = "Campo obrigatório")
    private String nome;
    @CNPJ(message = "Campo obrigatório")
    private String cnpj;
    @NotNull(message = "Campo obrigatório")
    private Character sexo;
    @NotNull(message = "Campo obrigatório")
    private BigInteger telefone;
    @NotNull(message = "Campo obrigatório")
    private BigInteger celular;
    @NotBlank(message = "Campo obrigatório")
    private String area;
    @NotBlank(message = "Campo obrigatório")
    private String especialidade;
    @NotBlank(message = "Campo obrigatório")
    private String email;
    @NotBlank(message = "Campo obrigatório")
    private String nomeUsuario;
    @NotBlank(message = "Campo obrigatório")
    private String senha;
    @NotBlank(message = "Campo obrigatório")
    private String conf_senha;
    
    public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public BigInteger getTelefone() {
		return telefone;
	}

	public void setTelefone(BigInteger telefone) {
		this.telefone = telefone;
	}

	public BigInteger getCelular() {
		return celular;
	}

	public void setCelular(BigInteger celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConf_senha() {
		return conf_senha;
	}

	public void setConf_senha(String conf_senha) {
		this.conf_senha = conf_senha;
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

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
