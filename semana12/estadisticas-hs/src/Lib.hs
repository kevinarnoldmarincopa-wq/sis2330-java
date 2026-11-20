module Lib
    ( Estudiante
    , promedio
    , mejorEstudiante
    , ordenarPorNota
    , aprobados
    ) where

type Estudiante = (String, Double)

promedio :: [Estudiante] -> Double
promedio [] = 0
promedio estudiantes =
    let suma = foldr (\(_, nota) acumulado -> nota + acumulado) 0 estudiantes
    in suma / fromIntegral (length estudiantes)

mejorEstudiante :: [Estudiante] -> Maybe Estudiante
mejorEstudiante [] = Nothing
mejorEstudiante estudiantes =
    Just (foldr elegir (head estudiantes) (tail estudiantes))
    where
        elegir actual@(nombre, nota) mejor@(_, notaMejor)
            | nota > notaMejor = actual
            | otherwise = mejor

ordenarPorNota :: [Estudiante] -> [Estudiante]
ordenarPorNota [] = []
ordenarPorNota (estudiante:resto) =
    insertar estudiante (ordenarPorNota resto)
    where
        insertar nuevo [] = [nuevo]
        insertar nuevo (actual@(_, nota):restantes)
            | snd nuevo <= nota = nuevo : actual : restantes
            | otherwise = actual : insertar nuevo restantes

aprobados :: [Estudiante] -> [Estudiante]
aprobados = filter (\(_, nota) -> nota >= 51)
