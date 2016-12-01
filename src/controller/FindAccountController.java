package controller;

import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
import network.Assembleddata;

public class FindAccountController implements Initializable {
	/**
	 * created by Jin Jung on 2016. 11. 30..
	 */
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

	private TextField inputField = null;

	/**
	 * */

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/**
		 * created by Jin Jung on 2016. 11. 30.. function : add items on site
		 * combobox loc : 8
		 */
		// add items on cmbBoxSite
		ObservableList<String> siteList = cmbBoxSite.getItems();
		siteList.add("naver.com");
		siteList.add("gmail.com");
		siteList.add("daum.net");
		siteList.add("직접 입력");

		// set handler on cmbBoxSite
		cmbBoxSite.getSelectionModel().selectedItemProperty().addListener(event -> cmbBoxSiteListener());
		/** 
		 * */
	}

	public void cmbBoxSiteListener() {
		/**
		 * created by Jin Jung function : handle cmbBoxSite loc : 18
		 */
		boolean existFlag = true; // inputField existence flag
		try {
			inputPane.getChildren().get(1); // check if there is inputField
		} catch (IndexOutOfBoundsException e) {
			existFlag = false;
		}

		// if user select last item of cmbBoxSite
		if (cmbBoxSite.getSelectionModel().getSelectedIndex() == 3) {
			inputField = new TextField();
			inputField.setPrefWidth(130);
			inputPane.getChildren().add(0, inputField);
		} else {
			if (existFlag) {
				inputPane.getChildren().remove(0); // remove inputField
				inputField = null;
			}
		}
		/** 
		 * */
	}

	public void btnFindPWHandler() {
		/**
		 * created by Jin Jung on 2016. 11. 30.. function : send password to
		 * user's email loc : 54
		 */

		String password = Assembleddata.getpw(); // get user's password

		String mailSite = null;

		if (inputField == null) // check if there is inputField
			mailSite = cmbBoxSite.getSelectionModel().getSelectedItem().toString();
		else
			mailSite = inputField.getText();

		// recipient info
		String recipient = mailID.getText() + "@" + mailSite;
		String host = "smtp." + mailSite;
		String mailPassword = mailPW.getText();

		String subject = "E-Dieter Password!"; // subject of mail
		String body = "Your password is " + password; // body of mail

		// setting properties
		Properties props = new Properties();
		props.put("mail.smtps.auth", "true");

		// mail session
		Session session = Session.getDefaultInstance(props);
		MimeMessage msg = new MimeMessage(session);

		// send email
		try {
			// set message
			msg.setSubject(subject);
			msg.setText(body);
			msg.setFrom(new InternetAddress(recipient));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

			// transport setting
			Transport transport = session.getTransport("smtps");
			transport.connect(host, recipient, mailPassword);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
		} catch (MessagingException e) {
			// if there is send error!
			e.printStackTrace();

			// fail alert
			Alert failAlert = new Alert(Alert.AlertType.ERROR);
			failAlert.setHeaderText(null);
			failAlert.setContentText("Send Fail! Try again!");
			failAlert.showAndWait();
			return;
		}

		// success alert
		Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
		successAlert.setHeaderText(null);
		successAlert.setContentText("Send Success! Please check your email!");
		successAlert.showAndWait();
		/** 
		 * */
	}

}
