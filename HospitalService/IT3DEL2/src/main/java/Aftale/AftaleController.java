package Aftale;

import java.util.List;

public class AftaleController {

    private AftaleService aftaleService;

    public AftaleController(AftaleService aftaleService){
      this.aftaleService = aftaleService;
    }

    public void deleteAftale(String cpr){
        aftaleService.getAftaleDAO().getAftaler().removeIf(aftale -> aftale.getCpr().equals(cpr));
        System.out.println("Aftale with cpr: " + cpr + " has been removed");
    }

    public void saveAftale(Aftale nyAftale) {
        aftaleService.addAftale(nyAftale);
    }



}
