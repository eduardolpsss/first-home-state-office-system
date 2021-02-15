//Eduardo Luiz Pontes de Souza - UC19100270
package projeto_mpc.mpc.View;

import projeto_mpc.mpc.Funcionario;
import projeto_mpc.mpc.Imovel;
import projeto_mpc.mpc.MinhaPrimeiraCasa;
import projeto_mpc.mpc.Proprietario;

import java.util.ArrayList;

public class Util {

	public static String list = ""; // Variável de listagem

	public static MinhaPrimeiraCasa cabecalho = new MinhaPrimeiraCasa(
			"Sistema de cadastramento imobiliário Minha Primeira Casa"); // Cabeçalho do programa

	// Primeiro Menu
	public static int menu(int menu) {
		int opcao = View.inserirMenu(cabecalho.getNome() + "\n\n Menu Principal \n\n" + "1. Cadastrar no sistema \n"
				+ "2. Editar cadastros do sistema \n" + "3. Pesquisar cadastro no sistema\n"
				+ "4. Listar cadastrados no sistema \n" + "5. Excluir cadastro do sistema \n"
				+ "6. Excluir todos os cadastrados no sistema \n" + "7. Sair do programa");
		return opcao;
	}

	// Menu da opção 1, cadastrar no sistema
	public static int menuCadastro(int menu) {
		int opcao = View.inserirMenu(cabecalho.getNome() + "\n\n Cadastrar no sistema \n\n"
				+ "1. Cadastrar funcionário \n" + "2. Cadastrar proprietário ou corretor do imóvel \n"
				+ "3. Cadastrar informações do imóvel \n" + "4. Voltar ao menu principal \n" + "5. Sair do programa");
		return opcao;
	}

	// Criação de Array lists
	private static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>(); // Array para a criação de
																						// funcionários
	private static ArrayList<Proprietario> proprietarios = new ArrayList<Proprietario>(); // Array para a criação de
																							// proprietários
	private static ArrayList<Imovel> imoveis = new ArrayList<Imovel>(); // Array para a criação de imóveis

	// Cadastrar funcionário
	public static void CadastrarFuncionario(Funcionario funcionarios) {
		Util.funcionarios.add(funcionarios);
	}

	// Função dedicada a listar funcionários presentes no sistema
	public static String listarFuncionarios() {
		list = "";
		for (int i = 0; i < funcionarios.size(); i++) {
			list += "ID do funcionário: " + ((Funcionario) funcionarios.get(i)).getIdFuncionario()
					+ "\n Nome do funcionário: " + ((Funcionario) funcionarios.get(i)).getNomeFuncionario()
					+ "\n CPF do funcionário: " + ((Funcionario) funcionarios.get(i)).getCpfFuncionario()
					+ "\n Telefone de contato do funcionário: "
					+ ((Funcionario) funcionarios.get(i)).getTelFuncionario() + "\n E-mail do funcionário: "
					+ ((Funcionario) funcionarios.get(i)).getEmailFuncionario() + "\n\n";
		}
		return list;
	}

	// Pesquisar funcionários cadastrados para editar
	public static Funcionario pesquisarFuncionario(int idFuncionario) {
		for (int i = 0; i < funcionarios.size(); i++) {
			if (((Funcionario) funcionarios.get(i)).getIdFuncionario() == idFuncionario) {
				return (Funcionario) funcionarios.get(i);
			}
		}
		return null;
	}

	// Função dedicada a remover funcionários antigos depois de editar novos
	public static void removerFuncionarioAnterior(Funcionario idFuncionario) {
		funcionarios.remove(idFuncionario);
	}

	// Função dedicada a excluir todas as informações referentes aos funcionários
	// cadastrados no sistema
	public static void removerAllFuncionario() {
		funcionarios.clear();
	}

	// Cadastrar proprietários responsáveis pelos imóveis
	public static void cadastrarProprietario(Proprietario proprietarios) {
		Util.proprietarios.add(proprietarios);
	}

	// Função dedicada a listar proprietários ou corretores responsáveis por imóveis
	// presentes no sistema
	public static String listarProprietarios() {
		for (int i = 0; i < proprietarios.size(); i++) {
			Proprietario auxLP = (Proprietario) proprietarios.get(i);
			list += "\n CPF do proprietário ou corretor: " + auxLP.getCpfDono()
					+ "\n Nome completo do proprietário ou corretor: " + auxLP.getNomeDono()
					+ "\n Telefone de contato do proprietários ou corretor: " + auxLP.getTelDono() + "\n Descrição: "
					+ auxLP.getDescDono() + "\n E-mail do proprietário ou corretor: " + auxLP.getEmailDono() + "\n\n";
		}
		return list;
	}

	// Pesquisar proprietários cadastrados para editar
	public static Proprietario pesquisarProprietario(int cpfDono) {
		for (int i = 0; i < proprietarios.size(); i++) {
			if (((Proprietario) proprietarios.get(i)).getCpfDono() == cpfDono) {
				return (Proprietario) proprietarios.get(i);
			}
		}
		return null;
	}

	// Função dedicada a remover proprietários antigos depois de editar novos
	public static void removerProprietarioAnterior(Proprietario cpfDono) {
		proprietarios.remove(cpfDono);
	}

	// Função dedicada a excluir todas as informações referentes aos proprietários
	// ou corretores responsáveis por imóveis cadastrados no sistema
	public static void removerAllProprietario() {
		proprietarios.clear();
	}

	// Cadastrar imóvel no sistema
	public static void cadastrarImovel(Imovel imoveis) {
		Util.imoveis.add(imoveis);
	}

	// Função dedicada a listar imóveis presentes no sistema
	public static String listarImoveis() {
		for (int i = 0; i < imoveis.size(); i++) {
			Imovel auxLI = (Imovel) imoveis.get(i);
			list += "\n\n Endereço do imóvel: " + auxLI.getEnderecoImovel() + "\n CEP do imóvel: "
					+ auxLI.getNumCepImovel() + "\n Número de suítes do imóvel: " + auxLI.getNumSuiteImovel()
					+ "\n Número de quartos do imóvel: " + auxLI.getNumQuartoImovel()
					+ "\n Número de banheiros do imóvel: " + auxLI.getNumBanheiroImovel() + "\n Descrição do imóvel: "
					+ auxLI.getDescImovel() + "\n CPF do proprietário ou corretor responsável pelo imóvel: "
					+ auxLI.getCpfDonoI() + "\n Valor do imóvel: R$" + auxLI.getValorImovel() + "\n\n\n";
		}
		return list;
	}

	// Função para verificar se o funcionário responsável pelo cadastro é válido e
	// existe no sistema
	public static boolean funcionarioExiste(int matFuncionario) {
		for (int i = 0; i < funcionarios.size(); i++) {
			if (matFuncionario == ((Funcionario) funcionarios.get(i)).getIdFuncionario()) {
				return true;
			}
		}
		return false;
	}

	// Função para verificar se o proprietário ou corretor do imóvel é válido e
	// existe no sistema
	public static boolean proprietarioExiste(int cpfDono) {
		for (int i = 0; i < proprietarios.size(); i++) {
			if (cpfDono == ((Proprietario) proprietarios.get(i)).getCpfDono()) {
				return true;
			}
		}
		return false;
	}

	// Pesquisar imóveis cadastrados para editar
	public static Imovel pesquisarImovel(int numCepImovel) {
		for (int i = 0; i < imoveis.size(); i++) {
			if (((Imovel) imoveis.get(i)).getNumCepImovel() == numCepImovel) {
				return (Imovel) imoveis.get(i);
			}
		}
		return null;
	}

	// Função dedicada a remover imóveis antigos depois de editar novos
	public static void removerImovelAnterior(Imovel numCepImovel) {
		imoveis.remove(numCepImovel);
	}

	// Função dedicada a excluir todas as informações referentes aos imóveis
	// cadastrados no sistema
	public static void removerAllImovel() {
		imoveis.clear();
	}
}
