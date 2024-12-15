
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