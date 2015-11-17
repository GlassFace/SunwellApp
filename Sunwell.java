package app.sunwell;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Sunwell {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Gui gui = (Gui) context.getBean("gui");
		gui.window();
	}
}
