# Gerenciador de Corridas e Desempenho de Pilotos

Projeto em Java desenvolvido para a disciplina de Programação Orientada a Objetos, focado na aplicação prática de conceitos de estruturação de dados, modularização e encapsulamento.

# Sobre o Projeto

O sistema é uma aplicação via linha de comando (CLI) que permite cadastrar pilotos de corrida, registrar os resultados de suas partidas em circuitos e analisar métricas de desempenho individuais e comparativas.

# Funcionalidades

Cadastro de Pilotos: Registro de pilotos com dados estruturados e capacidade customizada de histórico.
Registro de Corridas: Inserção de dados de circuitos, posições, pontuações, tempos e velocidades.
Consulta de Histórico: Exibição detalhada de todas as corridas registradas por piloto.
Análise de Desempenho: Cálculo automático de total de pontos, média por corrida, percentual de vitórias e contagem de pódios.
Comparação entre Pilotos: Identificação do líder do campeonato, piloto com mais vitórias e recordista de velocidade.

# Tecnologias Utilizadas

Linguagem: Java.
IDE: IntelliJ.
Controle de Versão: Git e GitHub.

# Estrutura de Arquivos

Corrida.java: Modelo de dados com os atributos das corridas e regras de pódio/vitória.
Piloto.java: Modelo de dados e métodos de negócio para cálculos de métricas e estatísticas.
Main.java: Interface CLI, controle de menus e gerenciamento dos arrays de objetos.
