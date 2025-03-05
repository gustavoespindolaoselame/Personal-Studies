// PTI - POO - Gustavo Espindola Oselame
using System;

abstract class Veiculo
{
    protected double TaxaDiaria {get; set;}
    public abstract double CalcularValorTotal(int numDiarias);
    
}

class Carro : Veiculo
{
    public Carro(double taxa)
    {
        TaxaDiaria = taxa;
    }
    public override double CalcularValorTotal(int dias)
    {
        return TaxaDiaria * dias;
    }
}

class Moto : Veiculo
{
    public Moto(double taxa)
    {
        TaxaDiaria = taxa;
    }
    public override double CalcularValorTotal(int dias)
    {
        return TaxaDiaria * dias;
    }
}

class Program
{
    static void Main()
    {
        Carro carro = new Carro(90.75);
        Moto moto = new Moto(45.5);
        int diarias = 10;
        Console.WriteLine("\nPTI - POO - Gustavo Espindola Oselame\nCarro - Diárias: " + diarias + "R$\nCarro - Total: " + carro.CalcularValorTotal(diarias) + "R$\n");
        Console.WriteLine("Moto - Diárias: " + diarias + "R$\nMoto - Total: " + moto.CalcularValorTotal(diarias) + "R$");
    }
}
