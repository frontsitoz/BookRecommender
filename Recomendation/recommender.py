from typing import List
from schemas import Book


def generate_recommendations(user_books: List[Book], all_books: List[Book], top_n: int = 5) -> List[Book]:
    #creamos la lista de libros que el usuario ha leído
    read_books = [book for book in user_books if book.isRead]
    
    #identificamos los libros mejor valorados que el usuario ha leído y que le interesan
    interested_books = [book for book in read_books if book.isBookMarked]
    best_rated_books = sorted(interested_books, key=lambda x: x.average_rating, reverse=True)
    
    #creo la lista donde se guardaran los libros recomendados
    recommended_books = []

    if best_rated_books:
        #si el usuario ha interactuado con libros  filtramos libros similares no leidos basados en el genero
        for book in best_rated_books:
            #filtro los libros de all_books que coinciden en genero y que no han sido leidos
            similar_books = [b for b in all_books if b.genre == book.genre and not b.isRead]
            for similar_book in similar_books:
                if similar_book not in recommended_books and not similar_book.isBookMarked:
                    recommended_books.append(similar_book)
    else:
        #si el usuario no ha leido ningun libro, mostrar libros mejor valorados en general o populares
        recommended_books = [book for book in all_books if not book.isRead and not book.isBookMarked]
        #ordeno por calificación promedio
        recommended_books.sort(key=lambda x: x.average_rating, reverse=True)
        recommended_books = recommended_books[:top_n]
    
    #ordeno los libros recomendados por calificacion promedio y devolver los top_n libros a recomendar
    recommended_books.sort(key=lambda x: x.average_rating, reverse=True)
    top_recommendations = recommended_books[:top_n]
    
    return top_recommendations
