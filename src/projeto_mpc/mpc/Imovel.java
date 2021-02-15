//Eduardo Luiz Pontes de Souza - UC19100270
package projeto_mpc.mpc;

public class Imovel {

	// Atributos
	private String enderecoImovel;
	private int numCepImovel;
	private int numSuiteImovel;
	private int numQuartoImovel;
	private int numBanheiroImovel;
	private String descImovel;
	private float valorImovel;
	private int cpfDonoI;

	// Construtores
	Imovel(String enderecoImovel, int numCepImovel, int numSuiteImovel, int numQuartoImovel, int numBanheiroImovel,
			String descImovel, float valorImovel, int cpfDonoI) {
		setEnderecoImovel(enderecoImovel);
		setNumCepImovel(numCepImovel);
		setNumSuiteImovel(numSuiteImovel);
		setNumQuartoImovel(numQuartoImovel);
		setNumBanheiroImovel(numBanheiroImovel);
		setDescImovel(descImovel);
		setValorImovel(valorImovel);
		setCpfDonoI(cpfDonoI);
	}

	Imovel() {

	}

	// Getters e setters
	public String getEnderecoImovel() {
		return enderecoImovel;
	}

	public void setEnderecoImovel(String enderecoImovel) {
		if (!enderecoImovel.isEmpty()) {
			this.enderecoImovel = enderecoImovel;
		} else {
			throw new IllegalArgumentException("[IMÓVEL]: Campo obrigatório, tente novamente.");
		}
	}

	public int getNumCepImovel() {
		return numCepImovel;
	}

	public void setNumCepImovel(int numCepImovel) {
		if (numCepImovel != 0) {
			this.numCepImovel = numCepImovel;
		} else {
			throw new IllegalArgumentException("[IMÓVEL]: Campo obrigatório, tente novamente.");
		}
	}

	public int getNumSuiteImovel() {
		return numSuiteImovel;
	}

	public void setNumSuiteImovel(int numSuiteImovel) {
		if (numSuiteImovel != 0) {
			this.numSuiteImovel = numSuiteImovel;
		} else {
			throw new IllegalArgumentException("[IMÓVEL]: Campo obrigatório, tente novamente.");
		}
	}

	public int getNumQuartoImovel() {
		return numQuartoImovel;
	}

	public void setNumQuartoImovel(int numQuartoImovel) {
		if (numQuartoImovel != 0) {
			this.numQuartoImovel = numQuartoImovel;
		} else {
			throw new IllegalArgumentException("[IMÓVEL]: Campo obrigatório, tente novamente.");
		}
	}

	public int getNumBanheiroImovel() {
		return numBanheiroImovel;
	}

	public void setNumBanheiroImovel(int numBanheiroImovel) {
		if (numBanheiroImovel != 0) {
			this.numBanheiroImovel = numBanheiroImovel;
		} else {
			throw new IllegalArgumentException("[IMÓVEL]: Campo obrigatório, tente novamente.");
		}
	}

	public String getDescImovel() {
		return descImovel;
	}

	public void setDescImovel(String descImovel) {
		if (!descImovel.isEmpty()) {
			this.descImovel = descImovel;
		} else {
			throw new IllegalArgumentException("[IMÓVEL]: Campo obrigatório, tente novamente.");
		}
	}

	public float getValorImovel() {
		return valorImovel;
	}

	public void setValorImovel(float valorImovel) {
		if (valorImovel != 0) {
			this.valorImovel = valorImovel;
		} else {
			throw new IllegalArgumentException("[IMÓVEL]: Campo obrigatório, tente novamente.");
		}
	}

	public int getCpfDonoI() {
		return cpfDonoI;
	}

	public void setCpfDonoI(int cpfDonoI) {
		if (cpfDonoI != 0) {
			this.cpfDonoI = cpfDonoI;
		} else {
			throw new IllegalArgumentException("[CPF DONO ]: Campo obrigatório, tente novamente.");
		}
	}
}
