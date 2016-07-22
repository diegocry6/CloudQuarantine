
#!/usr/bin/bash

echo "Demonio de Cuarentena SAMBA Funcionando"

while true

do
oldsize=$(du -s /home/debian/cuarentena)
sleep 0.001
newsize=$(du -s /home/debian/cuarentena)

if [ "$oldsize" != "$newsize" ]
then 
   owner=$(stat -c %U /home/debian/cuarentena/*)
   files=$(ls /home/debian/cuarentena)

	echo "INSERT INTO Owners VALUES ('','$files','$owner');" | mysql -u -p sambaLOG;

   sleep 5
   mv /home/debian/cuarentena/* /home/debian/.temporal 
   wait
   clamscan -r /home/debian/.temporal --move=/home/debian/cuarentena -l /home/debian/.clamAVLogs/.CLAMAV-"$(date)".log
   echo "Analisis Finalizado - $(date)" >> /home/debian/.log.log

   wait

   mv /home/debian/.temporal/* /home/debian/disponibles
   wait
   sh /home/debian/.parseLOG.sh 
fi
done
