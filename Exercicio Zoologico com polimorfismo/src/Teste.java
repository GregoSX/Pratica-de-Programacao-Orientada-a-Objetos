public class Teste {
    public static void main(String[] args) throws Exception {
        Animal animal = new Lobo("Fantasma", "branco");
        System.out.println(animal.getDescricaoLonga());

        animal = new Galinha("Josefina");
        System.out.println(animal.getDescricaoLonga());
    }
}
