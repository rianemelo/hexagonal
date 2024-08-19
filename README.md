# **Hexagonal**

## **Descrição**

Solução para controle de sondas em múltiplos planetas.
Todos os planetas têm tamanho 5x5.
As sondas estarão posicionadas em um dado planeta como num plano cartesiano, ou seja, através de (posicaoX, posicaoY) e podem estar apondatas paras as direções N, S, E e W que representam os pontos cardeias norte, sul, leste e oeste, respectivamente.
Para mover uma sonda, utilizaremos os comandos R, L e M, **R**ight: rotação de noventa graus no sentido horário, **L**eft: idem para o sentido anti-horário e **M**over: mover de um na direção em que a sonda aponta.

Exemplo:
> **Controlador** é uma API RESTful desenvolvida em Java + Spring Boot usando arquitetura hexagonal e DDD, documentada por Swagger que inclui no controlador planetas, aterrissa e move sondas, com o cuidado de não sobrepô-las, ou seja, duas sondas não podem colidir, uma sonda não pode aterrissar num planeta que não esteja já registrado no controlador e a sonda não pode ser movida para o espaço, i.e., extravasar a dimensão de 5x5.
> Applicar o comando MMMRR numa sonda (1,2) apontando para oeste resulta (1,-1) apontando para o leste.

## **Recursos**
- Java 17
- Spring Boot 3.3.2
- Banco de Dados MongoDB


