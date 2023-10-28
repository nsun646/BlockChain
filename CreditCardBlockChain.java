import java.util.ArrayList;
import java.util.List;
public class CreditCardBlockChain {
    private List<CreditCardTransaction> chain;

    public CreditCardBlockChain() {
        chain = new ArrayList<CreditCardTransaction>();
        chain.add(new CreditCardTransaction(0, "0", "Transaction 1", 045667755, "Ben Davis", "Macy's", 550.60));
    }

    public void addBlock(String data) {
        CreditCardTransaction previousBlock = chain.get(chain.size() - 1);
        CreditCardTransaction newBlock = new CreditCardTransaction(previousBlock.getIndex() + 1, previousBlock.getHash(), data, 3400056, "Jen Powers", "Starbucks", 7.66);
        chain.add(newBlock);
    }

    public void addBlock2(String data) {
        CreditCardTransaction previousBlock = chain.get(chain.size() - 1);
        CreditCardTransaction newBlock1 = new CreditCardTransaction(previousBlock.getIndex() + 1, previousBlock.getHash(), data, 800050006, "Mary Bee", "GoodWill", 5.30);
        chain.add(newBlock1);
    }

    public void printBlockChain() {
        for (CreditCardTransaction creditCardTransaction : chain) {
            System.out.println("Block #" + creditCardTransaction.getIndex());
            System.out.println("Timestamp: " + creditCardTransaction.getTimestamp());
            System.out.println("Previous Hash: " + creditCardTransaction.getPreviousHash());
            System.out.println("Hash: " + creditCardTransaction.getHash());
            System.out.println("Data: " + creditCardTransaction.getData());
            System.out.println("Credit Card Number: " + creditCardTransaction.getCreditCardNumber());
            System.out.println("Card Holder's Name: " + creditCardTransaction.getCreditCardHolderName());
            System.out.println("Place of Transaction: " + creditCardTransaction.getPlaceOfTransaction());
            System.out.println("Transaction Amount: " + creditCardTransaction.getTransactionAmount());
            System.out.println();
        }
    }
}