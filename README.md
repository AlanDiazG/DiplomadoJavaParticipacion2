# DiplomadoJavaParticipacion2

# Autores

### Diaz Guerrero Alan Mauricio

### Álvarez Rodea Carolina

### Villarreal Fajardo Gustavo 

### Espino Maya José Emmanuel 

### Gonzalez Castro Juan Fernando


## Participacion 2 API REST de Estados

Este proyecto es una API RESTful sencilla construida con el Spring Framework que permite la gestión de una colección de estados mediante operaciones CRUD básicas. El proyecto está configurado como una clase controladora que maneja solicitudes HTTP.

Estructura del Proyecto
Controlador: EstadoDtoController maneja las solicitudes HTTP entrantes.
Modelo: EstadoDto representa la entidad del estado.
Endpoints de la API

#### Endpoints Generales
(GET /api/v2/estados/)

Recupera una lista de todos los estados en la colección.

(GET /api/v2/estados/estados/{edo})

Busca y devuelve el estado por su nombre.

#### Endpoints de Gestión de Estados

(GET /api/v2/estados/{idEstado})
>  Recupera el estado con el ID especificado.

(POST /api/v2/estados/)
> Agrega un nuevo estado. Los datos del estado deben enviarse en el cuerpo de la solicitud.

(PUT /api/v2/estados/{idEstado})
> Reemplaza el estado con el ID especificado por uno nuevo. Si el estado no existe, crea uno nuevo.

(PATCH /api/v2/estados/{idEstado})
> Actualiza campos específicos del estado con el ID especificado según el cuerpo de la solicitud.

(DELETE /api/v2/estados/{idEstado})
> Elimina el estado con el ID especificado de la colección.

(GET /api/v2/estados/paginado)
> Recupera una lista paginada de estados. Los parámetros de paginación como page, size, dir, y sort pueden ser especificados.

Formatos de Respuesta
> Se utiliza el formato JSON para las respuestas de la API.

#### Manejo de Errores

Devuelve 404 Not Found si no se encuentra el estado solicitado.

Devuelve 201 Created al crear un nuevo estado.

Devuelve 200 OK para actualizaciones y eliminaciones exitosas.

Devuelve 204 No Content si los datos proporcionados para la actualización están incompletos o no tienen efecto.
#### Requisitos Previos
Java 8 o superior.
Dependencias de Spring Boot incluidas en el proyecto.
Una herramienta de construcción como Maven o Gradle.
