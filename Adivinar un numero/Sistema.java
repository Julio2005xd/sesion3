import java.util.Scanner;
import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Jugador jugador = new Jugador();

        System.out.println("Juego de adivinar un número");
        System.out.println("Por favor, digite el nombre del jugador:");
        String nombre = sc.nextLine(); 
        jugador.setNombre(nombre);

        Juego juego = new Juego(jugador);  
        char Continuar;

        do {
            juego.iniciarJuego();
            System.out.println("¿Deseas seguir jugando " + jugador.getNombre() + "? (S/N)(s/n)");
            Continuar = sc.next().charAt(0);
        } while (Continuar == 's' || Continuar == 'S');

        System.out.println("Gracias por jugar, " + jugador.getNombre() + ".");
        sc.close();
    }
}


