<?php
	$from_name =  $_GET["txtName"];
	$from_email = $_GET["txtEmail"];
	$subject = $_GET["selSubject"];
	$message = $_GET["txtMessage"];

	$to_email = "feedback@therandomhomepage.com";

	mail($to_email, $subject, $message,
     "From: $from_name<$from_email>\r\n" .
     "Reply-To: $from_name<$from_email>\r\n");
    header('Content-type: text/plain');
	echo "Success";
?>