Selenium Java Automation Framework - SauceDemo

Este proyecto es un framework de automatización robusto diseñado para la plataforma SauceDemo, aplicando las mejores prácticas de la industria como Page Object Model (POM), Data-Driven Testing e Integración Continua.
🚀 Arquitectura del Proyecto

El framework está construido bajo una estructura jerárquica que separa la lógica de los tests de la interacción con los elementos de la interfaz.
Componentes Clave:

    BasePage: Clase "madre" que centraliza la inicialización de elementos mediante PageFactory y define los Explicit Waits para asegurar la estabilidad de las pruebas.

    Page Objects: Clases como LoginPage e InventoryPage que encapsulan los localizadores y las acciones de cada página.

    BaseTest: Gestiona el ciclo de vida del WebDriver (Setup y Teardown), asegurando un entorno limpio para cada ejecución.

    ConfigReader: Implementación de Data-Driven Testing que lee configuraciones dinámicas (URL, credenciales) desde archivos .properties.

🛠️ Tecnologías Utilizadas

    Java: Lenguaje de programación principal.

    Selenium WebDriver: Herramienta de automatización del navegador.

    TestNG: Framework de pruebas para gestionar ejecuciones y aserciones.

    Maven: Gestor de dependencias y construcción del proyecto.

    Allure Reports: Generador de reportes visuales detallados.

Selenium-testng-allure-pom [automatizacionpom]
├── .idea                       # Configuración interna del IDE
├── allure-results              # Resultados temporales de Allure
├── settings                    # Directorio de configuración global
│   └── config.properties       # Variables (URL, navegador, headless)
├── src                         # Código fuente del proyecto
│   ├── main
│   │   ├── java/pages          # Objetos de Página (Page Objects)
│   │   │   ├── BasePage        # Lógica base (Waits, PageFactory)
│   │   │   ├── InventoryPage   # Elementos de la página de productos
│   │   │   └── LoginPage       # Elementos y acciones de Login
│   │   └── resources           # Archivos de recursos del sistema
│   │       └── environment.properties  # Datos para el reporte Allure
│   └── test
│       └── java
│           ├── tests           # Clases de ejecución de pruebas
│           │   ├── BaseTest    # Configuración de Driver (Setup/Teardown)
│           │   └── LoginTest   # Casos de prueba de autenticación
│           └── utils           # Herramientas de soporte
│               ├── ConfigReader# Motor de lectura de propiedades
│               └── ReportUtils # Configuración de reportes
├── target                      # Binarios generados y reportes finales
├── .gitignore                  # Archivos excluidos de Git
├── Jenkinsfile                 # Script de Pipeline para CI/CD
├── pom.xml                     # Gestión de dependencias (Maven)
├── README.md                   # Documentación del proyecto
└── testng.xml                  # Suite de configuración de TestNG

Guía de Ejecución (CLI)

Para ejecutar este proyecto desde tu terminal y ver el navegador en acción, utiliza los siguientes comandos:
1. Limpiar y Ejecutar Pruebas

Este comando limpia la carpeta target y lanza la ejecución de Selenium abriendo el navegador automáticamente.
Bash

mvn clean test

2. Generar y Ver Reporte de Allure

Una vez que la consola indique que los tests finalizaron, genera el reporte visual apuntando a la carpeta de resultados dentro de target:
Bash

allure serve target/allure-results

💡 Framework de Automatización E2E: SauceDemo
Arquitectura Robusta con Selenium, TestNG, Jenkins y Allure

Este repositorio contiene un framework de automatización de pruebas de extremo a extremo (E2E) profesional, diseñado bajo el patrón de diseño Page Object Model (POM) para garantizar escalabilidad y facilidad de mantenimiento.
🛠️ Stack Tecnológico

    Lenguaje: Java 17.

    Automatización: Selenium WebDriver 4.40.0.

    Framework de Pruebas: TestNG.

    Reportes Dinámicos: Allure Reports con integración de capturas de pantalla automáticas ante fallos.

    CI/CD: Jenkins Pipeline (Pipeline as Code mediante Jenkinsfile).

    Gestión de Dependencias: Maven.

✨ Características Principales

    Integración Continua (CI/CD): Configurado para ejecutarse automáticamente en Jenkins mediante un Pipeline orquestado.

    Modo Headless (Invisible): Capacidad de ejecución en servidores sin interfaz gráfica mediante el parámetro -Dheadless=true.

    Evidencia Visual Automática: En caso de fallo, el framework captura una imagen del estado exacto del navegador y la adjunta al reporte de Allure para un debugging inmediato.

    Data-Driven Configuration: Gestión centralizada de URLs y credenciales mediante archivos de propiedades y ConfigReader.

    Reportes de Calidad Profesional: Allure Report configurado para mostrar información del ambiente de ejecución (SO, Navegador, Ingeniero a cargo).

🚀 Instrucciones de Ejecución
Local

    Clonar: git clone https://github.com/Dldiernmg/POM-SELENIUM-TESTNG-ALLURE.git

    Ejecutar: mvn clean test

    Ver Reporte: allure serve target/allure-results

Jenkins

    Crear un Job de tipo Pipeline.

    Conectar con este repositorio de GitHub.

    Ejecutar con el parámetro HEADLESS=true.

Desarrollado por: Didier Norberto Marin (Tiko)

Organización: Testimatic - Soluciones de Calidad de Software