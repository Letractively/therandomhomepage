package therandomhomepage.mainclient;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 25, 2006
 * Time: 5:13:52 PM
 */
public class FeedbackPanel extends Composite {

    private TextBox txtEmail;
    private TextArea txtMessage;
    private VerticalPanel panel;
    private FlexTable table;


    public FeedbackPanel() {

        NamedFrame mailFrame = new NamedFrame("mailFrame");
        mailFrame.setVisible(false);

        final FormPanel form = new FormPanel(mailFrame);
        form.setAction("/php/sendMail.php");

        form.setEncoding(FormPanel.ENCODING_URLENCODED);
        form.setMethod(FormPanel.METHOD_POST);

        panel = new VerticalPanel();
        panel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
        panel.setVerticalAlignment(VerticalPanel.ALIGN_TOP);


        panel.add(form);

        panel.add(mailFrame);

        initWidget(panel);

        table = new FlexTable();
        table.addStyleName("divBlock");
        table.addStyleName("feedbackForm");

        table.setWidget(0, 0, new HTML("<h3>Feedback</h3>"));

        table.setWidget(1, 0, new Label("Name: "));
        table.getFlexCellFormatter().setVerticalAlignment(1, 0, HasVerticalAlignment.ALIGN_TOP);

        TextBox txtName = new TextBox();
        txtName.setName("txtName");
        table.setWidget(1, 1, txtName);

        table.setWidget(2, 0, new Label("Email: "));
        table.getFlexCellFormatter().setVerticalAlignment(2, 0, HasVerticalAlignment.ALIGN_TOP);

        txtEmail = new TextBox();
        txtEmail.setName("txtEmail");
        table.setWidget(2, 1, txtEmail);

        table.setWidget(3, 0, new Label("Subject: "));
        table.getFlexCellFormatter().setVerticalAlignment(3, 0, HasVerticalAlignment.ALIGN_TOP);

        ListBox subject = new ListBox();
        subject.setName("selSubject");
        subject.addItem("General", "General");
        subject.addItem("Comments", "Comments");
        subject.addItem("Suggestion", "Suggestion");
        subject.addItem("Bug report", "Bug report");
        subject.addItem("Others", "Others");

        table.setWidget(3, 1, subject);

        table.setWidget(4, 0, new Label("Message: "));
        table.getFlexCellFormatter().setVerticalAlignment(4, 0, HasVerticalAlignment.ALIGN_TOP);

        txtMessage = new TextArea();
        txtMessage.setName("txtMessage");
        txtMessage.setCharacterWidth(50);
        txtMessage.setVisibleLines(8);
        table.setWidget(4, 1, txtMessage);

        Button btnSubmit = new Button("Submit", new ClickListener() {
            public void onClick(Widget sender) {
                form.submit();
            }
        });

        table.setWidget(5, 0, btnSubmit);

        form.add(table);

        form.addFormHandler(new FormHandler() {
            public void onSubmitComplete(FormSubmitCompleteEvent event) {
                Window.alert(event.getResults());
            }

            public void onSubmit(FormSubmitEvent event) {
                if (txtEmail.getText().trim().length() == 0) {
                    Window.alert("Please provide your email address !");
                    event.setCancelled(true);
                    txtEmail.setFocus(true);
                } else if (txtMessage.getText().trim().length() == 0) {
                    Window.alert("Please provide feedback !");
                    event.setCancelled(true);
                    txtMessage.setFocus(true);
                }
                table.clear();
                HTML thanksHTML = new HTML("<h4>We really appreciate your feedback. Thanks a lot !</h4");
                table.setWidget(0, 0, thanksHTML);
                DOM.setAttribute(table.getWidget(0, 0).getElement(), "align", "center");
                DOM.setAttribute(table.getCellFormatter().getElement(0, 0), "width", "100%");
            }
        });


    }
}
