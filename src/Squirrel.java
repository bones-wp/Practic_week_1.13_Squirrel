public class Squirrel {
    int[] nuts;


    public Squirrel(int[] nuts) {
        this.nuts = nuts;
    }

    public int getNuts(int index){
        return nuts[index];
    }

    public int maxNuts(){
        int result = 0;
        if (nuts.length > 1){
            int[] n = new int[nuts.length];
            for (int i =0; i < n.length; i++){
                n[i] = 0;
            }
            int c = 0;
            for (int i = 0; i < nuts.length; i++){
                if (nuts[i] >= 0) {
                    n[c] = nuts[i];
                    result += n[c];
                    c++;
                }
                else if (nuts[i] < 0 && nuts[i+1] >= 0){
                    n[c] = nuts[i+1];
                    result += n[c];
                    i++;
                    c++;
                }
                else if (nuts[i] < 0 && nuts[i+1] < 0 && nuts[i] > nuts[i+1] && result + nuts[i] >= 0) {
                    n[c] = nuts[i];
                    result += n[c];
                    c++;
                }
                else if (nuts[i] < 0 && nuts[i+1] < 0 && nuts[i] < nuts[i+1] && result + nuts[i+1] >= 0) {
                    n[c] = nuts[i+1];
                    result += n[c];
                    i++;
                    c++;
                }
                else if (nuts[i] < 0 && nuts[i+1] < 0 && nuts[i] > nuts[i+1] && result + nuts[i] <= 0) {
                    result = 0;
                }
                else if (nuts[i] < 0 && nuts[i+1] < 0 && nuts[i] < nuts[i+1] && result + nuts[i+1] <= 0) {
                    result = 0;
                }
                else if (nuts[i] < 0 && nuts[i+1] < 0 && nuts[i] < nuts[i+1] && result + nuts[i+1] >= 0 && (i+1 == nuts.length))
                    break;
            }

        }
        return result;
    }


}
