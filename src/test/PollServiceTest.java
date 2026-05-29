package com.david.pollhub;

import com.david.pollhub.entity.Poll;
import com.david.pollhub.repository.PollRepository;
import com.david.pollhub.service.PollService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PollServiceTest {

    @Test
    void testGetAllPolls() {

        PollRepository mockRepository = Mockito.mock(PollRepository.class);

        Poll poll1 = new Poll();
        poll1.setQuestion("Java");

        Poll poll2 = new Poll();
        poll2.setQuestion("React");

        List<Poll> polls = Arrays.asList(poll1, poll2);

        Mockito.when(mockRepository.findAll()).thenReturn(polls);

        PollService pollService = new PollService(mockRepository);

        List<Poll> result = pollService.getAllPolls();

        assertEquals(2, result.size());
        assertEquals("Java", result.get(0).getQuestion());
        assertEquals("React", result.get(1).getQuestion());
    }
}