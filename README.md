# Marketplace Inventory - Mercado Livre

Este projeto é uma aplicação **Spring Boot** para gerenciamento de **inventário de produtos e usuários** para o **Mercado Livre**.  

---

## Funcionalidades

- **Produtos**
  - Criação de novos produtos
  - Atualização de produtos existentes
  - Remoção de produtos
  - Listagem de todos os produtos
  - Busca de um produto específico por ID

- **Usuários**
  - Criação de novos usuários
  - Atualização de dados de usuários
  - Remoção de usuários
  - Busca de usuários por ID
  - Validação de senha com regras de segurança

- **Outros**
  - Validação de dados para produtos e usuários
  - Tratamento de exceções centralizado

---

## Tecnologias Utilizadas

- Java 21  
- Spring Boot 3.5.5  
- Spring Data JPA (persistência de dados)  
- H2 Database (banco em memória para testes/desenvolvimento)  
- Maven (gerenciamento de dependências)  
- Lombok (redução de boilerplate)  
- MapStruct (mapeamento de DTOs e entidades)  
- JUnit 5 (testes unitários)  

---

## Arquitetura

O projeto segue **Clean Architecture** com separação em camadas:

- **Domain**  
  Entidades de negócio (`ProductDomain`, `UserDomain`), validadores (`ProductValidator`, `UserValidator`) e exceções customizadas.  

- **Application**  
  Casos de uso (use cases) e gateways que definem interfaces para a camada de infraestrutura.  

- **Infrastructure**  
  Implementação da persistência (`ProductRepositoryJPA`, `UserRepositoryJPA`), mapeamento de objetos e configurações.  

- **Presentation**  
  Exposição da **API REST** (`ProductController`, `UserController`), DTOs e tratamento global de exceções.  

---

## Configuração

Clone o repositório:

```bash
git clone https://github.com/daniloalves1902/marketplace-inventory-mercadolivre.git
````

Acesse o diretório do projeto:

```bash
cd marketplace-inventory-mercadolivre
```

### Configure as credenciais do Mercado Livre

Edite o arquivo `src/main/resources/application.properties` e substitua os placeholders:

```properties
# Credenciais do Mercado Livre
mercado-livre.client.id=YOUR-CLIENT-ID
mercado-livre.client.secret=YOUR-CLIENT-SECRET
mercado-livre.redirect.uri=YOUR-REDIRECT-URI

# Endpoints da API
mercado-livre.api.base-url=https://api.mercadolibre.com
mercado-livre.oauth.url=https://auth.mercadolivre.com.br/authorization
```

---

## Como Executar

Com o Maven Wrapper:

```bash
./mvnw spring-boot:run
```

Aplicação disponível em:
👉 [http://localhost:8080](http://localhost:8080)

Console do H2 disponível em:
👉 [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

---

## API Endpoints

### 🔹 Produtos

* `GET /api/v1/products` → Lista todos os produtos
* `GET /api/v1/products/{id}` → Busca produto por ID
* `POST /api/v1/products` → Cria novo produto
* `PUT /api/v1/products/{id}` → Atualiza produto existente
* `DELETE /api/v1/products/{id}` → Remove produto por ID

**Exemplo de corpo (POST/PUT):**

```json
{
  "sku": "EX-PROD-001",
  "name": "Produto de Exemplo",
  "description": "Descrição do produto de exemplo.",
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

---

### 🔹 Usuários

* `GET /api/v1/users` → Lista todos os usuários
* `GET /api/v1/users/{id}` → Busca usuário por ID
* `POST /api/v1/users` → Cria novo usuário
* `PUT /api/v1/users/{id}` → Atualiza usuário existente
* `DELETE /api/v1/users/{id}` → Remove usuário por ID

**Exemplo de corpo (POST/PUT):**

```json
{
  "name": "Nome do Usuário",
  "username": "usuarioteste",
  "password": "Password@123"
}
```

#### Regras de Validação da Senha

* Mínimo **8 caracteres**
* Pelo menos **1 caractere especial**
* Pelo menos **1 número**
* Pelo menos **1 letra maiúscula**

---

## Observações

* O `redirect.uri` deve ser **idêntico** ao configurado no app do Mercado Livre.
* O projeto usa **H2 Database** por padrão (ótimo para desenvolvimento).
  Para produção, configure outro banco no `application.properties`.

---
