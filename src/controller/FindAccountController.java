package controller;

<<<<<<< HEAD
=======
import java.net.URL;
import java.util.ResourceBundle;

>>>>>>> abc
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

<<<<<<< HEAD
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

=======
>>>>>>> abc
public class FindAccountController implements Initializable {
	@FXML
	private AnchorPane paneFind;

	@FXML
	private FlowPane inputPane;

	@FXML
	private TextField emailField;

	@FXML
	private ComboBox<String> cmbBoxSite;

	@FXML
	private Button btnFindPW;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> siteList = cmbBoxSite.getItems();
		siteList.add("naver.com");
		siteList.add("gmail.com");
		siteList.add("daum.net");
<<<<<<< HEAD
		siteList.add("ï¿½ï¿½ï¿½ï¿½ ï¿½Ô·ï¿½");
=======
		siteList.add("Á÷Á¢ ÀÔ·Â");
>>>>>>> abc

		cmbBoxSite.getSelectionModel().selectedItemProperty().addListener(event -> cmbBoxSiteListener());
	}

	public void cmbBoxSiteListener() {
		TextField inputField;
<<<<<<< HEAD
		// ï¿½ï¿½ï¿½ï¿½ ï¿½Ô·ï¿½ ï¿½Ø½ï¿½Æ® ï¿½Êµï¿½ ï¿½ï¿½ï¿½ï¿½ È®ï¿½ï¿½
=======
		// Á÷Á¢ ÀÔ·Â ÅØ½ºÆ® ÇÊµå À¯¹« È®ÀÎ
>>>>>>> abc
		boolean existFlag = true;
		try {
			inputPane.getChildren().get(1);
		} catch (IndexOutOfBoundsException e) {
			existFlag = false;
		}

<<<<<<< HEAD
		if (cmbBoxSite.getSelectionModel().getSelectedItem() == "ï¿½ï¿½ï¿½ï¿½ ï¿½Ô·ï¿½") {
=======
		if (cmbBoxSite.getSelectionModel().getSelectedItem() == "Á÷Á¢ ÀÔ·Â") {
>>>>>>> abc
			inputField = new TextField();
			inputField.setPrefWidth(130);
			inputPane.getChildren().add(0, inputField);
		} else {
<<<<<<< HEAD
			// ï¿½ï¿½ï¿½ï¿½ ï¿½Ô·ï¿½ ï¿½Ø½ï¿½Æ® ï¿½Êµå°¡ ï¿½ï¿½ï¿½ï¿½ï¿½Ï¸ï¿½
=======
			// Á÷Á¢ ÀÔ·Â ÅØ½ºÆ® ÇÊµå°¡ Á¸ÀçÇÏ¸é
>>>>>>> abc
			if(existFlag) {
				inputPane.getChildren().remove(0);
			}
		}
	}

	public void btnFindPWHandler() {
<<<<<<< HEAD
		// DBï¿½ï¿½ï¿½ï¿½ ï¿½Ì¸ï¿½ï¿½ï¿½ ï¿½Ö¼Ò¸ï¿½ Ã£ï¿½Æ¼ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ È®ï¿½ï¿½ ï¿½Ë¸ï¿½
		Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
		successAlert.setHeaderText(null);
		successAlert.setContentText("ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ È®ï¿½ï¿½ï¿½ï¿½ï¿½Ö¼ï¿½ï¿½ï¿½!");
		successAlert.showAndWait();

		// Ã£ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ ï¿½ï¿½Ïµï¿½ ï¿½Ì¸ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½Ù°ï¿½ ï¿½Ë¸ï¿½
		Alert failAlert = new Alert(Alert.AlertType.ERROR);
		failAlert.setHeaderText(null);
		failAlert.setContentText("ï¿½ï¿½Ïµï¿½ ï¿½Ì¸ï¿½ï¿½ï¿½ ï¿½Ö¼Ò°ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½Ï´ï¿½.");
		failAlert.showAndWait();
	}
	
	public void sendMail() throws MessagingException {
		 // ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
        String host = "smtp.gmail.com";
        String username = "ï¿½ï¿½ï¿½ï¿½ï¿½Ï¾ï¿½ï¿½Ìµï¿½@gmail.com";
        String password = "ï¿½ï¿½Ð¹ï¿½È£";
         
        // ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
        String recipient = "ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½Ö¼ï¿½"; // ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½Ö¼ï¿½
        String subject = "ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ß¼ï¿½ ï¿½×½ï¿½Æ®ï¿½Ô´Ï´ï¿½."; // ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
        String body = "ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½"; // ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
         
        //properties ï¿½ï¿½ï¿½ï¿½
        Properties props = new Properties();
        props.put("mail.smtps.auth", "true");
        // ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
        Session session = Session.getDefaultInstance(props);
        MimeMessage msg = new MimeMessage(session);
 
        // ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
        msg.setSubject(subject);
        msg.setText(body);
        msg.setFrom(new InternetAddress(username));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
 
        // ï¿½ß¼ï¿½ Ã³ï¿½ï¿½
        Transport transport = session.getTransport("smtps");
        transport.connect(host, username, password);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();  
	}
=======
		// DB¿¡¼­ ÀÌ¸ÞÀÏ ÁÖ¼Ò¸¦ Ã£¾Æ¼­ ÀÖÀ» °æ¿ì ¸ÞÀÏ È®ÀÎ ¾Ë¸²
		Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
		successAlert.setHeaderText(null);
		successAlert.setContentText("¸ÞÀÏÀ» È®ÀÎÇØÁÖ¼¼¿ä!");
		successAlert.showAndWait();

		// Ã£Áö ¸øÇÒ °æ¿ì µî·ÏµÈ ÀÌ¸ÞÀÏ ¾ø´Ù°í ¾Ë¸²
		Alert failAlert = new Alert(Alert.AlertType.ERROR);
		failAlert.setHeaderText(null);
		failAlert.setContentText("µî·ÏµÈ ÀÌ¸ÞÀÏ ÁÖ¼Ò°¡ ¾ø½À´Ï´Ù.");
		failAlert.showAndWait();
	}
	
>>>>>>> abc
}
