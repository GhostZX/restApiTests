package Core;

public class RandomGeneratedGender {

    private java.util.Random rnd = new java.util.Random();
    private StringBuilder salt = new StringBuilder();

    public String genderValue() {
        {
            while (salt.length() < 1) {
                String SALTCHARS = "FM";
                int index = (int) (rnd.nextFloat() * SALTCHARS.length());
                salt.append(SALTCHARS.charAt(index));
            }
        }
        return salt.toString();
    }
}
