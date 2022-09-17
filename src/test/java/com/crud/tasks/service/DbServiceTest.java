package com.crud.tasks.service;

import com.crud.tasks.controller.TaskController;
import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DbServiceTest {

    @InjectMocks
    private TaskController taskController;

    @Mock
    private DbService dbService;

    @Mock
    private TaskMapper taskMapper;

    @Test
    void testGetAllTasks() {
        //Given
        List<Task> taskList = new ArrayList<>();
        Task task = new Task(1L,"title1","content1");
        taskList.add(task);
        List<TaskDto> taskDtoList = new ArrayList<>();
        TaskDto taskDto = new TaskDto(1L,"title1","content1");
        taskDtoList.add(taskDto);
        when(dbService.getAllTasks()).thenReturn(taskList);
        when(taskMapper.mapToTaskDtoList(taskList)).thenReturn(taskDtoList);
        //When
        taskController.getTasks();
        //Then
        verify(dbService,times(1)).getAllTasks();
    }

    @Test
    void testGetTask() throws TaskNotFoundException {
        //Given
        TaskDto taskDto = new TaskDto(1L,"title1","content1");
        Task task = new Task(1L,"title1","content1");
        when(dbService.getTaskById(1L)).thenReturn(task);
        when(taskMapper.mapToTaskDto(task)).thenReturn(taskDto);
        //When
        taskController.getTask(1L);
        //Then
        verify(dbService,times(1)).getTaskById(1L);
    }

    @Test
    void testSaveTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L,"title1","content1");
        Task task = new Task(1L,"title1","content1");
        when(taskMapper.mapToTask(taskDto)).thenReturn(task);
        when(dbService.saveTask(task)).thenReturn(task);
        //When
        taskController.createTask(taskDto);
        //Then
        verify(dbService,times(1)).saveTask(task);
    }

    @Test
    void testDeleteTask() throws TaskNotFoundException {
        //Given
        Task task = new Task(1L,"title1","content1");
        //When
        taskController.deleteTask(task.getId());
        //Then
        verify(dbService,times(1)).deleteTask(task.getId());
    }


}