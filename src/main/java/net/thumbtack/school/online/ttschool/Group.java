package net.thumbtack.school.online.ttschool;

import java.util.*;

public class Group {

    private String name, room;
    private List<Trainee> trainees;

    private void checName(String name) throws TrainingException {
        if (name == null || name.length() == 0 || name.equals(" ")) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
        }
    }

    private void checRoom(String room) throws TrainingException {
        if (room == null || room.length() == 0 || room.equals(" ")) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        checName(name);
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) throws TrainingException {
        checRoom(room);
        this.room = room;
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void addTrainee(Trainee trainee) {
        trainees.add(trainee);
    }

    public Group(String name, String room) throws TrainingException {
        setName(name);
        setRoom(room);
        this.trainees = new ArrayList<Trainee>();
    }

    public void removeTrainee(Trainee trainee) throws TrainingException {
        if (!trainees.remove(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public void removeTrainee(int index) throws TrainingException {
        if (index >= trainees.size()) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        trainees.remove(index);
    }

    public Trainee getTraineeByFirstName(String firstName) throws TrainingException {
        for (Trainee tr : trainees) {
            if (tr.getFirstName().equals(firstName)) {
                return tr;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public Trainee getTraineeByFullName(String fullName) throws TrainingException {
        for (Trainee tr : trainees) {
            if (tr.getFullName().equals(fullName)) {
                return tr;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public void sortTraineeListByFirstNameAscendant() {
        trainees.sort(new Comparator<Trainee>() {
            @Override
            public int compare(Trainee o1, Trainee o2) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        });
    }

    public void sortTraineeListByRatingDescendant() {
        trainees.sort(new Comparator<Trainee>() {
            @Override
            public int compare(Trainee o1, Trainee o2) {
                if (o1.getRating() == o2.getRating()) {
                    return 0;
                } else if (o1.getRating() > o2.getRating()) {
                    return -1;
                } else return 1;
            }
        });
    }

    public void reverseTraineeList() {
        Collections.reverse(trainees);
    }

    public void rotateTraineeList(int positions) {
        Collections.rotate(trainees, positions);
    }

    public List<Trainee> getTraineesWithMaxRating() throws TrainingException {
        if (trainees.size() == 0) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        List<Trainee> maxRatingTrainess = new ArrayList<>();
        int max = 1; // пусть 1 - будет максимальной оценкой по умолчанию, с нее начнем отсчет
        for (Trainee tr : trainees) {
            if (tr.getRating() >= max) {
                maxRatingTrainess.clear(); // удалим все добавленные ранее значения
                maxRatingTrainess.add(tr); // начнем добавлять заново
                max = tr.getRating(); // будем переменной присваивать новое найденное максимальное значение
            }
            if (tr.getRating() == max) {
                maxRatingTrainess.add(tr);
            }
        }
        return maxRatingTrainess;
    }

    public boolean hasDuplicates() {
        /*в классе Trainee у нас переопределен метод equals, так как нам нужно. Пробежимся по списку и при
        нахождении хотябы одного дубликата возвращает true*/
        for (int i = 0; i < trainees.size(); i++) {
            for (int j = i + 1; j < trainees.size(); j++) {
                if (trainees.get(i).equals(trainees.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name) &&
                Objects.equals(room, group.room) &&
                Objects.equals(trainees, group.trainees);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, room, trainees);
    }
}
