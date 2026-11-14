package semester1.practice10;

interface CriticalStriker {
    double getCritMultiplier();
}

interface SelfRegenerating {
    int regenerateHp();
}

interface ShieldBearer {
    int absorbDamage(int incoming);
}

abstract class AbstractCombatUnit {
    private final String name;
    protected int hp;

    public AbstractCombatUnit(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public final boolean isAlive() {
        return hp > 0;
    }

    public abstract int calculateDamage();

    public void receiveDamage(int damage) {
        hp = Math.max(0, hp - damage);
    }

    public int getHp() {
        return hp;
    }
}

class BerserkerAssasin extends AbstractCombatUnit
        implements CriticalStriker {

    public BerserkerAssasin(String name, int hp) {
        super(name, hp);
    }

    @Override
    public int calculateDamage() {
        return 30;
    }

    @Override
    public double getCritMultiplier() {
        return 2.0;
    }
}

class TrollWarlord extends AbstractCombatUnit
        implements CriticalStriker, SelfRegenerating {

    public TrollWarlord(String name, int hp) {
        super(name, hp);
    }

    @Override
    public int calculateDamage() {
        return 25;
    }

    @Override
    public double getCritMultiplier() {
        return 1.5;
    }

    @Override
    public int regenerateHp() {
        return 15;
    }
}

class RoyalPaladin extends AbstractCombatUnit
        implements ShieldBearer, SelfRegenerating {

    public RoyalPaladin(String name, int hp) {
        super(name, hp);
    }

    @Override
    public int calculateDamage() {
        return 20;
    }

    @Override
    public int regenerateHp() {
        return 10;
    }

    @Override
    public int absorbDamage(int incoming) {
        return Math.max(0, incoming - 15);
    }
}

abstract class Task_39 {

    public static void main(String[] args) {
        AbstractCombatUnit[] units = {
                new BerserkerAssasin("Берсерк", 100),
                new TrollWarlord("Троль", 120),
                new RoyalPaladin("Паладин", 150)
        };

        for (int round = 1; round <= 5; round++) {
            System.out.println("\n========== Раунд " + round + " ==========");

            for (int i = 0; i < units.length; i++) {
                AbstractCombatUnit attacker = units[i];
                AbstractCombatUnit defender =
                        units[(i + 1) % units.length];

                if (!attacker.isAlive() || !defender.isAlive()) {
                    continue;
                }

                if (attacker instanceof SelfRegenerating reg) {
                    attacker.hp += reg.regenerateHp();
                    attacker.hp = Math.min(attacker.hp, 150);
                }

                int damage = attacker.calculateDamage();

                if (attacker instanceof CriticalStriker crit) {
                    damage = (int) (damage * crit.getCritMultiplier());
                }

                if (defender instanceof ShieldBearer shield) {
                    damage = shield.absorbDamage(damage);
                }

                defender.receiveDamage(damage);

                System.out.println(
                        attacker.getName() + " атакує "
                                + defender.getName()
                                + " на " + damage + " шкоди"
                );

                System.out.println(
                        defender.getName()
                                + " залишилося HP: " + defender.getHp()
                );
            }
        }

        System.out.println("\n========== Результат бою ==========");

        for (AbstractCombatUnit unit : units) {
            System.out.println(
                    unit.getName() + ": "
                            + (unit.isAlive()
                            ? "живий, HP = " + unit.getHp()
                            : "переможений")
            );
        }
    }
}