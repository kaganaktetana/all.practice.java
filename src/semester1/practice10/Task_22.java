
package semester1.practice10;

abstract class AbstractMilitaryUnit {
    private final String unitName;
    protected int hp;

    public AbstractMilitaryUnit(String unitName, int hp) {
        this.unitName = unitName;
        this.hp = hp;
    }

    public String getUnitName() {
        return unitName;
    }

    public int getHp() {
        return hp;
    }

    public abstract int getMoveSpeed();
}

interface RangedAttacker {
    int getAttackRange();

    int fireShot();
}

interface FieldHealer {
    int healAlly();
}

class HeavySniper extends AbstractMilitaryUnit
        implements RangedAttacker {

    public HeavySniper() {
        super("Heavy Sniper", 120);
    }

    @Override
    public int getMoveSpeed() {
        return 3;
    }

    @Override
    public int getAttackRange() {
        return 15;
    }

    @Override
    public int fireShot() {
        return 80;
    }
}

class CombatMedic extends AbstractMilitaryUnit
        implements FieldHealer {

    public CombatMedic() {
        super("Combat Medic", 100);
    }

    @Override
    public int getMoveSpeed() {
        return 6;
    }

    @Override
    public int healAlly() {
        return 40;
    }
}

class PaladinCaptain extends AbstractMilitaryUnit
        implements RangedAttacker, FieldHealer {

    public PaladinCaptain() {
        super("Paladin Captain", 200);
    }

    @Override
    public int getMoveSpeed() {
        return 5;
    }

    @Override
    public int getAttackRange() {
        return 8;
    }

    @Override
    public int fireShot() {
        return 50;
    }

    @Override
    public int healAlly() {
        return 30;
    }
}

abstract class Task_22 {

    public static void main(String[] args) {

        AbstractMilitaryUnit[] units = {
                new HeavySniper(),
                new CombatMedic(),
                new PaladinCaptain()
        };

        for (AbstractMilitaryUnit unit : units) {

            System.out.println("Підрозділ: " + unit.getUnitName());
            System.out.println("HP: " + unit.getHp());
            System.out.println("Швидкість: " + unit.getMoveSpeed());

            if (unit instanceof RangedAttacker attacker) {
                System.out.println("Дальність атаки: "
                        + attacker.getAttackRange());

                System.out.println("Шкода пострілу: "
                        + attacker.fireShot());
            }

            if (unit instanceof FieldHealer healer) {
                System.out.println("Лікування: "
                        + healer.healAlly());
            }

            System.out.println();
        }
    }
}

