José Vitor Gonçalves
30654114

Explicação das estratégias adotadas na resolução de cada questão

1. Solução para a Análise de Risco

Para o cenário envolvendo os algoritmos de risco, foi adotado o Padrão Strategy.
O problema central consistia na necessidade de permitir a intercambialidade de algoritmos em tempo de execução. A solução proposta isola essa família de algoritmos (VaR, ES, Stress Testing) em classes distintas, todas implementando uma interface comum denominada EstrategiaCalculoRisco.
A classe de contexto (ProcessadorRisco) passa a depender apenas dessa abstração, e não das implementações concretas. Dessa forma, elimina-se a necessidade de estruturas condicionais dentro do processador, tornando possível adicionar novos algoritmos sem alterar o código existente da classe ProcessadorRisco.

2. Solução para o Legado Bancário

O desafio de integração com o sistema legado foi solucionado por meio do Padrão Adapter.
A demanda principal era permitir que duas interfaces incompatíveis (ProcessadorTransacoes e SistemaBancarioLegado) pudessem colaborar entre si. O AdaptadorBancario atua como um tradutor bidirecional entre essas interfaces.
O ponto-chave dessa abordagem está no encapsulamento da complexidade de tradução: toda a lógica de mapeamento e tratamento de dados específicos do legado é de responsabilidade exclusiva do adaptador.
Com isso, o cliente permanece limpo e totalmente desacoplado do sistema legado, dependendo apenas da interface alvo definida.

3. Solução para a Usina Nuclear

No controle da usina nuclear, foi aplicado o Padrão State.
O comportamento do objeto UsinaNuclear variava conforme seu estado interno, o que justificou o uso desse padrão. Com o State, o comportamento foi delegado a classes específicas de estado, onde cada uma é responsável por:
Executar a lógica correspondente ao seu estado.
Definir as regras de transição para outros estados.
Essa estrutura tornou o gerenciamento das regras de transição (como a mudança unidirecional para o estado EMERGENCIA) mais limpo e seguro, uma vez que a lógica de transição está contida exclusivamente no estado que a permite.

4. Solução para a Validação de NF-e

O desafio da validação em múltiplas etapas foi solucionado com o Padrão Chain of Responsibility (CoR).
A solução implementa o CoR em sua forma pura: cada Handler (ValidadorAbstrato) conhece seu sucessor e é responsável por invocá-lo. Os requisitos mais complexos foram gerenciados por um objeto de contexto (ContextoValidacao), que carrega o estado da validação ao longo da cadeia.
Os principais pontos dessa implementação são:
Circuit Breaker: o ValidadorAbstrato verifica o contexto antes de executar, interrompendo a cadeia se o breaker estiver ativo.
Condicionais: validadores específicos, como o ValidadorRegrasFiscais, sobrescrevem o método validar para analisar o contexto e decidir se devem ou não ser executados.
Rollback: a lógica de executarRollback é chamada após a execução de proximo.validar(), utilizando a própria pilha de chamadas para garantir uma reversão em ordem LIFO, sem necessidade de listas auxiliares.
Em síntese, a aplicação desses padrões de projeto atendeu diretamente aos requisitos de desacoplamento, extensibilidade e coerência estrutural, proporcionando soluções claras e sustentáveis para cada cenário proposto.
