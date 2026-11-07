package semester1.practice08;

public class Task_39 {
    public static void main(String[] args) {

        CharacterUnit character = new CharacterUnit(
                "Warrior", 100, 100, 10
        );

        ShieldedPaladin paladin = new ShieldedPaladin(
                "Paladin", 150, 150, 15, 50
        );

        System.out.println("ЗВИЧАЙНИЙ ПЕРСОНАЖ:");
        System.out.println(character);

        character.takeDamage(30);

        System.out.println("\nПісля отримання шкоди:");
        System.out.println(character);

        System.out.println("\nПАЛАДИН:");
        System.out.println(paladin);

        paladin.takeDamage(30);

        System.out.println("\nПісля першої атаки:");
        System.out.println(paladin);

        paladin.takeDamage(50);

        System.out.println("\nПісля другої атаки:");
        System.out.println(paladin);
    }
}

class CharacterUnit {
    private String name;
    protected int hp;
    protected int maxHp;
    protected int armor;

    public CharacterUnit(String name, int hp,
                         int maxHp, int armor) {
        this.name = name;
        this.maxHp = Math.max(1, maxHp);
        this.hp = Math.max(0, Math.min(hp, this.maxHp));
        this.armor = Math.max(0, armor);
    }

    public void takeDamage(int rawDamage) {
        if (rawDamage <= 0 || hp <= 0) {
            return;
        }

        int damage = Math.max(1, rawDamage - armor);

        hp = Math.max(0, hp - damage);
    }

    public String getName() {
        return name;
    }

    protected String getHealthBar() {
        int totalBlocks = 10;

        int filledBlocks = (int) Math.round(
                (double) hp / maxHp * totalBlocks
        );

        filledBlocks = Math.max(0,
                Math.min(totalBlocks, filledBlocks));

        StringBuilder bar = new StringBuilder("[");

        for (int i = 0; i < totalBlocks; i++) {
            if (i < filledBlocks) {
                bar.append("█");
            } else {
                bar.append("░");
            }
        }

        bar.append("]");

        return bar.toString();
    }

    @Override
    public String toString() {
        return "Персонаж: " + name
                + "\nHP: " + hp + "/" + maxHp
                + "\nБроня: " + armor
                + "\nЗдоров'я: " + getHealthBar();
    }
}

class ShieldedPaladin extends CharacterUnit {
    private int shieldPoints;

    public ShieldedPaladin(String name, int hp,
                           int maxHp, int armor,
                           int shieldPoints) {
        super(name, hp, maxHp, armor);

        this.shieldPoints = Math.max(0, shieldPoints);
    }

    @Override
    public void takeDamage(int rawDamage) {
        if (rawDamage <= 0 || hp <= 0) {
            return;
        }

        if (shieldPoints >= rawDamage) {
            shieldPoints -= rawDamage;
            return;
        }

        int remainingDamage = rawDamage - shieldPoints;

        shieldPoints = 0;

        if (remainingDamage > 0) {
            super.takeDamage(remainingDamage);
        }
    }

    @Override
    public String toString() {
        return "=== МАГІЧНИЙ ПАЛАДИН ==="
                + "\nІм'я: " + getName()
                + "\nHP: " + hp + "/" + maxHp
                + "\nЗдоров'я: " + getHealthBar()
                + "\nБроня: " + armor
                + "\nМагічний щит: " + shieldPoints;
    }
}