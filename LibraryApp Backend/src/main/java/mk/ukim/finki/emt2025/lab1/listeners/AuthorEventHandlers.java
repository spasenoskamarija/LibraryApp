package mk.ukim.finki.emt2025.lab1.listeners;

import mk.ukim.finki.emt2025.lab1.events.AuthorCreatedEvent;
import mk.ukim.finki.emt2025.lab1.service.domain.AuthorService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AuthorEventHandlers {

    private final AuthorService authorService;

    public AuthorEventHandlers(AuthorService authorService) {
        this.authorService = authorService ;
    }

    @EventListener
    public void onAuthorCreated(AuthorCreatedEvent event) {
        this.authorService.refreshMaterializedView();
    }
}
