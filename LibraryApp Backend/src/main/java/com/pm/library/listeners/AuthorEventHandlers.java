package com.pm.library.listeners;

import com.pm.library.events.AuthorCreatedEvent;
import com.pm.library.service.domain.AuthorService;
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
