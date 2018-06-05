package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.Objects;

public class TimeEntry {

    private final long id;
    private final long projectId;
    private final long userId;
    private final LocalDate date;
    private final int hours;

    public TimeEntry(long id, long userId, long projectId, LocalDate date, int hours) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry(long userId, long projectId, LocalDate date, int hours) {
        this(0, userId, projectId, date, hours);
    }

    public TimeEntry() {
        this(0, 0, 0, null, 0);
    }

    public long getId() {
        return id;
    }

    public long getProjectId() {
        return projectId;
    }

    public long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return id == timeEntry.id &&
                projectId == timeEntry.projectId &&
                userId == timeEntry.userId &&
                hours == timeEntry.hours &&
                Objects.equals(date, timeEntry.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, projectId, userId, date, hours);
    }

    @Override
    public String toString() {
        return "TimeEntry{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", userId=" + userId +
                ", date=" + date +
                ", hours=" + hours +
                '}';
    }

    public static class Builder {
        private long id;
        private long projectId;
        private long userId;
        private LocalDate date;
        private int hours;

        public TimeEntry build() {
            return new TimeEntry(id, userId, projectId, date, hours);
        }

        public Builder copy(TimeEntry timeEntry) {
            this.id = timeEntry.id;
            this.projectId = timeEntry.projectId;
            this.userId = timeEntry.userId;
            this.date = timeEntry.date;
            this.hours = timeEntry.hours;
            return this;
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder projectId(long projectId) {
            this.projectId = projectId;
            return this;
        }

        public Builder userId(long userId) {
            this.userId = userId;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder hours(int hours) {
            this.hours = hours;
            return this;
        }
    }
}
