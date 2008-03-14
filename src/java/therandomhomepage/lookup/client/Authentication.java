package therandomhomepage.lookup.client;

import com.google.gwt.http.client.*;

public class Authentication {

    private static String token = null;

    public static void login(final LoginCallback callback) {

        String url = "https://www.google.com/accounts/ClientLogin";
        RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, url);
        builder.setHeader("Content-type", "application/x-www-form-urlencoded");
        try {
            String postData = "accountType=GOOGLE&Email=" + email + "&Passwd=" + passwd + "&source=GoogleLookup&service=wise";
            builder.sendRequest(postData, new RequestCallback() {
                public void onError(Request request, Throwable exception) {
                    exception.printStackTrace();
                    callback.onFailure();
                }

                public void onResponseReceived(Request request, Response response) {
                    String responseText = response.getText();
                    token = parseAuth(responseText);
                    System.out.println("Login Successful");
                    callback.onSuccess();
                }
            });
        } catch (RequestException e) {
            e.printStackTrace();
        }
    }


    public static String getToken() {
        if (token != null) {
            return token;
        }
        return token;
    }

    static String parseAuth(String s) {
        int i = s.indexOf("Auth");
        return s.substring(i + 5, s.length() - 1);
    }
}
