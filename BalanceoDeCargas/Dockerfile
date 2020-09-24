FROM openjdk:8

WORKDIR /balanceodecargas/bin

ENV PORT 6001

COPY /target/classes /balanceodecargas/bin/classes
COPY /target/dependency /balanceodecargas/bin/dependency

CMD ["java","-cp","./classes:./dependency/*","edu.eci.arep.tarea4.balanceodecargas.App"]
