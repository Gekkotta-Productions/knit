print '{"knittens":';
print json_encode($rows);
print '}';
<?php

$objConnect = mysql_connect("localhost","root","");
$objDB = mysql_select_db("knits");

$val = $_GET["q"];

$query = "SELECT * FROM knitters WHERE projID='$val'";

$objQuery = mysql_query($query);

$rows = array();

while ($r = mysql_fetch_assoc($objQuery)){
	$rows[] = $r;;
}
echo '{"knittens":'
echo json_encode($rows);
echo '}';
?>
