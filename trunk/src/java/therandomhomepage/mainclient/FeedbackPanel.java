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

        final FormPanel form = new FormPanel();
        form.setAction("/php/sendMail.php");

        form.setMethod(FormPanel.METHOD_POST);

        VerticalPanel panel = new VerticalPanel();
        panel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
        panel.setVerticalAlignment(VerticalPanel.ALIGN_TOP);

        form.setWidget(panel);

        initWidget(panel);

        FlexTable table = new FlexTable();
        table.setStyleName("divBlock");

        table.setWidget(0, 0, new Label("Name: "));
        TextBox txtName = new TextBox();
        txtName.setName("txtName");
        table.setWidget(0, 1, txtName);

        table.setWidget(1, 0, new Label("Email: "));
        TextBox txtEmail = new TextBox();
        txtEmail.setName("txtEmail");
        table.setWidget(1, 1, txtEmail);

        table.setWidget(2, 0, new Label("Subject: "));

        ListBox subject = new ListBox();
        subject.setName("selSubject");
        subject.addItem("General");
        subject.addItem("Comments");
        subject.addItem("Suggestion");
        subject.addItem("Bug report");
        subject.addItem("Others");

        table.setWidget(2, 1, subject);

        table.setWidget(3, 0, new Label("Message: "));


        txtMessage = new TextArea();
        txtMessage.setName("txtMessage");
        txtMessage.setCharacterWidth(100);
        txtMessage.setVisibleLines(10);
        table.setWidget(3, 1, txtMessage);



        // Add a 'submit' button.
        Button btnSubmit = new Button("Submit", new ClickListener() {
            public void onClick(Widget sender) {
                Window.alert("Submitting form");
                form.submit();
            }
        });

        table.getFlexCellFormatter().setColSpan(4, 0, 2);
        table.setWidget(4,0,btnSubmit);

        panel.add(table);

        // Add an event handler to the form.
        form.addFormHandler(new FormHandler() {
            public void onSubmitComplete(FormSubmitCompleteEvent event) {
                // When the form submission is successfully completed, this event is
                // fired. Assuming the service returned a response of type text/plain,
                // we can get the result text here (see the FormPanel documentation for
                // further explanation).
                Window.alert(event.getResults());
            }

            public void onSubmit(FormSubmitEvent event) {
                // This event is fired just before the form is submitted. We can take
                // this opportunity to perform validation.
                if (txtMessage.getText().length() == 0) {
                    Window.alert("The text box must not be empty");
                    event.setCancelled(true);
                }
            }
        });

    }
}
