package net.thumbtack.school.online.ttschool;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TraineeMap {
    private Map<Trainee, String> traineeMap;

    public TraineeMap() {
        traineeMap = new HashMap<Trainee, String>();
    }

    private void checkAddTrainee(Trainee trainee) throws TrainingException {
        if (traineeMap.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
        }
    }

    public void addTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        checkAddTrainee(trainee);
        traineeMap.put(trainee, institute);
    }

    private void checkReplaceTrainee(Trainee trainee) throws TrainingException {
        if (!traineeMap.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public void replaceTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        checkReplaceTrainee(trainee);
        traineeMap.put(trainee, institute);
    }

    public void removeTraineeInfo(Trainee trainee) throws TrainingException {
        checkReplaceTrainee(trainee); // воспользуемся написанным ранее методом
        traineeMap.remove(trainee);
    }

    public int getTraineesCount() {
        return traineeMap.size();
    }

    public String getInstituteByTrainee(Trainee trainee) throws TrainingException {
        checkReplaceTrainee(trainee);
        return traineeMap.get(trainee);
    }

    public Set<Trainee> getAllTrainees() {
        return traineeMap.keySet();
    }

    public Set<String> getAllInstitutes() {
        Set<String> set = new HashSet<String>();
        set.addAll(traineeMap.values());
        return set;
    }

    public boolean isAnyFromInstitute(String institute) {
        return traineeMap.containsValue(institute);
    }
}
