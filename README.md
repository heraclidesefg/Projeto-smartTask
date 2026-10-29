# SmartTask — Gerenciador de Tarefas Android

## 1. Sobre o projeto

O **SmartTask** é um aplicativo Android desenvolvido em Kotlin, utilizando o Android Studio, com o objetivo de auxiliar os usuários na organização e no gerenciamento de tarefas do dia a dia.

Como evolução do projeto inicial, foram adicionados recursos básicos de segurança, incluindo tela de login, controle de sessão e funcionalidade de logout.

O projeto foi desenvolvido como atividade prática do componente curricular **Desenvolvimento Android**, aplicando conceitos de programação mobile, interfaces gráficas, armazenamento local e segurança em dispositivos móveis.

## 2. Objetivos

- Desenvolver um aplicativo Android para gerenciamento de tarefas.
- Aplicar conceitos de programação utilizando Kotlin.
- Implementar operações de criação, edição e exclusão de tarefas.
- Implementar uma tela de login com validação de credenciais.
- Controlar o acesso à tela principal por meio de uma sessão local.
- Permitir o encerramento da sessão por meio do botão Sair.
- Aplicar boas práticas introdutórias de segurança em aplicações Android.

## 3. Funcionalidades

### Gerenciamento de tarefas

- Adicionar novas tarefas.
- Listar as tarefas cadastradas.
- Editar tarefas existentes.
- Excluir tarefas.
- Armazenar os dados localmente no dispositivo.

### Segurança e controle de acesso

- Tela de login.
- Validação local de usuário e senha.
- Registro do estado de autenticação com `SharedPreferences`.
- Verificação da sessão antes de abrir a tela principal.
- Botão Sair para encerrar a sessão e retornar à tela de login.

## 4. Tecnologias utilizadas

- **Linguagem:** Kotlin.
- **Ambiente de desenvolvimento:** Android Studio.
- **Interface:** XML.
- **Componentes Android:** Activity, Intent, AlertDialog, EditText e Button.
- **Listagem de tarefas:** RecyclerView.
- **Organização da lista:** LinearLayoutManager.
- **Armazenamento local:** SharedPreferences.

## 5. Organização do projeto

A estrutura principal do projeto está organizada da seguinte maneira:

```text
SmartTask/
├── app/
│   └── src/
│       └── main/
│           ├── java/com/example/smarttask/
│           │   ├── activities/
│           │   │   └── MainActivity.kt
│           │   ├── adapter/
│           │   │   └── TarefaAdapter.kt
│           │   ├── model/
│           │   │   └── Tarefa.kt
│           │   ├── utils/
│           │   │   └── Prefs.kt
│           │   └── LoginActivity.kt
│           ├── res/
│           │   └── layout/
│           │       ├── activity_login.xml
│           │       ├── activity_main.xml
│           │       └── item_tarefa.xml
│           └── AndroidManifest.xml
├── README.md
└── ...
```

*Observação: a estrutura apresentada é ilustrativa. Os nomes e caminhos devem corresponder aos arquivos existentes no projeto.*

## 6. Como executar o projeto

1. Instale o Android Studio.
2. Clone o repositório do GitHub ou abra o projeto existente.
3. Aguarde a sincronização do Gradle.
4. Inicie um emulador Android ou conecte um dispositivo com a depuração USB habilitada.
5. Execute o aplicativo pelo botão **Run** do Android Studio.
6. Na tela de login, informe as credenciais configuradas na `LoginActivity.kt`.
7. Após a autenticação, utilize as funcionalidades de gerenciamento de tarefas.

## 7. Testes funcionais

| Teste                                      | Resultado esperado                     |
| ------------------------------------------ | -------------------------------------- |
| Abrir o aplicativo sem sessão ativa        | Exibir a tela de login                 |
| Informar credenciais incorretas            | Impedir o acesso e exibir uma mensagem |
| Informar credenciais válidas               | Abrir a tela principal                 |
| Adicionar uma tarefa                       | Exibir a nova tarefa na lista          |
| Editar uma tarefa                          | Atualizar o título                     |
| Excluir uma tarefa                         | Remover a tarefa da lista              |
| Clicar em Sair                             | Encerrar a sessão e retornar ao login  |
| Tentar acessar a tela principal sem sessão | Redirecionar para o login              |

## 8. Considerações sobre segurança

O SmartTask utiliza um mecanismo introdutório de autenticação local, adequado para demonstrar conceitos básicos de controle de acesso.

O estado da sessão é armazenado por meio de `SharedPreferences`. A validação local de credenciais é uma demonstração didática e não deve ser considerada suficiente para proteger dados sensíveis em um aplicativo de produção.

Para evoluir a segurança, recomenda-se:

- Utilizar um serviço de autenticação apropriado.
- Evitar armazenar senhas diretamente no código-fonte.
- Utilizar armazenamento seguro para informações sensíveis.
- Proteger os dados de cada usuário de forma independente.
- Avaliar os riscos relacionados ao armazenamento local e aos backups.
- Implementar testes adicionais de segurança e privacidade.

**Importante:** o controle de sessão local, isoladamente, não constitui uma autenticação robusta. As tarefas também precisam de isolamento por usuário caso o aplicativo passe a oferecer múltiplas contas.

## 9. Aprendizados

O desenvolvimento do SmartTask permite praticar:

- Fundamentos do desenvolvimento Android com Kotlin.
- Criação e navegação entre Activities.
- Construção de interfaces com XML.
- Manipulação de listas com RecyclerView.
- Operações de inclusão, edição e exclusão.
- Persistência local de informações.
- Controle de sessão e encerramento de acesso.
- Testes funcionais e documentação técnica.

## 10. Repositório

Código-fonte: [https://github.com/heraclidesefg/Projeto-smartTask](https://github.com/heraclidesefg/Projeto-smartTask)

## 11. Autor

Projeto desenvolvido por Heraclides Mourão para fins educacionais no componente curricular Desenvolvimento Android.

**Tecnologias principais:** Kotlin, Android Studio e XML.
