package controladores;


public class Inicio {

    private boolean modoSeguro;

    public void ValidadorPassword() {
        this.modoSeguro = true;
    }

    /**
     * Verifica si una contraseña cumple con la longitud mínima.
     * @param pass La contraseña a verificar
     * @return Un mensaje indicando el resultado
     */
    public String verificarLongitud(String pass) {
        if (pass == null) {
            return "Error: Nulo"; 
        }
        
        if (pass.length() >= 8) {           
            return "Válido"; 
        } else {
          return "Falla";
        }
    }
    /** * Configura el comportamiento del validador. 
    * Actúa como un interruptor de encendido/apagado. 
    * * @param activo Si es true, activa la seguridad máxima.
    * Si es false, desactiva las restricciones. 
    */
    public void setModoSeguro(boolean activo) {
        this.modoSeguro = activo;
    }
    /**
    * Consulta el estado actual del validador. 
    * Nos permite saber si el "interruptor" de seguridad está encendido o apagado. 
    * * @return true si el modo seguro está activado, false si está desactivado. 
    */
    public boolean esModoSeguro() {
        return modoSeguro;
    }
}
