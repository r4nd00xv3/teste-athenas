package model;

	import java.util.Date;

	import javax.persistence.*;

    @Entity
	@Table(name = "pessoa" )
	public class Pessoa  {

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
		private Long id;


		@Column(name = "pNome")
		private String nome;

		@Temporal(TemporalType.DATE)
		@Column(name = "pData")
		private Date data_Nasc;

		@Column(name = "pCPF")
		private String cpf;

		@Column(name = "pSexo")
		private String sexo;

		@Column(name = "pAltura")
		private Double altura;

		@Column(name = "pPeso")
		private Double peso;


		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Date getData_Nasc() {
			return data_Nasc;
		}

		public void setData_Nasc(Date data_Nasc) {
			this.data_Nasc = data_Nasc;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getSexo() {
			return sexo;
		}

		public void setSexo(String sexo) {
			this.sexo = sexo;
		}

		public Double getAltura() {
			return altura;
		}

		public void setAltura(Double altura) {
			this.altura = altura;
		}

		public Double getPeso() {
			return peso;
		}

		public void setPeso(Double peso) {
			this.peso = peso;
		}
	}

