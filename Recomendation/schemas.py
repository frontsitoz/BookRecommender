# Esquemas de datos para entrada y salida de API
from pydantic import BaseModel, Field
from typing import List, Optional


# Clase libro
class Book(BaseModel):
    id: int  # ID del libro
    title: str  #titulo del libro
    authors: str  #autores del libro
    description: str  #descripcion del libro
    genre: str  #genero del libro
    publisher: str  #editorial del libro
    publishedDate: str  #fecha de publicacion del libro
    imageUrl: str  #URL de la imagen del libro
    pageCount: int  #numero de paginas del libro
    isBookMarked: bool  #indicador si el libro está marcado
    isRead: bool  # indicador si el libro ha sido leído
    isReading: bool  #indicador si el libro está en lectura
    isLike: bool  #indicador si el libro está marcado como 'me gusta'
    average_rating: float = Field(ge=0, le=5)  #calificacion promedio de 0 a 5

# clase del modelado de datos para la solicitud 
class RecommendationRequest(BaseModel):
    user_books: Optional[ List[Book]] = []
    all_books: List[Book]
    top_n: int = 10
