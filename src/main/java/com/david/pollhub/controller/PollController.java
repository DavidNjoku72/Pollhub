package com.david.pollhub.controller;

import com.david.pollhub.dto.PollDTO;
import com.david.pollhub.entity.Poll;
import com.david.pollhub.service.PollService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/polls")
public class PollController {

    private final PollService pollService;

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @PostMapping
    public Poll createPoll(@Valid @RequestBody PollDTO pollDTO) {
        return pollService.createPoll(pollDTO);
    }

    @GetMapping
    public List<Poll> getAllPolls() {
        return pollService.getAllPolls();
    }

    @GetMapping("/{id}")
    public Poll getPollById(@PathVariable Long id) {
        return pollService.getPollById(id);
    }

    @PutMapping("/{id}")
    public Poll updatePoll(
            @PathVariable Long id,
            @Valid @RequestBody PollDTO pollDTO) {

        return pollService.updatePoll(id, pollDTO);
    }

    @DeleteMapping("/{id}")
    public String deletePoll(@PathVariable Long id) {

        pollService.deletePoll(id);

        return "Poll deleted successfully";
    }
}