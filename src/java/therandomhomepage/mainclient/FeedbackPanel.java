package therandomhomepage.mainclient;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 25, 2006
 * Time: 5:13:52 PM
 */
public class FeedbackPanel extends Composite {

    TextArea txtMessage;

    public FeedbackPanel() {

        NamedFrame mailFrame = new NamedFrame("mailFrame");
        mailFrame.setHeight("0px");
        mailFrame.setWidth("0px");

        final FormPanel form = new FormPanel(mailFrame);
        form.setAction("/php/sendMail.php");

        form.setEncoding(FormPanel.ENCODING_URLENCODED);
        form.setMethod(FormPanel.METHOD_POST);

        VerticalPanel panel = new VerticalPanel();
        panel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
        panel.setVerticalAlignment(VerticalPanel.ALIGN_TOP);


        panel.add(form);

        panel.add(mailFrame);

        initWidget(panel);

        FlexTable table = new FlexTable();
        table.setStyleName("FeedbackForm");

        table.setWidget(0, 0, new HTML("<h3>Feedback</h3>"));

        table.setWidget(1, 0, new Label("Name: "));
        TextBox txtName = new TextBox();
        txtName.setName("txtName");
        table.setWidget(1, 1, txtName);

        table.setWidget(2, 0, new Label("Email: "));
        TextBox txtEmail = new TextBox();
        txtEmail.setName("txtEmail");
        table.setWidget(2, 1, txtEmail);

        table.setWidget(3, 0, new Label("Subject: "));

        ListBox subject = new ListBox();
        subject.setName("selSubject");
        subject.addItem("General", "General");
        subject.addItem("Comments", "Comments");
        subject.addItem("Suggestion", "Suggestion");
        subject.addItem("Bug report", "Bug report");
        subject.addItem("Others", "Others");

        table.setWidget(3, 1, subject);

        table.setWidget(4, 0, new Label("Message: "));

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

//        table.getFlexCellFormatter().setColSpan(5, 0, 2);
        table.setWidget(5, 0, btnSubmit);

        form.add(table);

        // Add an event handler to the form.
        form.addFormHandler(new FormHandler() {
            public void onSubmitComplete(FormSubmitCompleteEvent event) {
                // do nothing
            }

            public void onSubmit(FormSubmitEvent event) {
                // This event is fired just before the form is submitted. We can take
                // this opportunity to perform validation.


                if (txtMessage.getText().length() == 0) {
                    Window.alert("Please provide ");
                    event.setCancelled(true);
                }
            }
        });


    }
}
