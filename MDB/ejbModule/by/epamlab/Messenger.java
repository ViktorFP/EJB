package by.epamlab;

import java.util.Properties;

import javax.ejb.EJBException;
import javax.ejb.MessageDrivenBean;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Messenger implements MessageDrivenBean, MessageListener {

	private TopicConnection connect;
	private TopicSession session;
	private static final long serialVersionUID = 1L;

	@Override
	public void onMessage(Message message) {
		try {
			TextMessage textMsg = (TextMessage) message;
			String text = textMsg.getText();
			System.out.println("\nMessage:\n" + text);
		} catch (JMSException jmsE) {
			jmsE.printStackTrace();
		}
	}

	private static InitialContext getInitialContext() throws NamingException {
		Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		env.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
		env.put(Context.PROVIDER_URL, "jnp://localhost:1099");
		return new InitialContext(env);
	}

	public void ejbCreate() throws EJBException {
		try {
			InitialContext jndiContext = getInitialContext();
			TopicConnectionFactory factory = (TopicConnectionFactory) jndiContext
					.lookup("java:comp/env/jms/TopicFactory");
			Topic topic = (Topic) jndiContext.lookup("java:comp/env/jms/MsgTopic");
			connect = factory.createTopicConnection();
			session = connect.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			TopicSubscriber subscriber = session.createSubscriber(topic);
			subscriber.setMessageListener(this);
			connect.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void ejbRemove() throws EJBException {
		try {
			if (session != null)
				session.close();
			if (connect != null)
				connect.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setMessageDrivenContext(MessageDrivenContext context) throws EJBException {

	}
}
