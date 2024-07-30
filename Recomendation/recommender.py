import requests
from schemas import Book
from typing import List



def generate_recommendations(user_books: List[Book], all_books: List[Book], top_n: int = 5) -> List[Book]:
    #creamos la lista de libros que el usuario ha leído
    read_books = [book for book in user_books if book.read]
    
    #identificamos los libros mejor valorados que el usuario ha leído y que le interesan
    interested_books = [book for book in read_books if book.interested]
    best_rated_books = sorted(interested_books, key=lambda x: x.average_rating, reverse=True)
    
    #filtramos libros similares no leídos basados en el género
    recommended_books = []
    for book in best_rated_books:
        #filtramos los libros de all_books que coinciden en género y que no han sido leídos
        similar_books = [b for b in all_books if b.gender == book.gender and not b.read]
        for similar_book in similar_books:
            if similar_book not in recommended_books and not similar_book.interested:
                recommended_books.append(similar_book)
    
    #ordenar por calificación promedio y devolver los top_n libros a recomendar
    recommended_books.sort(key=lambda x: x.average_rating, reverse=True)
    top_recommendations = recommended_books[:top_n]
    
    return top_recommendations

