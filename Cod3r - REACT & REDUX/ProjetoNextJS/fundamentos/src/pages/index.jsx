import Navegador from "@/components/Navegador";
import Link from "next/link";

export default function Inicio(){
    return (
        <div style={{
            display:'flex',
            justifyContent:'center',
            alignItems: 'center',
            height:'100vh',
            flexWrap:'wrap'
        }}>
            <Navegador cor='crimson' destino="/estiloso" texto="estiloso"/>
            <Navegador destino="/exemplo" texto="exemplo"/>
            <Navegador cor='green' destino="/jsx" texto="Jsx"/>
        </div>
    )
}