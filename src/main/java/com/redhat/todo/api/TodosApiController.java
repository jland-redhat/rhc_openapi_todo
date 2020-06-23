package com.redhat.todo.api;

import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.redhat.todo.model.Todo;

@Controller
@RequestMapping("${openapi.todo.base-path:/v1}")
public class TodosApiController implements TodosApi {

    private final NativeWebRequest request;

    //TODO: Add TodoRepository to controller

    @org.springframework.beans.factory.annotation.Autowired
    public TodosApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    //TODO: Override and Implement GET method getTodo(Integer todoId)

    //TODO: (Optional) Override and Implement getTodos(Boolean completed)
    
    //TODO: (Optional) Override and Implement createTodo(Todo todo)

    //TODO: (Optional) Override and Implement updateTodo(Todo todo)

    //TODO: (Optional) Override and Implement deleteTodo(Integer todoId)

}
