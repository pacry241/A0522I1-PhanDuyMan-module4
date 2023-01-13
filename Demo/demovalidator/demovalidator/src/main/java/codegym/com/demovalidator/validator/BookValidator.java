package codegym.com.demovalidator.validator;

import codegym.com.demovalidator.model.Book;
import codegym.com.demovalidator.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

@Component
public class BookValidator implements Validator {
    @Autowired
    BookRepository repository;
    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Book book = (Book) target;
        if (book.getName().equalsIgnoreCase("The Duc")) {
            errors.rejectValue("name", "name.theduc");
        }

        String author = book.getAuthor();
        if (author.length() < 3 || author.length() > 11) {
            errors.rejectValue("author", "book.create.author.size"
                , new String[]{"3", "11"}, "Độ dài của chuỗi chưa chính xác");
        }

        String name = book.getName();
        if (repository.findBookByName(name) != null) {
            errors.rejectValue("name", "book.create.name.duplicate","Tên của sách không được trùng lặp");
        }

        Date datePublish = book.getPublishDate();
        if (datePublish != null && datePublish.after(new Date())) {
            errors.rejectValue("publishDate", "book.create.publishDate.afternow", "Ngày xuất bản không đúng");
        }
    }
}
