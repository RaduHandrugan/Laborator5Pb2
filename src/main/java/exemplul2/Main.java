/*Să implementeze clasa PerecheNumere care are variabile membre private doi întregi.
Clasa PerecheNumere va avea un constructor cu parametri şi unul fără parametri, gettere şi
setttere pentru accesarea variabilelor membre şi va redefini metoda toString din clasa Object.
În program se va crea o colecție de obiecte de tip List în care se vor adăuga minim 3
perechi de numere.
În programul principal se vor dezvolta metodele:
static void scriere(List< PerecheNumere > lista);
static List<Persoana> citire();
Metoda scriere() va salva lista perechilor de numere într-un fișier JSON, iar metoda
citire() va încărca lista perechilor de numere din fișierul JSON în program.
În clasa PerecheNumere se vor dezvolta următoarele metode:
• o metodă care va returna o valoare booleana care indică dacă cele două numere care
formează perechea sunt numere consecutive în șirul lui Fibonaci
• o metodă care returnează cel mic multiplu comun al celor două numere
• o metodă care va returna boolean daca cele doua numere au suma cifrelor egală
• o metodă care va returna boolean dacă cele doua numere au același număr de cifre pare.
* */
package exemplul2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Main
{
    public static void scriere(List<PerecheNumere> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/perechi.json");
            mapper.writeValue(file, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<PerecheNumere> citire() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/perechi.json");
            return mapper.readValue(file, new TypeReference<List<PerecheNumere>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        // Inițializare colecție
        List<PerecheNumere> perechi = new ArrayList<>();
        perechi.add(new PerecheNumere(3, 5));
        perechi.add(new PerecheNumere(8, 13));
        perechi.add(new PerecheNumere(6, 12));

        // Scrierea în fișier
        scriere(perechi);

        // Citirea din fișier
        List<PerecheNumere> perechiCitite = citire();
        System.out.println("Perechi citite din fișier:");
        perechiCitite.forEach(System.out::println);

        // Testare metode pe prima pereche
        if (!perechiCitite.isEmpty()) {
            PerecheNumere primaPereche = perechiCitite.get(0);
            System.out.println("\nPrima pereche: " + primaPereche);
            System.out.println("Sunt consecutive în Fibonacci? " + primaPereche.suntConsecutiveFibonacci());
            System.out.println("CMMMC: " + primaPereche.cmmmc());
            System.out.println("Au suma cifrelor egală? " + primaPereche.auSumaCifrelorEgala());
            System.out.println("Au același număr de cifre pare? " + primaPereche.auAcelasiNumarCifrePare());
        }
    }
}
