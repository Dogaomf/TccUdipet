package br.udipet.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private Integer id;
    
    @NotBlank(message = "Campo obrigatório")
    private String nome;
    @CPF(message = "Campo obrigatório")
    private String cpf;
    @NotNull(message = "Campo obrigatório")
    private Character sexo;
    @NotNull(message = "Campo obrigatório")
    private BigInteger telefone;
    @NotNull(message = "Campo obrigatório")
    private BigInteger celular;
    @NotBlank(message = "Campo obrigatório")
    private String endereco;
    @NotBlank(message = "Campo obrigatório")
    private String bairro;
    @NotNull(message = "Campo obrigatório")
    private BigInteger cep;
    @NotBlank(message = "Campo obrigatório")
    private String cidade;
    @NotBlank(message = "Campo obrigatório")
    private String uf;
    @NotBlank(message = "Campo obrigatório")
    private String email;
    @NotBlank(message = "Campo obrigatório")
    private String nomeUsuario;
    @NotBlank(message = "Campo obrigatório")
    private String senha;
    @NotBlank(message = "Campo obrigatório")
    private String conf_senha;
    
    private String path;
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "ong_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Collection<Role> roles;
	
	public Usuario(String path, String name) {
    	this.path = path;
    	this.name = name;
    }
    
    public Usuario() {
    	
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public BigInteger getCep() {
		return cep;
	}

	public void setCep(BigInteger cep) {
		this.cep = cep;
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
    
    public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
