modulo-controle-acesso
========================
Autor: Marco Reis

Tecnologias: CDI, JSF, JPA, EJB, JPA, JAX-RS, PRIMEFACES

Summary: An example that incorporates multiple technologies

Target Product: JBoss AS 

Fonte: <https://github.com/masreis/modulo-controle-acesso>

O que é isso?
-----------

Cadastro
- Usuário
- Perfil
- Funções
- Permissões


Configuração do JBoss 7.1.1
-------------------

All you need is love

 
Driver MySQL
---------------

If you have not yet done so, you must [Configure Maven](../README.md#configure-maven) before testing the quickstarts.


Datasource
-------------------------

		<datasource jndi-name="java:jboss/datasources/modulo-controle-acessoDS" enabled="true" use-java-context="true" pool-name="controle-acesso-pool">
		    <connection-url>jdbc:mysql://localhost:3306/controle-acesso</connection-url>
		    <driver>mysql</driver>
		    <security>
			<user-name>root</user-name>
			<password></password>
		    </security>
		    <validation>
			<check-valid-connection-sql>SELECT 1</check-valid-connection-sql>
		    </validation>
		</datasource>
 
Build and Deploy the Quickstart
-------------------------

_NOTE: The following build command assumes you have configured your Maven user settings. If you have not, you must include Maven setting arguments on the command line. See [Build and Deploy the Quickstarts](../README.md#build-and-deploy-the-quickstarts) for complete instructions and additional options._

1. Make sure you have started the JBoss Server as described above.
2. Open a command line and navigate to the root directory of this quickstart.
3. Type this command to build and deploy the archive:

        mvn clean package jboss-as:deploy

4. This will deploy `target/modulo-controle-acesso.war` to the running instance of the server.
 

Access the application 
---------------------

The application will be running at the following URL: <http://localhost:8080/modulo-controle-acesso/>.


Undeploy the Archive
--------------------

1. Make sure you have started the JBoss Server as described above.
2. Open a command line and navigate to the root directory of this quickstart.
3. When you are finished testing, type this command to undeploy the archive:

        mvn jboss-as:undeploy


Run the Arquillian Tests 
-------------------------

This quickstart provides Arquillian tests. By default, these tests are configured to be skipped as Arquillian tests require the use of a container. 

_NOTE: The following commands assume you have configured your Maven user settings. If you have not, you must include Maven setting arguments on the command line. See [Run the Arquillian Tests](../README.md#run-the-arquillian-tests) for complete instructions and additional options._

1. Make sure you have started the JBoss Server as described above.
2. Open a command line and navigate to the root directory of this quickstart.
3. Type the following command to run the test goal with the following profile activated:

        mvn clean test -Parq-jbossas-remote 


Run the Quickstart in JBoss Developer Studio or Eclipse
-------------------------------------
You can also start the server and deploy the quickstarts from Eclipse using JBoss tools. For more information, see [Use JBoss Developer Studio or Eclipse to Run the Quickstarts](../README.md#use-jboss-developer-studio-or-eclipse-to-run-the-quickstarts) 


Debug the Application
------------------------------------

If you want to debug the source code or look at the Javadocs of any library in the project, run either of the following commands to pull them into your local repository. The IDE should then detect them.

    mvn dependency:sources
    mvn dependency:resolve -Dclassifier=javadoc
