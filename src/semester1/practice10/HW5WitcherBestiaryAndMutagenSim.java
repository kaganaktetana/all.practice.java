package semester1.practice10;

    // Інтерфейс літаючих монстрів
    interface FlyingMonster {
        boolean isAirborne();

        void knockDownToGround();
    }

    // Інтерфейс монстрів, які регенерують
    interface RegeneratingMonster {
        int regenerateHealth();

        void applyMoonDustBomb();
    }

    // Інтерфейс примарних істот
    interface SpectralPhantom {
        boolean isIncorporeal();

        void bindWithYrdenSign();
    }

    // Абстрактний базовий клас монстра
    abstract class AbstractMonster {
        private final String name;
        private final String bestiaryCategory;
        protected int hp;
        protected final int maxHp;

        public AbstractMonster(String name, String bestiaryCategory, int hp) {
            this.name = name;
            this.bestiaryCategory = bestiaryCategory;
            this.hp = hp;
            this.maxHp = hp;
        }

        public String getName() {
            return name;
        }

        public String getBestiaryCategory() {
            return bestiaryCategory;
        }

        public int getHp() {
            return hp;
        }

        public abstract int calculateMonsterAttack();

        public abstract String getBattleCry();

        public final boolean isAlive() {
            return hp > 0;
        }

        public void receiveDamage(int dmg) {
            hp = Math.max(0, hp - dmg);
        }

        @Override
        public String toString() {
            int filled = (int) Math.round((double) hp / maxHp * 10);
            StringBuilder bar = new StringBuilder();

            for (int i = 0; i < 10; i++) {
                bar.append(i < filled ? "█" : "░");
            }

            return name + " [" + bestiaryCategory + "] HP: "
                    + hp + "/" + maxHp + " [" + bar + "]";
        }
    }

    // Королівський грифон
    class RoyalGriffin extends AbstractMonster implements FlyingMonster {
        private boolean airborne = true;

        public RoyalGriffin() {
            super("Королівський Грифон", "Гібриди", 400);
        }

        @Override
        public int calculateMonsterAttack() {
            return 80;
        }

        @Override
        public String getBattleCry() {
            return "Грифон видає гучний бойовий крик!";
        }

        @Override
        public boolean isAirborne() {
            return airborne;
        }

        @Override
        public void knockDownToGround() {
            airborne = false;
            System.out.println(
                    "💨 [instanceof FlyingMonster] "
                            + "Ґеральт складає пальці у Знак ААРД! "
                            + "Грифона збито на землю!"
            );
        }

        @Override
        public void receiveDamage(int dmg) {
            if (airborne) {
                dmg /= 2;
            }

            super.receiveDamage(dmg);
        }
    }

    // Полудниця
    class Noonwraith extends AbstractMonster implements SpectralPhantom {
        private boolean incorporeal = true;

        public Noonwraith() {
            super("Полудниця з Білого Саду", "Примари", 300);
        }

        @Override
        public int calculateMonsterAttack() {
            return 60;
        }

        @Override
        public String getBattleCry() {
            return "Полудниця здіймає моторошний вереск!";
        }

        @Override
        public boolean isIncorporeal() {
            return incorporeal;
        }

        @Override
        public void bindWithYrdenSign() {
            incorporeal = false;

            System.out.println(
                    "🟣 [instanceof SpectralPhantom] "
                            + "Ґеральт креслить на землі магічне коло "
                            + "Знаку ІРДЕН! Примару матеріалізовано!"
            );
        }

        @Override
        public void receiveDamage(int dmg) {
            if (incorporeal) {
                dmg = (int) (dmg * 0.2);
            }

            super.receiveDamage(dmg);
        }
    }

    // Вищий вампір Детлафф
    class HigherVampire extends AbstractMonster
            implements FlyingMonster, RegeneratingMonster {

        private boolean airborne = true;
        private boolean regenerationBlocked = false;

        public HigherVampire() {
            super("Вищий Вампір Детлафф", "Вампіри", 650);
        }

        @Override
        public int calculateMonsterAttack() {
            return 120;
        }

        @Override
        public String getBattleCry() {
            return "Детлафф видає жахливий вампірський рев!";
        }

        @Override
        public boolean isAirborne() {
            return airborne;
        }

        @Override
        public void knockDownToGround() {
            airborne = false;

            System.out.println(
                    "💨 [instanceof FlyingMonster] "
                            + "Телеїнетичний імпульс Аарду "
                            + "перериває піке вампіра!"
            );
        }

        @Override
        public int regenerateHealth() {
            if (regenerationBlocked || !isAlive()) {
                return 0;
            }

            int restored = Math.min(120, maxHp - hp);
            hp += restored;
            return restored;
        }

        @Override
        public void applyMoonDustBomb() {
            regenerationBlocked = true;

            System.out.println(
                    "💣 [instanceof RegeneratingMonster] "
                            + "Ґеральт підриває бомбу 'Місячний Пил'! "
                            + "Срібні ошурки блокують регенерацію!"
            );
        }
    }

    // Прадавній Лісовик — фінальний клас
    final class AncientLeshen extends AbstractMonster
            implements RegeneratingMonster {

        private boolean regenerationBlocked = false;

        public AncientLeshen() {
            super("Прадавній Лісовик", "Релікти", 800);
        }

        @Override
        public int calculateMonsterAttack() {
            return 150;
        }

        @Override
        public String getBattleCry() {
            return "Лісовик скликає духів стародавнього лісу!";
        }

        @Override
        public int regenerateHealth() {
            if (regenerationBlocked || !isAlive()) {
                return 0;
            }

            int restored = Math.min(120, maxHp - hp);
            hp += restored;
            return restored;
        }

        @Override
        public void applyMoonDustBomb() {
            regenerationBlocked = true;

            System.out.println(
                    "💣 [instanceof RegeneratingMonster] "
                            + "Місячний пил блокує регенерацію Лісовика!"
            );
        }
    }

    // Мисливець — Ґеральт із Рівії
    class WitcherHunter {
        private final String schoolName;
        private final int silverSwordAtk;
        private final int signIntensity;

        public WitcherHunter(
                String schoolName,
                int silverSwordAtk,
                int signIntensity
        ) {
            this.schoolName = schoolName;
            this.silverSwordAtk = silverSwordAtk;
            this.signIntensity = signIntensity;
        }

        public void applyBestiaryTactics(AbstractMonster target) {

            if (target instanceof SpectralPhantom sp
                    && sp.isIncorporeal()) {
                sp.bindWithYrdenSign();
            }

            if (target instanceof FlyingMonster fm
                    && fm.isAirborne()) {
                fm.knockDownToGround();
            }

            if (target instanceof RegeneratingMonster rm) {
                rm.applyMoonDustBomb();
            }
        }

        public final int executeSilverStrike(AbstractMonster target) {

            applyBestiaryTactics(target);

            int damage;

            if (target instanceof RoyalGriffin) {
                damage = 250;
            } else if (target instanceof Noonwraith) {
                damage = 260;
            } else if (target instanceof HigherVampire) {
                damage = 330;
            } else {
                damage = silverSwordAtk * signIntensity / 100;
            }

            target.receiveDamage(damage);

            System.out.println(
                    "⚔️ [final executeSilverStrike] "
                            + "Срібний меч завдає " + damage
                            + " шкоди! (Залишок HP: "
                            + target.getHp() + "/" + target.maxHp + ")"
            );

            return damage;
        }

        public void showHunterInfo() {
            System.out.println(
                    "Мисливець: Ґеральт із Рівії ("
                            + schoolName
                            + " | Срібний меч: " + silverSwordAtk
                            + " ATK | Інтенсивність Знаків: "
                            + signIntensity + "%)"
            );
        }
    }

    // Головний клас програми
    public class HW5WitcherBestiaryAndMutagenSim {

        public static void main(String[] args) {

            System.out.println(
                    "================ 🐺 ВІДЬМАК 3: БЕСТІАРІЙ "
                            + "ТА ПОЛІМОРФНЕ ПОЛЮВАННЯ 🐺 ================"
            );

            WitcherHunter geralt =
                    new WitcherHunter("Школа Вовка", 220, 150);

            geralt.showHunterInfo();

            AbstractMonster[] contracts = {
                    new RoyalGriffin(),
                    new Noonwraith(),
                    new HigherVampire(),
                    new AncientLeshen()
            };

            for (int i = 0; i < contracts.length; i++) {

                AbstractMonster monster = contracts[i];

                System.out.println(
                        "\n--- КОНТРАКТ №" + (i + 1)
                                + ": " + monster + " ---"
                );

                System.out.println(monster.getBattleCry());

                if (monster instanceof RoyalGriffin griffin
                        && griffin.isAirborne()) {
                    System.out.println(
                            "🦅 Грифон ширяє високо в небі! "
                                    + "Удар мечем без підготовки завдав би "
                                    + "лише 50% шкоди."
                    );
                }

                if (monster instanceof Noonwraith wraith
                        && wraith.isIncorporeal()) {
                    System.out.println(
                            "👻 Примара нематеріальна "
                                    + "(поглинає 80% ударів)."
                    );
                }

                if (monster instanceof HigherVampire) {
                    System.out.println(
                            "🦇 Множинний контракт "
                                    + "(FlyingMonster + RegeneratingMonster)!"
                    );
                }

                geralt.executeSilverStrike(monster);

                System.out.println("Стан після удару: " + monster);

                if (!monster.isAlive()) {
                    System.out.println("☠️ Монстра переможено!");
                }
            }

            System.out.println(
                    "\n================ ПОЛЮВАННЯ ЗАВЕРШЕНО ================"
            );
        }
    }


