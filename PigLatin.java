public class PigLatin {
    public static void main(String[] args) {
        System.out.println(convert("My List: Bob..."));
    }    

    public static String convert(String start) {
        PigLatin pL = new PigLatin();
        StringBuilder end = new StringBuilder();
        String[] words = start.split("[ ]");

        for (String word : words) {
            end.append(pL.translate(word) + " ");
        }

        return end.toString();
    }

    public static String translate(String sStart) {
        String start = sStart;
        StringBuilder sb = new StringBuilder();
        String prefix;

        StringBuilder endPunctuation = new StringBuilder();
        int itt = start.length() - 1;
        while (Character.isLetterOrDigit(start.charAt(itt)) == false) {
            endPunctuation.append(start.charAt(itt));
            start = start.substring(0, start.length() - 1);
            itt--;
        }
        endPunctuation.reverse();

        prefix = (findFirstVowel(start) != -1) ? ((findFirstVowel(start) == 0) ? "y" : (("quQu".contains(start.substring(0,2))) ? "qu" : start.substring(0, findFirstVowel(start)))) : "";
        for (int i = 0; i < start.length(); i++) {  
            if (i == findFirstVowel(start)) {
                sb.delete(0, sb.length());
            }
            sb.append(start.charAt(i));
        }

        if (prefix.equals("qu")) {
            sb.delete(0, 1);
        }
        
        /*
        sb.replace(0, 1, sb.toString().substring(0, 1).toUpperCase());
        prefix = prefix.toLowerCase();
        */
        sb.append(prefix + "ay" + endPunctuation.toString());

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