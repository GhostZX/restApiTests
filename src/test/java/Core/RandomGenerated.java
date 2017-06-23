package Core;


public class RandomGenerated {

    private java.util.Random rnd = new java.util.Random();
    private StringBuilder salt = new StringBuilder();

    public String stringValue(int length) {
        {
            while (salt.length() < length) {
                String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
                int index = (int) (rnd.nextFloat() * SALTCHARS.length());
                salt.append(SALTCHARS.charAt(index));
            }
        }
        return salt.toString();
    }


}
