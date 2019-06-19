package br.udipet.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Objects;

@Entity
public class Marcacao {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank(message = "Campo obrigatório")
    private String hora;
    @NotBlank(message = "Campo obrigatório")
    private String data;
    private String statusExec;
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "plano_id", referencedColumnName = "id")
    private Plano plano;
    @ManyToOne
    @JoinColumn(name = "procedimento_id", referencedColumnName = "id")
    private Procedimento procedimento;
    @ManyToOne
    @JoinColumn(name = "clinica_id", referencedColumnName = "id")
    private Clinica clinica;

    public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public Procedimento getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marcacao marcacao = (Marcacao) o;
        return Objects.equals(id, marcacao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    public void setStatusExec(String statusExec) {
		this.statusExec = statusExec;
	}

	public String getStatusExec() {
		return statusExec;
	}
}
