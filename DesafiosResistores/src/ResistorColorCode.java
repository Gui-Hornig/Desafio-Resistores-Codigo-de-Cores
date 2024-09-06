import java.util.HashMap;
import java.util.Map;

public class ResistorColorCode {

    private static final Map<Character, String> colorMap = new HashMap<>();

    static {
        colorMap.put('0', "preto");
        colorMap.put('1', "marrom");
        colorMap.put('2', "vermelho");
        colorMap.put('3', "laranja");
        colorMap.put('4', "amarelo");
        colorMap.put('5', "verde");
        colorMap.put('6', "azul");
        colorMap.put('7', "violeta");
        colorMap.put('8', "cinza");
        colorMap.put('9', "branco");
    }

    public static String getResistorColors(String input) {
        String[] parts = input.split(" ");
        String value = parts[0];
        StringBuilder result = new StringBuilder();

        if (value.contains("k")) {
            value = value.replace("k", "");
            int intValue = (int) (Double.parseDouble(value) * 1000);
            result.append(colorMap.get(Character.forDigit(intValue / 100, 10))).append(" ");
            result.append(colorMap.get(Character.forDigit((intValue / 10) % 10, 10))).append(" ");
            result.append(colorMap.get(Character.forDigit(intValue % 10, 10))).append(" ");
            result.append("dourado");
        } else if (value.contains("M")) {
            value = value.replace("M", "");
            int intValue = (int) (Double.parseDouble(value) * 1000000);
            result.append(colorMap.get(Character.forDigit(intValue / 100000, 10))).append(" ");
            result.append(colorMap.get(Character.forDigit((intValue / 10000) % 10, 10))).append(" ");
            result.append(colorMap.get(Character.forDigit((intValue / 1000) % 10, 10))).append(" ");
            result.append("dourado");
        } else {
            int intValue = Integer.parseInt(value);
            result.append(colorMap.get(Character.forDigit(intValue / 10, 10))).append(" ");
            result.append(colorMap.get(Character.forDigit(intValue % 10, 10))).append(" ");
            result.append("preto ").append("dourado");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(getResistorColors("47 ohms"));
        System.out.println(getResistorColors("4.7k ohms"));
        System.out.println(getResistorColors("1M ohms")); 
    }
}