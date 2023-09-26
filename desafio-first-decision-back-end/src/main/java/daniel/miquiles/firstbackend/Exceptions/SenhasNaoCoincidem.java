package daniel.miquiles.firstbackend.Exceptions;

public class SenhasNaoCoincidem extends RuntimeException{

    public SenhasNaoCoincidem() {
        super("Senha e Confirmação devem ser iguais");
    }
    
}