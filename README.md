# ARWS-Lab1-Concurrency
## Hecho por: Alejandro Prieto Reyes

---
### Parte I - Introducción a Hilos en Java
#### 1. De acuerdo con lo revisado en las lecturas, complete las clases CountThread, para que las mismas definan el ciclo de vida de un hilo que imprima por pantalla los números entre A y B.
  
**Solucion:** Hice el constructor de la clase, buscando que A siempre sea menor que B y el metodo run, para correr este dentro de la misma en un for, le agrego un salto final con el fin de, si hay mas CountThread funcionando, se diferencie uno de otro   
![alt text](./Img/1.png)  

**Funcionamiento:** Pusimos a iterar el ciclo entre 1 y 10.  
![alt text](./Img/2.png)    

#### 2. Complete el método main de la clase CountMainThreads para que:
##### i. Cree 3 hilos de tipo CountThread, asignándole al primero el intervalo [0..99], al segundo [99..199], y al tercero [200..299]

![alt text](./Img/3.png)  

##### ii. Inicie los tres hilos con 'start()'.

![alt text](./Img/4.png)  

##### iii. Ejecute y revise la salida por pantalla
![alt text](./Img/5.png)
**Observacion:** Podemos ver que todos los prin se ejecutaron de manera ordenada y secuencial.

##### iv. Cambie el incio con 'start()' por 'run()'. Cómo cambia la salida?, por qué?
![alt text](./Img/6.png)  
**Solucion:** Podemos observar, que la diferencia entre ejecutar el metodo run() y start() es que; run(), nos permite "separar" las ejecuciones *secuencialmente*, como si fuera un metodo "usual", en cambio, start(), las ejecuta todas al tiempo, abriendo un hilo mas por cada llamado (Para un total de 4, 3 de los metodos y 1 del main).

---
### Parte II - Ejercicio Black List Search
#### 