public class MyNewRepo {
    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon("Pikachu", 25, 100);

        System.out.println("Pokemon: " + pikachu.getName());
        System.out.println("Level: " + pikachu.getLevel());
        System.out.println("HP: " + pikachu.getHp());
        System.out.println(pikachu);
    }
}