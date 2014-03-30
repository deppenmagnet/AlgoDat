package wuerfelsim1;

public class WuerfelSim {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		int SIDES = 6;
		double[] dist = new double[2*SIDES + 1];
		for (int i = 1; i <= SIDES; i++)
			for (int j = 1; j <= SIDES; j++)
				dist[i+j] += 1.0;
		
		for (int k = 2; k <= 2*SIDES; k++)
			dist[k] /= 36.0;
		
		teste_wuerfel(dist);
		
	}
	
	static void teste_wuerfel(double[] wahrscheinlichkeitsverteilung){
		boolean abbruch = false;
		int wurf_zaehler = 0;
		// Werfen und Testen!
		// Da ich nur drei Nachkommastellen brauche kann ich prima mit Integern arbeiten. So vermeide ich beim Vergleichen Schwierigkeiten mit
		// den Gleitkomma-Ungenauigkeiten und kann die schnelle Integer-Arithmetik verwenden
		int[] dist = new int[wahrscheinlichkeitsverteilung.length];
		for(int i = 1; i < dist.length; i++)
			dist[i] = (int)(wahrscheinlichkeitsverteilung[i]*1000);
		
		// dementsprechend arbeite ich mit Integer weiter
		int[] wuerfe = new int[dist.length];
		int[] dist_real = new int[dist.length];

		while(!abbruch){
			wuerfe[werfe_wuerfel()]++;
			wurf_zaehler ++;
			//System.out.println("Durchgang: "+wurf_zaehler);
			for (int i = 2; i < dist.length; i++){ // die 1 kann nie vorkommen
				dist_real[i] = wuerfe[i]*1000/wurf_zaehler;
			}
			// Abbruchbedingung
			// Die Differenz jedes Wertes von dist und dist_real muss < eta sein.
			int anzahl_korrekter_ergebnisse = 1; // da 1 nie vorkommen kann kann ich bei zwei beginnen
			for (int i = 2; i < dist.length; i++){
				if(dist[i] == dist_real[i]){ 	// gleiche Verteilungswerte
					anzahl_korrekter_ergebnisse++;
				}
			}
			abbruch = (anzahl_korrekter_ergebnisse == 12);
		}
		System.out.println("Anzahl der benötigten Würfe: "+wurf_zaehler);
		for (int i = 2; i < dist.length; i++)
			System.out.println(i+": "+wuerfe[i]+"mal -> "+dist_real[i]+ " -> " + dist [i]);


	}

	static int werfe_wuerfel(){
		return ((int) (Math.random() * 6 +1)+(int)(Math.random() * 6 +1));


	}

}
