El padding oracle consiste en resumen en enviar bloques del mensaje cifrado
a atacar con un padding aleatorio a�adido para que el servidor diga:

A) El padding es incorrecto -> se prueba otro padding
B) El padding es correcto -> se pasa al siguente bloque

As� pues, el c�digo realiza esta funci�n, coge bloques del texto cifrado que
se incluye y va probando distintos padding obteniendo respuestas del servidor.

Ahora, esto se puede solventar de dos formas:

A) Que el servidor no detalle que el problema al descifrar ha sido el padding
B) Implementar un hashing del texto cifrado (modo Cifra y Autentica)

Al implementar Cifra y auntentica, el servidor antes de realizar ninguna tarea 
de descifrado, comprueba que el hashing del texto a descifrar recibido. Al ser
este hashing err�neo, el servidor no va a realizar ning�n tipo de descifrado, por
lo que el atacante no va a recibir informaci�n.

El problema de autentica y cifra y autentica y luego cifra es que antes de comprobar 
hashing ya es necesario realizar un descifrado, por lo que aunque se detecte que
el mensaje no es �ntegro el atacante ya ha obtenido la informaci�n deseada.

FUENTES:

https://en.wikipedia.org/wiki/Padding_oracle_attack
https://crypto.stackexchange.com/questions/202/should-we-mac-then-encrypt-or-encrypt-then-mac
https://security.stackexchange.com/questions/38942/how-to-protect-against-padding-oracle-attacks