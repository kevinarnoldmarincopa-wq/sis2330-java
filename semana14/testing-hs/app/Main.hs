module Main where

import Notas
import Historial
import Control.Monad.State
import qualified Data.Map as Map

lineas :: [String]
lineas =
    [ "Ana,90"
    , "Luis,75"
    , "Maria,97"
    , "Ana,85"
    , "Carlos,45"
    , "LineaIncorrecta"
    ]

main :: IO ()
main = do
    let resultados = map parsearLinea lineas
    let estudiantes = [e | Right e <- resultados]
    let errores = [err | Left err <- resultados]

    let historial = execState
            (mapM_ (registrarConsulta . fst) estudiantes)
            Map.empty

    putStrLn "=== REPORTE DE ESTUDIANTES ==="

    mapM_ (\(nombre, nota) ->
        putStrLn (nombre ++ " - Nota: " ++ show nota))
        (ordenarPorNota estudiantes)

    putStrLn ""
    putStrLn ("Promedio general: " ++ show (promedio estudiantes))

    putStrLn ""
    putStrLn "Estudiante con nota mas alta:"
    print (masAlto estudiantes)

    putStrLn ""
    putStrLn "Estudiantes aprobados:"
    mapM_ print (aprobados estudiantes)

    putStrLn ""
    putStrLn "=== HISTORIAL DE CONSULTAS ==="
    mapM_ (\(nombre, _) -> do
        let cantidad = evalState (obtenerConsultas nombre) historial
        putStrLn (nombre ++ ": " ++ show cantidad ++ " consultas"))
        estudiantes

    putStrLn ""
    putStrLn "=== ERRORES ==="
    mapM_ putStrLn errores
