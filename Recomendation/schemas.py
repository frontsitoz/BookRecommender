from pydantic import BaseModel, Field
from typing import List, Optional, Dict




#Clase libro 

class Book(BaseModel):
    book_id: int
    title: str
    gender : str
    average_rating: float = Field( ge=0.0, le=5.0)  #calificacion promedio de 0 a 5
    read : bool = False  #indica si el libro ha sido leido o no
    interested : bool = False #indicador si el libro esta marcado como me interesa 
    not_interested : bool = False #indicador si el libro esta marcado como no me interesa




