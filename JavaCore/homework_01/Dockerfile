FROM bellsoft/liberica-openjdk-alpine
COPY ./src ./src
RUN mkdir ./out
RUN javac -sourcepath ./src -d out src/ru/homework/gb/Main.java
CMD java -classpath ./out ru.homework.gb.Main