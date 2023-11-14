package sandoval.john.letsdoit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sandoval.john.letsdoit.models.Chat;
import sandoval.john.letsdoit.models.User;
import sandoval.john.letsdoit.repositories.ChatRepository;

@Service
public class ChatService {

    // * Inject the ChatRepository as a dependency
    @Autowired
    private ChatRepository chatRepository;

    // * Save a message to the database
    public void saveChatMessage(Chat message) {
        chatRepository.save(message);
    }

    // * Get the 100 most recent messages
    public List<Chat> getRecentMessages() {
        List<Chat> messages = new ArrayList<>();
        chatRepository.findAll().forEach(messages::add);
        int size = messages.size();
        if (size > 100) {
            messages = messages.subList(size - 100, size);
        }
        return messages;
    }

    // * Get all messages sent by a user
    public List<Chat> getMessagesByUser(User user) {
        return chatRepository.findByUser(user);
    }

    // * Get all chat partners of a user
    public List<User> getChatPartnersByUser(User user) {
        List<User> chatPartners = new ArrayList<>();
        List<Chat> messages = chatRepository.findByUser(user);
        for (Chat message : messages) {
            User chatPartner = message.getChatPartner(user);
            if (!chatPartners.contains(chatPartner)) {
                chatPartners.add(chatPartner);
            }
        }
        return chatPartners;
    }
}