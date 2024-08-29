import java.util.InputMismatchException;
import java.util.Scanner;

public class Juego {
    private Jugador jugador; 

    public Juego(Jugador jugador) {
        this.jugador = jugador;
    }

    public void iniciarJuego() {
        Scanner sc = new Scanner(System.in);
        int NumeroSecreto;
        int Intentos = 0;
        boolean Ganar = false;
        int RangoInferior = 0;
        int RangoSuperior = 0;

        try {
            System.out.println("Hola, " + jugador.getNombre() + "! Por favor, digite el rango de números con los que desea jugar.");
            
            do {
                System.out.println("Desde: ");
                RangoInferior = sc.nextInt();
                System.out.println("Hasta: ");
                RangoSuperior = sc.nextInt();
                
                if (RangoInferior >= RangoSuperior) {
                    System.out.println("El rango superior debe ser mayor que el rango inferior. Por favor, inténtalo de nuevo.");
                }
            } while (RangoInferior >= RangoSuperior);

            System.out.println("Por favor digite el número de intentos que desea tener en el juego");
            while (Intentos <= 0) {
                try {
                    Intentos = sc.nextInt();
                    if (Intentos <= 0) {
                        System.out.println("El número de intentos debe ser mayor a cero. Inténtalo de nuevo.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada no válida. Por favor, introduce un número entero.");
                    sc.next(); 
                }
            }
            
            NumeroSecreto = (int) (Math.random() * (RangoSuperior - RangoInferior + 1)) + RangoInferior;
            System.out.println("Escogeré un número entre " + RangoInferior + " y " + RangoSuperior + ". Tienes " + Intentos + " intentos para adivinarlo. ¡A jugar!");

            while (Intentos > 0 && !Ganar) {
                System.out.println("Introduce tu número:");
                int Numero = sc.nextInt();
                if (NumeroSecreto > Numero) {
                    System.out.println("El número que pienso es mayor.");
                } else if (NumeroSecreto < Numero) {
                    System.out.println("El número que pienso es menor.");
                } else {
                    System.out.println("¡Acertaste " + jugador.getNombre() + "! El número que pensé es: " + NumeroSecreto);
                    Ganar = true;
                }
                Intentos--;
            }

            if (!Ganar) {
                System.out.println("Se te acabaron los intentos, " + jugador.getNombre() + ". El número en el que pensaba era el: " + NumeroSecreto);
            }

        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida. Por favor, intenta de nuevo.");
            sc.next();
        }
    }
}

