package exemplul2;
public class PerecheNumere
{
    private int numar1;
    private int numar2;

    public PerecheNumere() {}

    public PerecheNumere(int numar1, int numar2)
    {
        this.numar1 = numar1;
        this.numar2 = numar2;
    }

    public int getNumar1()
    {
        return numar1;
    }

    public void setNumar1(int numar1)
    {
        this.numar1 = numar1;
    }

    public int getNumar2()
    {
        return numar2;
    }

    public void setNumar2(int numar2)
    {
        this.numar2 = numar2;
    }

    @Override
    public String toString()
    {
        return  numar1 + ", " + numar2;
    }

    // nr consecutive in sirul lui fibonacci
    public boolean suntConsecutiveFibonacci()
    {
        return esteFibonacci(numar1) && esteFibonacci(numar2) && Math.abs(numar1 - numar2) == 1;
    }

    private boolean esteFibonacci(int numar)
    {
        int x = 5 * numar * numar + 4;
        int y = 5 * numar * numar - 4;
        return estePatratPerfect(x) || estePatratPerfect(y);
    }

    private boolean estePatratPerfect(int numar)
    {
        int sqrt = (int) Math.sqrt(numar);
        return sqrt * sqrt == numar;
    }

    //CMMMC
    public int cmmmc()
    {
        return (numar1 * numar2) / cmmdc(numar1, numar2);
    }

    private int cmmdc(int a, int b)
    {
        while (b != 0)
        {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

            // suma egala cifre
    public boolean auSumaCifrelorEgala()
    {
        return sumaCifrelor(numar1) == sumaCifrelor(numar2);
    }

    private int sumaCifrelor(int numar)
    {
        int suma = 0;
        while (numar != 0)
        {
            suma += numar % 10;
            numar /= 10;
        }
        return suma;
    }

       //verificare cifre pare
    public boolean auAcelasiNumarCifrePare()
    {
        return numarCifrePare(numar1) == numarCifrePare(numar2);
    }

    private int numarCifrePare(int numar)
    {
        int count = 0;
        while (numar != 0)
        {
            int cifra = numar % 10;
            if (cifra % 2 == 0) {
                count++;
            }
            numar /= 10;
        }
        return count;
    }
}
