module Notas where

import Data.List (sortBy, maximumBy)
import Data.Ord (comparing)

type Estudiante = (String, Double)

promedio :: [Estudiante] -> Double
promedio [] = 0
promedio xs = sum (map snd xs) / fromIntegral (length xs)

masAlto :: [Estudiante] -> Estudiante
masAlto = maximumBy (comparing snd)

ordenarPorNota :: [Estudiante] -> [Estudiante]
ordenarPorNota = sortBy (flip (comparing snd))

aprobados :: [Estudiante] -> [Estudiante]
aprobados xs = [e | e <- xs, snd e >= 51]

parsearLinea :: String -> Either String Estudiante
parsearLinea linea =
    case break (== ',') linea of
        (nombre, ',' : notaTexto)
            | null nombre -> Left ("nombre vacio: " ++ linea)
            | otherwise ->
                case reads notaTexto :: [(Double, String)] of
                    [(nota, "")] -> Right (nombre, nota)
                    _ -> Left ("nota invalida: " ++ linea)
        _ -> Left ("linea sin formato nombre,nota: " ++ linea)
