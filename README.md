<h1 align="center" style="font-weight: bold;">Fórum Hub API </h1>
<p align="center">
  <img src="src/assets/Badge-Spring.png" alt="Meu Badge" width="200"/>
</p>

ForumHub é um projeto desenvolvido durante o programa **Oracle Next Education (ONE) + Alura**. É um sistema de fórum para cursos, com funcionalidades de cadastro de usuários, autenticação via JWT e gerenciamento de tópicos.

<p align="center">
  <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java"/>
  <img src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" alt="Spring"/>
  <img src="https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens" alt="JWT"/>
  <img src="https://img.shields.io/badge/Spring%20Security-6DB33F?logo=springsecurity&logoColor=white&style=for-the-badge" alt="Spring Security"/>
  <img src="https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL"/>
  <img src="https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white" alt="Apache Maven"/>
  <img src="https://img.shields.io/badge/JPA-Hibernate-aca69f?style=for-the-badge&logo=Hibernate&logoColor=white" alt="JPA Hibernate"/>
</p>

---

## Como Executar

1. Clone o projeto:
```
git clone https://github.com/SEU-USUARIO/forumhub.git
```
2. Configure o banco de dados e aplique os scripts de migração em src/main/resources/db/migration
3. Execute a aplicação com Maven:
```
mvn spring-boot:run
```
4. Acesse a API via http://localhost:8080

---

## Estrutura do projeto

```
com.jhonata.forumhub
├── controller        # Classes que expõem os endpoints
├── domain
│   ├── entity        # Entidades JPA (Usuario, Topico, Curso)
│   └── enums         # Enums (Categoria, StatusTopico)
├── dto               # Objetos de transferência de dados (Request/Response)
├── infrastructure
│   ├── exceptions    # Tratamento de erros
│   └── security      # Configuração de segurança e JWT
├── mapper            # Mapeamento entre DTOs e entidades
├── repository        # Repositórios JPA
└── service           # Lógica de negócio
```

## Endpoints Principais

### Autenticação.

**POST** `/login`  
Autentica o usuário e retorna o **JWT**.

**Request Body**
```json
{
  "login": "usuario123",
  "senha": "senha123"
}
```
**Response Body**
```json
{
  "tokenJWT": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

**GET** `/topicos`  
Lista todos os tópicos paginados.

**Response Body**
```json
{
	"content": [
		{
			"id": 1,
			"titulo": "Como aprender Java?",
			"mensagem": "Alguém pode me dar dicas?",
			"dataDeCriacao": "2025-08-18T20:24:05",
			"status": "ABERTO",
			"curso": {
				"nome": "Java Avançado",
				"categoria": "PROGRAMACAOWEB"
			}
		},
		{
			"id": 2,
			"titulo": "Dúvida sobre Spring Boot",
			"mensagem": "Não consigo entender o DeleteMapping",
			"dataDeCriacao": "2025-08-22T18:45:01",
			"status": "ABERTO",
			"curso": {
				"nome": "Java com Spring Boot",
				"categoria": "PROGRAMACAOWEB"
			}
		}
	],
	"pageable": {
		"pageNumber": 0,
		"pageSize": 20,
		"sort": {
			"empty": true,
			"unsorted": true,
			"sorted": false
		},
		"offset": 0,
		"unpaged": false,
		"paged": true
	},
	"totalPages": 1,
	"totalElements": 2,
	"last": true,
	"size": 20,
	"number": 0,
	"sort": {
		"empty": true,
		"unsorted": true,
		"sorted": false
	},
	"numberOfElements": 2,
	"first": true,
	"empty": false
}
```

**GET** `/topicos/{id}`  
Consulta um tópico específico por ID.

**Response Body**

```json
{
	"id": 1,
	"titulo": "Como aprender Spring Boot?",
	"mensagem": "Alguém pode me dar dicas?",
	"dataDeCriacao": "2025-08-18T20:24:05",
	"status": "ABERTO",
	"curso": {
		"nome": "Java Avançado",
		"categoria": "PROGRAMACAOWEB"
	}
}
```

**POST** /topicos  
Cria um novo tópico.

**Request Body**
```json
{
  "titulo": "Dicas para estudar Java Collections",
  "mensagem": "Quais são os melhores exercícios para praticar List, Set e Map?",
  "nomeCurso": "Java Intermediário",
  "categoria": "PROGRAMACAOWEB"
}
```






