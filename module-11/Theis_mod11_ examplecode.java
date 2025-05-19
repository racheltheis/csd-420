//Rachel Theis
//CSD 420
//5.18.25

//This is example code that demonstrates how the Languagelayer API works to identify the language that a text sample is in.

//Example Query

http://api.languagelayer.com/detect
    ? access_key = YOUR_ACCESS_KEY
    & query = I%20like%20apples%20%26%20oranges.

                

//Example Response
{
  "success": true,
  "results": [
	{
	"language_code": "en",
	"language_name": "English",
	"probability": 83.896703655741,
	"percentage": 100,
	"reliable_result": true
	}
  ]
} 
       
//References
//Languagelayer API. (n.d.). Documentation | languagelayer API. Languagelayer.com.
//https://languagelayer.com/documentation
                