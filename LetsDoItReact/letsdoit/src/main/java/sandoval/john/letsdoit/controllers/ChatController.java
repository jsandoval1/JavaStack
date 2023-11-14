package sandoval.john.letsdoit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import sandoval.john.letsdoit.models.Chat;
import sandoval.john.letsdoit.models.User;
import sandoval.john.letsdoit.services.ChatService;
import sandoval.john.letsdoit.services.UserService;

@Controller
public class ChatController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private UserService userService;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat") // * This is the endpoint that the client will send messages to
    public void processMessage(Chat message) {
        chatService.saveChatMessage(message);
        simpMessagingTemplate.convertAndSend("/topic/messages", message); // * This is the endpoint that the server will
                                                                          // send messages to
    }

    @SubscribeMapping("/chat") // * This is the endpoint that the client will subscribe to
    public List<Chat> getRecentMessages() {
        return chatService.getRecentMessages();
    }

    @GetMapping("/chat/{id}") // * This is the endpoint that the client will subscribe to
    @ResponseBody
    public List<Chat> getMessagesByUserId(@PathVariable("id") Long id) {
        User user = userService.findUser(id);
        return chatService.getMessagesByUser(user);
    }

    // ***
    // * The following endpoints are for testing purposes only

    // @GetMapping("/chat/new")
    // public String showCreateMessagePage(Model model) {
    // List<User> users = userService.allUsers();
    // model.addAttribute("users", users);
    // model.addAttribute("message", new Chat());
    // return "createMessage";
    // }

    // @GetMapping("/chat/new")
    // public String showCreateMessagePage(Model model) {
    // List<User> users = userService.getAllUsers(); // or userService.allUsers();
    // model.addAttribute("users", users);
    // model.addAttribute("message", new Chat());
    // return "createMessage";
    // }

    @GetMapping("/chat/new")
    public String showCreateMessagePage(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("messageForm", new Chat());
        return "createMessage";
    }

    @GetMapping("/chat/partners/{id}")
    public String getChatPartnersByUserId(@PathVariable("id") Long id, Model model) {
        User user = userService.findUser(id);
        List<User> chatPartners = chatService.getChatPartnersByUser(user);
        model.addAttribute("chatPartners", chatPartners);
        return "chatList";
    }

    // @MessageMapping("/chat")
    // public void handleChatMessage(Chat chatMessage) {
    //     chatService.saveChatMessage(chatMessage);
    // }
}
