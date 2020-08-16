package net.thumbtack.school.online.ttschool;

import java.util.*;

public class TraineeQueue {
    private Queue<Trainee> queue;

    public Queue<Trainee> getQueue() {
        return queue;
    }

    public TraineeQueue() {
        this.queue = new LinkedList<>();
    }

    public void addTrainee(Trainee trainee) {
        queue.add(trainee);
    }

    public Trainee removeTrainee() throws TrainingException {
        if (isEmpty()) {
            throw new TrainingException(TrainingErrorCode.EMPTY_TRAINEE_QUEUE);
        }
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
