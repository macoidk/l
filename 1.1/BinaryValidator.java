public class BinaryValidator {
    public static boolean isValidBinary(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        if (!str.matches("[01]+")) {
            return false;
        }

        try {
            int decimal = Integer.parseInt(str, 2);

            return decimal > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int binaryToDecimal(String binary) {
        if (!isValidBinary(binary)) {
            throw new IllegalArgumentException("Invalid binary string: must be a positive binary number");
        }
        return Integer.parseInt(binary, 2);
    }
}