package slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4JBasics {

    static Logger logger = LoggerFactory.getLogger(SLF4JBasics.class);

    public static void main(String[] args) {

        logger.info("Application Started");

        logger.debug("Debug Message");

        logger.warn("Warning Message");

        logger.error("Error Message");

        logger.info("Application Ended");
    }
}