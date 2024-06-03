package no.oslomet.cs.algdat.Oblig1;

import java.lang.UnsupportedOperationException;
import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.util.NoSuchElementException;

public class main {
    private main() {
    }


    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        if (a.length < 1)
            throw new java.util.NoSuchElementException("Tabellen a er tom!");

        int temp = 0;
        int maks = a[a.length - 1]; // definerer maksverdi og brukes dersom ingen ombyttinger er nødvendig
        for (int i = 1; i < a.length; i++) // starter med i = 1
        {
            if (a[i - 1] > a[i]) // sammenligner to naboverdier
            {
                temp = a[i];
                a[i] = a[i - 1];
                a[i - 1] = temp; // bytter om to naboverdier
                maks = a[a.length - 1]; // setter maksverdi
            }
        }
        return maks; // returnerer returnerer maksverdi


    }

    public static int ombyttinger(int[] a) {
        int temp = 0;
        int antall = 0; // antall ombyttinger i tabellen
        for (int i = 1; i < a.length; i++) // starter med i = 1
        {
            if (a[i - 1] > a[i]) // sammenligner to naboverdier
            {
                temp = a[i];
                a[i] = a[i - 1];
                a[i - 1] = temp; // bytter om to naboverdier
                antall++; // teller opp ombyttingene
            }
        }
        return antall; // returnerer antall ombyttinger


    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        int antall = 1;

        if (main.ombyttinger(a) == 0) { //sjekker om antall ombyttinger som trengs er 0 for å være i stigende rekkefølge
            for (int i = 1; i < a.length; i++) // starter med i = 1
            {
                if (!(a[i - 1] == a[i])) // sammenligner to naboverdier
                {
                    antall++; //teller antall ulike dersom verdiene ikke er like

                }
            }
        } else throw new IllegalStateException("Tabellen er ikke i stigende rekkefølge");
        if (a.length < 1) //sjekker for om tabellen er 0, og setter isåfall antall ulike tall til 0
            antall = 0;
        return antall; //returnerer antall ulike tall i tabellen
    }


    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        int antall = 0;
        HashMap<Integer, Integer> counting = new HashMap<Integer, Integer>();

        for (int c: a) {
            if (counting.containsKey(c)) {
                continue;
            }else {
                counting.put(c, 1);
                antall++;
            }
            }return antall;
    }
///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {


        // Current indexes from left and right
        int n = a.length;
        int l = 0, r = n - 1;
        int i;
        boolean odd = false;
        boolean even = false;
        boolean sole = true;

        for (i = 0; i < n; i++) {
            if (a[i] % 2 == 1) {
                odd = true;
            } else if (a[i] % 2 == 0) {
                even = true;
            }
        }
        int k = 0; // ??

        if (even == true && odd == true) {
            sole = false;
            while (l < r) {
                while (a[l] % 2 != 0)    // Finner første partall fra venstre side
                {
                    l++;
                    k++;
                }
                while (a[r] % 2 == 0 && l < r)  // Finner første oddetall fra høyre side<<
                    r--;
                if (l < r) {
                    // bytter om på array
                    int temp = a[l];
                    a[l] = a[r];
                    a[r] = temp;
                }
            }
        }
        if (sole == true) {
            Arrays.sort(a, 0, n);
        }

        if (odd == true) {
            Arrays.sort(a, 0, k); //Sorterer oddetall
        }
        if (even == true) {
            Arrays.sort(a, k, n); //Sorterer partall
        } else

    {
        ombyttinger(a);
    }

}
    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        int n = a.length; if (n < 2) return;
        char[] b = Arrays.copyOfRange(a, n - 1, n);
        for (int i=n-1;i>=1;i--)a[i]=a[i-1]; System.arraycopy(b, 0, a, 0, 1);
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        int n = a.length; if (n < 2) return;
        if ((k%=n)<0)k+=n;
        char[] b = Arrays.copyOfRange(a, n - k, n);
        for (int i=n-1;i>=k;i--)a[i]=a[i-k]; System.arraycopy(b, 0, a, 0, k);
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        // For å lagre resultat stringen
        StringBuilder result = new StringBuilder();

        // For hver index av string
        for (int i = 0; i < s.length() || i < t.length(); i++) {

            // Velger bokstav [i] dersom den eksisterer i første string
            if (i < s.length())
                result.append(s.charAt(i));

            // Velger bokstav [i] dersom den eksisterer i andre string
            if (i < t.length())
                result.append(t.charAt(i));
        }

        return result.toString();
    }

    /// 7b)
    public static String flett(String... s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (s[j].length() > i) {
                    result.append(s[j].charAt(i));
                }
            }
        }
        return result.toString();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new UnsupportedOperationException();
    }

}  
