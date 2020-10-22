public class Ovning1{
    public static void main(String[] args) {
        try{
            throw new RuntimeException("bra felmeddelande");
        } catch (RuntimeException ex){
            ex.printStackTrace();
        }
    }
}