// Gustavo Espindola Oselame
// Feito no .net console por familiaridade
// 06/05/2025

public class Program
{
    public class No {
        private long id;
        private No esq, dir;
        public No(long id, No esq, No dir){
            this.id = id; 
            this.esq = esq; 
            this.dir = dir;
        }
        public long getId() { return this.id; }
        public No getEsq() { return esq; }
        public No getDir() { return dir; }
    }

    public class ArvoreBinaria {
        private No raiz;
        public ArvoreBinaria() { this.raiz = null; }

        //Insere número novo na árvore
        public void Inserir(No novo) {
            if (raiz == null){
                raiz = novo;
            }
        }
        //Números esquerdos filhos de outro nó
        public int esquerdosFestivos() {
            return noEsquerdosFestivos(raiz, false);
        }

        //Número de números esquerdos ...
        private int noEsquerdosFestivos(No? no, bool isFilhoEsquerdo) {
            if (no == null){
                return 0;
            } 
            int index = isFilhoEsquerdo ? 1 : 0;
            index = index + noEsquerdosFestivos(no.getEsq(), true);
            index = index + noEsquerdosFestivos(no.getDir(), false);
            return index;
        }
        
        // TODO Loop em sí mesmo talvez usar recursividade
        public void idsRecuoRecursivo() {
            idsRecuoRecursivo(raiz, 0);
        }
        private void idsRecuoRecursivo(No? no, int nivel) {
            string recuo = new string(' ', nivel);
            if (no == null) {
                Console.WriteLine(recuo + "-");
                return;
            }
            Console.WriteLine(recuo + no.getId());
            idsRecuoRecursivo(no.getEsq(), nivel + 1);
            idsRecuoRecursivo(no.getDir(), nivel + 1);
        }
    }
    public static void Main(string[] args){
        No no111 = new No(111, null, null);
        No no444 = new No(444, null, null);
        No no999 = new No(999, null, null);
        No no333 = new No(333, no111, no444);
        No no888 = new No(888, null, no999);
        No no555 = new No(555, no333, no888);

        ArvoreBinaria arvore = new ArvoreBinaria();
        arvore.Inserir(no555);
        arvore.idsRecuoRecursivo();
        arvore.Inserir(no111);

        int count = arvore.esquerdosFestivos();
        Console.WriteLine("Número de nós da esquerda festiva - " + count);
    }

}
