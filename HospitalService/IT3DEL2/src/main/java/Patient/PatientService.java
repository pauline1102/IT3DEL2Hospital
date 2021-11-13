package Patient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.util.List;

@Path("patients")
public class PatientService {

    private Connection connection;
    public PatientService(Connection connection){

    }
    private PatientController patientController = new PatientController(new PatientDAO());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patient> getPatient() {
        return patientController.getPatients();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPatient(Patient patient) {http://localhost:8080/IT3DEL2_war/
        System.out.println(patient);
        patientController.addPatient(patient);
    }
}
