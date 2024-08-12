#CodeChallenge- Bradesco

Esta é uma aplicação Java que utiliza Feign Client para consumir uma API externa de produtos do DummyJSON. A aplicação expõe três endpoints para buscar todos os produtos, buscar um produto específico por ID, e buscar produtos com base em um parâmetro de pesquisa.

##Pré-requisitos
Java 17
IDE (Utilizei IntelliJ)
Maven (para build e gerenciamento de dependências)

##Configuração

1. Clone o Repositório
git clone https://github.com/ViniciusMendes19/CodeChallenge---Bradesco.git

3. Build do Projeto
Compile e construa o projeto usando Maven:
mvn clean install

5. Executar a Aplicação
Inicie a aplicação:
mvn spring-boot:run
A aplicação será iniciada na porta 8080 por padrão.

##Endpoints Disponíveis

#🟣 Obter Todos os Produtos
Retorna uma lista de todos os produtos disponíveis na API externa.
Endpoint: GET /api/products
Exemplo de Requisição:
GET http://localhost:8080/api/products

#🟣 Obter Produto por ID
Retorna um produto específico baseado no ID fornecido.
Endpoint: GET /api/products/{id}
id (inteiro): O ID do produto a ser buscado.
Exemplo de Requisição:
GET http://localhost:8080/api/products/1

#🟣 Buscar Produtos por Parâmetro
Retorna uma lista de produtos que correspondem ao parâmetro de pesquisa fornecido.
Endpoint: GET /api/products/search
query (string): O termo a ser pesquisado nos produtos.
Exemplo de Requisição:
GET "http://localhost:8080/api/products/search?query=apple"

#Tratamento de Erros
A aplicação lida com exceções como produtos não encontrados, retornando uma resposta apropriada:

404 Not Found: Quando um produto com o ID especificado não é encontrado.
#Testes
A aplicação inclui testes para validar as funcionalidades dos endpoints e o comportamento do Feign Client:


##Sobre
#Esta aplicação foi desenvolvida como um exemplo de consumo de API externa utilizando Feign Client no Spring Boot
