package by.epamlab;

import javax.ejb.EJBException;
import javax.ejb.MessageDrivenBean;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class Messenger implements MessageDrivenBean, MessageListener {

	private static final long serialVersionUID = 1L;
	MessageDrivenContext context = null;
	QueueConnection connection;
	QueueSession session;

	public Messenger() {
		System.out.println("Constructing MyMDB");
	}

	public void setMessageDrivenContext(MessageDrivenContext context) {
		this.context = context;
		System.out.println("setMessageDrivenContext");
	}

	public void ejbCreate() throws EJBException {
		System.out.println("ejbCreate");
		try {
			InitialContext initContext = new InitialContext();
			QueueConnectionFactory qcf = (QueueConnectionFactory) initContext.lookup("java:comp/env/jms/QCF");
			connection = qcf.createQueueConnection();
			session = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
			connection.start();
		} catch (Exception e) {
			throw new EJBException("Failed to initialize MyMDB", e);
		}
	}

	public void ejbRemove() {
		System.out.println("ejbRemove");
		context = null;
		try {
			if (session != null)
				session.close();
			if (connection != null)
				connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public void onMessage(Message message) {
		System.out.println("onMessage");
		try {
			TextMessage textMsg = (TextMessage) message;
			String text = textMsg.getText();
			System.out.println("\nMessage:\n" + text);
		} catch (JMSException jmsE) {
			jmsE.printStackTrace();
		}
	}
}
