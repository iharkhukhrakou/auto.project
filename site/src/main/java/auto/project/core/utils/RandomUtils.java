package auto.project.core.utils;

public final class RandomUtils {
    private static final char[] CHARACTERS = ("abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "0123456789").toCharArray();

    /**
     * This method generates a password.
     */
    public static String randomPassword() {
        final java.util.Random random = new java.util.Random();

        final byte randomLength = (byte) (random.nextInt(14) + 6);
        byte randomElementNumber;
        String password = "";

        for (int i = 0; i < randomLength; ++i) {
            randomElementNumber = (byte) random.nextInt(CHARACTERS.length);

            password = new StringBuilder(password).append(CHARACTERS[randomElementNumber]).toString();
        }

        return password;
    }

    /**
     * This method generates a token.
     */
    public static String randomToken() {
        final java.util.Random random = new java.util.Random();

        final byte randomLength = (byte) (random.nextInt(28) + 12);
        byte randomElementNumber;
        String token = "";

        for (int i = 0; i < randomLength; ++i) {
            randomElementNumber = (byte) random.nextInt(CHARACTERS.length);

            token = new StringBuilder(token).append(CHARACTERS[randomElementNumber]).toString();
        }

        return token;
    }
}
