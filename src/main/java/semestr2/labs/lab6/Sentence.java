package semestr2.labs.lab6;

class Sentence {

    private final static int МАХ_NUM_OF_WORDS = 20;

    private String sourceStr; // ссылка на исходную строку
    private String [ ] words; //ссылка на массив слов исходной строки
    private int counter; //число слов в исходной строке

    public Sentence () {
        sourceStr = ""; words = null; counter = 0;
    }

    public Sentence (String str) {
        setSourceStr(str);
    }

    public void setSourceStr(String str){
        sourceStr = str.trim();
        if (str == "") {
            words = null; counter = 0;
        }
        else splitIntoWords();
    }

    public String[] getWords() {return words;}

    public int getCounter() {return counter;}

    public String toString(){
        return sourceStr;
    }

    private void splitIntoWords(){
        words = new String[ МАХ_NUM_OF_WORDS ];
        int start, end;
        counter = 0;
        start = 0;
        end = sourceStr.indexOf(" ");
        try {
            while (end > 0){
                words[counter] = sourceStr.substring(start, end);
                counter++;
                while (sourceStr.charAt(end) == ' ') end++;
                start = end;
                end = sourceStr.indexOf(" ", start);
            }
            words[counter] = sourceStr.substring(start);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("В предложении слишком много слов, лишние придется обрезать:\n" + e);
            System.out.println();
            counter--;
        }
        counter++;
    }

    public String[] wordsLengthAboveN(int N){
        if (counter == 0) return null;
        String[] arr = new String[counter];
        int j = 0;
        for (int i = 0; i < counter; i++)
            if (words[i].length() > N){
                arr[j] = words[i];
                j++;
            }
        return arr;
    }

    public String [ ] wordsLetterFirstEqvLast(){
        if (counter == 0) return null;
        char c1, cN;
        String[] arr = new String[counter];
        int j = 0;
        for (int i = 0; i < counter; i++){
            c1 = words[i].charAt(0);
            cN = words[i].charAt(words[i].length() - 1);
            if (c1 == cN){
                arr[j] = words[i];
                j++;
            }
        }
        return arr;
    }

    public String capitalFirstLetterInWords(){
        if (sourceStr.equals(""))return "";

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < counter; i++){
            result.append(" ");
            result.append(words[i].substring(0,1).toUpperCase());
            result.append(words[i].substring(1).toLowerCase());
        }
        result.delete(0, 1);
        return result.toString();
    }

    public String deleteWordsLengthAboveN(int N){
        if (sourceStr.equals("")) return "";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < counter; i++){
            result.append(" ");
            if (words[i].length() > N) result.append(words[i]);
        }
        result.delete(0, 1);
        return result.toString();
    }

    public String[] wordsLetterFirstEqvA(){
        if (counter == 0) return null;
        char c1;
        String[] arr = new String[counter];
        int j = 0;
        for (int i = 0; i < counter; i++){
            c1 = words[i].charAt(0);
            if (c1 == 'a' || c1 == 'A'){
                arr[j] = words[i];
                j++;
            }
        }
        return arr;
    }

    public String wordsLetterFirstEqvALastEqvN(char N){
        if (counter == 0) return null;
        char c1, last;
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        int j = 0;
        for (int i = 0; i < counter; i++){
            c1 = words[i].charAt(0);
            last = words[i].charAt(words[i].length()-1);
            if ((c1 == 'a' || c1 == 'A') && (last == N)){
                sb.append(words[i]);
                j++;
            }
        }
        sb.delete(0, 1);
        return sb.toString();
    }
}