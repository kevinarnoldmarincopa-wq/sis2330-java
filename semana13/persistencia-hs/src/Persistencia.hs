module Persistencia where

import Modelo
import System.Directory (doesFileExist)

parsearLinea :: String -> Either String Estudiante
parsearLinea linea =
    case break (== ',') linea of
        (nombre, ',' : notaTexto)
            | null nombre -> Left "Nombre vacio"
            | otherwise ->
                case reads notaTexto :: [(Double, String)] of
                    [(nota, "")]
                        | nota >= 0 && nota <= 100 ->
                            Right (nombre, nota)
                        | otherwise -> Left "Nota fuera de rango"
                    _ -> Left "Nota invalida o formato incorrecto"
        _ -> Left "Formato incorrecto"

formatearLinea :: Estudiante -> String
formatearLinea (nombre, nota) = nombre ++ "," ++ show nota

guardarEstudiantes :: FilePath -> [Estudiante] -> IO ()
guardarEstudiantes ruta estudiantes =
    writeFile ruta (unlines (map formatearLinea estudiantes))

cargarEstudiantes :: FilePath -> IO [Either String Estudiante]
cargarEstudiantes ruta = do
    existe <- doesFileExist ruta
    if not existe
        then return []
        else do
            contenido <- readFile ruta
            let lineasNoVacias = filter (not . null) (lines contenido)
            return (map parsearLinea lineasNoVacias)
