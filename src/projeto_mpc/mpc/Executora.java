//Eduardo Luiz Pontes de Souza - UC19100270
package projeto_mpc.mpc;

import projeto_mpc.mpc.Background_image.Image;
import projeto_mpc.mpc.View.View;
import projeto_mpc.mpc.View.Util;

public class Executora {

	public static void main(String[] args) {

		new Image(); // Chamando a função da imagem de plano de fundo para o programa

		MinhaPrimeiraCasa c = new MinhaPrimeiraCasa();
		c.setNome("Minha Crimeira Casa"); // Criando imobiliária e cabeçalho do programa

		int opcaoMenu = 0; // Variável de escolha para os menus

		// Função primeiro Menu do sistema
		while (true) {
			try {
				opcaoMenu = Util.menu(opcaoMenu);
			} catch (Exception e) { // Exception caso seja inserido um outro tipo que não int no menu principal
				View.exibirErro("[MENU PRINCIPAL]: Insira apenas números", "Erro detectado pelo sistema");
			}

			switch (opcaoMenu) {

			// Primeiro menu opção 1, leva ao submenu de cadastro
			case 1:
				try {
					opcaoMenu = Util.menuCadastro(opcaoMenu);

					if (opcaoMenu < 1 || opcaoMenu > 5) { // Exception caso um número inválido (menor que 1 ou maior que
															// 5) seja inserido
						View.exibirErro("[MENU PRINCIPAL]: Insira um digito válido (1 - 5).",
								"Erro detectado pelo sistema");
						opcaoMenu = 4; // Opção voltar ao menu acionada automaticamente
					}
				} catch (Exception e) { // Exception caso seja inserido um outro tipo que não int no menu cadastrar
										// imóveis no sistema
					View.exibirErro("[MENU PRINCIPAL]: Insira apenas números.", "Erro detectado pelo sistema");
					opcaoMenu = 4; // Opção voltar ao menu acionada automaticamente
				}

				switch (opcaoMenu) { // Submenu da primeira opção do menu principal

				case 1: // Função Cadastrar imóveis no sistema case 1, cadastro de funcionário no
						// sistema
					try {
						int idF = View.inserirInt("Insira um ID para o funcionário: ",
								"Cadastro de informações do funcionário");
						String nomeF = View.inserirString("Insira o nome completo do funcionário: ",
								"Cadastro de informações do funcionário");
						String cpfF = View.inserirString("Insira o CPF do funcionário: ",
								"Cadastro de informações do funcionário");
						String telF = View.inserirString("Insira o número de celular ou fixo do funcionário: ",
								"Cadastro de informações do funcionário");
						String emailF = View.inserirString("Insira o e-mail do funcionário: ",
								"Cadastro de informações do funcionário");
						Funcionario funcionario = new Funcionario(idF, nomeF, cpfF, telF, emailF); // Criando
																									// funcionário
						Util.CadastrarFuncionario(funcionario);
					} catch (Exception e) { // Exception caso seja inserido uma informação não condizente na criação do
											// funcionário
						View.exibirErro(
								"[CADASTRO DE INFORMAÇÕES DO FUNCIONÁRIO]: ID ou nome do funcionário inválido, tente novamente.",
								"Erro detectado pelo sistema");
					}
					break;

				case 2: // Função Cadastrar imóveis no sistema case 2, cadastro de proprietário ou
						// corretor do imóvel
					try {
						int cpfD = View.inserirInt("Insira o CPF do proprietário ou corretor responsável pelo imóvel: ",
								"Cadastro de informações do proprietário ou corretor de imóvel");
						String nomeD = View.inserirString(
								"Insira o nome completo do proprietário ou corretor responsável pelo imóvel: ",
								"Cadastro de informações do proprietário ou corretor de imóvel");
						String telD = View.inserirString(
								"Insira o número de celular ou fixo do proprietário ou corretor responsável pelo imóvel: ",
								"Cadastro de informações do proprietário ou corretor de imóvel");
						String descD = View.inserirString(
								"Insira uma breve descrição do proprietário ou corretor responsável pelo imóvel (horários disponíveis pra visita, etc.): ",
								"Cadastro de informações do proprietário ou corretor de imóvel");
						String emailD = View.inserirString(
								"Insira o e-mail do proprietário ou corretor responsável pelo imóvel: ",
								"Cadastro de informações do proprietário ou corretor de imóvel");
						Proprietario proprietario = new Proprietario(cpfD, nomeD, telD, descD, emailD); // Criando
																										// proprietário
						Util.cadastrarProprietario(proprietario);
					} catch (Exception e) { // Exception caso seja inserido uma informação não condizente na criação do
											// proprietário
						View.exibirErro(
								"[CADASTRO DE INFORMAÇÕES DO PROPRIETÁRIO OU CORRETOR DE IMÓVEL]: Alguma informação não é válida, tente novamente.",
								"Erro detectado pelo sistema");
					}
					break;

				case 3: // Função Cadastrar imóveis no sistema case 3, cadastro de informações do imóvel
					try {
						int mat = View.inserirInt("Insira o ID do funcionário responsável pelo cadastramento: ",
								"Cadastro de informações do imóvel");
						int matFuncionario = (mat);
						int concatImovel = (View.inserirInt(
								"Insira o CPF do proprietário ou corretor responsável pelo imóvel: ",
								"Cadastro de informações do imóvel"));

						if (Util.funcionarioExiste(matFuncionario) && Util.proprietarioExiste(concatImovel)) {
							String enderecoI = View.inserirString("Insira o endereço do imóvel: ",
									"Cadastro de informações do imóvel");
							int numCepI = View.inserirInt("Insira o número do CEP do imóvel: ",
									"Cadastro de informações do imóvel");
							int numSuiteI = View.inserirInt("Insira o número de suítes do imóvel: ",
									"Cadastro de informações do imóvel");
							int numQuartoI = View.inserirInt("Insira o número de quartos do imóvel: ",
									"Cadastro de informações do imóvel");
							int numBanheiroI = View.inserirInt("Insira o número de banheiros do imóvel: ",
									"Cadastro de informações do imóvel");
							String descI = View.inserirString("Insira uma breve descrição do imóvel: ",
									"Cadastro de informações do imóvel");
							float valorI = View.inserirFloat("Insira o valor do imóvel: R$",
									"Cadastro de informações do imóvel");

							Imovel imovel = new Imovel(enderecoI, numCepI, numSuiteI, numQuartoI, numBanheiroI, descI,
									valorI, concatImovel);
							Util.cadastrarImovel(imovel);
						} else {
							View.exibirMensagem("Funcionário ou proprietário não encontrado no sistema.");
						}
					} catch (Exception e) {
						View.exibirErro(
								"[CADASTRO DE INFORMAÇÕES DO IMÓVEL]: Alguma informação não é válida, tente novamente.",
								"Erro detectado pelo sistema");
					}
					break;

				case 4: // Função dedicada a voltar ao menu principal
					break;

				case 5: // Função dedicada a sair do programa
					System.exit(0);
					break;

				default:
					View.exibirMensagem("[DEFAULT SUBMENU CADASTRAR]: Digite um número válido, tente novamente.");
					break;
				}
				break;

			// Primeiro menu opção 2, leva ao submenu de edição de cadastro
			case 2:
				opcaoMenu = View.inserirMenu(c.getNome() + "\n\n Editar cadastro de imóveis do sistema \n\n"
						+ "1. Editar informações de funcionários cadastrados no sistema \n"
						+ "2. Editar informações do proprietário ou corretor de imóveis cadastrados no sistema \n"
						+ "3. Editar informações de imóveis cadastrados no sistema \n" + "4. Voltar ao menu \n"
						+ "5. Sair do programa");

				switch (opcaoMenu) {

				case 1: // Função para editar informações de funcionários cadastrados no sistema
					Funcionario auxFuncionario = Util
							.pesquisarFuncionario(View.inserirInt("Insira o ID do funcionário a ser editado: ",
									"Editar cadastro de informações do funcionário"));
					if (auxFuncionario == null) {
						View.exibirErro("ID do Funcionário não encontrada no sistema!", "Erro detectado pelo sistema");
					} else {
						View.exibirMensagem(
								"Funcionário " + auxFuncionario.getNomeFuncionario() + " encontrado no sistema!");
						int newIdF = View.inserirInt("Insira um novo ID para o funcionário a ser editado: ",
								"Editar cadastro de informações do funcionário");
						String newNomeF = View.inserirString("Insira um novo nome para o funcionário a ser editado: ",
								"Editar cadastro de informações do funcionário");
						String newCpfF = View.inserirString("Insira um novo CPF para o funcionário a ser editado: ",
								"Editar cadastro de informações do funcionário");
						String newTelF = View.inserirString(
								"Insira um novo número de celular ou fixo para o funcionário a ser editado: ",
								"Editar cadastro de informações do funcionário");
						String newEmailF = View.inserirString(
								"Insira um novo e-mail para o funcionário a ser editado: ",
								"Editar cadastro de informações do funcionário");

						Funcionario auxF2 = new Funcionario(newIdF, newNomeF, newCpfF, newTelF, newEmailF);
						Util.removerFuncionarioAnterior(auxFuncionario);
						Util.CadastrarFuncionario(auxF2);
					}
					break;

				case 2: // Função para editar informações de proprietários ou corretores cadastrados no
						// sistema

					Proprietario auxProprietario = Util.pesquisarProprietario(View.inserirInt(
							"Insira o CPF do proprietário ou corretor responsável pelo imóvel a ser editado: ",
							"Editar cadastro de informações do proprietário ou corretor de imóvel"));
					if (auxProprietario == null) {
						View.exibirErro(
								"CPF do proprietário ou corretor responsável pelo imóvel não encontrada no sistema!",
								"Erro detectado pelo sistema");
					} else {
						View.exibirMensagem("Proprietário ou corretor responsável pelo imóvel "
								+ auxProprietario.getNomeDono() + " encontrado no sistema!");
						int newCpfD = View.inserirInt(
								"Insira um novo CPF para o proprietário ou corretor responsável pelo imóvel: ",
								"Editar cadastro de informações do proprietário ou corretor de imóvel");
						String newNomeD = View.inserirString(
								"Insira um novo nome completo para o proprietário ou corretor responsável pelo imóvel: ",
								"Editar cadastro de informações do proprietário ou corretor de imóvel");
						String newTelD = View.inserirString(
								"Insira um novo número de celular ou fixo para o  proprietário ou corretor responsável pelo imóvel: ",
								"Editar cadastro de informações do proprietário ou corretor de imóvel");
						String newDescD = View.inserirString(
								"Insira uma nova breve descrição do proprietário ou corretor responsável pelo imóvel (horários disponíveis pra visita, etc.): ",
								"Editar cadastro de informações do proprietário ou corretor de imóvel");
						String newEmailD = View.inserirString(
								"Insira um novo e-mail para o proprietário ou corretor responsável pelo imóvel: ",
								"Editar cadastro de informações do proprietário ou corretor de imóvel");
						Proprietario auxP2 = new Proprietario(newCpfD, newNomeD, newTelD, newDescD, newEmailD);
						Util.removerProprietarioAnterior(auxP2);
						Util.cadastrarProprietario(auxP2);
					}
					break;

				case 3: // Função para editar informações de imóveis cadastrados no sistema
					Imovel auxImovel = Util.pesquisarImovel(View.inserirInt("Insira o CEP do imóvel a ser editado: ",
							"Editar cadastro de informações do imóvel"));
					if (auxImovel == null) {
						View.exibirErro("CEP do imóvel não encontrada no sistema!", "Erro detectado pelo sistema");
					} else {
						View.exibirMensagem("Imóvel " + auxImovel.getNumCepImovel() + " encontrado no sistema!");
						String newEnderecoI = View.inserirString("Insira um novo endereço para o imóvel: ",
								"Editar cadastro de informações do imóvel");
						int newNumCepI = View.inserirInt("Insira um novo CEP para o imóvel: ",
								"Editar cadastro de informações do imóvel");
						int newNumSuiteI = View.inserirInt("Insira um novo número de suítes para o imóvel: ",
								"Editar cadastro de informações do imóvel");
						int newNumQuartoI = View.inserirInt("Insira um novo número de quartos para o imóvel: ",
								"Editar cadastro de informações do imóvel");
						int newNumBanheiroI = View.inserirInt("Insira um novo número de banheiros para o imóvel: ",
								"Editar cadastro de informações do imóvel");
						String newDescI = View.inserirString("Insira uma nova breve descrição para o imóvel: ",
								"Editar cadastro de informações do imóvel");
						float newValorI = View.inserirInt("Insira um novo valor para o imóvel: R$",
								"Editar cadastro de informações do imóvel");
						int newCpfD = View.inserirInt("Insira um novo CPF para o proprietário ou corretor do imóvel: ",
								"Editar cadastro de informações do imóvel");
						Imovel auxI2 = new Imovel(newEnderecoI, newNumCepI, newNumSuiteI, newNumQuartoI,
								newNumBanheiroI, newDescI, newValorI, newCpfD);
						Util.removerImovelAnterior(auxI2);
						Util.cadastrarImovel(auxI2);
					}
					break;

				case 4: // Função dedicada a voltar ao menu principal
					break;

				case 5: // Função dedicada a sair do programa
					System.exit(0);
					break;

				default:
					View.exibirMensagem("[DEFAULT SUBMENU EDITAR]: Digite um número válido, tente novamente.");
				}
				break;

			// Primeiro menu opção 3, leva ao submenu de pesquisa de cadastro
			case 3:
				opcaoMenu = View.inserirMenu(c.getNome().toString()
						+ "\n\n Pesquisar cadastro de imóveis do sistema \n\n"
						+ "1. Pesquisar informações de funcionários cadastrados no sistema \n"
						+ "2. Pesquisar informações do proprietário ou corretor de imóveis cadastrados no sistema \n"
						+ "3. Pesquisar informações de imóveis cadastrados no sistema \n" + "4. Voltar ao menu \n"
						+ "5. Sair do programa");

				switch (opcaoMenu) {

				case 1: // Função para pesquisar informações de funcionários cadastrados no sistema
					Funcionario auxFuncionario = Util
							.pesquisarFuncionario(View.inserirInt("Insira o ID do funcionário a ser pesquisado: ",
									"Pesquisar cadastro de informações do funcionário"));
					if (auxFuncionario == null) {
						View.exibirErro("ID do Funcionário não encontrada no sistema!", "Erro detectado pelo sistema");
					} else {
						View.exibirMensagem(
								"Funcionário " + auxFuncionario.getNomeFuncionario() + " encontrado no sistema!");
					}
					break;

				case 2: // Função para pesquisar informações de proprietários ou corretores cadastrados
						// no sistema
					Proprietario auxProprietario = Util.pesquisarProprietario(View.inserirInt(
							"Insira o CPF do proprietário ou corretor responsável pelo imóvel a ser pesquisado: ",
							"Pesquisar cadastro de informações de proprietários ou corretores"));
					if (auxProprietario == null) {
						View.exibirErro(
								"CPF do proprietário ou corretor responsável pelo imóvel não encontrada no sistema!",
								"Erro detectado pelo sistema");
					} else {
						View.exibirMensagem("Proprietário ou corretor responsável pelo imóvel "
								+ auxProprietario.getNomeDono() + " encontrado no sistema!");
					}
					break;

				case 3: // Função para pesquisar informações de imóveis cadastrados no sistema
					Imovel auxImovel = Util.pesquisarImovel(View.inserirInt("Insira o CEP do imóvel a ser editado: ",
							"Editar cadastro de informações do imóvel"));
					if (auxImovel == null) {
						View.exibirErro("CEP do imóvel não encontrada no sistema!", "Erro detectado pelo sistema");
					} else {
						View.exibirMensagem("Imóvel " + auxImovel.getNumCepImovel() + " encontrado no sistema!");
					}
					break;

				case 4: // Função dedicada a voltar ao menu principal
					break;

				case 5: // Função dedicada a sair do programa
					System.exit(0);
					break;

				default:
					View.exibirMensagem("[DEFAULT SUBMENU EDITAR]: Digite um número válido, tente novamente.");
				}
				break;

			// Primeiro menu opção 4, leva ao submenu de listagem
			case 4:
				opcaoMenu = View.inserirMenu(c.getNome().toString() + "\n\n Listar cadastro de imóveis do sistema \n\n"
						+ "1. Listar informações de funcionários cadastrados no sistema \n"
						+ "2. Listar informações do proprietário ou corretor de imóveis cadastrados no sistema \n"
						+ "3. Listar informações de imóveis cadastrados no sistema \n" + "4. Voltar ao menu \n"
						+ "5. Sair do programa");

				switch (opcaoMenu) {

				case 1: // Função listar funcionários do sistema
					View.exibirMensagem(Util.listarFuncionarios());
					Util.list = "";
					break;
				case 2: // Função listar proprietários ou corretores responsáveis por imóveis do sistema
					View.exibirMensagem(Util.listarProprietarios());
					Util.list = "";
					break;
				case 3: // Função listar imóveis do sistema
					View.exibirMensagem(Util.listarImoveis());
					Util.list = "";
					break;

				case 4: // Função dedicada a voltar ao menu principal
					break;

				case 5: // Função dedicada a sair do programa
					System.exit(0);
					break;

				default:
					View.exibirMensagem("[DEFAULT SUBMENU EDITAR]: Digite um número válido, tente novamente.");
				}
				break;

			// Primeiro menu opção 5, leva ao submenu de exclusão
			case 5:
				opcaoMenu = View.inserirMenu(c.getNome().toString() + "\n\n Excluir cadastro de imóveis do sistema \n\n"
						+ "1. Excluir informações de funcionários cadastrados no sistema \n"
						+ "2. Excluir informações do proprietário ou corretor de imóveis cadastrados no sistema \n"
						+ "3. Excluir informações de imóveis cadastrados no sistema \n" + "4. Voltar ao menu \n"
						+ "5. Sair do programa");

				switch (opcaoMenu) {

				case 1: // Função excluir funcionários do sistema
					int auxIdFuncionario = View.inserirInt("Insira o ID do funcionário a ser excluído: ",
							"Excluir cadastro de informações do funcionário");
					Funcionario auxFuncionario = Util.pesquisarFuncionario(auxIdFuncionario);
					if (auxFuncionario == null) {
						View.exibirErro("ID do Funcionário não encontrada no sistema!", "Erro detectado pelo sistema");
					} else {
						String auxNomeFuncionario = auxFuncionario.getNomeFuncionario();
						Util.removerFuncionarioAnterior(auxFuncionario);
						View.exibirMensagem(
								"Funcionário " + auxNomeFuncionario + " encontrado no sistema e excluído com sucesso!");
					}
					break;

				case 2: // Função excluir proprietários ou corretores responsáveis por imóveis do
						// sistema
					int auxCpfProprietario = View.inserirInt(
							"Insira o CPF do proprietário ou corretor responsável pelo imóvel a ser excluído: ",
							"Excluir cadastro de informações do proprietário ou corretor de imóvel");
					Proprietario auxProprietario = Util.pesquisarProprietario(auxCpfProprietario);
					if (auxProprietario == null) {
						View.exibirErro(
								"CPF do proprietário ou corretor responsável pelo imóvel não encontrada no sistema!",
								"Erro detectado pelo sistema");
					} else {
						String auxNomeProprietario = auxProprietario.getNomeDono();
						Util.removerProprietarioAnterior(auxProprietario);
						View.exibirMensagem("Proprietário ou corretor responsável " + auxNomeProprietario
								+ " encontrado no sistema e excluído com sucesso!");
					}
					break;

				case 3: // Função excluir imóveis do sistema
					int auxCepImovel = View.inserirInt("Insira o CEP do imóvel a ser excluído: ",
							"Excluir cadastro de informações do funcionário");
					Imovel auxImovel = Util.pesquisarImovel(auxCepImovel);
					if (auxImovel == null) {
						View.exibirErro("CEP do imóvel não encontrada no sistema!", "Erro detectado pelo sistema");
					} else {
						String auxEnderecoImovel = auxImovel.getEnderecoImovel();
						Util.removerImovelAnterior(auxImovel);
						View.exibirMensagem("Imóvel do endereço " + auxEnderecoImovel
								+ " encontrado no sistema e excluído com sucesso!");
					}
					break;

				case 4: // Função dedicada a voltar ao menu principal
					break;

				case 5: // Função dedicada a sair do programa
					System.exit(0);
					break;

				default:
					View.exibirMensagem("[DEFAULT SUBMENU EDITAR]: Digite um número válido, tente novamente.");
				}
				break;

			// Primeiro menu opção 6, leva ao submenu de exclusão geral
			case 6:
				opcaoMenu = View.inserirMenu(c.getNome().toString()
						+ "\n\n Exclusão geral de informações cadastradas de imóveis do sistema \n\n"
						+ "1. Excluir todas as  informações de funcionários cadastrados no sistema \n"
						+ "2. Excluir todas as informações do proprietário ou corretor de imóveis cadastrados no sistema \n"
						+ "3. Excluir todas as informações de imóveis cadastrados no sistema \n"
						+ "4. Voltar ao menu \n" + "5. Sair do programa");

				switch (opcaoMenu) {

				case 1: // Função excluir todas as informações de funcionários do sistema
					Util.removerAllFuncionario();
					View.exibirMensagem("Funcionários encontrados no sistema excluídos com sucesso!");
					break;

				case 2:
					Util.removerAllProprietario();
					View.exibirMensagem("Proprietarios encontrados no sistema excluídos com sucesso!");
					break;

				case 3:
					Util.removerAllImovel();
					View.exibirMensagem("Imóveis encontrados no sistema excluídos com sucesso!");
					break;

				case 4: // Função dedicada a voltar ao menu principal
					break;

				case 5: // Função dedicada a sair do programa
					System.exit(0);
					break;

				default:
					View.exibirMensagem("[DEFAULT SUBMENU EDITAR]: Digite um número válido, tente novamente.");
				}
				break;

			case 7:
				View.exibirMensagem("Obrigado por usar o sistema Minha Primeira Casa, volte sempre!"
						+ "\n\n Programa desenvolvido por Eduardo Luiz Pontes de Souza - UC19100270");
				System.exit(0);
				break;
			default:
				break;
			}
		}
	}
}