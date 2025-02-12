import React from 'react'
import produtos from '../../data/produtos'

export default _ => {
    const produtoBody = produtos.map(produto => 
    <tr key={produto.id}>
        <td>{produto.id}</td>
        <td>{produto.nome}</td>
        <td>{produto.preco}</td>
    </tr>);

    return (
        <div>
            <table>
                <tbody>
                    <tr>
                        <th>Id</th>
                        <th>Nome</th>
                        <th>Preço</th>
                    </tr>
                    { produtoBody }
                </tbody>
            </table>
        </div>
    )
}