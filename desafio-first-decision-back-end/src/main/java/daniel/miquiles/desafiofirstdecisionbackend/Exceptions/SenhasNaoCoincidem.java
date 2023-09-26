package daniel.miquiles.desafiofirstdecisionbackend.Exceptions;

public class SenhasNaoCoincidem extends RuntimeException{

    public SenhasNaoCoincidem() {
        super("Senha e Confirmação devem ser iguais");
    }
    
}