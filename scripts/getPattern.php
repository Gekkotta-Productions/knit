<?php

$objConnect = mysql_connect("localhost","root","");
$objDB = mysql_select_db("knits");

$query = "SELECT * FROM knitters WHERE projID='1'";

$objQuery = mysql_query($query);

$rows = array();

while ($r = mysql_fetch_assoc($objQuery)){
	$rows[] = $r;
	print json_encode($r);
}
?>
