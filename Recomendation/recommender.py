import requests
from schemas import Book
from typing import List


# URL de la API de Google Books para buscar libros relacionados con "Gato"
url = "https://www.googleapis.com/books/v1/volumes?q=Gato&key=AIzaSyCrAvZb2kPz17Yy782H-3LlKuljOGw2DZE"

# Realizamos la solicitud GET a la API
response = requests.get(url)

# Lista para almacenar los títulos de los libros
book_titles = []

# Verificamos si la solicitud fue exitosa
if response.status_code == 200:
    # Extraemos los datos en formato JSON
    books_data = response.json()
    # Iteramos sobre los libros en 'items'
    for item in books_data.get('items', []):
        # Obtenemos la información del volumen
        volume_info = item.get('volumeInfo', {})
        # Obtenemos el título del libro
        title = volume_info.get('title')
        if title:
            book_titles.append(title)
else:
    print(f"Error: {response.status_code}")



def generate_recommendations(user_books: List[Book], all_books: List[Book], top_n: int = 5) -> List[Book]:
    # Creamos la lista de libros que el usuario ha leído
    read_books = [book for book in user_books if book.read]
    
    # Identificamos los libros mejor valorados que el usuario ha leído y que le interesan
    interested_books = [book for book in read_books if book.interested]
    best_rated_books = sorted(interested_books, key=lambda x: x.average_rating, reverse=True)
    
    # Filtramos libros similares no leídos basados en el género
    recommended_books = []
    for book in best_rated_books:
        # Filtramos los libros de all_books que coinciden en género y que no han sido leídos
        similar_books = [b for b in all_books if b.gender == book.gender and not b.read]
        for similar_book in similar_books:
            if similar_book not in recommended_books and not similar_book.interested:
                recommended_books.append(similar_book)
    
    # Ordenar por calificación promedio y devolver los top_n libros a recomendar
    recommended_books.sort(key=lambda x: x.average_rating, reverse=True)
    top_recommendations = recommended_books[:top_n]
    
    return top_recommendations

# Ejemplo de uso con datos ficticios
books = [
    Book(id=1, title="Book One", gender="Fiction", average_rating=4.5, read=False, interested=True, not_interested=False),
    Book(id=2, title="Book Two", gender="Fiction", average_rating=4.0, read=False, interested=False, not_interested=False),
    Book(id=3, title="Book Three", gender="Non-Fiction", average_rating=4.8, read=True, interested=False, not_interested=False),
]

user_books = [
    Book(id=1, title="Book One", gender="Fiction", average_rating=4.5, read=False, interested=True, not_interested=False),
    Book(id=3, title="Book Three", gender="Non-Fiction", average_rating=4.8, read=True, interested=False, not_interested=False)
]

# generamos recomendaciones
recommended_books = generate_recommendations(user_books, books, top_n=5)

# Mostramos recomendaciones
for book in recommended_books:
    print(f"Recommended Book: {book.title}, Average Rating: {book.average_rating}")
