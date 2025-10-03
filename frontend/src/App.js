import './App.css';
import React, { useState, useEffect } from 'react';

function App() {

  const [currentMeme, setCurrentMeme] = useState();

  const fetchRandomMeme = async () => {
    try {
      const res = await fetch("http://localhost:8080/api/memes/random");
      const data = await res.json();
      setCurrentMeme(data);
    } catch (err) {
      console.error(err);
    }
  };

  useEffect(() => {
    fetchRandomMeme();
  }, []);

  return (
    <div className="App">
      <header className="Meme-title">
        <p>
          This is my Meme Generator App.
        </p>
      </header>
      {currentMeme ? (
        <div className="Meme-body">
          <img
            src={currentMeme.url}
            alt="Meme"
            className="Meme-container"
          />
          <p className="Top-text">
            {currentMeme.topText}
          </p>
          <p className="Bottom-text">
            {currentMeme.bottomText}
          </p>
        </div>
      ) : (
        <p>Loading meme...</p>
      )}
      <button
        onClick={fetchRandomMeme}
      >
        Generate Meme
      </button>
    </div>
  );
}

export default App;
