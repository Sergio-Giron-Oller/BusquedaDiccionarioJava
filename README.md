# Buscador en Diccionario español

Buscador de todas las palabras que se pueden formar con una secuencia de caracteres en el diccionario español, se puede acotar el resultado por la longitud de caracteres deseada

El fichero diccionario.txt es un diccionario español en formato texto plano
El fichero consultas.txt, es donde se escriben las búsquedas que quieren realizarse, estas tienen dos formas, una secuencia de caracteres seguido de la palabra ALL, o un numero

La carpeta /estructuras contiene las interfaces y clases genéricas de las estructuras utilizadas

La carpeta /programa contiene el código, que,

Primero crea un árbol genérico, con un nodo raíz, y a continuación va insertando las palabras de forma que cada nodo intermedio contiene un carácter, y cada palabra válida (es decir, que figura en diccionario.txt) tiene un hijo de tipo nodo hoja.
El árbol debe estar ordenado de forma que los hijos de un nodo, primero se encuentre el nodo hoja en caso de que se trate de una palabra valida, y a continuación el resto de nodos hijos por orden alfabético

Ahora, tenemos el diccionario cargado en memoria en forma de árbol, donde cada palabra valida empieza en el nodo raiz, pasa por x nodos carácter y termina en un nodo hoja
Ahora cogemos el fichero consultas.txt y ejecutamos cada linea como una busqueda, la cual esta compuesta por un conjunto de caracteres, seguidos de "ALL" o un digito
Si queremos obtener todas las posibles palabras que se forman con los caracteres indicados, sin importar la longitud de la palabra encontrada, usamos "ALL"
En cambio, si ponemos un digito, acotamos el resultado a solo las palabras que tienen esa longitud

El algoritmo realiza un recorrido en profundidad, de tipo preorden, ya que va consultando primero el nodo actual, y a continuación sus nodos hijos de izquierda a derecha, y si encuentra uno que coincida con un carácter de la secuencia a buscar, continua analizando los hijos de dicho nodo, y asi sucesivamente mediante recursividad hasta que o bien encuentra un nodo hoja y añade esa palabra a la cola de salida, o bien se encuentra con un nodo carácter que contiene un carácter que no se encuentra en la secuencia de caracteres a buscar
