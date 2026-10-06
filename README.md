<div align="center">

# 🏍️ Gerenciador de Corridas & Desempenho de Pilotos

### *Monitoramento de telemetria, estatísticas e classificação de pilotos de motovelocidade em Java*

---

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Git](https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)

</div>

---

## 📌 Visão Geral

Aplicação desenvolvida em **Java** via linha de comando (CLI) voltada para a gestão de dados de motovelocidade. O projeto consolida a aplicação prática dos pilares da **Programação Orientada a Objetos (POO)**, enfatizando:

* **Encapsulamento rigoroso** de entidades.
* **Modularização** em camadas de domínio e execução.
* **Manipulação e estruturação** de coleções de objetos.

O sistema permite cadastrar competidores, registrar telemetria de voltas e baterias, além de processar relatórios estatísticos detalhados da temporada.

---

## ⚡ Funcionalidades Principais

* 🏍️ **Gestão de Pilotos:** Cadastro com histórico dimensionável e controle de dados.
* ⏱️ **Registro de Telemetria:** Registro de circuitos, tempos de volta, posições finais e velocidades máximas na pista.
* 📊 **Análise de Desempenho:**
  * Total de pontos acumulados e média de pontuação por corrida.
  * Taxa percentual de vitórias e frequência de pódios conquistados.
* 🏆 **Classificação & Recordes:**
  * Determinação do líder geral do campeonato.
  * Destaque para o piloto com mais vitórias na temporada.
  * Identificação do recordista de velocidade máxima atingida nas retas.

---

## 🏗️ Modelagem das Classes

| Classe | Responsabilidade | Destaques |
| :--- | :--- | :--- |
| `Piloto.java` | Entidade de domínio do competidor | Métodos de cálculo de médias, taxas de vitória e agregação de histórico |
| `Corrida.java` | Registro individual de prova | Validação de pódio, cálculo de pontuação e telemetria |
| `Main.java` | Ponto de entrada e interface CLI | Controle de fluxo, menus interativos e gerenciamento dos vetores |

---

## 📂 Arquitetura do Repositório

```text
sistema_motogp/
├── src/
│   ├── Corrida.java
│   ├── Piloto.java
│   └── Main.java
├── .gitignore
└── README.md
