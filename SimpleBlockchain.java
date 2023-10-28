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
        blockChain1.addBlock("Transaction 2");
        blockChain1.addBlock2("Transaction 3");

        blockChain1.printBlockchain();

        StudentGradesBlockChain blockChain2 = new StudentGradesBlockChain();
        blockChain2.addBlock("Student 2");
        blockChain2.addBlock2("Student 3");

        blockChain2.printBlockChain();

    }
}
