package exceptions;

public class SemSaldoException extends Exception {
    public SemSaldoException() {
        System.out.println("Seu saldo é insuficiente para realizar essa compra.");
    }
}