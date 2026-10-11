import java.util.ArrayList;

public class Cliente {

    // Atributos
    private String nombreCompleto;
    private String cedula;
    private char sexo;
    private String correoElectronico;
    private String profesion;
    private String direccion;
    private String contrasenia;
    private ArrayList<CuentaAhorro> cuentaAhorro;
    private ArrayList<CuentaDebito> cuentaDebito;
    private ArrayList<CuentaCredito> cuentaCredito;

    // Métodos
    // Constructor
    public Cliente (String nombreCompleto, String cedula, char sexo, String correoElectronico, String profesion, String direccion, String contrasenia){
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.sexo = sexo;
        this.correoElectronico = correoElectronico;
        this.profesion = profesion;
        this.direccion = direccion;
        this.contrasenia = contrasenia;
        this.cuentaAhorro = new ArrayList<>();
        this.cuentaDebito = new ArrayList<>();
        this.cuentaCredito = new ArrayList<>();
    }

    // Getters
    public String getNombreCompleto(){
        return nombreCompleto;
    }

    public String getCedula() {
        return cedula;
    }

    public char getSexo() {
        return sexo;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getProfesion() {
        return profesion;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public ArrayList<CuentaAhorro> getCuentasAhorro() {
        return cuentaAhorro;
    }

    public ArrayList<CuentaDebito> getCuentasDebito() {
        return cuentaDebito;
    }

    public ArrayList<CuentaCredito> getCuentasCredito() {
        return cuentaCredito;
    }

    // Setters
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    // equals()
    public boolean equals(Cliente cliente){
        return this.cedula.equals(cliente.cedula);
    }

    // toString()
    @Override
    public String toString(){
        return "Nombre completo: " + nombreCompleto + "\nCédula: " + cedula + "\nSexo: " + sexo + "\nCorreo electrónico: " + correoElectronico + "\nProfesión: " + profesion + "\nDirección: " + direccion;
    }

    // Relaciones: agregar cuentas
    public void agregarCuentaAhorro(CuentaAhorro cuenta) {
        this.cuentaAhorro.add(cuenta);
    }

    public void agregarCuentaDebito(CuentaDebito cuenta) {
        this.cuentaDebito.add(cuenta);
    }

    public void agregarCuentaCredito(CuentaCredito cuenta) {
        this.cuentaCredito.add(cuenta);
    }
}
