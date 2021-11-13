package Aftale;

import Patient.Patient;

import java.util.ArrayList;
import java.util.List;

public class AftaleDAO {
    //Forbind til database
    private final List<Aftale> aftaleList;


    public AftaleDAO(){
        this.aftaleList = new ArrayList<>();
    }

    public List<Aftale> getAftaler() {
        //TODO hent aftaler fra database
        return aftaleList;
    }

    public void addAftale(Aftale nyAftale){
        //TODO tilføj aftaler til database
        System.out.println("Opretter aftale...");
        this.aftaleList.add(nyAftale);
        System.out.println("Aftale oprettet! " + nyAftale);
    }

}
