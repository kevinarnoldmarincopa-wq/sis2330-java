import Notas
import Test.HUnit
import Test.QuickCheck
import System.Exit

testPromedioSimple :: Test
testPromedioSimple =
    TestCase (assertEqual "promedio" 80.0 (promedio [("Ana", 90), ("Luis", 70)]))

testPromedioVacio :: Test
testPromedioVacio =
    TestCase (assertEqual "promedio vacio" 0.0 (promedio []))

testMasAlto :: Test
testMasAlto =
    TestCase (assertEqual "mas alto" ("Ana", 95) (masAlto [("Luis", 80), ("Ana", 95)]))

testAprobados :: Test
testAprobados =
    TestCase (assertEqual "aprobados" [("Ana", 70)] (aprobados [("Ana", 70), ("Luis", 40)]))

testParsearLineaValida :: Test
testParsearLineaValida =
    TestCase (assertEqual "linea valida" (Right ("Ana", 90)) (parsearLinea "Ana,90"))

testParsearLineaInvalida :: Test
testParsearLineaInvalida =
    TestCase (assertBool "linea invalida" (case parsearLinea "Ana,abc" of
        Left _ -> True
        Right _ -> False))

propOrdenarPreservaLongitud :: [Estudiante] -> Bool
propOrdenarPreservaLongitud xs =
    length (ordenarPorNota xs) == length xs

todosLosTests :: Test
todosLosTests = TestList
    [ testPromedioSimple
    , testPromedioVacio
    , testMasAlto
    , testAprobados
    , testParsearLineaValida
    , testParsearLineaInvalida
    ]

main :: IO ()
main = do
    resultados <- runTestTT todosLosTests
    putStrLn "Propiedad QuickCheck: ordenar preserva longitud"
    quickCheck propOrdenarPreservaLongitud
    if errors resultados + failures resultados == 0
        then exitSuccess
        else exitFailure
