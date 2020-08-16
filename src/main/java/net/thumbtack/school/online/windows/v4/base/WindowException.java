package net.thumbtack.school.online.windows.v4.base;

public class WindowException extends Exception {

    private WindowErrorCode windowErrorCode;

    public WindowErrorCode getWindowErrorCode() {
        return windowErrorCode;
    }

    public void setWindowErrorCode(WindowErrorCode windowErrorCode) {
        this.windowErrorCode = windowErrorCode;
    }

    public WindowException(WindowErrorCode errorCode, Throwable cause) {
        super(errorCode.getErrorString(), cause);
    }

    public WindowException(WindowErrorCode errorCode) {
        super(errorCode.getErrorString());
        setWindowErrorCode(errorCode);
    }

    public WindowException(WindowErrorCode errorCode, String param) {
        super(String.format(errorCode.getErrorString(), param));
    }
}
