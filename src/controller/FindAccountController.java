package controller;

//<<<<<<< HEAD
//=======
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

//<<<<<<< HEAD
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//>>>>>>> abc
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

//=======
//>>>>>>> abc
public class FindAccountController implements Initializable {
	@FXML
	private AnchorPane paneFind;

	@FXML
	private FlowPane inputPane;

	@FXML
	private TextField mailID;

	@FXML
	private PasswordField mailPW;

	@FXML
	private ComboBox<String> cmbBoxSite;

	@FXML
	private Button btnFindPW;

	private TextField inputField;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> siteList = cmbBoxSite.getItems();
		siteList.add("naver.com");
		siteList.add("gmail.com");
		siteList.add("daum.net");
		siteList.add("Á÷Á¢ ÀÔ·Â");

		cmbBoxSite.getSelectionModel().selectedItemProperty().addListener(event -> cmbBoxSiteListener());
	}

	public void cmbBoxSiteListener() {
		boolean existFlag = true;
		try {
			inputPane.getChildren().get(1);
		} catch (IndexOutOfBoundsException e) {
			existFlag = false;
		}

		if (cmbBoxSite.getSelectionModel().getSelectedIndex() == 3) {
			inputField = new TextField();
			inputField.setPrefWidth(130);
			inputPane.getChildren().add(0, inputField);
		} else {
			if (existFlag) {
				inputPane.getChildren().remove(0);
			}
		}
	}

	public void btnFindPWHandler() {
		// Get password from db
		String password = "123";

		String mailSite = cmbBoxSite.getSelectionModel().getSelectedItem().toString();

		String recipient = mailID.getText() + "@" + mailSite;
		String host = "smtp." + mailSite;
		String mailPassword = mailPW.getText();

		String subject = "E-Dieter Password!"; // ï¿½ï¿½ï¿½ï¿½
		String body = "Your password is " + password; // ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½

		// properties ï¿½ï¿½ï¿½ï¿½
		Properties props = new Properties();
		props.put("mail.smtps.auth", "true");

		// ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
		Session session = Session.getDefaultInstance(props);
		MimeMessage msg = new MimeMessage(session);

		// ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
		try {
			msg.setSubject(subject);
			msg.setText(body);
			msg.setFrom(new InternetAddress(recipient));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

			// ï¿½ß¼ï¿½ Ã³ï¿½ï¿½
			Transport transport = session.getTransport("smtps");
			transport.connect(host, recipient, mailPassword);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
		} catch (MessagingException e) {
			e.printStackTrace();

			Alert failAlert = new Alert(Alert.AlertType.ERROR);
			failAlert.setHeaderText(null);
			failAlert.setContentText("ï¿½ï¿½Ïµï¿? ï¿½Ì¸ï¿½ï¿½ï¿½ ï¿½Ö¼Ò°ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½Ï´ï¿½.");
			failAlert.showAndWait();
			return;
		}

		Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
		successAlert.setHeaderText(null);
		successAlert.setContentText("ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ È®ï¿½ï¿½ï¿½ï¿½ï¿½Ö¼ï¿½ï¿½ï¿½!");
		successAlert.showAndWait();

	}

}
