# Sprint3

<h2> Informações</h2>
<p>Na pasta resources estão os arquivos, do swagger(documentacao.yaml) da questão 2, application.properties e o dta.sql

<h3>Eu habilitei o cors do Spring, para poder fazer testes da requisição via Swagger</h3>

![Captura de Tela (92)](https://user-images.githubusercontent.com/81782608/201473598-514cc6eb-78b4-4e47-be40-366ee744f63a.png)

![Captura de Tela (104)](https://user-images.githubusercontent.com/81782608/201504908-ffb09db1-bd6d-4486-abe5-db0b225e2acb.png)

<h3>Foi criada a classe <strong>StringEnumConverte</strong> para converter os valores do params para Enum e assim fazer o filtro por região</h3>

![Captura de Tela (106)](https://user-images.githubusercontent.com/81782608/201563351-fa322b8d-7904-474b-886d-0942eb37ed08.png)

<h3>Houve a necessidade de validar o filtro por Região, então criei uma classe handler que capturaria possiveis erros e retornasse um badRequest</h3>

![Captura de Tela (109)](https://user-images.githubusercontent.com/81782608/201695312-602a3360-79b3-4c97-a58a-732bd73f477e.png)


<h3>Assim que a aplicação rodar, será feito o insert de dois estados Bahia e Sergipe</h3>

![Captura de Tela (98)](https://user-images.githubusercontent.com/81782608/201474014-44d64b9c-873b-4280-abd0-b54b747c41e3.png)

<p>A aplicação tem um crud, localizado na pasta controller, tem uma classe chamada <strong>StaterController</strong>, ela possui 5 métodos, são eles:
<ul>
  <li><strong>listarStates</strong>, que faz filtragem por região, maior população ou área, e também faz paginação</li>
  <li><strong>buscar</strong>, busca um state por id, caso não encontre retorna um 404, se ocorrer tudo certo retorna um 200</li>
  <li><strong>adicionar</strong>, adiciona um state, caso tudo seja preenchido de maneira correta, retorna um 201, se não um 400 e lança uma mensagem informando quais campos estão inválidos</li>
  <li><strong>atualizar</strong>, atualiza um state por id, caso tudo seja preenchido de maneira correta, retorna um 200, caso não encontre retorna um 404</li>
  <li><strong>excluir</strong>, deleta um state por id, retorna 204 , caso não encontre retorna um 404</li>
</ul>
<p>Para o endpoint Put (atualização) foi criado uma classe <strong>StateAtualizacaoForm</strong>

<h3>As anotação de persistencia está na entidade <strong>State(nome no banco de dados é States)</strong>  br.com.sprint3.states.domain.model</h3>

![Captura de Tela (94)](https://user-images.githubusercontent.com/81782608/201473756-d48cf2e2-a57b-4d86-87cd-3543470ccf2f.png)

<h3>Utilizei enum para aceitar apenas os valores Sul, Sudeste, Norte, Nordeste e Centro-oeste  br.com.sprint3.states.domain.model, adicionei também a anotação @JsonProperty()</h3> 

![Captura de Tela (93)](https://user-images.githubusercontent.com/81782608/201473720-49043ae7-5b2c-480b-bc70-ae0507bf414c.png)

<h3>Criei a a interface <strong>StateRepository</strong> br.com.sprint3.states.domain.repository</h3>

![Captura de Tela (97)](https://user-images.githubusercontent.com/81782608/201473988-617ddfc5-ffa4-40bb-938b-c349a557839b.png)

<h3>Criei a classe de serviço <strong>CadastroStateService</strong>, para fazer consultas no banco de dados, utilizei a interface <strong>StateRepository</strong> para recuperar dados do banco, br.com.sprint3.states.domain.service</h3>

![Captura de Tela (95)](https://user-images.githubusercontent.com/81782608/201473817-089e3cf1-ac05-4224-bc2f-86e762b6b505.png)

<h3>Também criei uma classe para idicar erro de formulário com as propriedades campos e erro, <strong>ErroDeFormulario</strong>.</h3>

![Captura de Tela (99)](https://user-images.githubusercontent.com/81782608/201474205-64865255-1680-428d-b199-aa965cf5c07a.png)

<h3>Postman.</h3>

<h4>Listar</h4>

![Captura de Tela (100)](https://user-images.githubusercontent.com/81782608/201474389-617184c5-c218-4396-b9c6-3b279183e527.png)

<h4>Cadastrar</h4>

![Captura de Tela (101)](https://user-images.githubusercontent.com/81782608/201474414-5e7d6625-6719-48b9-ac9c-b9356f11c5a1.png)

<h4>Atualizar</h4>

![Captura de Tela (102)](https://user-images.githubusercontent.com/81782608/201474420-f956a12d-17ae-415f-a840-20840983b467.png)


