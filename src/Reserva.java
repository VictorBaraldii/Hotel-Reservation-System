public class Reserva {
    private Cliente cliente;
    private Quarto quarto;

    public Reserva(Cliente cliente, Quarto quarto) {
        this.cliente = cliente;
        this.quarto = quarto;
        quarto.reserva();
    }
    public Cliente getCliente() {
        return cliente;
    }

    public Quarto getQuarto() {
        return quarto;
    }
}
