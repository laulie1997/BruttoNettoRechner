import java.util.Scanner;

public class BruttoNettoRechner {
    static Scanner scanner = new Scanner(System.in);

    static double bruttoGehalt;
    static double berechneSteuer;
    static double zuVersteuerndesEinkommen;

    static double steuerfreibetrag;
    static boolean kirchenzugehoerigkeit;
    static double kirchensteuer;
    static double steuersatz;
    static double krankenversicherung;
    static double arbeitslosenversicherung;
    static double pflegeversicherung;
    static double rentenversicherung;
    static int steuerklasse;
    static double nettoGehalt;

    static final double DEFAULT_STEUERSATZ = 0.20;
    static final double STEUERSATZ_STEUERKLASSE_1 = 0.3;
    static final double STEUERSATZ_STEUERKLASSE_2 = 0.25;
    static final double STEUERSATZ_STEUERKLASSE_3 = 0.15;
    static final double STEUERSATZ_STEUERKLASSE_4 = 0.20;
    static final double STEUERSATZ_STEUERKLASSE_5 = 0.25;

    static final double KRANKENVERSICHERUNGSSATZ = 0.075;
    static final double ARBEITSLOSENVERSICHERUNGSSATZ = 0.02;
    static final double PFLEGEVERSICHERUNGSSATZ = 0.0015;
    static final double RENTENVERSICHERUNGSSATZ = 0.018;

    static final double FREIBETRAG_PRO_KIND = 2000;

    static final double GRUND_STEUERFREIBETRAG = 10000;

    public static void main(String[] args) {
        inputBrutto();
        calculateSteuerfreibetrag();
        calculateKirchensteuer();
        calculateKrankenversicherung();
        calculatePflegeversicherung();
        calculateArbeitslosenversicherung();
        calculateRentenversicherung();
        calculateSteuer();
        calculateNettogehalt();
        ausgabeErgebnisse();
        scanner.close();
    }

    public static double calculateNettogehalt() {
        nettoGehalt = bruttoGehalt - (berechneSteuer + kirchensteuer + rentenversicherung + krankenversicherung + pflegeversicherung + arbeitslosenversicherung);
        return nettoGehalt;
    }

    public static void ausgabeErgebnisse() {
        System.out.println("Das Nettogehalt beträgt: " + nettoGehalt);
        System.out.println("Sozialabgaben: " +
                " Krankenversicherung: " + krankenversicherung +
                " Pflegeversicherung: " + pflegeversicherung +
                " Arbeitslosenversicherung: " + arbeitslosenversicherung +
                " Rentenversicherung: " + rentenversicherung);
        System.out.print("Ihr Steuerfreibetrag beträgt: " + steuerfreibetrag +
                " Sie bezahlen " + berechneSteuer + " Steuern." +
                " Sie bezahlen " + kirchensteuer + " Kirchensteuer");
    }

    public static double inputBrutto() {
        System.out.print("Geben Sie Ihr jährliches Bruttogehalt ein: ");
        bruttoGehalt = scanner.nextDouble();
        return bruttoGehalt;
    }

    public static int steuerklasse() {
        System.out.print("Geben Sie Ihre Steuerklasse ein (1-6): ");
        steuerklasse = scanner.nextInt();
        return steuerklasse;
    }

    public static double calculateSteuerfreibetrag() {
        System.out.print("Wie viele Kinder haben Sie?: ");
        int anzahlKinder = scanner.nextInt();
        steuerfreibetrag = GRUND_STEUERFREIBETRAG + (anzahlKinder * FREIBETRAG_PRO_KIND);
        return steuerfreibetrag;
    }

    public static double zuVersteuerndesEinkommen() {
        zuVersteuerndesEinkommen = bruttoGehalt - steuerfreibetrag;
        return zuVersteuerndesEinkommen;
    }

    public static boolean kirchzugehoerigkeit() {
        System.out.print("Gehören Sie einer Kirche an? (ja/nein): ");
        String kirchenzugehoerigkeitAntwort = scanner.next().toLowerCase();
        kirchenzugehoerigkeit = kirchenzugehoerigkeitAntwort.equals("ja");
        return kirchenzugehoerigkeit;
    }

    public static double calculateKirchensteuer() {
        kirchensteuer = 0;
        if (kirchzugehoerigkeit()) {
            double kirchensteuerSatz = 0.008;
            kirchensteuer = zuVersteuerndesEinkommen() * kirchensteuerSatz;
        }
        return kirchensteuer;
    }

    public static double calculateKrankenversicherung() {
        krankenversicherung = bruttoGehalt * KRANKENVERSICHERUNGSSATZ;
        return krankenversicherung;
    }

    public static double calculateArbeitslosenversicherung() {
        arbeitslosenversicherung = bruttoGehalt * ARBEITSLOSENVERSICHERUNGSSATZ;
        return arbeitslosenversicherung;
    }

    public static double calculatePflegeversicherung() {
        pflegeversicherung = bruttoGehalt * PFLEGEVERSICHERUNGSSATZ;
        return pflegeversicherung;
    }

    public static double calculateRentenversicherung() {
        rentenversicherung = bruttoGehalt * RENTENVERSICHERUNGSSATZ;
        return rentenversicherung;
    }

    public static double setzeSteuerklasse() {
        steuersatz = DEFAULT_STEUERSATZ;

        switch (steuerklasse()) {
            case 1:
                steuersatz = STEUERSATZ_STEUERKLASSE_1;
                break;
            case 2:
                steuersatz = STEUERSATZ_STEUERKLASSE_2;
                break;
            case 3:
                steuersatz = STEUERSATZ_STEUERKLASSE_3;
                break;
            case 4:
                steuersatz = STEUERSATZ_STEUERKLASSE_4;
                break;
            case 5:
                steuersatz = STEUERSATZ_STEUERKLASSE_5;
                break;
            default:
                steuersatz = DEFAULT_STEUERSATZ;
        }
        return steuersatz;
    }

    public static double calculateSteuer() {
        berechneSteuer = zuVersteuerndesEinkommen() * setzeSteuerklasse();
        return berechneSteuer;
    }
}
