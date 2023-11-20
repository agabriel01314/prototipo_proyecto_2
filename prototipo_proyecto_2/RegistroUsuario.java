import java.io.*;
import java.util.*;

/**
 * Representa el registro del usuario.
 */
class RegistroUsuario {

    // declarar variable para el csv
    private static final String users_csv = "usuarios.csv";
    // array para los users 
    private ArrayList<Usuario> usuarios;

    // agregar al registro 
    public RegistroUsuario(){
        usuarios = new ArrayList<>();
        loadUsuarios();
    }

    // cargar los usuarios
    private void loadUsuarios(){
        try( BufferedReader br = new BufferedReader(new FileReader(users_csv) )){
            String line;

            while( (line = br.readLine()) != null){
                // separar datos por comas 
                String[] datos = line.split(",");

                // para los datos de cada usuario regisgtrado 
                if (datos.length == 3) {
                    String nombreUsuario = datos[0 ];
                    String contra = datos[1 ];
                    String tipoUsuario =  datos[2];
                    usuarios.add(new Usuario( nombreUsuario, contra, tipoUsuario) );
                }

            }
        } 
        catch ( IOException e){
            System.out.println("Error al leer el archivo csv con los datos de los usuarios: " + e.getMessage());
        }
        
    }

    // guardar los users en el csv
    private void guardarUser( Usuario usuario) throws IOException{
        
        // guardar separando por comas
        try (FileWriter filewrite = new FileWriter(users_csv, true );
             BufferedWriter bufer = new BufferedWriter(filewrite)){
            String usuarioCSV = usuario.getNombreUsuario() + "," + usuario.getContrasena() + "," + usuario.getTipoUsuario();
            
            bufer.write(usuarioCSV);
            bufer.newLine();
        } 
        catch ( IOException e ){
            System.out.println("Error al editar archivo csv de usuarios " + e.getMessage());
            
            throw e; //  el error
        }
    }

    // verificar que el nombre de usuario y la contraseña coincidan por lo ingresado por el usuario 
    public boolean verifyInicioSesion( String nombreUsuario , String contra){
        // for recorriendo los usuarios
        for(Usuario usuario : usuarios){
            // si coincide con alguno del arraylist
            if (usuario.getNombreUsuario().equals(nombreUsuario)  && usuario.getContrasena().equals(contra) ){
                return true;
            }
        }

        return false;
    }

    // para registrar nuevo user 
    public void registrarNuevoUsuario( String nombreUsuario , String contra , String tipoUsuario)  throws IOException{
        Usuario nuevoUsuario = new Usuario(nombreUsuario, contra, tipoUsuario);
        // añadir el usuario a los usuarios
        usuarios.add(nuevoUsuario);
        guardarUser(nuevoUsuario);
    }
}
