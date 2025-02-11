import React from 'react'
import produtos from '../../data/produtos'

export default props => {
    const produtosIdList = produtos.map(produto => {
        return (<tr>
            {produto.id}
            </tr>);
    });
    const produtosNomeList = produtos.map(produto => {
        return (<tr>
            {produto.nome}
            </tr>);
    });
    const produtosPrecoList = produtos.map(produto => {
        return (<tr>
            {produto.preco}
            </tr>);
    });
    return (
        <div>
            <table>
                <td> { produtosIdList } </td>
                <td> { produtosNomeList } </td>
                <td> { produtosPrecoList } </td>
            </table>
        </div>
    )
}