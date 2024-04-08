import java.io.*;

public class FileEncryptionDecryption {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter 'encrypt' to encrypt or 'decrypt' to decrypt: ");
            String mode = reader.readLine().toLowerCase();

            System.out.print("Enter the file name or path: ");
            String fileName = reader.readLine();

            switch (mode) {
                case "encrypt":
                    encryptFile(fileName);
                    System.out.println("File encrypted successfully.");
                    break;
                case "decrypt":
                    decryptFile(fileName);
                    System.out.println("File decrypted successfully.");
                    break;
                default:
                    System.out.println("Invalid mode. Please enter 'encrypt' or 'decrypt'.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void encryptFile(String fileName) {
        processFile(fileName, "_encrypted", ch -> (char) (ch + 1));
    }

    public static void decryptFile(String fileName) {
        processFile(fileName, "_decrypted", ch -> (char) (ch - 1));
    }

    public static void processFile(String fileName, String suffix, CharTransformer transformer) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
                BufferedWriter writer = new BufferedWriter(new FileWriter(suffix + fileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                StringBuilder processedLine = new StringBuilder();
                for (char ch : line.toCharArray()) {
                    processedLine.append(transformer.transform(ch));
                }
                writer.write(processedLine.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    interface CharTransformer {
        char transform(char ch);
    }
}
