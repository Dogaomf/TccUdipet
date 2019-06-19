package br.udipet.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class AnimalDTO {
    private Integer id;
    private MultipartFile file;
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
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
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
		public String getPelagem() {
			return pelagem;
		}
		public void setPelagem(String pelagem) {
			this.pelagem = pelagem;
		}
}
