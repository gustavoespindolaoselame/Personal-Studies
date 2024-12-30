db.estados.find().pretty()

db.empresas.insert({
    nome: "Bradesco", estadoId: ObjectId("675f301cac8b4ae14ea5c0ad")
})

db.empresas.insert({
    nome: "Vale", cidadeoId: ObjectId("675f312cac8b4ae14ea5c0b1")
})