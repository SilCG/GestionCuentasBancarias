public class Administrador {

    // Atributos
    private String nombreCompleto;
    private String cedula;
    private String correoElectronico;
    private String contrasenia;

    // Métodos
    // Constructor
    public Administrador (String nombreCompleto, String cedula, String correoElectronico, String contrasenia){
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
    }

    // Getters
    public String getNombreCompleto(){
        return nombreCompleto;
    }

    public String getCedula() {
        return cedula;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    // Setters
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    // equals()
    public boolean equals(Administrador administrador){
        return this.cedula.equals(administrador.cedula);
    }

    // toString()
    @Override
    public String toString(){
        return "Nombre completo: " + nombreCompleto + "\nCédula: " + cedula + "\nCorreo electrónico: " + correoElectronico;
    }
}
