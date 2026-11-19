module Main where

import Lib

main :: IO ()
main = do
    putStrLn "=== CALCULADORA HASKELL ==="
    putStrLn "Ingrese el primer numero:"
    entrada1 <- getLine

    putStrLn "Ingrese el segundo numero:"
    entrada2 <- getLine

    let numero1 = read entrada1 :: Double
    let numero2 = read entrada2 :: Double

    putStrLn ("La suma es: " ++ show (suma numero1 numero2))
