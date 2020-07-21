package de.gtarc.chariot.registeragent;

import de.dailab.jiactng.agentcore.action.AbstractMethodExposingBean;
import de.gtarc.chariot.connectionapi.ConnectionException;
import de.gtarc.chariot.connectionapi.impl.MqttConnectionImpl;
import de.gtarc.chariot.dbhandlerapi.KmsHandler;
import de.gtarc.chariot.dbhandlerapi.impl.KmsHandlerImpl;
import de.gtarc.chariot.registrationapi.server.RegistrationServer;
import java.util.UUID;

public class RegistrationBean extends AbstractMethodExposingBean {

    private UUID uuid;

    private String host ;
    private String username;
    private String password;
    private String clientId;
    private String url;
    @Override
    public void doStart() throws Exception {

        super.doStart();

        MqttConnectionImpl dc = new MqttConnectionImpl(host, username, password, clientId);
        try {
            dc.connect();
        } catch (ConnectionException e) {
            e.printStackTrace();
        }

        KmsHandler kms = new KmsHandlerImpl();
        kms.setURL(url);

        dc.subscribeTopic("register");

        new RegistrationServer(dc, kms);

        System.out.println("RegisterAgent started.");
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setEntityId(String entityId) {
        this.uuid = UUID.fromString(entityId);
    }

    public void setKmsURL(String kmsURL) {
        this.url = kmsURL;
    }

}
