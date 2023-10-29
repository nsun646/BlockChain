import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankRecords {
    private int index;
    private long timestamp;
    private String previousHash;
    private String hash;
    private String data;
    private int accountNumber;
    private String accountType;
    private String transactionType;
    private double transactionAmount;


    public BankRecords(int index, String previousHash, String data, int accountNumber, String accountType, String transactionType, double transactionAmount) {
        this.index = index;
        this.timestamp = new Date().getTime();
        this.previousHash = previousHash;
        this.data = data;
        this.hash = calculateHash(3);
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
    }

    public String calculateHash(int difficulty) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            String input = index + timestamp + previousHash + data;
            int nonce = 0;
            String target = "0".repeat(difficulty);

            while (true) {
                String dataToHash = input + nonce;
                byte[] hashBytes = digest.digest(dataToHash.getBytes("UTF-8"));
                String hash = bytesToHex(hashBytes);

                if (hash.substring(0, difficulty).equals(target)) {
                    return hash;
                }

                nonce++;
            }
        } catch (NoSuchAlgorithmException | java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }


    public int getIndex() {
        return index;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getHash() {
        return hash;
    }

    public String getData() {
        return data;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }
}
