package com.redhat.todo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.redhat.todo.model.Todo;
import com.redhat.todo.repository.TodoRepository;

@Controller
@RequestMapping("${openapi.todo.base-path:/v1}")
public class TodosApiController implements TodosApi {

    @Autowired
    TodoRepository todoRepository;

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TodosApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<Todo>> getTodos(@Valid Boolean completed) {
        return ResponseEntity.ok(todoRepository.getByCompleted(completed));
    }

    @Override
    public ResponseEntity<Todo> getTodo(Integer todoId) {
        return ResponseEntity.ok(todoRepository.findById(todoId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Override
    public ResponseEntity<Void> createTodo(@Valid Todo todo) {
        todoRepository.save(todo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<Void> updateTodo(Integer todoId, @Valid Todo todo) {
        //TODO: Add validation todo item exist and throw a 404 if missing
        todo.setId(todoId);
        todoRepository.save(todo);
        return TodosApi.super.updateTodo(todoId, todo);
    }

    @Override
    public ResponseEntity<Void> deleteTodo(Integer todoId) {
        //TODO: Add validation todo item exist and throw a 404 if missing
        todoRepository.deleteById(todoId);
        return TodosApi.super.deleteTodo(todoId);
    }
}
