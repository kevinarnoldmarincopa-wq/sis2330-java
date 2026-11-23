module Modelo where

import Data.List (sortBy)
import Data.Ord (comparing)

type Estudiante = (String, Double)

promedio :: [Estudiante] -> Double
promedio [] = 0
promedio estudiantes =
    sum (map snd estudiantes) / fromIntegral (length estudiantes)

aprobados :: [Estudiante] -> [Estudiante]
aprobados estudiantes = filter (\(_, nota) -> nota >= 51) estudiantes

ordenarPorNota :: [Estudiante] -> [Estudiante]
ordenarPorNota = reverse . sortBy (comparing snd)
