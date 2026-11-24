
package semester1.practice12;

import java.util.*;

public class Task_39 {

    interface Poisonable {
        boolean isPoisoned();
        void tickPoison();
    }

    interface Regenerating {
        void healTurn();
    }

    abstract static class RpgHero {

        private final String name;
        protected int hp;

        private final Set<String> activeBuffs =
                new HashSet<>();

        public RpgHero(String name, int hp) {
            this.name = name;
            this.hp = hp;
        }

        public String getName() {
            return name;
        }

        public int getHp() {
            return hp;
        }

        public void addBuff(String buff) {

            if (activeBuffs.add(buff)) {
                System.out.println(name
                        + " отримав баф " + buff);
            }
        }

        public void showStatus() {
            System.out.println(name + " | HP: " + hp
                    + " | Бафи: " + activeBuffs);
        }
    }

    static class Warrior extends RpgHero
            implements Regenerating {

        public Warrior(String name, int hp) {
            super(name, hp);
        }

        @Override
        public void healTurn() {
            hp += 10;
            System.out.println(getName()
                    + " відновив 10 HP");
        }
    }

    static class Mage extends RpgHero
            implements Poisonable {

        private boolean poisoned = true;

        public Mage(String name, int hp) {
            super(name, hp);
        }

        @Override
        public boolean isPoisoned() {
            return poisoned;
        }

        @Override
        public void tickPoison() {

            if (poisoned) {
                hp -= 15;
                System.out.println(getName()
                        + " отримав 15 шкоди від отрути");
            }
        }
    }

    static class Ranger extends RpgHero
            implements Poisonable, Regenerating {

        private boolean poisoned = false;

        public Ranger(String name, int hp) {
            super(name, hp);
        }

        @Override
        public boolean isPoisoned() {
            return poisoned;
        }

        @Override
        public void tickPoison() {

            if (poisoned) {
                hp -= 10;
            }
        }

        @Override
        public void healTurn() {
            hp += 5;
            System.out.println(getName()
                    + " відновив 5 HP");
        }
    }

    public static void main(String[] args) {

        List<RpgHero> party = new ArrayList<>();

        party.add(new Warrior("Thor", 100));
        party.add(new Mage("Merlin", 40));
        party.add(new Ranger("Robin", 70));

        for (int turn = 1; turn <= 3; turn++) {

            System.out.println("\n========== ХІД "
                    + turn + " ==========");

            Iterator<RpgHero> it = party.iterator();

            while (it.hasNext()) {

                RpgHero hero = it.next();

                hero.addBuff("HASTE");

                if (hero instanceof Poisonable p
                        && p.isPoisoned()) {
                    p.tickPoison();
                }

                if (hero instanceof Regenerating r) {
                    r.healTurn();
                }

                // Додаткова бойова шкода
                if (hero instanceof Mage) {
                    hero.hp -= 15;
                }

                if (hero instanceof Warrior) {
                    hero.hp -= 20;
                }

                if (hero instanceof Ranger) {
                    hero.hp -= 25;
                }

                if (hero.hp <= 0) {

                    System.out.println(
                            hero.getName()
                                    + " вибув із бою!");

                    it.remove();

                } else {

                    hero.showStatus();
                }
            }

            System.out.println("Героїв у загоні: "
                    + party.size());

            if (party.isEmpty()) {
                System.out.println("Загін програв!");
                break;
            }
        }

        System.out.println("\n=== ФІНАЛЬНИЙ ЗАГІН ===");

        for (RpgHero hero : party) {
            hero.showStatus();
        }
    }
}
