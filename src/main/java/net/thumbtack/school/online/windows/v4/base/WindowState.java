package net.thumbtack.school.online.windows.v4.base;

public enum WindowState {
    ACTIVE,
    INACTIVE,
    DESTROYED;

    public static WindowState fromString(String stateString) {
        if (stateString == null) {
            return null;
        }
        switch (stateString) {
            case "ACTIVE":
                return WindowState.ACTIVE;
            case "INACTIVE":
                return WindowState.INACTIVE;
            case "DESTROYED":
                return WindowState.DESTROYED;
            default:
                return null;
        }
    }
}
