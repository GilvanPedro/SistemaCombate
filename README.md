# Sistema de Combate

Um projeto Java (Maven) simples que simula um combate em arena entre três personagens: `Guerreiro`, `Mago` e `Arqueiro`. O fluxo principal está em `JogoMain`, que cria os personagens, ativa suas habilidades especiais e inicia o combate na `Arena`.

## Requisitos
- Java JDK 24
- Maven 3.9+
- Sistema operacional: Windows, macOS ou Linux

## Estrutura do projeto
```
SistemaDeCombate/
├─ pom.xml
├─ README.md
└─ src/
   └─ main/
      └─ java/
         └─ br/com/
            ├─ JogoMain.java       # Ponto de entrada do aplicativo
            ├─ Arena.java          # Lógica de turnos e combate
            ├─ Personagem.java     # Classe base e interfaces Atacante/Defensor
            ├─ Guerreiro.java      # Implementa ataque/defesa e habilidade especial
            ├─ Mago.java           # Consome mana ao atacar; restaura com habilidade
            └─ Arqueiro.java       # Consome flechas ao atacar; recupera com habilidade
```

## Como compilar
```bash
mvn clean package
```

## Como executar
Como o `pom.xml` não define o plugin de execução, use o classpath após compilar:

```bash
# Compila
mvn clean package

# Executa a classe principal
java -cp target/classes br.com.JogoMain
```

Se preferir usar o Maven para executar diretamente, adicione o plugin `exec-maven-plugin` ao `pom.xml` ou rode com linha de comando especificando o main class (exige plugin):
```bash
mvn -Dexec.mainClass=br.com.JogoMain exec:java
```

## Lógica do combate
- A `Arena` roda turnos sequenciais enquanto houver pelo menos 2 personagens vivos.
- Ordem por turno:
  1. `p1` ataca `p2` (ou `p3` se `p2` estiver morto)
  2. `p2` ataca `p3` (ou `p1` se `p3` estiver morto)
  3. `p3` ataca `p1` (ou `p2` se `p1` estiver morto)
- Ao final de cada turno, a `Arena` imprime o HP restante de cada personagem.
- Vence quem permanecer com vida positiva quando restar apenas um vivo.

## Personagens e habilidades
- Guerreiro (`Guerreiro`)
  - Atributos iniciais: vida 150, ataque 30, defesa 25.
  - Implementa `Atacante` e `Defensor`.
  - Habilidade especial: mensagem de "Fúria de Batalha" (efeito ilustrativo).
  - Ataque causa `ataque - defesa_do_alvo` (mínimo 0).

- Mago (`Mago`)
  - Atributos iniciais: vida 100, ataque 40, defesa 10.
  - Implementa `Atacante`.
  - Consome 20 de mana por ataque; sem mana, não ataca.
  - Habilidade especial: restaura a mana para 100.

- Arqueiro (`Arqueiro`)
  - Atributos iniciais: vida 100, ataque 30, defesa 12.
  - Implementa `Atacante`.
  - Consome 1 flecha por ataque; sem flechas, não ataca.
  - Habilidade especial: recupera as flechas para 20.

## Exemplo de execução
Saída aproximada ao rodar `JogoMain`:
```
💥 Conan usa FÚRIA DE BATALHA! Ataque +50%
✨ Gandalf usa RECUPERAÇÃO MÁGICA e restaura toda a mana!
✨ Sérgio recupera todas as suas flechas perdidas no chão!

🏟 COMBATE INICIADO! 🏟
Conan vs Gandalf vs Sérgio
================================
--- Turno 1 ---
⚔️ Conan ataca Gandalf causando 20 de dano!
🔮 Gandalf lança BOLA DE FOGO em Sérgio! Dano: 40
🔮 Sérgio lança BOLA DE FOGO em Conan! Dano: 30
Conan: 120 HP
Gandalf: 80 HP
Sérgio: 60 HP
...
🏆 <VENCEDOR> VENCEU!
```

## Como alterar os personagens
Edite os atributos e comportamentos em:
- `src/main/java/br/com/Guerreiro.java`
- `src/main/java/br/com/Mago.java`
- `src/main/java/br/com/Arqueiro.java`

O ponto de entrada (`main`) está em `src/main/java/br/com/JogoMain.java`. Você pode mudar os nomes dos personagens, criar novos personagens (subclasses de `Personagem`) e ajustar a ordem de ataque.

## Compatibilidade
O `pom.xml` define `maven.compiler.source` e `maven.compiler.target` como 24. Caso esteja usando outra versão do Java, ajuste essas propriedades conforme necessário.

## Roadmap de melhorias
- Balanceamento de atributos e efeitos reais das habilidades.
- Plugin Maven para execução (`exec-maven-plugin`).
- Testes automatizados (JUnit).
- Logs estruturados e níveis de log.
- Interface interativa (CLI) para escolher ações por turno.

## Licença
Este projeto é distribuído sob a licença MIT. Ajuste conforme sua necessidade.
