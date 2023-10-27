public class SimpleBlockchain {
    public static void main(String[] args) {
        // Create a new blockchain
        Blockchain blockchain = new Blockchain();
        // Add some blocks to the blockchain
        blockchain.addBlock("Transaction 1");
        blockchain.addBlock("Transaction 2");
        blockchain.addBlock("Transaction 3");
        // Print the blockchain
        blockchain.printBlockchain();

        BankRecordsBlockChain blockChain1 = new BankRecordsBlockChain();
        blockChain1.addBlock("Transaction 4");

        blockChain1.printBlockchain();
    }
}
