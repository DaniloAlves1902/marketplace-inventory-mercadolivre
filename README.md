# Marketplace Inventory - Mercado Livre

Este projeto é uma aplicação **Spring Boot** para gerenciamento de inventário de produtos para o Mercado Livre. Ele fornece uma **API REST** para realizar operações de CRUD (Criar, Ler, Atualizar, Deletar) em produtos.

## Funcionalidades

* Criação de novos produtos
* Atualização de produtos existentes
* Remoção de produtos
* Listagem de todos os produtos
* Busca de um produto específico por ID

## Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3.5.5**
* **Spring Data JPA**: Para persistência de dados
* **H2 Database**: Banco de dados em memória para ambiente de teste/desenvolvimento
* **Maven**: Para gerenciamento de dependências
* **Lombok**: Para reduzir código boilerplate
* **MapStruct**: Para mapeamento de DTOs e entidades
* **JUnit 5**: Para testes unitários

## Arquitetura

O projeto segue uma arquitetura baseada em camadas, separando as responsabilidades em:

* **Domain**: Contém as entidades de negócio (`ProductDomain`) e as regras de validação (`ProductValidator`)
* **Application**: Orquestra o fluxo da aplicação, contendo os casos de uso (use cases) e os gateways para a camada de infraestrutura
* **Infrastructure**: Implementa a persistência de dados (`ProductRepositoryJPA`) e outros detalhes de infraestrutura
* **Presentation**: Expõe a API REST (`ProductController`) e lida com os DTOs (Data Transfer Objects)

## Configuração

1. **Clone o repositório**
```bash
git clone https://github.com/daniloalves1902/marketplace-inventory-mercadolivre.git
````

2. **Acesse o diretório do projeto**

```bash
cd marketplace-inventory-mercadolivre
```

3. **Configure as credenciais do Mercado Livre**
   Abra o arquivo `src/main/resources/application.properties` e substitua os placeholders `YOUR-CLIENT-ID`, `YOUR-CLIENT-SECRET` e `YOUR-REDIRECT-URI` com suas credenciais do Mercado Livre.

```properties
# Credenciais do Mercado Livre
mercado-livre.client.id=YOUR-CLIENT-ID
mercado-livre.client.secret=YOUR-CLIENT-SECRET
mercado-livre.redirect.uri=YOUR-REDIRECT-URI

# Endpoints da API
mercado-livre.api.base-url=https://api.mercadolibre.com
mercado-livre.oauth.url=https://auth.mercadolivre.com.br/authorization
```

## Como Executar

Você pode executar a aplicação usando o **Maven Wrapper**:

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em:
[http://localhost:8080](http://localhost:8080)

## API Endpoints

### Produtos

* **`GET /api/v1/products`**: Retorna uma lista de todos os produtos
* **`GET /api/v1/products/{id}`**: Retorna um produto específico pelo seu ID
* **`POST /api/v1/products`**: Cria um novo produto

**Exemplo de corpo da requisição:**

```json
{
  "sku": "EX-PROD-001",
  "name": "Produto de Exemplo",
  "description": "Descrição detalhada do produto de exemplo, mostrando como a API funciona.",
  "price": 149.90,
  "stock": 15,
  "currencyId": "BRL",
  "categoryId": "MLB1055",
  "listingTypeId": "gold_special",
  "condition": "new",
  "warranty": "1 ano de garantia pelo fabricante",
  "images": [
    "http://http2.mlstatic.com/D_NQ_NP_654321-MLB987654_012025-F.jpg"
  ],
  "attributes": {
    "BRAND": "Marca Exemplo",
    "MODEL": "Modelo XPTO",
    "COLOR": "Azul"
  }
}
```

* **`PUT /api/v1/products/{id}`**: Atualiza um produto existente (mesmo corpo do POST)
* **`DELETE /api/v1/products/{id}`**: Deleta um produto pelo seu ID

---

## Observações

* Certifique-se de que o `redirect.uri` seja **idêntico ao configurado no app do Mercado Livre**
* O projeto usa H2 Database por padrão, ideal para desenvolvimento. Para produção, configure outro banco, se necessário

---
