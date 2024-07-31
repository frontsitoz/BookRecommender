from schemas import Book
from typing import List

def generate_recommendations(user_books: List[Book], all_books: List[Book], top_n: int = 5) -> List[Book]:
    #creamos la lista de libros que el usuario ha leido
    read_books = [book for book in user_books if book.read]
    
    #identifico los libros mejor valorados que el usuario ha leído y que le interesan
    interested_books = [book for book in read_books if book.interested]
    best_rated_books = sorted(interested_books, key=lambda x: x.average_rating, reverse=True)
    
    #creo la ista donde se guardaran los libros recomendados
    recommended_books = []

    if best_rated_books:
        #sii el usuario ha interactuado con libros filtramos libros similares no leidos basados en el genero
        for book in best_rated_books:
            #filtrar los libros de allbooks que coinciden en genero y que no han sido leidos
            similar_books = [b for b in all_books if b.gender == book.gender and not b.read]
            for similar_book in similar_books:
                if similar_book not in recommended_books and not similar_book.interested:
                    recommended_books.append(similar_book)
    else:
        #si el usuario no ha leido ningun libro  mostramos libros mejor valorados en general o populares
        recommended_books = [book for book in all_books if not book.read and not book.not_interested]
        # Ordenar por calificación promedio
        recommended_books.sort(key=lambda x: x.average_rating, reverse=True)
        recommended_books = recommended_books[:top_n]
    
    #ordenamos los libros recomendados por calificacion promedio y devolver los top_n libros a recomendar
    recommended_books.sort(key=lambda x: x.average_rating, reverse=True)
    top_recommendations = recommended_books[:top_n]
    
    return top_recommendations