package fabricaautomoveis.carros;

public enum Marca {
    VW(1), 
    FIAT(2), 
    CHEVROLET(3);
    
    private int id;
    
    private Marca(int id) {
        this.id = id;
    }
    
    public static Marca peloID(int id) {
        for (Marca c : Marca.values()) {
            if (c.id == id) {
                return c;
            }
        }
        throw new RuntimeException("Não existe franquia de id " + id);
    }
}
