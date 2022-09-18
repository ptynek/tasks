package com.crud.tasks.scheduler;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmailSchedulerTest {

    @Autowired
    private EmailScheduler emailScheduler;

    @Test
    void testFindOutWord(){
        int size = 1;
        int size1 = 2;

        String word = emailScheduler.findOutWord(size);
        String word1 = emailScheduler.findOutWord(size1);

        assertEquals(" task", word);
        assertEquals(" tasks", word1);
    }
}