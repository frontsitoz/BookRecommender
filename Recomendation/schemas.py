from pydantic import BaseModel, Field
from typing import List, Optional, Dict
#import numpy as np



#Clase libro 

class Book(BaseModel):
    id: int
    title: str
    gender = str
    average_raiting: float = Field(ge=0, le=5)  #calificacion promedio de 0 a 5
    read : bool = False  #indica si el libro ha sido leido o no
    similar_books: List[int] = [] #Ids de libros similares que el usuario no ha leido
    interested : bool = False #indicador si el libro esta marcado como me interesa 
    not_interested = bool = False #indicador si el libro esta marcado como no me interesa




