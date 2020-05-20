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

    @org.springframework.beans.factory.annotation.Autowired
    public TodosApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    //Note: Parameter level annotaions are required when overriding api methods
    public ResponseEntity<List<Todo>> getTodos(@ApiParam(value = "Show completed/uncompleted todo items") @Valid @RequestParam(value = "completed", required = false) Boolean completed) {
        Todo responseItem = new Todo();
        responseItem.setName("My First Todo Item");
        responseItem.setDescription("Making the '/todos' path work");
        responseItem.setDate(OffsetDateTime.now().plusDays(1));
        responseItem.setCompleted(false);
        return ResponseEntity.ok(Arrays.asList(responseItem));
    }

}
