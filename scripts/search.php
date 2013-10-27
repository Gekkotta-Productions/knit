<?php
$objConnect = mysql_connect("localhost","root","");
$objDB = mysql_select_db("knits");

$search = $_GET["query"];

$query = "SELECT `projID`,`name`,`image` FROM projects WHERE description LIKE '%$search%'";

$objQuery = mysql_query($query);

$rows = array();

while ($r = mysql_fetch_assoc($objQuery)){
	$rows[] = $r;
}

print '{"knittens":';
print json_encode($rows);
print '}';

?>
