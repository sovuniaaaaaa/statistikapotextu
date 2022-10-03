public class StstisticOnTheText {
    public static long countAllSymbols(String text) {
        return text.length();
    }

    public static long countSymbolsWithoutGaps(String text) {
        text = text.replaceAll("\\s", "");
        return text.length();
    }

    public static long countAllWords(String text) {
        int numberOfWords = 0;
        String textReplace = text.replaceAll("[\"\\\\\\[\\]\\/\\*\\+\\.\\,\\(\\)\\&\\?\\%\\$\\#\\@\\!\\;\\№]+"," ");
        String[] splitLine = textReplace.split("\\s");
        for (int i = 0; i < splitLine.length; i++) {
            if(splitLine[i].isEmpty()||splitLine[i] == ""||splitLine[i].matches("[-]+")){
                continue;
            }

            numberOfWords++;
        }
        return numberOfWords;
    }
}