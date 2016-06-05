package by.epamlab;

import java.io.IOException;
import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
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
		TopicConnection connect = null;
		try {
			String message = "message";
			Properties properties = new Properties();
			properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			properties.put(Context.PROVIDER_URL, "localhost:1099");
			InitialContext jndiContext = new InitialContext(properties);
			TopicConnectionFactory factory = (TopicConnectionFactory) jndiContext
					.lookup("java:comp/env/jms/TopicFactory");
			Topic topic = (Topic) jndiContext.lookup("java:comp/env/jms/MsgTopic");
			connect = factory.createTopicConnection();
			TopicSession session = connect.createTopicSession(true, 0);
			TopicPublisher publisher = session.createPublisher(topic);
			TextMessage textMsg = session.createTextMessage();
			textMsg.setText(message);
			publisher.publish(textMsg);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connect != null) {
				try {
					connect.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
