package com.redhat.todo.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.redhat.todo.model.Todo;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-05-14T16:03:13.202-04:00[America/New_York]")

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
    public ResponseEntity<List<Todo>> getTodos(@Valid Boolean completed) {
        Todo responseItem = new Todo();
        responseItem.setName("My First Todo Item");
        responseItem.setDescription("Making the '/todos' path work");
        responseItem.setDate(OffsetDateTime.now().plusDays(1));
        responseItem.setCompleted(false);
        return ResponseEntity.ok(Arrays.asList(responseItem));
    }

}
