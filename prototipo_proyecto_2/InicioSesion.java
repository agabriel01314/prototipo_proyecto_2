import java.util.Scanner;
import java.io.*;

/**
 * Clase que representa el inicio de sesión.
 */
class InicioSesion {

    private RegistroUsuario registro;

    public InicioSesion( RegistroUsuario registro ){
        this.registro = registro;
    }

    public boolean  iniciarSesion(){

        Scanner scan = new Scanner(System.in);

        System.out.print("\nIngrese el nombre de usuario: ");
        String nombreUsuario = scan.nextLine();
        System.out.print("Ingrese la contraseña: ") ;
        String contrasena = scan.nextLine();

        //  para comprobar el user y la contraseña
        if (registro.verifyInicioSesion( nombreUsuario , contrasena) ){

            System.out.println("Se ha iniciado sesión");
            return true;

        } 
        else{

            System.out.println("El nombre de usuario o la contraseña son incorrectos.");
            return false;
        }
    }

    // registrar al usuario ----------
    public void registrarUser(){
        Scanner scan = new Scanner(System.in);
        System.out.print("\nIngrese su nombre de usuario para el registro: ");
        String nombreUsuario = scan.nextLine();
        System.out.print( "Ingrese su contraseña para el registro: ") ;
        String contrasena = scan.nextLine();
        System.out.print("Ingrese su tipo de usuario (admin/usuario): ");
        String  tipoUsuario  = scan.nextLine();

        // try and catch para el registro del nuevo user 
        try{
            registro.registrarNuevoUsuario(nombreUsuario ,  contrasena   , tipoUsuario );
            System.out.println( "El usuario se ha registrado");

        } 
        catch (IOException e){
            System.out.println("Error al registrar el usuario: " +  e.getMessage());
        }
    }
}
