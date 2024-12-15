1 - Remove Collection:
        cb.collectionName.drop()

2 - Insert Into Collection:
        db.collectionName.insertOne({
        var1: "1",
        var2: 2,
        var3: [
          {_id: ObjectId(),
          var4:4,
          var5:5,
          },
          {_id: ObjectId(),
          var6:6
          }    
        ]
        })

3 - Show Collection:
        db.collectionName.find()

        Primeiro parâmetro do find é o filtro.

4 - Show Collection por valor:
        db.collectionName.find({
        var7: "var7"}
        )

5 - Show Collection por função boolean:
        db.collectionName.find({
                $filterName: [{
                var8: var8}, {
                var9: "var9"}
                ]})
        filterName tende a ser or ou and.

6 - Show Collection por validação:
        db.collectionName.find({
        var10: {
        $exists:true}}
        )

7 - Show Collection paginado:
        db.collectionName.skip(página)
        db.collectionName.limit(número de registros em uma página)

8 - Show quantidade de registros:
        db.collectionName.count()


9 - Show collection escolhendo atributos para mostrar:
        db.collectionName.find({var11: var11},{var12: 1, var13: 1, var14: 0})

        Mostraria var12 e var13

10 - Show collection escolhendo atributos de classes internas para mostrar:
        db.collectionName.find({var11: var11},{var12.var15: 1, var13.var16.var17: 1, var14: 0})

        Mostraria var12,var15 e var13,var16,var17

11 - Update registro:
        db.collectionName.update({var17: "var17"}, {$set: {var18: var18}})

11 - Update add registro:
        db.collectionName.update({var17: "var17"}, {$push: {newvar: newvar, newvar2: newvar2}})
