package br.udipet.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Objects;
import java.util.Set;

@Entity
public class Procedimento {
    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "Campo obrigatório")
    private String nome;
    @NotNull(message = "Campo obrigatório")
    private Integer codproc;
    @NotBlank(message = "Campo obrigatório")
    private String tipo;
    @NotBlank(message = "Campo obrigatório")
    private String descproc;
    
    private String path;
	private String name;

    @ManyToOne
    @JoinColumn(name = "clinica_id", referencedColumnName = "id")
    private Clinica clinica;


    @ManyToMany
    @JoinTable(name="procedimento_plano",
            joinColumns=@JoinColumn(name="procedimento_id"),
            inverseJoinColumns=@JoinColumn(name="plano_id")
    )
    private Set<Plano> planos;
    
    public Procedimento(String path, String name) {
    	this.path = path;
    	this.name = name;
    }
    
    public Procedimento() {
    	
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

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getDescproc() {
        return descproc;
    }

    public void setDescproc(String descproc) {
        this.descproc = descproc;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodproc() {
        return codproc;
    }

    public void setCodproc(Integer codproc) {
        this.codproc = codproc;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    public Set<Plano> getplanos() {
        return planos;
    }

    public void setPlanos(Set<Plano> planos) {
        this.planos = planos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Procedimento procedimento = (Procedimento) o;
        return Objects.equals(id, procedimento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
