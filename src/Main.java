import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        // 1. Administrador
        System.out.println("=== ADMINISTRADOR ===");
        Administrador admin = new Administrador("Carmen Venegas Jarquín", "102340472", "carmen@banco.com", "Admin123!");
        System.out.println(admin);
        admin.setCorreoElectronico("carmen.venegas@banco.com");
        System.out.println("Correo actualizado: " + admin.getCorreoElectronico());

        Administrador adminCopia = new Administrador("Marco Galdamuz Serrano", "102340472", "marco@banco.com", "Admin234!");
        System.out.println("¿Mismo administrador (por cédula)? " + admin.equals(adminCopia));

        // 2. Cliente
        System.out.println("\n=== CLIENTE ===");
        Cliente cliente = new Cliente("Ana Cristina Rivera", "112345678", 'F', "ana@correo.com", "Ingeniera", "Heredia", "Cliente123!");
        System.out.println(cliente);
        cliente.setProfesion("Arquitecta");
        System.out.println("Profesión actualizada: " + cliente.getProfesion());

        // 3. Cuenta de ahorro
        System.out.println("\n=== CUENTA DE AHORRO ===");
        double saldoInicialAhorro = 50;
        if (CuentaAhorro.saldoValido(saldoInicialAhorro)) {
            System.out.println("Cuenta creada.");
        } else {
            System.out.println("No es posible crear la cuenta: el saldo mínimo es $100.");
        }

        CuentaAhorro ahorro = new CuentaAhorro(500, LocalDate.of(2026, 1, 15), LocalDate.of(2030, 1, 15), 2);
        cliente.agregarCuentaAhorro(ahorro);
        System.out.println(ahorro);
        ahorro.depositar(200);        // saldo 700
        ahorro.pagar(100);            // saldo 600
        ahorro.pagar(550);            // rechazado: quedaría en $50
        ahorro.generarIntereses();    // 2% sobre 600
        System.out.println("Saldo tras intereses: $" + ahorro.getSaldo());

        // 4. Cuenta de débito
        System.out.println("\n=== CUENTA DE DÉBITO ===");
        CuentaDebito debito = new CuentaDebito(300, LocalDate.of(2026, 3, 1), LocalDate.of(2031, 3, 1), 1);
        cliente.agregarCuentaDebito(debito);
        System.out.println(debito);
        debito.depositar(100);        // saldo 400
        debito.pagar(400);            // saldo 0, permitido
        debito.pagar(10);             // rechazado: quedaría negativo

        // Cuenta de débito vencida para probar el bloqueo
        CuentaDebito debitoVencida = new CuentaDebito(100, LocalDate.of(2020, 1, 1), LocalDate.of(2025, 1, 1), 1);
        System.out.println("¿Vencida? " + debitoVencida.estaVencida());
        debitoVencida.pagar(10);      // bloqueada

        // 5. Cuenta de crédito
        System.out.println("\n=== CUENTA DE CRÉDITO ===");
        CuentaCredito credito = new CuentaCredito(LocalDate.of(2026, 5, 10), LocalDate.of(2031, 5, 10), 3, 1000, "Cashback");
        cliente.agregarCuentaCredito(credito);
        System.out.println(credito);  // saldo inicial $0
        credito.pagar(400);           // deuda 400
        credito.pagar(700);           // rechazado: superaría el límite
        credito.abonar(150);          // deuda 250
        credito.abonar(500);          // rechazado: quedaría negativa
        credito.generarIntereses();   // 3% sobre 250
        System.out.println("Deuda tras intereses: $" + credito.getSaldo());

        // 6. Relación Cliente - cuentas
        System.out.println("\n=== CUENTAS DEL CLIENTE ===");
        System.out.println("Cuentas de ahorro: " + cliente.getCuentasAhorro().size());
        System.out.println("Cuentas de débito: " + cliente.getCuentasDebito().size());
        System.out.println("Cuentas de crédito: " + cliente.getCuentasCredito().size());
    }
}