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
            <Navegador cor='crimson' destino="/jsx" texto="Jsx"/>
            <Navegador destino="/navegacao" texto="Navegação - 01"/>
            <Navegador cor='crimson' destino="/cliente/sp-2/123" texto="Navegação - 01"/>
            <Navegador destino="/estado" texto="Estado"/>
            <Navegador cor='crimson' destino="/integracao" texto="Integracao"/>
        </div>
    )
}