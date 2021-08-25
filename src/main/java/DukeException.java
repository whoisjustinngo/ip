abstract class DukeException extends Exception {

    DukeException(String message) {
        super(message);
    }

    static class InvalidCommandException extends DukeException {
        InvalidCommandException(String message) {
            super(message);
        }
    }
    
    static class InvalidTaskDescriptionException extends DukeException {
        InvalidTaskDescriptionException(String message) {
            super(message);
        }
    }
    
    static class DuplicateTaskException extends DukeException {
        DuplicateTaskException(String message) {
            super(message);
        }
    }
    
    static class InvalidTaskNumException extends DukeException {
        InvalidTaskNumException(String message) {
            super(message);
        }
    }
    
    static class NoSuchTaskException extends DukeException {
        NoSuchTaskException(String message) {
            super(message);
        }
    }
    
    static class TaskAlreadyCompleteException extends  DukeException {
        TaskAlreadyCompleteException(String message) {
            super(message);
        }
    }
    
    static class EmptyTaskListException extends DukeException {
        EmptyTaskListException(String message) {
            super(message);
        }
    }
}
