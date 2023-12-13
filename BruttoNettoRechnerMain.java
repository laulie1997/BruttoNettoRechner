public class BruttoNettoRechnerMain {
    public static void main(String[] args) {
        BruttoNettoRechner.inputBrutto();
        BruttoNettoRechner.calculateSteuerfreibetrag();
        BruttoNettoRechner.calculateKirchensteuer();
        BruttoNettoRechner.calculateKrankenversicherung();
        BruttoNettoRechner.calculatePflegeversicherung();
        BruttoNettoRechner.calculateArbeitslosenversicherung();
        BruttoNettoRechner.calculateRentenversicherung();
        BruttoNettoRechner.calculateSteuer();
        BruttoNettoRechner.calculateNettogehalt();
        BruttoNettoRechner.ausgabeErgebnisse();
        BruttoNettoRechner.scanner.close();
    }
}