import java.util.ArrayList;
import java.util.Scanner;

public class SistemaReservaHotel {
    private ArrayList<Quarto> quartos = new ArrayList<>();
    private ArrayList<Reserva> reservas = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public SistemaReservaHotel() {
        for (int i = 1; i <= 10; i++) {
            quartos.add(new Quarto(i));
        }
    }

    public void listarQuartosDisponiveis() {
        System.out.println("Quartos disponíveis: ");
        for (Quarto quarto : quartos) {
            if (quarto.isDisponivel()) {
                System.out.println("Quarto número: " + quarto.getNumero());
            }
        }
    }

    public void reservarQuarto() {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf);

        listarQuartosDisponiveis();
        System.out.print("Digite o número do quarto para reserva: ");
        int numeroQuarto = scanner.nextInt();
        scanner.nextLine();

        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numeroQuarto && quarto.isDisponivel()) {
                Reserva reserva = new Reserva(cliente, quarto);
                reservas.add(reserva);
                System.out.println("Reserva feita com sucesso para o cliente " + cliente.getNome());
                return;
            }
        }
        System.out.println("Quarto indisponível ou número inválido.");
    }
    public void cancelarReserva() {
        System.out.print("Digite o CPF do cliente para cancelar a reserva");
        String cpf = scanner.nextLine();

        for (Reserva reserva : reservas) {
            if (reserva.getCliente().getCpf().equals(cpf)) {
                reserva.getQuarto().liberar();
                reservas.remove(reserva);
                System.out.println("Reserva cancelada com sucesso.");
                return;
            }
        }
        System.out.println("Reserva não encontrada.");
    }
    public static void main(String[] args) {
        SistemaReservaHotel sistema = new SistemaReservaHotel();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSistema de Reserva de Hotel");
            System.out.println("1. Listar quartos disponíveis");
            System.out.println("2. Reservar quarto");
            System.out.println("3. Cancelar reserva");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    sistema.listarQuartosDisponiveis();
                    break;
                case 2:
                    sistema.reservarQuarto();
                    break;
                case 3:
                    sistema.cancelarReserva();
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
