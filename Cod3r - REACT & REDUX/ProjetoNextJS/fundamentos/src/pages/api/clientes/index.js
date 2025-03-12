export default function cliente(req, res){
    switch(req.method){
        case 'GET':
            res.status(200).json({
                id: 0,
                nome: 'superbanana',
                idade: 29.3,
                metodo: req.method,
                banana: banana,
                params: JSON.stringify(req.query)
            })
        break;
        case 'POST':
            res.status(200).json({
                id: 1,
                nome: 'posthomem',
                idade: 300
            })
        break;
    }
}