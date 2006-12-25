package therandomhomepage.mainclient;

import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.Window;

/**
 * Created by IntelliJ IDEA.
 * User: Siddique Hameed
 * Date: Dec 25, 2006
 * Time: 5:13:52 PM
 */
public class FeedbackPanel {

    public FeedbackPanel() {

        final FormPanel form = new FormPanel();
        form.setAction("/php/sendMail.php");

        form.setMethod(FormPanel.METHOD_POST);

        VerticalPanel panel = new VerticalPanel();
        form.setWidget(panel);

        Label name = new Label("Your Name: ");

        // Create a TextBox, giving it a name so that it will be submitted.
        final TextBox tb = new TextBox();
        tb.setName("textBoxFormElement");
        panel.add(tb);

        // Create a ListBox, giving it a name and some values to be associated with
        // its options.
        ListBox lb = new ListBox();
        lb.setName("listBoxFormElement");
        lb.addItem("foo", "fooValue");
        lb.addItem("bar", "barValue");
        lb.addItem("baz", "bazValue");
        panel.add(lb);


        // Add a 'submit' button.
        panel.add(new Button("Submit", new ClickListener() {
            public void onClick(Widget sender) {
                form.submit();
            }
        }));

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
                if (tb.getText().length() == 0) {
                    Window.alert("The text box must not be empty");
                    event.setCancelled(true);
                }
            }
        });

    }
}
