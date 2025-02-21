# Proyecto Backend

## Tecnologías y Herramientas Utilizadas

Este proyecto backend utiliza las siguientes tecnologías y herramientas para garantizar un desarrollo robusto y escalable:

- **Spring Boot**: Framework basado en Java para el desarrollo de aplicaciones backend.
- **Arquitectura Hexagonal**: Diseño modular que facilita la escalabilidad y mantenibilidad del código.
- **Swagger**: Implementación de documentación interactiva para APIs REST.
- **Configuración CORS**: Configuración de políticas de seguridad para el intercambio de recursos entre dominios.

## Instalación y Configuración

1. Clona este repositorio:
   ```bash
   git clone https://github.com/dandresipuz/codeSmell.git
   ```

2. Accede al directorio del proyecto:
   ```bash
   cd codeSmell
   ```

3. Construye el proyecto con Maven:
   ```bash
   mvn clean install
   ```

4. Inicia la aplicación:
   ```bash
   mvn spring-boot:run
   ```

5. Accede a la documentación de la API en Swagger:
   ```
   http://localhost:8080/swagger-ui/index.html
   ```

## Autenticación

Para acceder a los endpoints protegidos, utiliza las siguientes credenciales:

- **Usuario**: `admin`
- **Contraseña**: `admin`

## Arquitectura del Proyecto

Este backend está diseñado bajo la arquitectura hexagonal, lo que permite una mejor separación de responsabilidades y facilita la integración con distintos componentes externos.

- **Capa de Dominio**: Contiene las reglas de negocio y entidades del sistema.
- **Capa de Aplicación**: Implementa los casos de uso y la lógica de la aplicación.
- **Capa de Infraestructura**: Maneja la persistencia, controladores y configuración.

## Contribución

Si deseas contribuir a este proyecto, sigue estos pasos:

1. Crea un fork del repositorio.
2. Crea una rama con tu nueva funcionalidad:
   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```
3. Realiza tus cambios y confirma los commits.
4. Envía un pull request para su revisión.

## Contacto

Para consultas o soporte, puedes contactar a los mantenedores del proyecto a través de diegoipuzg@gmail.com o abrir un issue en el repositorio.
