# Funcionamento Javascript
------------------------------------------------------------------------------------------------------------

Javascript é single threaded.
    Funciona em cima do EVENTO LOOP que lida por meio de uma pilha (LIFO) de funções o chamado CALL STACK, onde as funções principais são operadas e o EVENT QUEUE onde as operações em espera são alternativamente operadas conforme possível como pendências.
    
    O EVENT LOOP verifica se a CALL STACK está vazia e nesse caso pega o próximo evento de EVENT QUEUE e coloca na CALL STACK, esse eventos podem chamar outros eventos que por sí podem adicionar ao EVENT QUEUE e ao STACK.