package com.computec.sitevisit.model.common;

import java.io.IOException;
import java.io.Serializable;

import java.util.Hashtable;

import javax.management.Descriptor;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.modelmbean.ModelMBeanInfo;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import javax.naming.Context;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.binding.BindingContainer;

import oracle.jbo.RowIterator;

public class SQLAuthenticatorAdapter implements Serializable {
    private static final String MBEAN_INTERFACE = "weblogic.security.providers.authentication.SQLAuthenticatorMBean";
    private MBeanServerConnection connection;
    private JMXConnector connector;
    private ObjectName providerON;
    public SQLAuthenticatorAdapter() {
    }

    public void addUser() {
        try {
            connect();
            testCreateUser();
            //testCreateGroup();
            //testAddMemberTopGroup();
            close();
            ADFUtil.invokeEL("#{bindings.Execute.execute}");
        } catch (Exception e) {
            // TODO: Add catch code
            close();
            e.printStackTrace();
        }
    }
    
    public void testRemoveUser() throws Exception {
        String username = "kiril";
        removeUser(username);
    }

    public void testCreateUser() throws Exception {
        String username = "kiril";
        String password = "kiril.amin";
        String displayName = "Kiril Amin";
        BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding iter = (DCIteratorBinding)bindings.get("UsrView1Iterator");
        RowIterator usrs = iter.getRowSetIterator();
//        Key parentKey = new Key(new Object[] { (String) getAttributeInternal(CLINO) }); 
//        parentIter.setCurrentRowWithKey(parentKey.toStringFormat(true));
        createUser(username, password, displayName);
    }

    public void testCreateGroup() throws Exception {
        String groupName = "SOADevGroup";
        String description = "This is a especial group created through SQLAuthenticatorAdapter";
        createGroup(groupName, description);
    }

    public void testAddMemberTopGroup() throws Exception {
        String username = "pino";
        String groupName = "SOADevGroup";
        addMemberToGroup(groupName, username);
    }

    public void createUser(String username, String password, String description) throws Exception {
        connection.invoke(providerON, "createUser", new Object[] { username, password, description },
                          new String[] { "java.lang.String", "java.lang.String", "java.lang.String" });
    }
    
    public void removeUser(String username) throws Exception {
        connection.invoke(providerON, "removeUser", new Object[] { username },
                          new String[] { "java.lang.String" });
    }

    public void createGroup(String groupName, String description) throws Exception {
        connection.invoke(providerON, "createGroup", new Object[] { groupName, description },
                          new String[] { "java.lang.String", "java.lang.String" });
    }

    public void addMemberToGroup(String groupName, String username) throws Exception {
        connection.invoke(providerON, "addMemberToGroup", new Object[] { groupName, username },
                          new String[] { "java.lang.String", "java.lang.String" });
    }

    public void changeUserPassword(String username, String oldPassword, String newPassword) throws Exception {
        connection.invoke(providerON, "changeUserPassword", new Object[] { username, oldPassword, newPassword },
                          new String[] { "java.lang.String", "java.lang.String", "java.lang.String" });
    }
    
    public void resetUserPassword(String userName, String newPassword) throws Exception {
        connection.invoke(providerON, "resetUserPassword", new Object[] { userName, newPassword },
                          new String[] { "java.lang.String", "java.lang.String" });
    }

    public boolean isMember(String parentGroupName, String memberUserOrGroupName, boolean recursive) throws Exception {
        return (Boolean) connection.invoke(providerON, "isMember",
                                           new Object[] { parentGroupName, memberUserOrGroupName, recursive },
                                           new String[] { "java.lang.String", "java.lang.String",
                                                          "java.lang.Boolean" });
    }

    private ObjectName getAuthenticationProviderObjectName(String type) throws Exception {

        ObjectName defaultRealm = getDefaultRealm();
        ObjectName[] atnProviders = (ObjectName[]) connection.getAttribute(defaultRealm, "AuthenticationProviders");
        ObjectName MBTservice =
            new ObjectName("com.bea:Name=MBeanTypeService,Type=weblogic.management.mbeanservers.MBeanTypeService");
        for (int p = 0; atnProviders != null && p < atnProviders.length; p++) {
            ObjectName provider = atnProviders[p];
            ModelMBeanInfo info = (ModelMBeanInfo) connection.getMBeanInfo(provider);
            Descriptor desc = info.getMBeanDescriptor();
            String className = (String) desc.getFieldValue("interfaceClassName");
            String[] mba =
                (String[]) connection.invoke(MBTservice, "getSubtypes", new Object[] { type },
                                             new String[] { "java.lang.String" });
            for (int i = 0; i < mba.length; i++) {
                if (mba[i].equals(className)) {
                    return provider;
                }
            }
        }
        return null;
    }

    private ObjectName getDefaultRealm() throws Exception {
        ObjectName service =
            new ObjectName("com.bea:Name=DomainRuntimeService,Type=weblogic.management.mbeanservers.domainruntime.DomainRuntimeServiceMBean");
        ObjectName domainMBean = (ObjectName) connection.getAttribute(service, "DomainConfiguration");
        ObjectName securityConfiguration = (ObjectName) connection.getAttribute(domainMBean, "SecurityConfiguration");
        ObjectName defaultRealm = (ObjectName) connection.getAttribute(securityConfiguration, "DefaultRealm");
        return defaultRealm;
    }

    public void connect() {
        String hostname = "localhost";
        String username = "weblogic";
        String password = "weblogic1";
        int port = 7101;
        connect(hostname, username, password, port);
    }

    public void connect(String hostname, String username, String password, int port) {
        try {
            String protocol = "t3";
            String jndi = "/jndi/weblogic.management.mbeanservers.domainruntime";
            JMXServiceURL serviceURL = new JMXServiceURL(protocol, hostname, port, jndi);
            Hashtable env = new Hashtable();
            env.put(Context.SECURITY_PRINCIPAL, username);
            env.put(Context.SECURITY_CREDENTIALS, password);
            env.put(JMXConnectorFactory.PROTOCOL_PROVIDER_PACKAGES, "weblogic.management.remote");
            env.put("jmx.remote.x.request.waiting.timeout", new Long(10000));
            connector = JMXConnectorFactory.connect(serviceURL, env);
            connection = connector.getMBeanServerConnection();
            providerON = getAuthenticationProviderObjectName(MBEAN_INTERFACE);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void close() {
        try {
            connector.close();
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    public void delUser() {
        try {
            connect();
            testRemoveUser();
            close();
            ADFUtil.invokeEL("#{bindings.Execute.execute}");
        } catch (Exception e) {
            // TODO: Add catch code
            close();
            e.printStackTrace();
        }
    }
}
