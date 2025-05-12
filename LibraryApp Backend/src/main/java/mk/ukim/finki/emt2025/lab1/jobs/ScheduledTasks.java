package mk.ukim.finki.emt2025.lab1.jobs;


import mk.ukim.finki.emt2025.lab1.model.domain.Book;
import mk.ukim.finki.emt2025.lab1.repository.views.BooksPerAuthorViewRepository;
import mk.ukim.finki.emt2025.lab1.service.domain.BookService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    private final BookService bookService;

    public ScheduledTasks(BookService bookService) {
        this.bookService = bookService;
    }

    @Scheduled(cron = "0 0 * * * *") //
    public void refreshMaterializedView() {
        this.bookService.refreshMaterializedView();
    }
}
