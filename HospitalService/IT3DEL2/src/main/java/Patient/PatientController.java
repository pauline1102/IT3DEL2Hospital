package Patient;

import java.util.ArrayList;
import java.util.List;
@Deprecated
public class PatientController {

    private PatientDAO patientDAO;

    public PatientController(PatientDAO patientDAO){
            this.patientDAO = new PatientDAO();
    }

    public List<Patient> getPatients() {
        return patientDAO.getPatients();
    }

    public void addPatient(Patient patient){
        patientDAO.addPatient(patient);
    }
}
