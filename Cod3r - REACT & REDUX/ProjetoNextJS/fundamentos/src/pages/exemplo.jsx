// import Cabecalho from "@/components/Cabecalho";
import Link from "next/link";

export default function Exemplo(){
    return (
        <div>
            <h1>Oi Exemplo</h1>
            <Link href="/" style={{
                backgroundColor: '#888',
                padding:'2px',
                borderRadius:'6px'
            }}>voltar</Link>
        </div>
    )
}