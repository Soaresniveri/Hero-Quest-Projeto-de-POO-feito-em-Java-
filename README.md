# HeroQuest Java

Mini RPG de terminal feito em Java para praticar Programacao Orientada a Objetos.

O projeto simula uma aventura simples em que o jogador escolhe uma classe, enfrenta monstros, ganha experiencia, sobe de nivel, recebe equipamentos por drop e pode salvar/carregar o progresso usando um arquivo `.txt`.

## Funcionalidades

- Escolha de classe:
  - Guerreiro
  - Mago
  - Arqueiro
- Sistema de combate por turno.
- Ataque fisico e ataque magico.
- Defesa fisica e defesa magica.
- Monstros com vida, ataque, defesa, XP e drops.
- Equipamentos compativeis com classes especificas.
- Ganho de experiencia e subida de nivel.
- Sistema de save e load via arquivo `save.txt`.

## Conceitos praticados

- Classes e objetos.
- Heranca.
- Classe abstrata.
- Sobrescrita de metodos.
- Encapsulamento.
- Composicao entre objetos.
- Uso de `ArrayList`.
- Leitura de entrada com `Scanner`.
- Escrita e leitura de arquivos com `FileWriter`, `File` e `Scanner`.

## Estrutura principal

```text
Heroquest.java      # Classe principal com o menu e loop do jogo
Entidade.java       # Classe base para personagens e monstros
Personagem.java     # Classe abstrata dos herois
Guerreiro.java      # Classe do guerreiro
Mago.java           # Classe do mago
Arqueiro.java       # Classe do arqueiro
Monstro.java        # Classe dos inimigos
Equipamento.java    # Classe dos equipamentos
Fase.java           # Classe para representar fases
SaveManager.java    # Classe responsavel por salvar e carregar o jogo
```

## Como executar localmente

Com o Java instalado, compile todos os arquivos:

```bash
javac *.java
```

Depois execute:

```bash
java Heroquest
```

## Como jogar

Ao iniciar, o jogo permite:

```text
1 - Novo jogo
2 - Carregar jogo
```

Em um novo jogo, escolha o nome e a classe do heroi. Durante o combate, use o menu:

```text
1 - Ataque fisico
2 - Ataque magico
3 - Curar
4 - Salvar
5 - Sair
```

Ao derrotar monstros, o personagem ganha XP e pode receber equipamentos caso o inimigo tenha um drop.

## Save e load

O jogo salva o progresso em um arquivo chamado:

```text
save.txt
```

O arquivo armazena informacoes simples no formato `chave=valor`, por exemplo:

```text
nome=Arthur
classe=Guerreiro
vida=30
nivel=2
xp=40
fase=Floresta
```

Esse formato foi escolhido por ser simples de entender e bom para treinar leitura de arquivos em Java.

## Como testar no GitHub

Como o projeto ainda nao usa Maven ou Gradle, o teste automatico mais simples no GitHub e verificar se o codigo compila.

Crie este arquivo no repositorio:

```text
.github/workflows/java.yml
```

Com este conteudo:

```yaml
name: Java CI

on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]

jobs:
  compile:
    runs-on: ubuntu-latest

    steps:
      - name: Baixar codigo
        uses: actions/checkout@v4

      - name: Configurar Java
        uses: actions/setup-java@v4
        with:
          distribution: temurin
          java-version: '21'

      - name: Compilar projeto
        run: javac *.java
```

Sempre que voce fizer `push` ou abrir um pull request para a branch `main`, o GitHub vai tentar compilar o projeto. Se algum erro de Java aparecer, a Action falha e mostra o problema na aba **Actions** do repositorio.

## Proximos passos possiveis

- Organizar o projeto com Maven.
- Separar as classes em pacotes.
- Criar testes automatizados com JUnit.
- Melhorar o sistema de fases.
- Salvar tambem equipamento atual e fase atual real.
- Criar inventario.
- Adicionar mais monstros, itens e eventos.

## Status do projeto

Projeto em desenvolvimento, criado como estudo de Java, POO e estrutura de dados basica.
