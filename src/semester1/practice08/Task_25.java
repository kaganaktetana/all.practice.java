package semester1.practice08;

public class Task_25 {
    public static void main(String[] args) {
        DotaHero hero = new DotaHero(
                "Invoker", "Універсальний", 200
        );

        StrengthHero strengthHero = new StrengthHero(
                "Axe", "Сила", 200, 25
        );

        AlchemistHero alchemist = new AlchemistHero(
                "Alchemist", "Сила", 200, 30, 250
        );

        System.out.println(hero);
        System.out.println();

        System.out.println(strengthHero);
        System.out.println();

        System.out.println(alchemist);
        System.out.println(alchemist.chemicalRage());
    }
}

class DotaHero {
    private String name;
    private String primaryAttribute;
    private int baseHp;

    public DotaHero(String name, String primaryAttribute, int baseHp) {
        this.name = name;
        this.primaryAttribute = primaryAttribute;
        this.baseHp = baseHp;
    }

    public int getMaxHp() {
        return baseHp;
    }

    public String getName() {
        return name;
    }

    public String getPrimaryAttribute() {
        return primaryAttribute;
    }

    public int getBaseHp() {
        return baseHp;
    }

    @Override
    public String toString() {
        return "Герой: " + name
                + ", основний атрибут: " + primaryAttribute
                + ", базове HP: " + baseHp;
    }
}

class StrengthHero extends DotaHero {
    private int strength;

    public StrengthHero(String name, String primaryAttribute,
                        int baseHp, int strength) {
        super(name, primaryAttribute, baseHp);

        this.strength = strength;
    }

    @Override
    public int getMaxHp() {
        return super.getMaxHp() + strength * 22;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", сила: " + strength
                + ", максимальне HP: " + getMaxHp();
    }
}

class AlchemistHero extends StrengthHero {
    private int greevilsGreedBonusGold;

    public AlchemistHero(String name, String primaryAttribute,
                         int baseHp, int strength,
                         int greevilsGreedBonusGold) {
        super(name, primaryAttribute, baseHp, strength);

        this.greevilsGreedBonusGold = greevilsGreedBonusGold;
    }

    public String chemicalRage() {
        return getName() + " активує Chemical Rage!";
    }

    @Override
    public String toString() {
        return super.toString()
                + ", бонус золота Greevil's Greed: "
                + greevilsGreedBonusGold;
    }
}