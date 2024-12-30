
db.estados.aggregate([{ $project: { nome: 1, "cidades.nome": 1, _id: 0 } }])

db.estados.aggregate([{
        $project: {populacao: {$sum: "$cidades.populacao"}, sigla: 1, _id: 0}},{
        $group: {_id: null, populacaoTotal: {$sum: "$populacao"}}},{
        $project:{ _id:0, populacaoTotal: 1}}
        ])

db.estados.aggregate([{
    $match: {"cidades.nome": "Sorocaba"}},{
    $unwind: "$cidades"},{
    $match: {"cidades.nome": "Sorocaba"}},{
    $project:{ _id: "$cidades._id"}},
]).pretty()

db.empresas.aggregate([{
    $match: {nome: "Bradesco"}},{
    $lookup: {from: "estados", 
        localField: "estadoId", 
        foreignField: "_id",
        as: "estado"}},
])

db.empresas.aggregate([{
    $match: {nome: "Vale"}},{
    $lookup: {from: "estados", 
        localField: "cidadeId", 
        foreignField: "cidades._id",
        as: "cidade"}},{
    $unwind: "$estado"},{
    $unwind: "$estado.cidades"}, {
    $match: {"estados.cidades._id":"$cidadesID"}},
])

db.empresas.aggregate([{
    $match: {nome: "Vale"}},{
    $lookup: {from: "estados", 
        localField: "cidadeId", 
        foreignField: "cidades._id",
        as: "cidade"}},{
    $unwind: "$estado"},{
    $unwind: "$estado.cidades"}, {
    $addFields: {mesmaCidade: {$cmp: ["$estado.cidades._id", "$cidadeID"]}}},
])