module Main where

import Lib

main :: IO ()
main = do
    putStrLn "=== SISTEMA DE ESTADISTICAS DE ESTUDIANTES ==="
    putStrLn "Ingrese la cantidad de estudiantes:"
    entrada <- getLine
    let cantidad = read entrada :: Int

    if cantidad <= 0
        then putStrLn "No hay estudiantes registrados."
        else do
            estudiantes <- registrarEstudiantes cantidad
            mostrarEstadisticas estudiantes

registrarEstudiantes :: Int -> IO [Estudiante]
registrarEstudiantes 0 = return []
registrarEstudiantes n = do
    putStrLn ("Nombre del estudiante " ++ show (n) ++ ":")
    nombre <- getLine
    putStrLn "Ingrese su nota:"
    entrada <- getLine
    let nota = read entrada :: Double
    resto <- registrarEstudiantes (n - 1)
    return ((nombre, nota) : resto)

mostrarEstadisticas :: [Estudiante] -> IO ()
mostrarEstadisticas estudiantes = do
    putStrLn "\n=== RESULTADOS ==="
    putStrLn ("Promedio de la clase: " ++ show (promedio estudiantes))

    case mejorEstudiante estudiantes of
        Just (nombre, nota) ->
            putStrLn ("Mejor estudiante: " ++ nombre ++ " (" ++ show nota ++ ")")
        Nothing -> putStrLn "No hay estudiantes."

    putStrLn "\nEstudiantes ordenados por nota:"
    mapM_ imprimirEstudiante (ordenarPorNota estudiantes)

    putStrLn "\nEstudiantes aprobados:"
    mapM_ imprimirEstudiante (aprobados estudiantes)

imprimirEstudiante :: Estudiante -> IO ()
imprimirEstudiante (nombre, nota) =
    putStrLn (nombre ++ " - " ++ show nota)
