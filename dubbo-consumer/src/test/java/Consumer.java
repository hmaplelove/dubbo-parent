import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hmaplelove.apps.commons.service.UserService;

public class Consumer {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
		context.start();
		UserService demoService = (UserService)context.getBean("userService"); // 获取远程服务代理
		String hello = demoService.sayHello("显示调用结果"); // 执行远程方法
		System.out.println( hello ); // 显示调用结果
		System.in.read();
	}

}
