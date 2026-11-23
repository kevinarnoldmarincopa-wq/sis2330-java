# Semana 13 - Persistencia de estudiantes en Haskell

## Objetivo
Desarrollar un programa en Haskell que permita guardar y cargar estudiantes utilizando archivos CSV.

## Estructura del proyecto
- `src/Modelo.hs`: contiene el tipo Estudiante y las funciones de cálculo.
- `src/Persistencia.hs`: contiene las funciones para guardar y cargar estudiantes.
- `app/Main.hs`: contiene el programa principal.
- `estudiantes.csv`: archivo donde se almacenan los estudiantes.

## Formato del archivo CSV
Cada estudiante se guarda en una línea con el siguiente formato:

Nombre,Nota

Ejemplo:

Ana,92.0
Luis,85.0

## Manejo de errores
Se utiliza el tipo `Either` para identificar líneas incorrectas del archivo.
Las líneas válidas se cargan y las incorrectas muestran un aviso sin detener el programa.

## Funciones principales
- `guardarEstudiantes`: guarda los estudiantes en un archivo.
- `cargarEstudiantes`: carga los estudiantes desde un archivo.
- `parsearLinea`: convierte una línea CSV en un estudiante o devuelve un error.
- `promedio`: calcula el promedio de las notas.
- `aprobados`: obtiene los estudiantes aprobados.

## Compilación
```bash
stack build --system-ghc --no-install-ghc --no-haddock --no-haddock-deps
