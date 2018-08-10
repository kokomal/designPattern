package yuanjun.chen.design.mediator;

public class ChatClient {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl(); // 初始化Mediator
        User user1 = new UserImpl(mediator, "Pankaj"); // 每一个User都要传入mediator这个中介
        User user2 = new UserImpl(mediator, "Lisa");
        User user3 = new UserImpl(mediator, "Saurabh");
        User user4 = new UserImpl(mediator, "David");
        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4); // 加入所有小伙伴

        user1.send("Hi All");
    }
}
