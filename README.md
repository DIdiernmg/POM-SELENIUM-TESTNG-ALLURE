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

💡 Nota sobre el estado actual

    Nota: Actualmente, el framework está configurado para ejecución con interfaz gráfica (Navegador visible). El modo Headless está en la hoja de ruta para la fase de integración con Jenkins.