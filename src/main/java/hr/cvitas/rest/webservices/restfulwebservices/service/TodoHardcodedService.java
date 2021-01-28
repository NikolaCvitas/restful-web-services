package hr.cvitas.rest.webservices.restfulwebservices.service;

import hr.cvitas.rest.webservices.restfulwebservices.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodedService {

    private static List<Todo> todos = new ArrayList<Todo>();
    private static int idCounter = 0;


    static {
        todos.add(new Todo(++idCounter, "nikola","Learn Javascript", new Date(), false));
        todos.add(new Todo(++idCounter, "nikola","Learn Java", new Date(), false));
        todos.add(new Todo(++idCounter, "nikola","Learn Python", new Date(), false));
        todos.add(new Todo(++idCounter, "nikola","Learn C++", new Date(), false));
        todos.add(new Todo(++idCounter, "nikola","Learn Kotlin", new Date(), false));
        todos.add(new Todo(++idCounter, "nikola","Learn Spring", new Date(), false));
    }

    public List<Todo> findAll(){
        return todos;
    }

    public Todo deleteById(long id){
        Todo todo = findById(id);

        if(todo == null){
            return null;
        }
        if(todos.remove(todo)){
            return todo;
        }

        return null;

    }

    public Todo findById(long id) {

        for(Todo todo:todos){
            if(todo.getId() == id){
                return todo;
            }
        }

        return null;

    }

    public Todo save(Todo todo){
        if(todo.getId() == -1){
            todo.setId(++idCounter);
            todos.add(todo);
        }else{
            deleteById(todo.getId());
            todos.add(todo);
        }

        return todo;
    }
}
