# LPOO1718_T5G8

LPOO projects- Aliens Invasion

[Documentação Javadoc](https://github.com/SmilingOwl/AliensInvasion/tree/master/"Javadoc")


[UML Diagram](LpooUML.jpg)

Setup/Installation Procedure

    Opções disponíveis 

        •	Download o ficheiro android-realease.apk no dispositivo móvel

        •	Clonar a repositório AliensInvasion e abrir no Android Studio, correr como Android no dispositivo móvel.

Design of behavioural aspects:

    1. Model-view-controller(MVC)

    O jogo apresenta 3 packages principais:

        •	Model: Expressa o comportamento da aplicação. Gerência diretamente os dados, a lógica e as regras Da aplicação.

        •	View: Interface do jogo e representação de toda a informação d Model como output.

        •	Controller: Aceita os inputs e converte-os para o Model e para o view, trata da física do jogo.

Design Patterns 

    1.Flyweight:
    Usado na classe ViewFactory visto que clarifica e simplifica  o Código .

    2.Object Pool:
    Usado nas bolas de fogo disparadas pelos aliens, encontra-se na classe GameModel.

    3.Singleton:
    Usado nas classes GameModel e GameControler, ambas as classes têm apenas uma instância. Consideramos a utilização deste design pattern pois  organiza e clarifica o código.


Principais Dificuldades:

    Ao longo da realização do trabalho as maiores dificuldades que encontramos foram por as configurações necessárias para a realização dos testes unitários . 


Distribuição do trabalho:

    Ambos os membros do grupo trabalharam de igual forma e na maior parte das vezes em conjunto para facilitar a resolução de problemas. Ambos os elementos despenderam cerca de 50 horas na realização deste trabalho.


[User Manual](https://github.com/SmilingOwl/AliensInvasion/blob/master/User%20Manual.pdf)


Catarina de Almeida Figueiredo  up201606334@fe.up.pt

Juliana Maria Cruz Marques up201605568@fe.up.pt
