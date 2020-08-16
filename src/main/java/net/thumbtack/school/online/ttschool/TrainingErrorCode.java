package net.thumbtack.school.online.ttschool;

public enum TrainingErrorCode {

    TRAINEE_WRONG_FIRSTNAME ("You cannot pass null"), // ошибка при передаче неверного имени
    TRAINEE_WRONG_LASTNAME ("You cannot pass null"), // ошибка при передаче неверной фамилии
    TRAINEE_WRONG_RATING ("The rating is not valid"), // ошибка при передаче недопустимой оценки
    GROUP_WRONG_NAME ("The group name is not valid"), // ошибка при передаче недопустимого названия группы
    GROUP_WRONG_ROOM ("The group name is not valid"), // ошибка при передаче недопустимого названия аудитории
    TRAINEE_NOT_FOUND ("Trainee not found"), // ошибка при удалении несуществующего студента из списка
    SCHOOL_WRONG_NAME ("School wrong name"), // ошибка при передаче неверного имени
    SCHOOL_WRONG_YEAR ("School wrong year"), // ошибка при передаче неверного года
    DUPLICATE_GROUP_NAME ("Duplicate group name"), // ошибка при добавлении дубликата
    GROUP_NOT_FOUND ("Group not found"), // ощибка при удалении группы
    DUPLICATE_TRAINEE ("Duplicate trainee"), // ошибка при добавлении дубликата
    EMPTY_TRAINEE_QUEUE ("Empty trainee queue"); // ошибка при удалении элемента из пустой очереди



    private String errorString;

    public String getErrorString() {
        return errorString;
    }

    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }

    TrainingErrorCode(String errorString) {
        setErrorString(errorString);
    }
}
