José Vitor Gonçalves
30654114

Explicação das estratégias adotadas na resolução de cada questão:

1. Solução para a Análise de Risco (Strategy)
Para o cenário dos algoritmos de risco, a escolha foi o Padrão Strategy.
O problema central era a necessidade de intercambialidade de algoritmos em tempo de execução. A solução isola essa família de algoritmos (VaR, ES, Stress Testing) em classes distintas, todas implementando uma interface comum (EstrategiaCalculoRisco).
A classe de contexto (ProcessadorRisco) depende apenas desta abstração, não das implementações concretas. Isso elimina a necessidade de condicionais no processador, já que agora podemos adicionar novos algoritmos sem alterar a classe ProcessadorRisco.

2. Solução para o Legado Bancário (Adapter)
O problema de integração com o legado foi resolvido com o Padrão Adapter.
A necessidade era de fazer duas interfaces incompatíveis (ProcessadorTransacoes e SistemaBancarioLegado) colaborarem. O AdaptadorBancario atua como o um tradutor bidirecional.
O ponto-chave desta solução é o encapsulamento da complexidade da tradução. Toda a lógica de mapeamento e o tratamento de dados obrigatórios do legado são de responsabilidade exclusiva do adaptador.
Isso mantém o cliente limpo e totalmente desacoplado do sistema legado, dependendo apenas da interface alvo.

4. Solução para a Usina Nuclear (State)
Para o controle da usina, foi aplicado o Padrão State.
O comportamento do objeto UsinaNuclear mudava de acordo com seu estado interno.
Ao usar o Padrão State, delegamos o comportamento a classes de estado específicas. Cada classe de estado agora é responsável por:
Executar a lógica daquele estado.
Definir as regras de transição para outros estados.
Isso tornou o gerenciamento de regras complexas (como a transição unidirecional para EMERGENCIA) muito mais limpo e seguro, pois a lógica de transição só existe no estado que a permite.

4. Solução para a Validação de NF-e (Chain of Responsibility)
O desafio de validação em etapas foi solucionado com o Padrão Chain of Responsibility (CoR).
A solução implementou o CoR puro, onde cada Handler (ValidadorAbstrato) conhece seu sucessor e é responsável por invocá-lo. Os requisitos complexos foram gerenciados por um objeto de Contexto (ContextoValidacao).
Este objeto mensageiro carrega o estado da validação através da cadeia. Os principais destaques desta solução são:
Circuit Breaker: O ValidadorAbstrato verifica o Contexto antes de executar, interrompendo a cadeia se o breaker estiver ativo.
Condicionais: Elos específicos (como ValidadorRegrasFiscais) sobrescrevem o método validar para verificar o contexto e decidir se pulam a si mesmos.
Rollback: A lógica de executarRollback foi posicionada após a chamada ao proximo.validar().
Isso utiliza a própria pilha de chamadas (call stack) para garantir uma execução de rollback em ordem LIFO (Last-In, First-Out) de forma natural, sem a necessidade de gerenciar uma lista de reversão.
Em síntese, a aplicação desses padrões resolveu diretamente os requisitos de desacoplamento, extensibilidade e coesão propostos em cada cenário.
