package com.github.sooogle.todo;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class TodoRepositoryTest {

    @Autowired
    TodoRepository repository;

    @Transactional
    @Test
    void testSaveAll() {
        var todos = IntStream.range(0, 10000).mapToObj(index -> {
            var todo = new Todo();
            todo.setDescription("todo" + index);
            return todo;
        }).collect(Collectors.toList());
        repository.saveAll(todos);
        repository.flush();
    }

}
