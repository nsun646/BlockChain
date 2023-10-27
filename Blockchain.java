import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Blockchain {
    private List<Block> chain;

    public Blockchain() {
        chain = new ArrayList<Block>();
        // Create the genesis block (the first block in the chain)
        chain.add(new Block(0, "0", "Genesis Block"));
    }
    public void addBlock(String data) {
        Block previousBlock = chain.get(chain.size() - 1);
        Block newBlock = new Block(previousBlock.getIndex() + 1, previousBlock.getHash(), data);
        chain.add(newBlock);
    }
    public void printBlockchain() {
        for (Block block : chain) {
            System.out.println("Block #" + block.getIndex());
            System.out.println("Timestamp: " + block.getTimestamp());
            System.out.println("Previous Hash: " + block.getPreviousHash());
            System.out.println("Hash: " + block.getHash());
            System.out.println("Data: " + block.getData());
            System.out.println();
        }
    }
}
