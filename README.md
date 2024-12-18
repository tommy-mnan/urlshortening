# URL Shortening Service
This repository contains a URL Shortening Service implemented in Java, designed to convert long URLs into shorter, more manageable links.

# Getting Started

Prerequisites
  
  •	Java Development Kit (JDK) 8 or higher
  
  •	Maven 3.6.0 or higher

Installation
  1.	Clone the repository:

      git clone https://github.com/tommy-mnan/urlshortening.git


  2.	Navigate to the project directory:

      cd urlshortening


  3.	Build the project using Maven:

      mvn package

  4.	Run the application:

      mvn spring-boot:run

      

# API Endpoints
  •	POST : /shorten
  •	Request Body:

    {
      "full_url": "https://example.com",
    }


•	Response:

    {
      "status": 200,
      "message": "Success",
      "data": {
          "full_url": "https://example.com",
          "short_url": "localhost:8083/VBSl"
      }
    }  


•	Redirect to Long URL:
  •	GET /{shortURL}
  •	Response Success :
     
       Redirects to the original long URL.

  Failed :

      Redirects to not found page.
    
# Contributing

Contributions are welcome! Please fork this repository and submit a pull request for any enhancements or bug fixes.

# License

This project is licensed under the MIT License. 
