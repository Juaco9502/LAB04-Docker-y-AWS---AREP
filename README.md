# HOMEWORK 4 AREP (Taller de de modularización con virtualización e Introducción a Docker y a AWS)


For the task you must build an application with the proposed architecture and deploy it on AWS using EC2 and Docker.


# DOCUMENTATION

[Tarea 4 - Arep (LaTeX)](/Tarea4Arep.pdf)

# DESIGN

![3](img/3.PNG)

# CONTEXT

* 1. El servicio MongoDB es una instancia de MongoDB corriendo en un container de docker en una máquina virtual de EC2
* 2. LogService es un servicio REST que recibe una cadena, la almacena en la base de datos y responde en un objeto JSON con las 10 ultimas cadenas almacenadas en la base de datos y la fecha en que fueron almacenadas.
* 3. La aplicación web APP-LB-RoundRobin está compuesta por un cliente web y al menos un servicio REST. El cliente web tiene un campo y un botón y cada vez que el usuario envía un mensaje, este se lo envía al servicio REST y actualiza la pantalla con la información que este le regresa en formato JSON. El servicio REST recibe la cadena e implementa un algoritmo de balanceo de cargas de Round Robin, delegando el procesamiento del mensaje y el retorno de la respuesta a cada una de las tres instancias del servicio LogService.


# START

Copy the project through git clone in any direction to start working:
```
git clone https://github.com/Juaco9502/LAB04-Docker-y-AWS---AREP
```

## PRE-REQUISITES

* Java jdk > 7
* Maven (Apache Maven)
* Git
* Docker / Docker Toolbox (Windows)

## INSTALL

1. Run in terminal:

```
$$ docker pull juanortizm21/webapp:latest
$$ docker pull juanortizm21/log1:latest
$$ docker pull juanortizm21/log2:latest
$$ docker pull juanortizm21/roundrob:latest
```
## DOCKER HUB
![4](img/4.PNG)

## AMAZON EC2
![1](img/1.JPG)

## WEB CLIENT
![2](img/2.PNG)

2.(Optional):
If you want to view the documentation of the application, execute the following command and check the following path: root / target / site / apidocs:

```
mvn javadoc:javadoc
```

## BUILT

* [Maven](https://maven.apache.org/) - Dependency Management
* [JAVA JDK 8](http://www.oracle.com/technetwork/java/javase/overview/index.html) - Building
* [Docker](https://www.docker.com/)
* [Amazon Web Services](https://aws.amazon.com/es/education/awseducate/) - Amazon Educate
* [Spark Framework](http://sparkjava.com/)


## AUTHOR

* **JUAN CAMILO ORTIZ MEDINA** - [Juaco9502](https://github.com/juaco9502)


## LICENSE

This project is licensed under the GNU General Public License - [LICENSE](LICENSE) 