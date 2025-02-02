# Duck Market 

Esta é uma API REST desenvolvida em Java utilizando o framework Spring Boot, destinada ao gerenciamento de uma granja de patos. A API permite o cadastro de patos, clientes, vendedores e a realização de vendas de patos, além de gerar relatórios.

## Funcionalidades e Requisitos

1. Cadastro de Patos

- Cada pato deve ter informações básicas, como ID, nome e mãe (referência a outro pato para rastreamento).
- Durante o cadastro, é necessário indicar a "mãe" de cada pato.
  
2. Cadastro de Clientes
   
- Cada cliente deve ter informações como ID, nome e status de elegibilidade para desconto (com/sem desconto).
  
3. Cadastro de Vendedores
   
- Vendedores devem ser identificados por um CPF válido, Nome e Matrícula.
- Não pode haver vendedores com o mesmo CPF ou matrícula.
- Não será possível excluir vendedores que já realizaram vendas.
  
4. Venda de Patos
  
- É possível registrar a venda de um ou mais patos ao mesmo tempo para um cliente cadastrado.
- Se o cliente for elegível para desconto, um desconto de 20% será aplicado automaticamente no valor total da venda.
- A data da venda deve ser registrada automaticamente.
- Não será possível realizar a venda do mesmo pato mais de uma vez (controle de estoque).
- O vendedor da venda deve ser identificado.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.4.2
- Maven
- Lombok
- H2 Database (usado no Profile test)
- Postgres no docker (usado no Profile dev)

## Como Rodar a Aplicação

Clone o repositório:
```
git clone https://github.com/otthonleao/spring-duck-market
cd Duck
```
Execute o projeto
```
mvn spring-boot:run
```
### Endpoints
- POST : http://localhost:8080/ducks
```json
{
	"name": "Rafael",
    "mother_id": 1
}
```
<img width="1552" alt="Screenshot 2025-02-02 at 17 50 05" src="https://github.com/user-attachments/assets/bbdb448b-1f87-427d-827a-b84bd7bf4ef0" />

- POST : http://localhost:8080/customers
```json
{
	"name": "Rodrigo",
    "has_discount": true
}

```
<img width="1508" alt="Screenshot 2025-02-02 at 17 52 05" src="https://github.com/user-attachments/assets/1eb837c0-4ef9-4ba6-acb2-0097bdc7b0a1" />

- POST : http://localhost:8080/sellers
```json
{
    "name": "Otthon",
    "cpf": 125525645,
    "registration": "2501h50"
}
```
<img width="1552" alt="Screenshot 2025-02-02 at 17 53 00" src="https://github.com/user-attachments/assets/f5aa58d8-72ab-4c70-a0f7-36ada1ae0d82" />

- GET: : http://localhost:8080/sellers
  <img width="1552" alt="Screenshot 2025-02-02 at 17 54 05" src="https://github.com/user-attachments/assets/8ab358c2-d1d3-4c09-bcaa-3bac5757f1dd" />

- POST : http://localhost:8080/sales
```json
{
  "customer_id": 3,
  "seller_id": 1,
  "ducks": [7, 8, 9]
}
```
<img width="1552" alt="Screenshot 2025-02-02 at 17 55 26" src="https://github.com/user-attachments/assets/7a6c05bb-220a-4073-8780-edc2fd69395f" />














