package se.hernebring.ovningar14;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ovning1 {
    final static Logger logger = LoggerFactory.getLogger(Ovning1.class);
    public static void main(String[] args) {
        
    int someData = 3;
    logger.atDebug().log("Detta är debuginfo");
    logger.atInfo().log("Detta är bra information");
    logger.atWarn().log("Detta är en varning med data: {}", someData);
    }
}
    