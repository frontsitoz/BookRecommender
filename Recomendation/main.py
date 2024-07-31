from fastapi import FastAPI
from schemas import  RecommendationRequest
from recommender import generate_recommendations


app = FastAPI()

@app.get("/")
def read_root():
    return {"Hello": "world"}


#consumimos el endpoint del backend
@app.post("/getRecommendations")
async def getRecommendations(request: RecommendationRequest):
      
      user_books = request.user_books
      all_books = request.all_books
      top_n = request.top_n
      

      recommendatios = generate_recommendations(user_books, all_books, top_n)


      return recommendatios

    






