import static java.lang.IO.*;

void main() {

    String cpf = readln("Digite o CPF: ");

    // Remove pontos e traço
    cpf = cpf.replace(".", "").replace("-", "");

    if (cpf.length() != 11) {
        println("CPF invalido!");
        return;
    }

    // Verifica se todos os números são iguais (tipo 11111111111)
    boolean iguais = true;
    for (int i = 1; i < 11; i++) {
        if (cpf.charAt(i) != cpf.charAt(0)) {
            iguais = false;
            break;
        }
    }
    if (iguais) {
        println("CPF invalido!");
        return;
    }

    //Cálculo do 1º dígito
    int soma = 0;
    for (int i = 0; i < 9; i++) {
        soma += (cpf.charAt(i) - '0') * (10 - i);
    }

    int dig1 = 11 - (soma % 11);
    if (dig1 >= 10) dig1 = 0;

    //Cálculo do 2º dígito
    soma = 0;
    for (int i = 0; i < 10; i++) {
        soma += (cpf.charAt(i) - '0') * (11 - i);
    }

    int dig2 = 11 - (soma % 11);
    if (dig2 >= 10) dig2 = 0;

    //Verificação final
    if (dig1 == (cpf.charAt(9) - '0') && dig2 == (cpf.charAt(10) - '0')) {
        println("CPF valido!");
    } else {
        println("CPF invalido!");
    }
}