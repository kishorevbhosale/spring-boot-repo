package com.kb.auditing.controller;

import com.kb.auditing.entity.Book;
import com.kb.auditing.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.history.Revision;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class BookRepoController {

    BookRepository repository;

    @PostMapping("/book/save")
    public String saveBook(@RequestBody Book book){
        repository.save(book);
        return "book : "+book.getName()+" saved successfully";
    }

    @PutMapping("/book/update/{id}/{pages}")
    public String updateBook(@PathVariable int id, @PathVariable int pages){
        Book book = repository.getById(id);
        book.setPages(pages);
        repository.save(book);
        return "book : "+book.getName()+" updated successfully";
    }

    @DeleteMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable int id){
        Book book = repository.getById(id);
        repository.deleteById(id);
        return "book : "+book.getName()+" deleted successfully";
    }

    @GetMapping("/book/revision-info/{id}")
    public void getRevisionInfo(@PathVariable int id){
        System.out.println(repository.findLastChangeRevision(id));
    }
}
