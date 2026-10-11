import java.time.LocalDate;

public class CuentaDebito {
    // Débito no necesariamente deben tener saldo positivo en todo momento (pueden llegar a $0), pero NUNCA saldo negativo

    // Atributos
    private double saldo;
    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;
    private double porcentajeInteres;

    //Métodos
    // Constructor
    public CuentaDebito(double saldo, LocalDate fechaEmision, LocalDate fechaVencimiento, double porcentajeInteres) {
        this.saldo = saldo;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.porcentajeInteres = porcentajeInteres;
    }

    // Validación de la regla de saldo mínimo
    public static boolean saldoValido(double saldo) {
        return saldo >= 0;
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
    public boolean equals(CuentaDebito cuenta) {
        return this.saldo == cuenta.saldo && this.fechaEmision.equals(cuenta.fechaEmision) && this.fechaVencimiento.equals(cuenta.fechaVencimiento) && this.porcentajeInteres == cuenta.porcentajeInteres;
    }

    // toString()
    @Override
    public String toString() {
        return "Cuenta de débito" + "\nSaldo: $" + saldo + "\nFecha de emisión: " + fechaEmision + "\nFecha de vencimiento: " + fechaVencimiento + "\nPorcentaje de interés: " + porcentajeInteres + "%";
    }

    // Vencimiento: bloquea transacciones si la cuenta ya venció
    public boolean estaVencida() {
        return !fechaVencimiento.isAfter(LocalDate.now());
    }

    // Transacciones
    public void pagar(double monto) {
        if (estaVencida()) {
            System.out.println("Transacción bloqueada: la cuenta está vencida.");
        } else if (saldo - monto < 0) {
            System.out.println("Pago rechazado: el saldo restante no puede quedar en negativo.");
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
