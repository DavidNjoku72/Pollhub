package com.david.pollhub.service;

import com.david.pollhub.dto.PollDTO;
import com.david.pollhub.entity.Poll;
import com.david.pollhub.repository.PollRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollService {

    private final PollRepository pollRepository;

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    public Poll createPoll(PollDTO pollDTO) {
        Poll poll = new Poll();

        poll.setQuestion(pollDTO.getQuestion());
        poll.setCreatedBy(pollDTO.getCreatedBy());

        return pollRepository.save(poll);
    }

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    public Poll getPollById(Long id) {
        return pollRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Poll not found"));
    }

    public Poll updatePoll(Long id, PollDTO pollDTO) {
        Poll poll = getPollById(id);

        poll.setQuestion(pollDTO.getQuestion());
        poll.setCreatedBy(pollDTO.getCreatedBy());

        return pollRepository.save(poll);
    }

    public void deletePoll(Long id) {
        Poll poll = getPollById(id);
        pollRepository.delete(poll);
    }
}