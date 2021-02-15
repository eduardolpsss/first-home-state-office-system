//Eduardo Luiz Pontes de Souza - UC19100270
package projeto_mpc.mpc;

public class Proprietario {

	// Atributos
	private int cpfDono;
	private String nomeDono;
	private String telDono;
	private String descDono; // Descrição do proprietário é um breve resumo de horários disponíveis, etc.
	private String emailDono;

	// Construtores
	Proprietario(int cpfDono, String nomeDono, String telDono, String descDono, String emailDono) {
		setCpfDono(cpfDono);
		setNomeDono(nomeDono);
		setTelDono(telDono);
		setDescDono(descDono);
		setEmailDono(emailDono);
	}

	// Getter e setters

	public int getCpfDono() {
		return cpfDono;
	}

	public void setCpfDono(int cpfDono) {
		if (cpfDono != 0) { // Validação do campo do CPF do proprietário
			this.cpfDono = cpfDono;
		} else {
			throw new IllegalArgumentException("[PROPRIETÁRIO]: Campo obrigatório, tente novamente.");
		}
	}

	public String getNomeDono() {
		return nomeDono;
	}

	public void setNomeDono(String nomeDono) {
		if (!nomeDono.isEmpty()) { // Validação do campo do nome do proprietário
			this.nomeDono = nomeDono;
		} else {
			throw new IllegalArgumentException("[PROPRIETÁRIO]: Campo obrigatório, tente novamente.");
		}
	}

	public String getTelDono() {
		return telDono;
	}

	public void setTelDono(String telDono) {
		if (!telDono.isEmpty()) { // Validação do campo do email do funcionário
			this.telDono = telDono;
		} else {
			throw new IllegalArgumentException("[FUNCIONÁRIO]: Campo obrigatório, tente novamente.");
		}
	}

	public String getDescDono() {
		return descDono;
	}

	public void setDescDono(String descDono) {
		if (!descDono.isEmpty()) { // Validação do campo da descrição do proprietário
			this.descDono = descDono;
		} else {
			throw new IllegalArgumentException("[PROPRIETÁRIO]: Campo obrigatório, tente novamente.");
		}
	}

	public String getEmailDono() {
		return emailDono;
	}

	public void setEmailDono(String emailDono) {
		if (!emailDono.isEmpty()) { // Validação do campo do email do proprietário
			this.emailDono = emailDono;
		} else {
			throw new IllegalArgumentException("[PROPRIETÁRIO]: Campo obrigatório, tente novamente.");
		}
	}
}
