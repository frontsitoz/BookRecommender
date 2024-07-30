# Esquemas de datos para entrada y salida de API
from pydantic import BaseModel, Field
from typing import List, Optional, Dict
#import numpy as np



#Clase libro
class Book(BaseModel):
    id: int #id 
    title: str #titulo
    author: Optional[List[str]] = None  # Autores del libro, opcional
    gender :str #genero del libro
    average_rating: float = Field(ge=0, le=5)  #calificacion promedio de 0 a 5
    read : bool = False  #indica si el libro ha sido leido o no
    interested : bool = False #indicador si el libro esta marcado como me interesa
    not_interested : bool = False #indicador si el libro esta marcado como no me interesa