package net.thumbtack.school.online.ttschool;

public class TrainingException extends Exception {
    private TrainingErrorCode errorCode;

    public TrainingErrorCode getErrorCode() {
        return errorCode;
    }

    public void setTrainingErrorCode(TrainingErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public TrainingException(TrainingErrorCode trainingErrorCode) {
        super(trainingErrorCode.getErrorString());
        setTrainingErrorCode(trainingErrorCode);
    }

    public TrainingException(TrainingErrorCode trainingErrorCode, String param) {
        super(String.format(trainingErrorCode.getErrorString(), param));
    }

    public TrainingException(TrainingErrorCode trainingErrorCode, Throwable cause) {
        super(trainingErrorCode.getErrorString(), cause);
    }
}
