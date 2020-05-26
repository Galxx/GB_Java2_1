package HW4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;


public class Controller {

    @FXML
    TextArea Message;

    @FXML
    TextArea Chat;

    public void btnOneClickAction(ActionEvent actionEvent) {
        Chat.appendText( Message.getText() +"\n");
        Message.clear();
    }

    public void txtOnKeyPressed(KeyEvent keyEvent) {
       if (keyEvent.getText().equals("\r")){
           Chat.appendText(Message.getText());
           Message.clear();
       }
    }

}

