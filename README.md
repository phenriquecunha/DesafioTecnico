# Desafio Técnico

## 💻 Pré-requisitos

- Java JDK 17
- Um servidor de banco de dados local ou remoto. Por padrão a aplicação está configurada para acessar um banco MS SQL chamado 'dev', voce deverá atualizar as informações de acesso ao seu BD em `src/main/resources/application.properties`
  
  ```properties
  spring.datasource.url=jdbc:sqlserver://localhost;encrypt=false;trustServerCertificate=false;databaseName=dev
  spring.datasource.username=sa
  spring.datasource.password=Admin123
  spring.datasource.driverClassName=com.microsoft.sqlserver.jdbc.SQLServerDriver
  spring.jpa.hibernate.dialect=org.hibernate.dialect.SQLServer2012Dialect
  ```
- O projeto inclui o Maven Wrapper (mvnw), permitindo que você utilize o Maven mesmo sem instalá-lo globalmente.

## 🚀 Instalando o projeto

Para instalar o projeto, faça o clone do repositório com o comando:

```powershell
git clone https://github.com/phenriquecunha/DesafioTecnico.git
```
ou faça o download do .zip clicando em `Code` -> `Download ZIP` na página inicial do repositório

## ☕ Rodando o projeto
Após a instalação, na pasta raiz do projeto, compile a aplicação com o comando:
```powershell
./mvnw clean install
```
e rode o projeto Spring com o comando:
```powershell
./mvnw spring-boot:run
```
Por padrão, a aplicação irá rodar na porta 9090, caso queira altera-lá é possivel modificar a seguinte linha no `src/main/resources/application.properties`
  ```properties
  server.port=9090
  ```
