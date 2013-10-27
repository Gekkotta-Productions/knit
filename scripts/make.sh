i=1;
while read p; do
	echo "INSERT INTO knitters VALUES (2,$i,'$p')";
	i=$(($i+1));
done < pattern
