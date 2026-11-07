package semester1.practice08;

public class Task_20 {
    public static void main(String[] args) {
        Weapon weapon = new Weapon("Звичайний меч", 50);

        EnchantedSword sword = new EnchantedSword(
                "Вогняний меч",
                50,
                "Вогонь",
                20,
                3
        );

        System.out.println(weapon);
        System.out.println();

        System.out.println(sword);
        System.out.println("Загальна шкода: "
                + sword.calculateDamage());
    }
}

class Weapon {
    private String title;
    private int baseDamage;

    public Weapon(String title, int baseDamage) {
        this.title = title;
        this.baseDamage = baseDamage;
    }

    public int calculateDamage() {
        return baseDamage;
    }

    public String getTitle() {
        return title;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    @Override
    public String toString() {
        return "Зброя: " + title
                + ", фізична шкода: " + baseDamage;
    }
}

class EnchantedSword extends Weapon {
    private String element;
    private int magicPower;
    private int enchantmentLevel;

    public EnchantedSword(String title, int baseDamage,
                          String element, int magicPower,
                          int enchantmentLevel) {
        super(title, baseDamage);

        this.element = element;
        this.magicPower = magicPower;
        this.enchantmentLevel = enchantmentLevel;
    }

    @Override
    public int calculateDamage() {
        return super.calculateDamage()
                + magicPower * enchantmentLevel;
    }

    @Override
    public String toString() {
        int physicalDamage = super.calculateDamage();
        int magicalDamage = magicPower * enchantmentLevel;

        return "Зачарований меч: " + getTitle()
                + "\nЕлемент: " + element
                + "\nФізична шкода: " + physicalDamage
                + "\nМагічна сила: " + magicPower
                + "\nРівень зачарування: " + enchantmentLevel
                + "\nМагічна шкода: " + magicalDamage
                + "\nЗагальна шкода: " + calculateDamage();
    }
}
