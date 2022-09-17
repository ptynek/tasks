package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.assertj.AssertableApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskMapperTest {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    void mapToTaskTest(){
        TaskDto taskDto = new TaskDto(1L, "Title", "Content");

        Task task = taskMapper.mapToTask(taskDto);

        assertAll(
                () -> assertEquals(1L, task.getId()),
                () -> assertEquals("Title", task.getTitle()),
                () -> assertEquals("Content", task.getContent())
        );
    }

    @Test
    void MapToTaskDtoTest(){
        Task task = new Task(1L, "Title", "Content");

        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        assertAll(
                () -> assertEquals(1L, taskDto.getId()),
                () -> assertEquals("Title", taskDto.getTitle()),
                () -> assertEquals("Content", taskDto.getContent())
        );
    }

    @Test
    void mapToTaskListTest(){
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1L, "Title", "Content"));

        List<TaskDto> taskDtos = taskMapper.mapToTaskDtoList(taskList);

        assertEquals(1, taskDtos.size());
    }
}