package DB;



import Aftale.Aftale;
import Aftale.AftaleController;
import Hospital.Hospital;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


// Jeg vil foreslå at ændre jeres klasse til noget der beskriver en handling for, hvad jeres system skal gøre.

// Main metoden er der hvor hele programmet køres og det vil give bedst mening.
public class UseDB {
        public static void main(String[] args) {

            // Når i opretter (new - initialize) jeres hospital vil den oprette aftale- og patientservice i sin klasse
            // Tjek det ud
            // Det er vigtigt at i forstår det. Så snart objekterne er "oprettet" har i adgang til dens metoder.

            new Hospital();

            // Instansier et Aftale objekt og brug den til at tilføje, fjerne, ændre og hente.
            Aftale secondAftale = new Aftale( new Date(2021-1900, Calendar.NOVEMBER, 10), "10-12-1999-6767");

            // Tilføje en aftale listen
            Hospital.getAftaleService().opretAftale(secondAftale);

            // Slette en aftale listen
            Hospital.getAftaleService().deleteAftale("10-12-1999-6767");

            // Ændre en aftale listen
            Hospital.getAftaleService().editAftale("12-12-2010-6767", new Date(2021-1900, Calendar.FEBRUARY, 21));

            // Hent en aftale fra listen
            System.out.println(Hospital.getAftaleService().getAftale("10-10-10"));

        }
}
