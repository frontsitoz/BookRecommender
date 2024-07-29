
# backend/app/main.py

from fastapi import FastAPI
from recommender import recommended_books

app = FastAPI()

@app.get("/")
def read_root():
    return {"Hello": "World"}


@app.get("/getData")
def recommender():
    recommended_books





