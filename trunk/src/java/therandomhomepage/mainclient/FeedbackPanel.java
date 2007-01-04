/*
 * Copyright 2006 Siddique Hameed <siddii AT gmail.com> - http://www.TheRandomHomepage.com
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

    private TextBox txtEmail;
    private TextArea txtMessage;
    private FlexTable table;
    Button btnSubmit;

    public FeedbackPanel() {

        NamedFrame mailFrame = new NamedFrame("mailFrame");
        mailFrame.setVisible(false);

        final FormPanel form = new FormPanel(mailFrame);
        form.setAction("/php/sendMail.php");

        form.setMethod(FormPanel.METHOD_GET);
        form.setEncoding(FormPanel.ENCODING_URLENCODED);

        VerticalPanel panel = new VerticalPanel();
        panel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
        panel.setVerticalAlignment(VerticalPanel.ALIGN_TOP);


        panel.add(form);

        panel.add(mailFrame);

        initWidget(panel);

        table = new FlexTable();
        table.addStyleName("divBlock");
        table.addStyleName("feedbackForm");

        table.setWidget(1, 0, new HTML("<h3>Feedback</h3>"));

        table.setWidget(2, 0, new Label("Name: "));
        table.getFlexCellFormatter().setVerticalAlignment(1, 0, HasVerticalAlignment.ALIGN_TOP);

        TextBox txtName = new TextBox();
        txtName.setName("txtName");
        table.setWidget(2, 1, txtName);

        table.setWidget(3, 0, new Label("Email: "));
        table.getFlexCellFormatter().setVerticalAlignment(2, 0, HasVerticalAlignment.ALIGN_TOP);

        txtEmail = new TextBox();
        txtEmail.setName("txtEmail");
        table.setWidget(3, 1, txtEmail);

        table.setWidget(4, 0, new Label("Subject: "));
        table.getFlexCellFormatter().setVerticalAlignment(3, 0, HasVerticalAlignment.ALIGN_TOP);

        ListBox subject = new ListBox();
        subject.setName("selSubject");
        subject.addItem("General", "General");
        subject.addItem("Comments", "Comments");
        subject.addItem("Suggestion", "Suggestion");
        subject.addItem("Bug report", "Bug report");
        subject.addItem("Others", "Others");

        table.setWidget(4, 1, subject);

        table.setWidget(5, 0, new Label("Message: "));
        table.getFlexCellFormatter().setVerticalAlignment(4, 0, HasVerticalAlignment.ALIGN_TOP);

        txtMessage = new TextArea();
        txtMessage.setName("txtMessage");
        txtMessage.setCharacterWidth(50);
        txtMessage.setVisibleLines(8);
        table.setWidget(5, 1, txtMessage);


        btnSubmit = new Button("Submit", new ClickListener() {
            public void onClick(Widget sender) {
                form.submit();
            }
        });

        table.setWidget(6, 0, btnSubmit);

        form.add(table);

        form.addFormHandler(new FormHandler() {
            public void onSubmitComplete(FormSubmitCompleteEvent event) {
                //ignore this
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
                } else {
                    HTML thanksHTML = new HTML("<b class=\"thanks\">We really appreciate your feedback. Thanks a lot !</b>");
                    table.setWidget(0, 1, thanksHTML);
                    btnSubmit.setEnabled(false);
                }
            }
        });
    }
}
