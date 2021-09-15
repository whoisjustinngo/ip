package duke;

import java.util.Objects;
//import java.util.concurrent.TimeUnit;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;

    private Duke duke;

    private final Image userImage = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/images"
            + "/DaUser.png")));
    private final Image dukeImage = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/images"
            + "/me.jpg")));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    public void setDuke(Duke d) {
        duke = d;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText().trim();
        assert input.length() > 0 : "invalid user input: blank line";
        if (input.equals("bye")) {
            this.closeApp();
        }
        String response = duke.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getDukeDialog(response, dukeImage)
        );
        userInput.clear();
    }

    private void closeApp() {
        javafx.application.Platform.exit();
    }

    void sendMessageToUser(String message) {
        dialogContainer.getChildren().add(0, DialogBox.getDukeDialog(message, dukeImage));
    }
}
