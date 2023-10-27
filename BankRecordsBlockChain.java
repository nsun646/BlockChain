import java.util.ArrayList;
import java.util.List;
public class BankRecordsBlockChain {
        private List<BankRecords> chain;

        public BankRecordsBlockChain() {
            chain = new ArrayList<BankRecords>();
            // Create the genesis block (the first block in the chain)
            chain.add(new BankRecords(0, "0", "Genesis Block", 123, "Savings", "Debit", 200));
        }
        public void addBlock(String data) {
            BankRecords previousBlock = chain.get(chain.size() - 1);
            BankRecords newBlock = new BankRecords(previousBlock.getIndex() + 1, previousBlock.getHash(), data, 12345, "Savings", "Debit", 700);
            chain.add(newBlock);
        }
        public void printBlockchain() {
            for (BankRecords bankRecords : chain) {
                System.out.println("Block #" + bankRecords.getIndex());
                System.out.println("Timestamp: " + bankRecords.getTimestamp());
                System.out.println("Previous Hash: " + bankRecords.getPreviousHash());
                System.out.println("Hash: " + bankRecords.getHash());
                System.out.println("Data: " + bankRecords.getData());
                System.out.println("Account Number: " + bankRecords.getAccountNumber());
                System.out.println("Account Type: " + bankRecords.getAccountType());
                System.out.println("Transaction Type: " + bankRecords.getTransactionType());
                System.out.println("Transaction Amount: " + bankRecords.getTransactionAmount());
                System.out.println();
            }
        }
    }
