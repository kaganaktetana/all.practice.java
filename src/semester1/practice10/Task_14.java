
package semester1.practice10;

interface Authenticatable {

    boolean verifySignature(String key);
}

interface Auditable {

    String getAuditTrail();
}

interface BlockchainSmartContract
        extends Authenticatable, Auditable {

    boolean executeContract(double gasLimit);
}

class EscrowSmartContract implements BlockchainSmartContract {

    @Override
    public boolean verifySignature(String key) {
        return key != null && key.equals("SECRET123");
    }

    @Override
    public String getAuditTrail() {
        return "Контракт створено. Очікується виконання.";
    }

    @Override
    public boolean executeContract(double gasLimit) {
        return gasLimit >= 1000;
    }
}

abstract class Task_14 {

    public static void main(String[] args) {

        EscrowSmartContract contract = new EscrowSmartContract();

        System.out.println("Перевірка підпису: "
                + contract.verifySignature("SECRET123"));

        System.out.println("Історія аудиту: "
                + contract.getAuditTrail());

        System.out.println("Виконання контракту: "
                + contract.executeContract(2000));
    }
}
