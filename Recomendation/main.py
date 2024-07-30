
# backend/app/main.py

from fastapi import FastAPI , HTTPException
from recommender import generate_recommendations
from schemas import Book
from typing import List


app = FastAPI()

@app.get("/")
def read_root():
    return {"Hello": "World"}



@app.get("/getRecommendations")
def recommendatios():

    try:
        # ejemplo de uso con datos falsos 
        books = [
            Book(book_id=1, title="Book One", gender="Fiction", average_rating=4.5, read=False, similar_books=[2, 3], interested=True,not_interested=False),
            Book(book_id=2, title="Book Two", gender="Fiction", average_rating=4.0, read=False, similar_books=[1, 3], interested=False,not_interested=False),
            Book(book_id=3, title="Book Three", gender="Non-Fiction", average_rating=4.8, read=True, similar_books=[1, 2], interested=False,not_interested=False),
        ]

        user_books = [
            Book(book_id=1, title="Book One", gender="Fiction", average_rating=4.5, read=False, similar_books=[2, 3], interested=True, not_interested=False),
            Book(book_id=3, title="Book Three", gender="Non-Fiction", average_rating=4.8, read=True, similar_books=[1, 2], interested=False, not_interested= False)
        ]

        # generamos recomendaciones
        recommended_books = generate_recommendations(user_books, books, top_n=5)


        response = {
            "status": "success",
            "data": [book for book in recommended_books],
            "message": "reommendations generated suceessfully"
        }

        return response
    except Exception as e:
        raise HTTPException(status_code=500,detail=str(e))

