Comunicação push e pull referem-se a como dados são produzidos e consumidos:

    Push: O produtor decide quando enviar dados ao consumidor. O consumidor é passivo.

    Pull: O consumidor solicita dados do produtor quando necessário. O produtor é passivo.

Aplicações:

    Promises:

        Push: A Promise (produtor) envia o resultado (ou erro) ao consumidor quando está pronta.

    Observables:

        Push: O Observable (produtor) emite valores ao Observer (consumidor) ao longo do tempo.

    Functions:

        Pull: A função (produtor) só executa e retorna um valor quando chamada (consumidor solicita).

    Iterators:

        Pull: O consumidor solicita o próximo valor ao iterador (produtor) usando next().

Resumo:

    Push: Produtor controla o fluxo (Promises, Observables).

    Pull: Consumidor controla o fluxo (Functions, Iterators).