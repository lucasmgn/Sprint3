# Sprint3

<h2> Informações</h2>
<p>Api foi desenvolvida seguindo o modelo de arquitetura MVC.
Na pasta resources, estão os arquivos, do swagger(documentacao.yaml), application.properties e o dta.sql

<p>Eu habilitei o cors do Spring, para poder fazer testes da requisição via Swagger
<p>Assim que a aplicação rodar, será feito o insert de dois estados Bahia e Sergipe

<p>A aplicação tem um crud, localizado na pasta controller, tem uma classe chamada StaterController, ela possui 5 métodos, são eles:
<ul>
  <li><strong>listarStates</strong>, que faz filtragem por região, maior população ou área, e também faz paginação</li>
  <li><strong>buscar</strong>, busca um state por id, caso não encontre retorna um 404, se ocorrer tudo certo retorna um 200</li>
  <li><strong>adicionar</strong>, adiciona um state, caso tudo seja preenchido de maneira correta, retorna um 201, se não um 400 e lança uma mensagem informando quais campos estão inválidos</li>
  <li><strong>atualizar</strong>, atualiza um state por id, caso tudo seja preenchido de maneira correta, retorna um 200, caso não encontre retorna um 404</li>
  <li><strong>excluir</strong>, deleta um state por id, retorna 204 , caso não encontre retorna um 404</li>
</ul>
<p>Para a atualização foi criado uma classe StateAtualizacaoForm
<p>As anotação de banco de dados está na entidade State(nome no banco de dados é States)  br.com.sprint3.states.domain.model
<p>Utilizei enum para aceitar apenas os valores Sul, Sudeste, Norte, Nordeste e Centro-oeste  br.com.sprint3.states.domain.model, adicionei também a anotação @JsonProperty() 
<p>Criei a a interface StateRepository br.com.sprint3.states.domain.repository
<p>Criei a classe de serviço CadastroStateService, para fazer consultas no banco de dados, utilizei a interface StateRepository para pegar os dados do banco, br.com.sprint3.states.domain.service
<p>Também criei uma classe para idicar erro de formulário com as propriedades campos e erro.
