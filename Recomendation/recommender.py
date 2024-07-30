import requests
from schemas import Book


def generate_recommendations(user_books: List[Book], all_books: List[Book], top_n: int = 5) -> List[Book]:



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

# Mostramos los títulos de los libros
for title in book_titles:
    print(title)
    # Creamos la lista de libros que el usuario a leido
    read_books = [book for book in user_books if book.read]

    # Identificamos los libros mejor valorados que el usuario ha leído
    interested_books = [book for book in read_books if book.interested]
    best_rated_books = sorted(interested_books,key=lambda x:x.average_raiting,reverse=True)


    # Filtramos libros similares no leídos
    recommended_books = []
    for book in best_rated_books:
        for similar_book_id in book.similar_books:
            similar_book = next((b for b in all_books if b.id == similar_book_id and not b.read), None)
            if similar_book and similar_book not in recommended_books and not similar_book.interested:
                recommended_books.append(similar_book)

    # Filtramos libros no deseados
    # recommended_books = [book for book in recommended_books if not book.interested] #esta parte no va por que al inicio ya se filtro los libros por interesados

    # Ordenar por calificación promedio y devolver los top_n que serian el numero de libros a recomendar
    recommended_books.sort(key=lambda x: x.average_rating, reverse=True)
    top_recommendations = recommended_books[:top_n]

    return top_recommendations

# ejemplo de uso con datos falsos
books = [
    Book(id=1, title="Book One", gender="Fiction", average_rating=4.5, read=False, similar_books=[2, 3], interested=True),
    Book(id=2, title="Book Two", gender="Fiction", average_rating=4.0, read=False, similar_books=[1, 3], interested=False),
    Book(id=3, title="Book Three", gender="Non-Fiction", average_rating=4.8, read=True, similar_books=[1, 2], interested=False),
]

user_books = [
    Book(id=1, title="Book One", gender="Fiction", average_rating=4.5, read=False, similar_books=[2, 3], interested=True),
    Book(id=3, title="Book Three", gender="Non-Fiction", average_rating=4.8, read=True, similar_books=[1, 2], interested=False)
]

# generamos recomendaciones
recommended_books = generate_recommendations(user_books, books, top_n=5)

# Mostramos recomendaciones
for book in recommended_books:
    print(f"Recommended Book: {book.title}, Average Rating: {book.average_rating}")
