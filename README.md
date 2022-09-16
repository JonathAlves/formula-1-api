# formular-1-API
Api para controle de informações de circuitos de formula 1.

Para executar a API, é necessário que seja feita a importação do projeto maven e executado em uma IDE da preferência do usuário. (Intellij, Eclipse, etc.)

Após a execução do projeto, serão importados os dados no banco e os endpoints estarão disponíveis para serem consumidos.

O consumo da API pode ser feito digitando o endpoint desejado na barra de navegação. Caso deseje, para uma maior acertividade, também é possível consumir a API utilizando os aplicativos Postman ou Insomnia.

Nesta API estão disponíveis os seguintes endpoints:

**---> localhost:8085/drivers/winning**

  * *Este endpoint irá retornar todos os pilotos que já venceram ao menos uma corrida.* *

**---> localhost:8085/drivers/wins-gap**

  * *Este endpoint irá retornar o piloto com a maior distância entre sua primeira e última vitória.* *
  
**---> localhost:8085/drivers/teams**

  * *Este endpoint irá retornar os 10 pilotos que pilotaram pelo maior número de equipes, por ordem 
  decrescente.* *

Estes são os endpoints disponíveis até o momento.





