import java.util.List;

public class PostcardApp {
    public static void main(String[] args) {
        System.out.println("Skriv in meddelande:");
        String message = Utils.scan.nextLine();

        String[] address = new String[3];
        System.out.println("Skriv in adress");
        int i;
        for (i = 0; i < address.length; i++) {
            address[i] = Utils.scan.nextLine();
        }
        Postcard pc = new Postcard(message, address);

        System.out.println("Välj stil:");
        List<String> styles = pc.getStyles();
        for (i = 1; i <= styles.size(); i++) {
            System.out.println("("+i+") " + styles.get(i-1));
        }
        int styleChoice = Utils.scan.nextInt()-1;
        Utils.scan.nextLine();
        String style = styles.get(styleChoice);
        pc.printGreeting(style);
        
    }
}
