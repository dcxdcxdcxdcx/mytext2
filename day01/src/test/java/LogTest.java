import org.apache.log4j.Logger;
import org.junit.Test;

public class LogTest {
    private Logger logger  =Logger.getLogger(LogTest.class);
    @Test
    public void fun01(){
        logger.error("error日志级别....");
        logger.warn("warn日志级别....");
        logger.info("info日志级别....");
        logger.debug("debug日志级别....");
        logger.trace("trace日志级别....");
    }
}
