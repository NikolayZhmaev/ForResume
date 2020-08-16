package net.thumbtack.school.online.windows.v4.base;

public enum WindowErrorCode {
    WRONG_STATE("Error window state"),     /* При создании окна передается WindowState.DESTROYED или null.
                                               При изменении состояния, состояние устанавливается в null или окно,
                                               находящееся в WindowState.DESTROYED, переводится в иное состояние. */
    WRONG_INDEX("The index is not valid"), // Передан недопустимый индекс для массива строк.
    EMPTY_ARRAY("The array is empty"),     // Массив строк равен null.
    NULL_WINDOW("You cannot pass null");   // вместо окна передается ноль.

    private String errorString;

    public String getErrorString() {
        return errorString;
    }

    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }

    WindowErrorCode(String errorString) {
        setErrorString(errorString);
    }
}
