public class Calculate {
    public static int calculate(int a, int b, String calcu) {
        return switch (calcu) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 0;
        };
    }

    public static int calculate(String a, String b, String calcu) {
        return switch (calcu) {
            case "+" -> Integer.parseInt(a) + Integer.parseInt(b);
            case "-" -> Integer.parseInt(a) - Integer.parseInt(b);
            case "*" -> Integer.parseInt(a) * Integer.parseInt(b);
            case "/" -> Integer.parseInt(a) / Integer.parseInt(b);
            default -> 0;
        };
    }
}
