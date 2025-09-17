package com.pm.library.events;

import lombok.Getter;
import com.pm.library.model.domain.Author;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

@Getter
public class AuthorCreatedEvent extends ApplicationEvent {

    private LocalDateTime when;

    public AuthorCreatedEvent(Author source) {
        super(source);
        this.when = LocalDateTime.now();
    }

    public AuthorCreatedEvent(Author source, LocalDateTime when) {
        super(source);
        this.when = when;
    }
}
