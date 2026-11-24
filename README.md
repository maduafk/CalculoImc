# Cálculo de IMC

Aplicação desktop para calcular o IMC, classificar o resultado e guardar o histórico de cada pessoa.

Feito com **Java 18**, **JavaFX** e **PostgreSQL** (Hibernate/JPA). O objetivo foi praticar interface gráfica, separação entre tela, regra e banco, e persistência dos cálculos.

## O que dá para fazer

- Ajustar peso e altura e ver o IMC na hora
- Ver a classificação (abaixo do peso, peso normal, sobrepeso ou obesidade)
- Salvar o cálculo com o nome da pessoa
- Consultar o histórico já salvo

## Como rodar

1. Instale o JDK 18 e o [Maven](https://maven.apache.org/).
2. Crie o banco `imc` no PostgreSQL.
3. Copie o arquivo de configuração e preencha a senha local:

```powershell
copy src\main\resources\db.properties.example src\main\resources\db.properties
```

4. Na pasta do projeto:

```bash
mvn javafx:run
```

A URL, o usuário e a senha do banco ficam só no `db.properties`, que não entra no Git.

## Stack

Java 18 · JavaFX · Maven · Hibernate · JPA · PostgreSQL
