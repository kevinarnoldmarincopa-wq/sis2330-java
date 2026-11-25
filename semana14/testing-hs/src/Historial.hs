module Historial where

import Control.Monad.State
import qualified Data.Map as Map

registrarConsulta :: String -> State (Map.Map String Int) ()
registrarConsulta nombre =
    modify (Map.insertWith (+) nombre 1)

obtenerConsultas :: String -> State (Map.Map String Int) Int
obtenerConsultas nombre = do
    historial <- get
    return (Map.findWithDefault 0 nombre historial)
