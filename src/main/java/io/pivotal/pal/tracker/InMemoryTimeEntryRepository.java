package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private long id = 1L;
    private Map<Long, TimeEntry> repo = new HashMap<>();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry newEntry = new TimeEntry(id++, timeEntry.getUserId(), timeEntry.getProjectId(), timeEntry.getDate(), timeEntry.getHours());
        repo.put(newEntry.getId(), newEntry);
        return newEntry;
    }

    @Override
    public TimeEntry find(long id) {
        return repo.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(repo.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry updatedEntry = new TimeEntry.Builder()
                .copy(timeEntry)
                .id(id)
                .build();
        repo.put(id, updatedEntry);
        return updatedEntry;
    }

    @Override
    public Boolean delete(long id) {
        return repo.remove(id) != null;
    }
}
