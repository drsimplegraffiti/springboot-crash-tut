#### Download java the proper way
Go to https://adoptium.net/ and download the latest version of the JDK.

Then Install the msi

Go to the environment variables and add the path to the bin folder of the JDK
And add the path to the bin folder of the JDK to the path variable
- Right-click the Computer icon on your desktop and select Properties.
- Click Advanced system settings.
- Click Environment variables.
- Under User variables, click New.
- Enter JAVA_HOME as the variable name.
- Enter the path to the JDK as the variable value. For example, C:\Program Files (x86)\IBM\Java70\.
- Click OK.
- Locate the PATH variable.
- Append the path to the JDK (up to the bin folder) as the PATH value. For example, C:\Program Files (x86)\IBM\Java70\bin.
![Image description](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/ojycy36ufesz05yjbpgw.png)

Then restart your computer

### Check if java is installed
Open a command prompt and type
```java -version```

If you get a version number, you are good to go

---

#### Starting spring application from scratch
https://spring.io/projects/spring-boot
https://docs.spring.io/spring-boot/docs/current/reference/html/

![Image description](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/dos3jgfpw6pn7zkyrq2q.png)
Click on the link to the reference documentation as a guide
Click on the getting started guide
Scroll to the developing your first spring application

Go to your project and delete everything except the .gitignore file
You should have:

![Image description](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/304jqavpn5p3qeygaqqf.png)
Then check java version

Open a command prompt and type
```java -version```

Check if you have maven installed
```mvn -version``` 

If you dont have maven installed follow this guide https://phoenixnap.com/kb/install-maven-windows

![Image description](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/uei8340hu2x0tcx4aess.png)

#### Steps
- Download the apache-maven-3.8.7-bin.zip at https://maven.apache.org/download.cgi
- Extract the zip file to a folder preferably C:\Program Files\apache-maven-3.8.7
- Add the path to the bin folder of the maven to the path variable
- Right-click the Computer icon on your desktop and select Properties.
- Click Advanced system settings.
- Click Environment variables.
- Under system variables, click New.
- Enter MAVEN_HOME as the variable name.
- Enter the path to the maven as the variable value. For example, C:\Program Files\apache-maven-3.8.7.
- Click OK.
- Under the system variable again Locate the PATH variable and click edit.
- Then click new and add %MAVEN_HOME%\bin
- Click OK.
- Restart your computer

Then check if maven is installed
```mvn -version```

### Continue with the spring from scratch guide
- Create a pom.xml file
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>myproject</artifactId>
    <version>0.0.1-SNAPSHOT</version>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.0.1</version>
    </parent>

    <!-- Additional lines to be added here... -->

</project>
 ```
- Then Load the project

Next run the following command
```mvn package```

Then run the following command 
```mvn dependency:tree```

Then add your spring boot starter web dependency
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
```
Then run the dependency tree again
```mvn dependency:tree```

Then to write your code, create a new file in the src/main/java folder
src/main/java/ScratchApplication.java

Then add the following code
```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
public class ScratchApplication {
    public static void main(String[] args){
        SpringApplication.run(ScratchApplication.class);
    }
}

```

Run your application
```mvn spring-boot:run```

Then go to http://localhost:8080/ and you should see the following

To stop the application press ctrl+c
To create a quick rest api
````java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
public class ScratchApplication {
    public static void main(String[] args){
        SpringApplication.run(ScratchApplication.class);
    }

    @RequestMapping("/")
    public String homePage(){
        return "Hello world";
    }
}

````

---

#### Reloading Spring boot application on save
- Download the Spring boot dev tool into the pom.xml
- Add the dev tool dependency to the pom.xml

Then go to file -> settings -> Advance settings -> And click on the Allow auto-make to start even if developed application is currently running

Then fo to file -> settings -> Build -> Compiler -> And check Build project automatically

---

#### Run spring boot application from command line
- Go to the folder where the pom.xml is located
- Run the command ```mvn spring-boot:run```


---

#### Creating executable jar file
You need the maven jar plugin to create an executable jar file
- Add the following to the pom.xml after the dependencies section and reboot the maven again
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```
Then run the following command
```mvn package```

Then go to the target folder and you should see the following

Then run the following command
```java -jar myproject-0.0.1-SNAPSHOT.jar```

Then go to http://localhost:8080/ and you should see the following

You can open with file explorer and see the following. Extract the zip folder and open the cmd ini the folder path 

Then run the command prompt and run the following command
```java -jar myproject-0.0.1-SNAPSHOT.jar```