import java.util.*;

public class repte3 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String[] hotels = { "Hotel1", "Hotel2", "Hotel3", "Hotel4", "Hotel5", "Hotel6", "Hotel7", "Hotel8",
                "Hotel9", "Hotel10", "Hotel11", "Hotel12", "Hotel13", "Hotel14", "Hotel15" };
        String[][] habitacions = new String[15][10];
        int opcio, habitacio;
        String hotel, nom_client;
        System.out.println("----Benvingut a la gestio de hotels----");

        System.out.printf("Que vols fer %n1.check-in%n2.check-out%n3.Sortir%n");
        opcio = entrada.nextInt();
        while (opcio != 3) {

            switch (opcio) {
                case 1:
                    System.out.println("Donem el teu nom");
                    nom_client = entrada.next();
                    System.out.println("Diguem el hotel per fer la reserva");
                    hotel = entrada.next();
                    check_in(hotel, nom_client, hotels, entrada, habitacions, nom_client);
                    break;
                case 2:
                    System.out.println("Donem el teu nom");
                    nom_client = entrada.next();
                    System.out.println("Diguem el hotel per fer el checkout");
                    hotel = entrada.next();
                    check_out(nom_client, hotel, hotels, habitacions);
                    break;
                default:
                    break;
            }
            System.out.printf("Que vols fer %n1.check-in%n2.check-out%n3.Sortir%n");
            opcio = entrada.nextInt();
        }

    }

    public static void check_in(String hotel, String client, String[] hotels, Scanner entrada, String[][] habitacions,
            String nom_client) {

        int index_hotel = index_hotel(hotel, hotels);
        if (index_hotel != -1) {
            for (int i = 0; i < hotels.length; i++) {
                if (habitacions[index_hotel][i] == null) {
                    habitacions[index_hotel][i] = nom_client;

                    break;
                }
            }
            for (int i = 0; i < habitacions[index_hotel].length; i++) {
                if (habitacions[index_hotel][i] != null) {
                    System.out.println(habitacions[index_hotel][i]);
                }
            }

        }

    }

    public static int index_hotel(String hotel, String[] hotels) {
        int index_hotel = -1;

        for (int i = 0; i < hotels.length; i++) {
            if (hotels[i].equalsIgnoreCase(hotel)) {
                index_hotel = i;

            }

        }
        return index_hotel;
    }

    public static void check_out(String nom_client, String hotel, String[] hotels, String[][] habitacions) {
        int index_hotel = index_hotel(hotel, hotels);
        if (index_hotel != -1) {
            for (int i = 0; i < hotels.length; i++) {
                if (habitacions[index_hotel][i].equalsIgnoreCase(nom_client)) {
                    habitacions[index_hotel][i] = null;

                    break;
                }
            }
        }
        for (int i = 0; i < habitacions[index_hotel].length; i++) {
                if (habitacions[index_hotel][i] != null) {
                    System.out.println(habitacions[index_hotel][i]);
                }
            }
    }
}