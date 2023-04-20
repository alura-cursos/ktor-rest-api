# Ceep

REST API em Ktor que implementa um CRUD de notas com título e mensagem.

## 🔨 Funcionalidades do projeto

A aplicação permite:

- listar todas as notas
- busca nota por id
- criar uma nota
- alterar ou salva uma nota de id específico
- remover nota a partir do id

<img width="1018" alt="Console exibindo log de inicialização do Ktor" src="https://user-images.githubusercontent.com/8989346/233460234-8e75987d-0768-43fe-ab35-cecc627f8be5.png">

## ✔️ Técnicas e tecnologias utilizadas

Para implementar a aplicação foi utilizado

- `ktor server` 
- `ktor serialization`
- `ktor content negotiation`
- `kotlin serialization`
- `exposed`
- `h2 database`
- `Netty engine`
- `logback`

## 📁 Acesso ao projeto

Você pode acessar o [código fonte](https://github.com/alura-cursos/ktor-rest-api/tree/dev) da aplicação ou [baixar o zip](https://github.com/alura-cursos/ktor-rest-api/archive/refs/heads/dev.zip).

## 🛠️ Abrir e rodar o projeto

Para abrir o projeto, você pode considerar o uso do IntelliJ IDEA Comunnity ou Ultimate, basta apenas usar a opção **Open**, abrir o projeto e aguardar as tasks do Gradle em conjunto com indexação da IDE, então, é só acessar o arquivo `src\main\kotlin\br\com\alura\Application.kt` e rodá-lo.
