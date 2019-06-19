package br.udipet.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import java.util.Objects;

@Entity
public class Animal {
    @Id
    @GeneratedValue
    private Integer id;
    
    @NotBlank(message = "Campo obrigatório")
    private String nome;
    @NotNull(message = "Campo obrigatório")
    private String tipo;
    @NotNull(message = "Campo obrigatório")
    private Float peso;
    @NotBlank(message = "Campo obrigatório")
    private String raca;
    @NotBlank(message = "Campo obrigatório")
    private String cor;
    @NotNull(message = "Campo obrigatório")
    private String pelagem;
    
    private String path;
	private String name;
    
    public String getTipo() {
		return tipo;
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

	public Animal(String path, String name) {
    	this.path = path;
    	this.name = name;
    }
    
	public Animal() {
		
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPelagem() {
		return pelagem;
	}

	public void setPelagem(String pelagem) {
		this.pelagem = pelagem;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
