## 🚗 Projeto Concessionária em Java

Este projeto é um sistema de concessionária desenvolvido em Java, com o objetivo de aplicar conceitos de Programação Orientada a Objetos (POO), tratamento de exceções e organização de código em camadas.

O sistema simula o funcionamento de uma concessionária, permitindo cadastrar veículos e clientes, realizar vendas, gerar relatórios e recomendar veículos de acordo com o perfil do cliente.


## ✨ Funcionalidades

✔️ Cadastro de veículos (Carro, Moto e NovoVeiculo)

✔️ Cadastro de clientes com diferentes perfis (biotipos)

✔️ Listagem de veículos e clientes

✔️ Sugestão automática de veículos com base no perfil do cliente

✔️ Registro de vendas, com cálculo de lucro ou prejuízo

✔️ Geração de relatórios de vendas

✔️ Tratamento de exceções personalizadas:

VeiculoNaoEncontradoException

ClienteNaoEncontradoException

PrecoInvalidoException


## 📂 Estrutura de Pastas
src/
 ├── concessionaria/
 
 │   ├── Main.java               # Classe principal com menu interativo
 
 │   ├── Concessionaria.java     # Regras de negócio
 
 │   ├── Cliente.java            # Classe de cliente
 
 │   ├── Veiculo.java            # Classe abstrata veículo
 
 │   ├── Carro.java              # Classe carro
 
 │   ├── Moto.java               # Classe moto
 
 │   ├── NovoVeiculo.java        # Classe veículo elétrico/novo
 
 │   ├── Venda.java              # Registro de vendas
 
 │   └── exceptions/             # Exceções personalizadas
 
   │ ├── ClienteNaoEncontradoException.java
 
   │ ├── VeiculoNaoEncontradoException.java
 
   │ └── PrecoInvalidoException.java


# ▶️ Como Executar

# Clone o repositório

git clone https://github.com/IsabelSantosDev/Exercicios-POO-Java-Projeto-Final.git

Acesse a pasta do projeto

cd src

Compile os arquivos

javac src/*.java

Execute o programa

java -cp src Main


## 🎯 Conceitos Aplicados

Herança e Polimorfismo → classes Carro, Moto e NovoVeiculo herdam de Veiculo.

Tratamento de Exceções → validações para clientes, veículos e preços inválidos.

Encapsulamento → atributos privados e acesso via getters/setters.

Listas Dinâmicas → uso de ArrayList para armazenar clientes, veículos e vendas.


## 📌 Possíveis Melhorias Futuras

🔹 Persistência dos dados em arquivos ou banco de dados

🔹 Interface gráfica (JavaFX ou Swing)

🔹 API REST em Java Spring Boot

🔹 Testes unitários com JUnit


## 👩‍💻 Autor

Isabel dos Santos
