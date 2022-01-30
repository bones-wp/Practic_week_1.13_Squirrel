public class Squirrel {
    int[] nuts;

    public Squirrel(int[] nuts) {
        this.nuts = nuts;
    }

    int getNuts(int n) {
        return nuts[n];
    }
    private int max(int a, int b) {
        if (a >= b) return a;
        return b;
    }

    int maxNuts() {
        if (nuts.length > 1) {
            int arr[] = nuts.clone();
            //создаём дублирующий массив

            arr[1] = max(arr[1], arr[0] + arr[1]); //  7

            if (arr[1] < 0) arr[1] = 0;
            // мы поняли как лучше прыгнуть на первые 2 пенька, теперь разбираемся с остальными

            for (int i = 2; i < arr.length; i++) {
            // как лучше прыгнуть, перепрыгнуть предыдущий пенек или нет

                arr[i] = max(arr[i] + arr[i - 1], arr[i] + arr[i - 2]);
                if (arr[i] < 0) arr[i] = 0;
            }

            // таким образом мы проходим все элементы массива, кроме последних двух
            // ведь последний элемент может быть отрицательным и возможно туда
            // прыгать было не нужно (наш for просто проверяет все элементы, в том числе
            // и последний), поэтому осталось сравнить 2 последних элемента, как мы сравнивали
            // два первых и возвратить данное значение и проверить, что оно больше 0

            int a = max(arr[arr.length - 2], arr[arr.length - 1]); // -1
            return max(0, a);
        } else return max(0, nuts[0]);
        // если массив длинной 1, то мы проверяем, надо ли вообще прыгать на пенек, если он кривой,
        // то вернем 0 орехов, а если там есть орехи, то вернем их.
    }

}
/* public class Squirrel {
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
*/
