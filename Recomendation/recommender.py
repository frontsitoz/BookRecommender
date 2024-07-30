from typing import List, Optional, Dict
from schemas import Book
import requests
import pprint as pp


url= "https://www.googleapis.com/books/v1/volumes?q=Gato&key=AIzaSyCrAvZb2kPz17Yy782H-3LlKuljOGw2DZE"

response = requests.get(url)

book_titles = []

# Verificamos si la solicitud fue exitosa
if response.status_code == 200:
    # Extraemos los datos en formato JSON
    books_data = response.json()
    for item in books_data.get('items',[]):
        volume_info = item.get('volumeInfo',{})
        title= volume_info.get('title')
        if title:
            book_titles.append(title)
            pp.pprint(book_titles)

    

else:
    # Imprimimos un mensaje de error en caso de que la solicitud falle
    print(f"Error: {response.status_code}")



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

# Ejemplo de uso con datos ficticios
books = [
    Book(book_id=1, title="Book One", gender="Fiction", average_rating=4.5, read=False, interested=True, not_interested=False),
    Book(book_id=2, title="Book Two", gender="Fiction", average_rating=4.0, read=False, interested=False, not_interested=False),
    Book(book_id=3, title="Book Three", gender="Non-Fiction", average_rating=4.8, read=True, interested=False, not_interested=False),
]

user_books = [
    Book(book_id=1, title="Book One", gender="Fiction", average_rating=4.5, read=False, interested=True, not_interested=False),
    Book(book_id=3, title="Book Three", gender="Non-Fiction", average_rating=4.8, read=True, interested=False, not_interested=False)
]

# Generamos recomendaciones
recommended_books = generate_recommendations(user_books, books, top_n=5)

# Mostramos recomendaciones
for book in recommended_books:
    print(f"Recommended Book: {book.title}, Average Rating: {book.average_rating}")