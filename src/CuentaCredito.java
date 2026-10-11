import java.time.LocalDate;

public class CuentaCredito {
    // Crédito pueden tener saldo positivo o ser $0, pero NUNCA superar limiteCredito disponible (al momento de su creación).
    // Las cuentas de crédito siempre son creadas con un saldo inicial de $0.

    // Atributos
    private double saldo;
    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;
    private double porcentajeInteres;
    private double limiteCredito;
    private String tipo;

    //Métodos
    // Constructor
    public CuentaCredito(LocalDate fechaEmision, LocalDate fechaVencimiento, double porcentajeInteres, double limiteCredito, String tipo) {
        saldo = 0;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.porcentajeInteres = porcentajeInteres;
        this.limiteCredito = limiteCredito;
        this.tipo = tipo;
    }

    // Validación límite de crédito
    public static boolean limiteValido(double limiteCredito) {
        return limiteCredito > 0;
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

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public String getTipo() {
        return tipo;
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

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // equals()
    public boolean equals(CuentaCredito cuenta) {
        return this.saldo == cuenta.saldo && this.fechaEmision.equals(cuenta.fechaEmision) && this.fechaVencimiento.equals(cuenta.fechaVencimiento) && this.porcentajeInteres == cuenta.porcentajeInteres && this.limiteCredito == cuenta.limiteCredito && this.tipo.equals(cuenta.tipo);
    }

    // toString()
    @Override
    public String toString() {
            return "Cuenta de crédito" + "\nTipo: " + tipo + "\nSaldo (deuda): $" + saldo + "\nLímite de crédito: $" + limiteCredito + "\nFecha de emisión: " + fechaEmision + "\nFecha de vencimiento: " + fechaVencimiento + "\nPorcentaje de interés: " + porcentajeInteres + "%";
    }

    // Vencimiento: bloquea transacciones si la cuenta ya venció
    public boolean estaVencida() {
        return !fechaVencimiento.isAfter(LocalDate.now());
    }

    // Transacciones
    // Pago(compra): La deuda sube sin sobrepasar el límite de crédito
    public void pagar(double monto) {
        if (estaVencida()) {
            System.out.println("Transacción bloqueada: la cuenta está vencida.");
        } else if (saldo + monto > limiteCredito) {
            System.out.println("Pago rechazado: superaría el límite de crédito.");
        } else {
            saldo += monto;
            System.out.println("Pago realizado. Deuda actual: $" + saldo);
        }
    }

    // Abono: La deuda baja, sin quedar en números negativos
    public void abonar(double monto) {
        if (estaVencida()) {
            System.out.println("Transacción bloqueada: la cuenta está vencida.");
        } else if (saldo - monto < 0){
            System.out.println("Abono rechazado: La deuda no puede quedar negativa");
        } else{
            saldo -= monto;
            System.out.println("Abono realizado. Deuda actual: $" + saldo);
        }
    }

    // Intereses
    public void generarIntereses() {
        saldo += saldo * porcentajeInteres / 100;
    }


}



