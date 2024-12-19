package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author();
        author.setFirstName("Bill");
        author.setLastName("Smith");

        Book book = new Book();
        book.setTitle("The Book");
        book.setIsbn("123456");

        Author erikSaved = authorRepository.save(author);
        Book bookSaved = bookRepository.save(book);


        Author author2 = new Author();
        author2.setFirstName("Wane");
        author2.setLastName("Johns");

        Book book2 = new Book();
        book2.setTitle("Java language");
        book2.setIsbn("236541");

        Author waneSaved = authorRepository.save(author2);
        Book waneBookSaved = bookRepository.save(book2);

        erikSaved.getBooks().add(bookSaved);
        waneSaved.getBooks().add(waneBookSaved);

        bookSaved.getAuthors().add(erikSaved);
        waneBookSaved.getAuthors().add(waneSaved);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Parker");
        publisher.setAddress("Legendary street, 23");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setZip(23654);

        Publisher publisherSaved = publisherRepository.save(publisher);

        bookSaved.setPublisher(publisher);
        waneBookSaved.setPublisher(publisher);

        bookRepository.save(bookSaved);
        bookRepository.save(waneBookSaved);



        System.out.println("In Bootstrap");
        System.out.println("Author count: "+authorRepository.count());
        System.out.println("Book count: "+bookRepository.findById(1L).get().getPublisher().getPublisherName());
        System.out.println("Publisher count: "+publisherRepository.count());
        System.out.println("Publisher's name: "+publisherRepository.findById(1L).get().getPublisherName());

    }
}
