# Paradigma Funcional - First Class Functions
------------------------------------------------------------------------------------------------------------

DECLARE GUERRA ÀS ATRIBUIÇÕES, DEFINIU ACABOU

First Class Functions
    * Funções são valores
    * Funções conseguem receber funções como parâmetro
    * Funções conseguem retornar valores
    * Funções podem ser guardadas em coleções

    @ - Função como variável:
    function dobro(x){
        return x*2;
    }
    dobro(20);

    @ - Função anônima, funcionalmente igual À anterior (atrelada à uma variável):
    const dobro = function(x){
        return x * 2;
    }
    dobro(20);

    @ - Função composta e anônima:
    const exagerado = composicao(
        gritar, <- Função
        enfatizar, <- Função
    )
    exagerado('PARA')