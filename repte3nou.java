import java.util.*;

public class repte3nou {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcio = 0, hotels_long = 0, habitacions_long = 0, indice = 0;
        String[] hotels = null;
        String[] habitacions = null;
        int[] habitacions_per_hotel = null;

        do {
            System.out.println("==BENVINGUT A LA GESTIO DE HOTELS==");
            System.out.println("1.Registrar hotel");
            System.out.println("2.Buscar habitacions lliures");
            System.out.println("3.Mostra hotels i habitacions");
            System.out.println("4.Check-in client");
            System.out.println("5.Check-out client");
            System.out.println("===================================");
            opcio = entrada.nextInt();
            switch (opcio) {

                case 1: // agafem num hotel i habitacions
                    System.out.println("Quants hotels vols registrar?");
                    hotels_long = entrada.nextInt();
                    hotels = new String[hotels_long];
                    habitacions_per_hotel = new int[hotels_long];
                    habitacions = registrar(hotels, entrada, habitacions_long, habitacions_per_hotel, indice,
                            habitacions);
                    break;
                case 2: // busqueda de hab lliure
                    cerca_hab(habitacions, habitacions_per_hotel, hotels, entrada);
                    break;

                case 3: // mostra els hotels amb les seves habitacions
                    mostrar_hotels(habitacions, habitacions_per_hotel, hotels);
                    break;
                case 4: // check-in usuari

                    break;
                case 5: // check-out del usuari
                    break;
                default:
                    break;
            }
        } while (opcio != 5);

    }

    public static String[] registrar(String[] hotels, Scanner entrada, int habitacions_long,
            int[] habitacions_per_hotel, int indice, String[] habitacions) {
        for (int i = 0; i < hotels.length; i++) {
            System.out.println("Digues el nom del hotel" + (i + 1) + ":");
            hotels[i] = entrada.next();
            System.out.println("Quantes habitacions te aquest hotel?");
            habitacions_per_hotel[i] = entrada.nextInt();
        }
        for (int j = 0; j < habitacions_per_hotel.length; j++) {
            habitacions_long += habitacions_per_hotel[j];
        }
        habitacions = new String[habitacions_long];
        return habitacions;
    }

    public static void cerca_hab(String[] habitacions, int[] habitacions_per_hotel, String[] hotels, Scanner x) {
        int index_h = 0;
        String hotel_busc;
        System.out.println("Donem el hotel");
        hotel_busc = x.next();
        int j = 0, i = 0, inicio, fin;
        do {
            if (hotels[j].equalsIgnoreCase(hotel_busc)) {
                index_h = j;
            }
            j++;

            inicio = inici_cal(index_h, habitacions_per_hotel);
            fin = calcularFin(index_h, habitacions_per_hotel);

            if (habitacions[i] == null) {
                System.out.println("Habitacio" + (i + 1) + ":" + " esta lliure");
            } else {
                System.out.println("Habitacio ocupada");
            }
            i++;
        } while (j < hotels.length && i <= fin);

      
    }
    public static void mostrar_hotels (String[] habitacions, int[] habitacions_per_hotel, String[] hotels){
   
        for (int i = 0; i < hotels.length; i++) {
        System.out.println((i + 1) + ". " + hotels[i] + 
                         " - " + habitacions_per_hotel[i] + " habitacions");
    }


       
    }
    public static int inici_cal(int index_h, int[] habitacions_per_hotel) {
        int inicio = 0;
        for (int i = 0; i < index_h; i++) {
            inicio += habitacions_per_hotel[i];
        }

        return inicio;
    }

    public static int calcularFin(int index_h, int[] habPorHotel) {
        int inici = inici_cal(index_h, habPorHotel);
        int fin = inici + habPorHotel[index_h] - 1;
        return fin;
    }


}