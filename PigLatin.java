public class PigLatin {
    public static String convert(String start) {
        StringBuilder sb = new StringBuilder();

        String prefix = (findFirstVowel(start) != -1) ? ((findFirstVowel(start) == 0) ? "y" : (("quQu".contains(start.substring(0,2))) ? "qu" : start.substring(0, findFirstVowel(start)))) : "";

        for (int i = 0; i < start.length(); i++) {  
            if (i == findFirstVowel(start)) {
                sb.delete(0, sb.length());
            }
            sb.append(start.charAt(i));
        }

        if (prefix.equals("qu")) {
            sb.delete(0, 1);
        }

        sb.append(prefix + "ay");

        return sb.toString();
    }

    public static int findFirstVowel(String start) {
        int position = -1;
        for (int i = 0; i < start.length(); i++) {
            char compare = start.charAt(i);
            if ("aAeEiIoOuU".indexOf(compare) != -1) {
                position = i;
                break;
            }
        }

        return position;
    }
}