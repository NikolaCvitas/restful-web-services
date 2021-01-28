package hr.cvitas.rest.webservices.restfulwebservices.controller;

import hr.cvitas.rest.webservices.restfulwebservices.model.Todo;
import hr.cvitas.rest.webservices.restfulwebservices.service.TodoHardcodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {

    @Autowired
    private TodoHardcodedService todoService;

    @GetMapping("users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable  String username){

        return todoService.findAll();
    }

    @GetMapping("users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable  String username, @PathVariable long id){

        return todoService.findById(id);
    }

    @DeleteMapping("users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){

        Todo todo = todoService.deleteById(id);
        if(todo != null){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username,
                                           @PathVariable long id,
                                           @RequestBody Todo todo){

        Todo todoUpdated = todoService.save(todo);

        return new ResponseEntity<Todo>(todo, HttpStatus.OK);

    }
}
