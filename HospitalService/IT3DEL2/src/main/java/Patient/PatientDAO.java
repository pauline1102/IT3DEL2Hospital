package Patient;

import java.util.ArrayList;
import java.util.List;
@Deprecated
public class PatientDAO {
    //Forbind til database

    private List<Patient> patientListe;

    public PatientDAO(){
        this.patientListe = new ArrayList<>();
    }

    public List<Patient> getPatients() {
        //TODO Hent patienter fra database
        return patientListe;
    }

    public void addPatient(Patient patient){

        //TODO Tilføj patient til database
        patientListe.add(patient);
    }
}
