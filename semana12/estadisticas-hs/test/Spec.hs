module Main where

import Lib

main :: IO ()
main = do
    let estudiantes =
            [("Ana", 92.5), ("Luis", 85), ("Maria", 97)]

    putStrLn "=== PRUEBAS DEL SISTEMA ==="

    if promedio estudiantes == 91.5
        then putStrLn "Prueba de promedio: CORRECTA"
        else putStrLn "Prueba de promedio: ERROR"

    if mejorEstudiante estudiantes == Just ("Maria", 97)
        then putStrLn "Prueba de mejor estudiante: CORRECTA"
        else putStrLn "Prueba de mejor estudiante: ERROR"

    if length (ordenarPorNota estudiantes) == 3
        then putStrLn "Prueba de ordenamiento: CORRECTA"
        else putStrLn "Prueba de ordenamiento: ERROR"

    if length (aprobados estudiantes) == 3
        then putStrLn "Prueba de aprobados: CORRECTA"
        else putStrLn "Prueba de aprobados: ERROR"

    if promedio [] == 0 && mejorEstudiante [] == Nothing
        then putStrLn "Prueba de lista vacia: CORRECTA"
        else putStrLn "Prueba de lista vacia: ERROR"
