class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < words.length){
            int j = i;
            int lineLength = 0;
            while(j < words.length){
                int wordLength = words[j].length();
                if(lineLength + wordLength + (j - i) > maxWidth){
                    break;
                }
                lineLength += wordLength;
                j++;
            }
            int numberOfWords = j - i;
            boolean lastLine = (j == words.length);
            StringBuilder line = new StringBuilder();
            if(lastLine){
                for(int k = i; k < j; k++){
                    line.append(words[k]);
                    if(k < j - 1){
                        line.append(" ");
                    }
                }
                while(line.length() < maxWidth){
                    line.append(" ");
                }
            }
            else if(numberOfWords == 1){
                line.append(words[i]);
                while(line.length() < maxWidth){
                    line.append(" ");
                }
            }
            else{
                int totalSpaces = maxWidth - lineLength;
                int gaps = numberOfWords - 1;
                int spacesPerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;
                for(int k = i; k < j; k++){
                    line.append(words[k]);
                    if(k < j - 1){
                        int spaces = spacesPerGap;
                        if(extraSpaces > 0){
                            spaces++;
                            extraSpaces--;
                        }
                        for(int s = 0; s < spaces; s++){
                            line.append(" ");
                        }
                    }
                }
            }
            result.add(line.toString());
            i = j;
        }
        return result;
    }    
}
