public class HashSuche {
    private int mod;
    private int[] zahlen;
    private double[] zahlen1;
    // private int[] index= new int[10];
    private int[] koll;



    public HashSuche(int pMod){
        mod=pMod;
        zahlen= new int[mod];
        zahlen1= new double[mod];
        koll= new int[mod];
    }

    public int berechneHash(int pSchluessel){
        return pSchluessel %mod;
    }

    public int fuegeEin(int pSchluessel, double wert){
        int index =  berechneHash(pSchluessel); //den Hashwert des Schlüsselbekommen
        int kollisionen=0; //die Kollisionen initialisieren


        while (zahlen[index+kollisionen] != 0) { //solange durchgehen, bis ein freies Feld gefunden wurde
            kollisionen++; //Kollisionen erhöhen
            if(kollisionen==zahlen.length){ //wenn es keine freien Felder mehr gibt
                return kollisionen; // return Kollisionen, nicht einfügen, weil voll
            }
        }
        if(index+kollisionen>zahlen.length){ //wenn man von vorne wieder anfangen muss einzufügen
            zahlen[(index+kollisionen)-zahlen.length]=pSchluessel; //Schlüssel einfügen
            zahlen1[(index+kollisionen)-zahlen.length]=wert; //Wert einfügen
            koll[index]=kollisionen;
        }else {
            zahlen[index + kollisionen] = pSchluessel; //Schlüssel einfügen
            zahlen1[index + kollisionen] = wert; //Wert einfügen
            koll[index]=kollisionen;
        }


//

        return kollisionen;
    } //Werte in die Tabelle einfügen, Tabelle voll

    public int suchePositionVon(int pSchluessel) {
        int index = berechneHash(pSchluessel); //eigentlichen index vom Schlüssel bekommen

        for (int i = index; i <= index + koll[index]; i++) { //index und die höchste Kollision an dem Index, um Begrenzung zu schaffen
            if (i > zahlen.length) { //Abfrage, ob man von vorne weiter gehen muss
                if (pSchluessel == zahlen[i - zahlen.length]) { //wenn man an der letzten Stelle vom Array angelangt ist
                    return i - zahlen.length; //return des Index
                }
            } else {
                if (pSchluessel == zahlen[i]) { //Wenn der Schlüssel gefunden wrude
                    return i;
                }
            }
        }
        return -1;
    }




    public int[] gibZahlen(){
        return zahlen;
    }

    public double[] gibZahlen1(){
        return zahlen1;
    }

    public int[] gibKollisionen(){
        return koll;
    }

    public double gibWertVon(int pGeburtsdatum){
        for(int i=0 ; i<zahlen.length; i++){
            if(zahlen[i]==pGeburtsdatum){
                return zahlen1[i];
            }
        }
        return -1;
    }
}