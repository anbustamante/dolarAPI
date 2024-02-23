function DolarAhora(data) {
  var url= "https://www.ambito.com/contenidos/dolar-informal.html";
  var response = UrlFetchApp.fetch(url);
  var parsedData = JSON.parse(response.getContentText());
  return parsedData[data];
  }

function addTextAndButtonToDiv(div) {
  const newText = document.createElement('p');
  newText.textContent = 'Your additional text';
  const newButton = document.createElement('button');
  newButton.textContent = 'Click Me';
  div.appendChild(newText);
  div.appendChild(newButton);
  newButton.addEventListener('click', function() {
    alert('Button clicked!');
  });
}

const priceGridContainers = document.querySelectorAll('.ui-search-result__content-columns');
priceGridContainers.forEach(addTextAndButtonToDiv);


/*
eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3Mzk3NzA1MzUsInR5cGUiOiJleHRlcm5hbCIsInVzZXIiOiJhbmR5MDBiQGdtYWlsLmNvbSJ9.GFq8NEN8ELqpEjowjDzEhMOv5uiDYNnwwfGhlmRoSFh-vRnXJR9eJ0jVKlWxGIPUNq8ZypBNAoQyZgNLVH1L0Q
*/