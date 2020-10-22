public class Example {
    public static void main(String[] args) {

    }

    public String getResultString(int numResults) {
        StringBuffer sb = null;

        for (int result[] = getResults(numResults); numResults-- > 0;) {
            int i = result[numResults];
            if (i == 0) {
                int j = i + 1;
                if (sb == null)
                    sb = new StringBuffer();
                else
                    sb.append(",");
                sb.append(j);
            } else {
                int j = i + 1;
                if (sb == null)
                    sb = new StringBuffer();
                else
                    sb.append(",");
                sb.append(j);
            }
        }
        return sb.toString();
    }

    int[] getResults(int numResults){
        int[] numbers = new int[numResults];
        for(int i=0;i<numResults;i++){
            numbers[i]=i;
        }
        return numbers;
    }
}
