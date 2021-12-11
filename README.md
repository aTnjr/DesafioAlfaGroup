# DesafioAlfaGroup

Antes de tudo, após o download dos arquivos, é necessário tirar a pasta security da pasta principal da aplicação (DesafioAlfaGroup\demo\src\main\java\com\desafioalfagroup\taskManager). Pois ainda não temos um usuário cadastrado e se rodarmos a API com a pasta security não teremos autorização para salvar um usuário.

após mover a pasta será possível iniciar a aplicação, e salvar um usuário utilizando o método POST no caminho http://localhost:8080/api/usuario/salvar
passando no body:

{
    "login":"seuLogin",
    "password":"suaSenha"
}



agora a api consegue salvar o usuário padrão e a senha sera encrypitada.

Logo podemos voltar com a pasta security e reiniciar a aplicação.

Para consumir a API deverá ser feito uma requisição de POST para http://localhost:8080/login contendo no body o login e senha:

{
    "login":"seuLogin",
    "password":"suaSenha"
}

o JWT gerará um token que expira em 10 minutos, esse token deverá ser usado para autenticar o usuário e poder usar os métodos da API via postman.




requisições:

GET   localhost:8080/api/usuario/listarTodos       -----> Retorna uma lista com todos os usuários com login salvo e esconde as senhas.

GET   localhost:8080/api/usuario/validarSenha      -----> Verifica se a Senha é válida e retorna true

GET   localhost:8080/api/tarefas/                  -----> retorna uma lista com todas as tarefas

POST  localhost:8080/api/tarefas/save              -----> salva uma tarefa

GET   localhost:8080/api/tarefas/status            -----> Retorna uma lista com o Status passado como parametro (caso não passe nenhum retorna a lista completa).

GET   localhost:8080/api/tarefas/ordem             -----> Retorna a lista em ordem crescente de data de entrega

GET   localhost:8080/api/tarefas/prioridade        -----> Retorna uma lista com a Prioridade passada como parametro (caso não passe nenhum retorna a lista completa).

GET   localhost:8080/api/tarefas/prioridadeEntrega -----> Retorna uma lista com o menor intervalo de tempo desde o salvamento da tarefa até a data de entrega.




