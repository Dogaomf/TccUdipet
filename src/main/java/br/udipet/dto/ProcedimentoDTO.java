package br.udipet.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class ProcedimentoDTO {
	    private Integer id;
		private MultipartFile file;
		@NotBlank(message = "Campo obrigatório")
	    private String nome;
	    @NotNull(message = "Campo obrigatório")
	    private Integer codproc;
	    @NotBlank(message = "Campo obrigatório")
	    private String tipo;
	    @NotBlank(message = "Campo obrigatório")
	    private String descproc;
	    
	    private String path;
	    
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public MultipartFile getFile() {
			return file;
		}
		public void setFile(MultipartFile file) {
			this.file = file;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public Integer getCodproc() {
			return codproc;
		}
		public void setCodproc(Integer codproc) {
			this.codproc = codproc;
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

}
