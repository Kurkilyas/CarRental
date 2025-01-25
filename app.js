const express = require('express');
const app = express();
const port = 3000;

app.set('view engine', 'ejs'); // EJS kullanacağımızı belirtiyoruz

app.get('/', async (req, res) => {
  try {
    // Bu kısıma API çağrısını ekleyerek verileri alabilirsin
    const amount = 100; // Örnek veri
    const fromCurrency = 'TL'; // Örnek veri
    const toCurrency = 'USD'; // Örnek veri
    const convertedAmount = 85.5; // Örnek veri

    // JSON içindeki değişkenleri view'e gönderiyoruz
    res.render('index', { amount, fromCurrency, toCurrency, convertedAmount });
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: 'Internal Server Error' });
  }
});

app.listen(port, () => {
  console.log(`Server is running at http://localhost:${port}`);
});
