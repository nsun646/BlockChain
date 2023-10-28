import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class CreditCardTransaction {
    private int index;
    private long timestamp;
    private String previousHash;
    private String hash;
    private String data;
    private int creditCardNumber;
    private String creditCardHolderName;
    private String placeOfTransaction;
    private double transactionAmount;

    public CreditCardTransaction(int index, String previousHash, String data,int creditCardNumber, String creditCardHolderName, String placeOfTransaction, double transactionAmount) {
        this.index = index;
        this.timestamp = new Date().getTime();
        this.previousHash = previousHash;
        this.data = data;
        this.hash = calculateHash();
        this.creditCardNumber = creditCardNumber;
        this.creditCardHolderName = creditCardHolderName;
        this.placeOfTransaction = placeOfTransaction;
        this.transactionAmount = transactionAmount;

    }
    public String calculateHash() {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            String input = index + timestamp + previousHash + data;
            byte[] hashBytes = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);

            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException | java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
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
    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
    public int getCreditCardNumber() {
        return creditCardNumber;
    }
    public void setCreditCardHolderName(String creditCardHolderName) {
        this.creditCardHolderName = creditCardHolderName;
    }
    public String getCreditCardHolderName() {
        return creditCardHolderName;
    }
    public void setPlaceOfTransaction(String placeOfTransaction) {
        this.placeOfTransaction = placeOfTransaction;
    }
    public String getPlaceOfTransaction() {
        return placeOfTransaction;
    }
    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
    public double getTransactionAmount() {
        return transactionAmount;
    }
}
