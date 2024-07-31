from fastapi import FastAPI, Query
import requests
from typing import Optional, Dict


app = FastAPI()

@app.get("/")
def read_root():
    return {"Hello": "world"}


#consumimos el endpoint del backend
@app.get("/getAllBooks")
def getAllBooks(query:str = Query("", description = "search Query for books"),
                page : int = Query(0,description = "page number for pagination"),
                size:int = Query(30,description="number of results per page")
):
    
    #url del endpoint del backend
    url = f"http://localhost:9090/api/books/searchBooks?query={query}&page={page}&size={size}"

    #realizamos la solicitud get
    response = requests.get(url)

    #verificamos si la solicitud fue exitosa
    if response.status_code == 200:
        data  = response.json()
        return {"data":data}
    else:
        return{"error": f"fail to fetch data, status code : {response.status_code}"}





