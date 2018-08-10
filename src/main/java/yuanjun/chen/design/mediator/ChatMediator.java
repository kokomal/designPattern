package yuanjun.chen.design.mediator;

public interface ChatMediator {
	void sendMessage(String msg, User user);

	void addUser(User user);
}
