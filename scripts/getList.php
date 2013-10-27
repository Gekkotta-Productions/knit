<?php
$objConnect = mysql_connect("localhost","root","");
$objDB = mysql_select_db("knits");

$query = "SELECT * FROM projects WHERE projID='1'";

$objQuery = mysql_query($query);

print json_encode(mysql_fetch_assoc($objQuery));

?>
