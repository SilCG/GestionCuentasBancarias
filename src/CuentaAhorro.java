import java.time.LocalDate;

public class CuentaAhorro {
    // Ahorro: las cuentas de ahorro tienen que tener en todo momento, incluido el momento de su creación, al menos $100 de saldo

    // Atributos
    private double saldo;
    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;
    private double porcentajeInteres;

    //Métodos
    // Constructor
    public CuentaAhorro (double saldo, LocalDate fechaEmision, LocalDate fechaVencimiento, double porcentajeInteres){
        this.saldo = saldo;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.porcentajeInteres = porcentajeInteres;
    }

    // Validación de la regla de saldo mínimo
    public static boolean saldoValido(double saldo) {
        return saldo >= 100;
    }

    // Getters
    public double getSaldo() {
        return saldo;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public double getPorcentajeInteres() {
        return porcentajeInteres;
    }

    // Setters
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setPorcentajeInteres(double porcentajeInteres) {
        this.porcentajeInteres = porcentajeInteres;
    }

    // equals()
    public boolean equals(CuentaAhorro cuenta) {
        return this.saldo == cuenta.saldo && this.fechaEmision.equals(cuenta.fechaEmision) && this.fechaVencimiento.equals(cuenta.fechaVencimiento) && this.porcentajeInteres == cuenta.porcentajeInteres;
    }

    // toString()
    @Override
    public String toString() {
        return "Cuenta de ahorro" + "\nSaldo: $" + saldo + "\nFecha de emisión: " + fechaEmision + "\nFecha de vencimiento: " + fechaVencimiento + "\nPorcentaje de interés: " + porcentajeInteres + "%";
    }

    // Vencimiento: bloquea transacciones si la cuenta ya venció
    public boolean estaVencida() {
        return !fechaVencimiento.isAfter(LocalDate.now());
    }

    // Transacciones
    public void pagar(double monto) {
        if (estaVencida()) {
            System.out.println("Transacción bloqueada: la cuenta está vencida.");
        } else if (saldo - monto < 100) {
            System.out.println("Pago rechazado: el saldo restante no puede ser menor de $100.");
        } else {
            saldo -= monto;
            System.out.println("Pago realizado. Saldo actual: $" + saldo);
        }
    }

    public void depositar(double monto) {
        if (estaVencida()) {
            System.out.println("Transacción bloqueada: la cuenta está vencida.");
        } else {
            saldo += monto;
            System.out.println("Depósito realizado. Saldo actual: $" + saldo);
        }
    }

    // Intereses
    public void generarIntereses() {
        saldo += saldo * porcentajeInteres / 100;
    }
}
