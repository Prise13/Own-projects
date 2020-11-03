package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textField1;

    @FXML
    private TextField textField2;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private RadioButton radio1;

    @FXML
    private ToggleGroup group;

    @FXML
    private RadioButton radio2;

    @FXML
    void initialize() {
        btn1.setOnAction(event -> {
            if (radio1.isSelected()) {
                Character[] l = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7',
                        '8', '9'};
                ArrayList<Character> alphabet = new ArrayList<>(Arrays.asList(l));
                String encryptedMessage = "";
                if (!textField1.getText().isEmpty()) {
                    String plainText = textField1.getText().toLowerCase();
                    for (int i = 0; i < plainText.length(); i++) {
                        if (alphabet.indexOf(plainText.charAt(i)) < alphabet.size() - 1) {
                            encryptedMessage += alphabet.get(alphabet.indexOf(plainText.charAt(i)) + 1);
                        } else {
                            encryptedMessage += plainText.charAt(i);
                        }
                    }
                } else {
                    textField1.setText("Field must not be empty");
                }
                textField2.setText(encryptedMessage);
            }
            else {
                try {
                    if (!textField1.getText().isEmpty()) {
                        textField2.setText(Base64.getEncoder().encodeToString(textField1.getText().getBytes()));
                    } else {
                        textField1.setText("Field must not be empty");
                    }
                }
                catch (IllegalArgumentException e) {
                    textField1.setText("Cant be converted to Base64");
                }
            }
        });
        btn2.setOnAction(event -> {
            if (radio1.isSelected()) {
                Character[] l = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7',
                        '8', '9'};
                ArrayList<Character> alphabet = new ArrayList<>(Arrays.asList(l));
                String decryptedMessage = "";
                if (!textField1.getText().isEmpty()) {
                    String plainText = textField1.getText().toLowerCase();
                    for (int i = 0; i < plainText.length(); i++) {
                        if (alphabet.indexOf(plainText.charAt(i)) > 0) {
                            decryptedMessage += alphabet.get(alphabet.indexOf(plainText.charAt(i)) - 1);
                        } else {
                            decryptedMessage += plainText.charAt(i);
                        }
                    }
                } else {
                    textField1.setText("Field must not be empty");
                }
                textField2.setText(decryptedMessage);
            }
            else {
                try {
                    if (!textField1.getText().isEmpty()) {
                        textField2.setText(new String(Base64.getDecoder().decode(textField1.getText())));
                    } else {
                        textField1.setText("Field must not be empty");
                    }
                }
                catch (IllegalArgumentException e) {
                    textField1.setText("Cant be converted to base64");
                }
            }
        });
    }
}

