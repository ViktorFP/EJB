package by.epamlab;

import java.io.IOException;
import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JSMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JSMServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		performTask(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		performTask(request, response);
	}

	private void performTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		QueueConnection queueConnection = null;
		try {
			//Context context = new InitialContext();
			Properties properties = new Properties();
			properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			properties.put(Context.PROVIDER_URL, "localhost:1099");
			InitialContext context = new InitialContext(properties);
			
			QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) context
					.lookup("ConnectionFactory");
			String queueName = "queue/MyQueue";
			Queue queue = (Queue) context.lookup(queueName);
			queueConnection = queueConnectionFactory.createQueueConnection();
			QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			QueueSender queueSender = queueSession.createSender(queue);
			TextMessage message = queueSession.createTextMessage();
			message.setText("This is a TextMessage");
			queueSender.send(message);
			System.out.println("Message sent.");
		} catch (NamingException e) {
			System.out.println("Naming Exception");
			e.printStackTrace();
		} catch (JMSException e) {
			System.out.println("JMS Exception");
			e.printStackTrace();
		} finally {
			if (queueConnection != null) {
				try {
					queueConnection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
