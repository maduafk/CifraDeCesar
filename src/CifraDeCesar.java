import java.util.Scanner;

public class CifraDeCesar {

    // A chave de criptografia está pré-definida pelo número 3.
    private static final int CHAVE = 3;

    public static String criptografar(String mensagem) {
        StringBuilder mensagemCriptografada = new StringBuilder();
        for (int i = 0; i < mensagem.length(); i++) {
            char caractere = mensagem.charAt(i);
            if (Character.isLetter(caractere)) {
                char inicioAlfabeto = Character.isLowerCase(caractere) ? 'a' : 'A';
                char novoCaractere = (char) (((caractere - inicioAlfabeto + CHAVE) % 26) + inicioAlfabeto);
                mensagemCriptografada.append(novoCaractere);
            } else if (Character.isDigit(caractere)) {
                char novoCaractere = (char) (((caractere - '0' + CHAVE) % 10) + '0');
                mensagemCriptografada.append(novoCaractere);
            } else {
                mensagemCriptografada.append(caractere);
            }
        }
        return mensagemCriptografada.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Digite a mensagem a ser criptografada:");
            String mensagem = scanner.nextLine();

            String mensagemCriptografada = criptografar(mensagem);

            System.out.println("Mensagem criptografada: " + mensagemCriptografada);

            System.out.println("Deseja continuar? (sim/não)");
            String resposta = scanner.nextLine();

            if (!resposta.equalsIgnoreCase("sim")) {
                continuar = false; // Termina o loop se a resposta não for = sim
            }
        }

        scanner.close();
    }
}
