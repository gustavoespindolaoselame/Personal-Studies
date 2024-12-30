# Declarativo VS Imperativo - Estilos de paradigmas
------------------------------------------------------------------------------------------------------------

O estilo de código imperativo mostra o como e não o quê fazer.
    * Variáveis podem ser alteradas. (Mutabilidade)
    * Funcionamento explícito e claro mas mais complexo.

O estilo de código declarativo não mostra o como mas sim o quê fazer.
    * O estilo declarativo não altera variáveis apenas cria replicas. (Imutabilidade)
    * O estilo declarativo utiliza blocos imperativos implícitos para definir as ações que serão declaradas. 

        @ - Imperativo
        Func Divide(x){
            retorna x/2;
        }

        @ - Imperativo
        Func Soma(x){
            retorna x+2;
        }

        @ - Declarativo (Ênfase aqui)
        x = 2
        print(soma.(divide(x)))

        @ - Resultado
        3
