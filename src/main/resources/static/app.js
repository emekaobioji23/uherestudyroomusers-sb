fetch('/api')
  .then(response => response.json())
  .then(data => {
    document.getElementById('api-message').innerText = data.message;
  })
  .catch(error => console.error('Error fetching API:', error));
