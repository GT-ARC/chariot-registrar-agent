package de.gtarc.chariot.registeragent;

import de.dailab.jiactng.agentcore.SimpleAgentNode;
import de.dailab.jiactng.agentcore.lifecycle.LifecycleException;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

public class StartRegistrationService {

    public static void main(String[] args) throws LifecycleException {

        ApplicationContext context = SimpleAgentNode.startAgentNode("classpath:config/entity.xml", "jiactng_log4j.properties");
        SimpleAgentNode node = (SimpleAgentNode) context.getBean("RegistrationNode");
        try {
            node.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

        System.setProperty("log4j.configuration", "jiactng_log4j.properties");

        //stopAgent(node);
    }
}

