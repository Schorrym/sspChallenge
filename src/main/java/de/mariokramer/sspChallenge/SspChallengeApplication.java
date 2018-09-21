package de.mariokramer.sspChallenge;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SspChallengeApplication {

    private static final Log LOG = LogFactory.getLog(SspChallengeApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SspChallengeApplication.class, args);
        LOG.debug("SspChallenge startet");
    }

}
